package com.suning.facade.manager.service;

import com.suning.facade.manager.entity.Item;

public interface ItemFacade {
	int saveItem(Item item);
	
	Boolean saveItem(Item item, String description);
}