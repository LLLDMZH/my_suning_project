package com.suning.facade.manager.service;

import com.suning.facade.manager.entity.ItemDescription;

public interface ItemDescriptionFacade {
	int saveItemDescription(ItemDescription itemDescription);
	
	int saveItemDescription(ItemDescription itemDescription, String description, Long itemId);

	ItemDescription getItemDescriptionById(Long id);
}
