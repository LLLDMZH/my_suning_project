package com.suning.facade.manager.service;

import java.util.List;

import com.suning.facade.manager.entity.ItemCat;
import com.suning.facade.manager.pojo.vo.IndexVO;

/**
 * 门面模式 外观模式 对外部系统提供统一对entity实体的操作
 * 
 * @author Administrator
 *
 */
public interface ItemCatFacade {
	List<ItemCat> listItemsByParentId(Long parentId);

	ItemCat getItemById(Long cid);

	IndexVO listIndexItemCat();
}
