package com.suning.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.suning.facade.manager.entity.ItemDescription;
import com.suning.facade.manager.pojo.vo.ItemVo;
import com.suning.web.service.ItemService;

@RequestMapping("/item")
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	/**
	 * 返回详情页面信息
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
	public ModelAndView itemDetail(@PathVariable("itemId") Long itemId) {
		ModelAndView mv = new ModelAndView("item");
		ItemVo item = this.itemService.getItemById(itemId);
		mv.addObject("item", item);
		
		//商品描述数据
		ItemDescription itemDescription = this.itemService.getItemDescriptionByItemId(itemId);
		mv.addObject("itemDescription", itemDescription);
		
		//商品规格参数数据
		String itemParamData = this.itemService.getItemParamDataByItemId(itemId);
		mv.addObject("itemParamData",itemParamData);
		return mv;
	}
}
