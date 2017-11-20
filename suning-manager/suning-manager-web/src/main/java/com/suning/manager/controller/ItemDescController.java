package com.suning.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suning.facade.manager.entity.ItemDescription;
import com.suning.facade.manager.service.ItemDescriptionFacade;

@RequestMapping("item/description")
@Controller
public class ItemDescController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ItemDescController.class);

	@Autowired
	private ItemDescriptionFacade itemDescriptionFacade;

	@RequestMapping(value = "{itemId}", method = RequestMethod.GET)
	// 处理返回值的时候 首先判断类型是否是ResponseEntity 紧接着判断 @ResponseBody注解，判断是否是ModelAndView
	// 普通对象等
	public ResponseEntity<ItemDescription> queryItemDescription(
			@PathVariable("itemId") Long id) {
		ItemDescription itemDescription = this.itemDescriptionFacade
				.getItemDescriptionById(id);
		try {
			if (null == itemDescription) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.ok(itemDescription);
		} catch (Exception e) {
			LOGGER.debug("查询ItemDescription 出错 id = " + id, e);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
				null);
	}
}
