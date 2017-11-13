package com.suning.manager.service.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suning.facade.manager.entity.ItemCat;
import com.suning.facade.manager.entity.ItemCatExample;
import com.suning.facade.manager.entity.ItemCatExample.Criteria;
import com.suning.manager.service.dao.ItemCatDao;

@Service("itemCatBiz")
public class ItemCatBiz {
	@Autowired
	private ItemCatDao itemCatDao;

	public List<ItemCat> listItemsByParentId(Long parentId) {
		ItemCatExample example = new ItemCatExample();
		Criteria c1 = example.or();
		c1.andParentIdEqualTo(parentId);//设置查询参数
		return itemCatDao.selectByExample(example);
	}
}