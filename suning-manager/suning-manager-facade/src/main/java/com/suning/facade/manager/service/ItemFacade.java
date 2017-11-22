package com.suning.facade.manager.service;

import com.suning.common.entity.PageBean;
import com.suning.facade.manager.entity.Item;

public interface ItemFacade {
	int saveItem(Item item);
	
	Boolean saveItem(Item item, String description, String itemParams);

	PageBean listPageItemList(Integer page, Integer rows);

	Boolean updateItem(Item item, String description, String itemParams);

	Item getItem(Long itemId);
}
