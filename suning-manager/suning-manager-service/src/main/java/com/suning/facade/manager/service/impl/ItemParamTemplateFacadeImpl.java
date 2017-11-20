package com.suning.facade.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suning.facade.manager.entity.ItemParamTemplate;
import com.suning.facade.manager.service.ItemParamTemplateFacade;
import com.suning.manager.service.biz.ItemParamTemplateBiz;
@Service("itemParamTemplateFacade")
public class ItemParamTemplateFacadeImpl implements ItemParamTemplateFacade{

	@Autowired
	ItemParamTemplateBiz itemParamTemplateBiz;
	
	@Override
	public ItemParamTemplate getItemParamTemplateByItemCatId(Long itemCatId) {
		ItemParamTemplate record = new ItemParamTemplate();
		record.setItemcatId(itemCatId);
		return itemParamTemplateBiz.getByWhere(record );
	}

	@Override
	public Boolean saveItemParamTemplate(Long itemCatId, String paramData) {
		ItemParamTemplate itemParamTemplate = new ItemParamTemplate();
		itemParamTemplate.setItemcatId(itemCatId);
		itemParamTemplate.setParamData(paramData);
		itemParamTemplate.setId(null);
		Integer count = itemParamTemplateBiz.save(itemParamTemplate);
		return count == 1;
	}

}
