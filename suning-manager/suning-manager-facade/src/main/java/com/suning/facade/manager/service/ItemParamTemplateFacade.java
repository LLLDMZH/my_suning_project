package com.suning.facade.manager.service;

import com.suning.facade.manager.entity.ItemParamTemplate;

public interface ItemParamTemplateFacade {
	ItemParamTemplate getItemParamTemplateByItemCatId(Long itemCatId);

	Boolean saveItemParamTemplate(Long itemCatId, String paramData);
}
