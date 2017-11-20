package com.suning.manager.service.biz;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.suning.facade.manager.entity.ItemParamData;
@Service("itemParamDataBiz")
public class ItemParamDataBiz extends BaseBiz<ItemParamData>{
	
	public int updateByWhere(Long id, String itemParams) {
		ItemParamData itemParamData = new ItemParamData();
		itemParamData.setParamData(itemParams);
		itemParamData.setUpdatedTime(new Date());
		//根据一个自定义的条件做选择性更新
		Example example = new Example(ItemParamData.class);
		example.createCriteria().andEqualTo("itemId", id);
		return super.mapper.updateByExampleSelective(itemParamData, example);
	}

}