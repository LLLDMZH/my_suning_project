package com.suning.facade.manager.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.suning.common.constant.CacheConsts;
import com.suning.common.service.RedisService;
import com.suning.facade.manager.entity.ItemCat;
import com.suning.facade.manager.pojo.dto.ItemCatDTO;
import com.suning.facade.manager.pojo.vo.IndexVO;
import com.suning.facade.manager.service.ItemCatFacade;
import com.suning.manager.service.biz.ItemCatBiz;

/**
 * 门面模式 外观模式 对外部系统提供统一对entity实体的操作
 * 
 * @author Administrator
 *
 */
@Service("itemCatFacade")
public class ItemCatFacadeImpl implements ItemCatFacade{
	
	@Autowired
	private ItemCatBiz itemCatBiz;
	
	@Autowired
	private RedisService redisService;
	
	@Override
	public List<ItemCat> listItemsByParentId(Long parentId) {
		ItemCat record = new ItemCat();
		record.setParentId(parentId);
		return itemCatBiz.listByWhere(record);
	}

	@Override
	public ItemCat getItemById(Long cid) {
		return itemCatBiz.getById(cid);
	}
	
	
	@Override
	public IndexVO listIndexItemCat() {
			
			//先从缓存中命中，如果命中就返回，没有命中继续
			try {
				String cacheData = this.redisService.get(CacheConsts.SUNING_MANAGE_ITEM_CAT_API);
				if (StringUtils.isNotEmpty(cacheData)) {
					//命中TODO
					return JSON.parseObject(cacheData, IndexVO.class);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			IndexVO indexVO = new IndexVO();
			// 全部查出，并且在内存中生成树形结构
			List<ItemCat> cats = itemCatBiz.listAll();
			
			// 转为map存储，key为父节点ID，value为数据集合 大约145个
			Map<Long, List<ItemCat>> itemCatMap = new HashMap<Long, List<ItemCat>>(128);
			//进行分拣
			for (ItemCat itemCat : cats) {
				//如果当前Map中没有 你遍历元素的parentId
				if(!itemCatMap.containsKey(itemCat.getParentId())){
					//将此item的parentId作为Key，ArrayList作为value存入map
					itemCatMap.put(itemCat.getParentId(), new ArrayList<ItemCat>());
				}
				//如果有 那么直接获取对应parentId key所对应的ArrayList 加入对象
				itemCatMap.get(itemCat.getParentId()).add(itemCat);
			}
			
			
			
			
			//获取所有一级对象parentId为0的
			List<ItemCat> ParentItemCats = itemCatMap.get(0L);
			for (ItemCat itemCat : ParentItemCats) {
				ItemCatDTO parentDTO = new ItemCatDTO();
				parentDTO.setUrl("/products/" + itemCat.getId() + ".html");
				parentDTO.setName("<a href='"+parentDTO.getUrl()+"'>"+itemCat.getItemName()+"</a>");
				//将parentDTO江入到IndexVO
				indexVO.getItemCats().add(parentDTO);
				
				//根据一级类目ID找到一群二级类目
				List<ItemCat> SonItemCats = itemCatMap.get(itemCat.getId());
				//每个二级类目都有一个DTO
				List<ItemCatDTO> sonItemCatDTOS = new ArrayList<ItemCatDTO>();
				//设置当前一级类目的items的items
				parentDTO.setItems(sonItemCatDTOS);
				
				//遍历这些二级类目
				for (ItemCat sonItemCat : SonItemCats) {
					ItemCatDTO sonItemCatDTO = new ItemCatDTO();
					sonItemCatDTO.setName(sonItemCat.getItemName());
					sonItemCatDTO.setUrl("/products/" + sonItemCat.getId() + ".html");
					sonItemCatDTOS.add(sonItemCatDTO);
					//如果当前添加的类目还有子类目
					if(sonItemCat.getIsParent()){
						// 封装三级对象
						List<ItemCat> subSonItemCats = itemCatMap.get(sonItemCat.getId());
						List<String> subSonContents = new ArrayList<String>();
						sonItemCatDTO.setItems(subSonContents);
						for (ItemCat itemCat3 : subSonItemCats) {
							subSonContents.add("/products/" + itemCat3.getId() + ".html|"+itemCat3.getItemName());
						}
					}
				}
				
				if(indexVO.getItemCats().size() >= 14){
					break;
				}
			}
			//将数据库的查询结果集写入到缓存中 缓存时间3个月
			System.out.println("写入:" + JSON.toJSONString(indexVO));
			try {
				this.redisService.set(CacheConsts.SUNING_MANAGE_ITEM_CAT_API,JSON.toJSONString(indexVO), CacheConsts.ITEM_CAT_TIME);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return indexVO;
		}

}
