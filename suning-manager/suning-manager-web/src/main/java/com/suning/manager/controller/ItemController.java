package com.suning.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.druid.util.StringUtils;
import com.suning.facade.manager.entity.Item;
import com.suning.facade.manager.entity.ItemDescription;
import com.suning.facade.manager.service.ItemDescriptionFacade;
import com.suning.facade.manager.service.ItemFacade;

@RequestMapping("item")
@Controller
public class ItemController {
	
	@Autowired
	private ItemFacade itemFacade;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveItem(Item item, @RequestParam(value="desc") String description) {
		try {
			
			if (StringUtils.isEmpty(item.getTitle())) {
				//参数有误 400
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			Boolean success = itemFacade.saveItem(item, description);
			if (success) {
				return ResponseEntity.status(HttpStatus.CREATED).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
