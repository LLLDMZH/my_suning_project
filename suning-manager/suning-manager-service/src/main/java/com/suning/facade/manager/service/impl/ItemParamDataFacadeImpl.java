package com.suning.facade.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suning.facade.manager.entity.ItemParamData;
import com.suning.facade.manager.service.ItemParamDataFacade;
import com.suning.manager.service.biz.ItemParamDataBiz;

@Service("itemParamDataFacade")
public class ItemParamDataFacadeImpl implements ItemParamDataFacade{
	
	@Autowired
	private ItemParamDataBiz itemParamDataBiz;
	@Override
	public ItemParamData getItemParamDataByItemId(Long itemId) {
		ItemParamData record = new ItemParamData();
		record.setItemId(itemId);
		return itemParamDataBiz.getByWhere(record);
	}

}
