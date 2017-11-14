package com.suning.facade.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suning.facade.manager.entity.ItemCat;
import com.suning.facade.manager.entity.ItemDescription;
import com.suning.facade.manager.service.ItemCatFacade;
import com.suning.facade.manager.service.ItemDescriptionFacade;
import com.suning.manager.service.biz.ItemBiz;
import com.suning.manager.service.biz.ItemCatBiz;
import com.suning.manager.service.biz.ItemDescriptionBiz;

/**
 * 门面模式 外观模式 对外部系统提供统一对entity实体的操作
 * 
 * @author Administrator
 *
 */
@Service("itemDescriptionFacade")
public class ItemDescriptionFacadeImpl implements ItemDescriptionFacade{
	
	@Autowired
	private ItemDescriptionBiz itemDescriptionBiz;
	
	@Override
	public int saveItemDescription(ItemDescription itemDescription) {
		return itemDescriptionBiz.save(itemDescription);
	}
	
	@Override
	public int saveItemDescription(ItemDescription itemDescription,
			String description, Long itemId) {
		itemDescription.setItemId(itemId);
		itemDescription.setItemDesc(description);
		return itemDescriptionBiz.save(itemDescription);
	}
}
