package com.suning.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.suning.facade.manager.entity.ItemParamTemplate;
import com.suning.facade.manager.service.ItemParamTemplateFacade;

@Controller
@RequestMapping("/item/param/template")
public class ItemParamTemplateController {
	
	
	/**
	 * 查询商品规格
	 */
	@Autowired
	private ItemParamTemplateFacade itemParamTemplateFacade;
	@RequestMapping(value = "/{itemCatId}", method = RequestMethod.GET)
	public ResponseEntity<ItemParamTemplate> queryItemParamTemplate(@PathVariable("itemCatId") Long itemCatId) {
		try {
			ItemParamTemplate itemParamTemplate = itemParamTemplateFacade.getItemParamTemplateByItemCatId(itemCatId);
			if (null == itemParamTemplate) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.ok(itemParamTemplate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
	@RequestMapping(value = "/{itemCatId}", method = RequestMethod.POST)
	public ResponseEntity<Void> saveItemParamTemplate(@PathVariable("itemCatId") Long itemCatId,
			@RequestParam("paramData") String paramData) {
		try {
			boolean success = itemParamTemplateFacade.saveItemParamTemplate(itemCatId, paramData);
			if (success) {
				return ResponseEntity.status(HttpStatus.CREATED).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
}
