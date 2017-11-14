package com.suning.facade.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suning.facade.manager.entity.Item;
import com.suning.facade.manager.entity.ItemDescription;
import com.suning.facade.manager.service.ItemFacade;
import com.suning.manager.service.biz.ItemBiz;
import com.suning.manager.service.biz.ItemDescriptionBiz;

@Service("itemFacadeImpl")
public class ItemFacadeImpl implements ItemFacade{

	
	@Autowired
	private ItemBiz itemBiz;//service1
	
	@Autowired
	private ItemDescriptionBiz itemDescriptionBiz;//service2
	
	@Override
	public int saveItem(Item item) {
		//设置状态
		item.setStatus(1);
		//安全问题
		item.setId(null);
		return itemBiz.save(item);
	}

	@Override
	public Boolean saveItem(Item item, String description) {
		int count1 = this.saveItem(item);
		
		ItemDescription itemDescription = new ItemDescription();
		itemDescription.setItemId(item.getId());
		itemDescription.setItemDesc(description);
		int count2 = itemDescriptionBiz.save(itemDescription);
		boolean success = ((count1 == 1) && (count2 == 1));
		return success;
	}
	
}