package com.suning.manager.service.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.mapper.Mapper;
import com.suning.facade.manager.entity.ItemCat;
import com.suning.manager.service.dao.ItemCatDao;
@Service("itemCatBiz")
public class ItemCatBiz extends AbstractBaseBiz<ItemCat>{
	@Autowired
	private ItemCatDao itemCatDao;

	@Override
	public Mapper<ItemCat> getMapper() {
		return this.itemCatDao;
	}
}
