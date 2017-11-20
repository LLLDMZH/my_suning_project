package com.suning.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suning.facade.manager.entity.ItemParamData;
import com.suning.facade.manager.service.ItemParamDataFacade;

@Controller
@RequestMapping("/item/param/data")
public class ItemParamDataController {
	@Autowired
	private ItemParamDataFacade itemParamDataFacade;
	@RequestMapping(value = {"/{itemId}"}, method = RequestMethod.GET)
	public ResponseEntity<ItemParamData> queryItemParamData(@PathVariable("itemId") Long itemId) {
		try {
			ItemParamData itemParamData = itemParamDataFacade.getItemParamDataByItemId(itemId);
			if (null == itemParamData) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.ok(itemParamData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
}
