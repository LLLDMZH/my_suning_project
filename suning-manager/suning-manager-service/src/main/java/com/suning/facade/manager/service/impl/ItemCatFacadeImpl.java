package com.suning.facade.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suning.facade.manager.entity.ItemCat;
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
	
	@Override
	public List<ItemCat> listItemsByParentId(Long parentId) {
		return itemCatBiz.listItemsByParentId(parentId);
	}

}