package com.suning.manager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.druid.util.StringUtils;
import com.suning.common.entity.PageBean;
import com.suning.facade.manager.entity.Item;
import com.suning.facade.manager.service.ItemFacade;

@RequestMapping("/item")
@Controller
public class ItemController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ItemController.class);

	@Autowired
	private ItemFacade itemFacade;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveItem(Item item,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "itemParams") String itemParams) {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.info("新增商品,item = {}, description = {}", item,
						description);
			}
			if (StringUtils.isEmpty(item.getTitle())) {
				// 参数有误 400
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			Boolean success = itemFacade.saveItem(item, description, itemParams);
			if (!success) {
				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("新增商品失败,item = {}, description = {}", item,
							description);
				}
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.build();
			}
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("新增商品成功,itemId = {}", item.getId());
			}
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			LOGGER.error("新增商品出错！ item = " + item, e);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	/**
	 * 查询商品列表 
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<PageBean> queryItemInPages(
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "rows", defaultValue = "30") Integer rows) {
		try {
			PageBean itemListVO = itemFacade.listPageItemList(page, rows);
			return ResponseEntity.ok(itemListVO);
		} catch (Exception e) {
			LOGGER.error("查询商品列表出错! page = " + page + ", rows = " + rows);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
	
	/**
	 * 修改商品
	 * @param item
	 * @param description
	 * @param itemParams
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateItem(Item item,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "itemParams") String itemParams) {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.info("修改商品,item = {}, description = {}", item,
						description);
			}
			if (StringUtils.isEmpty(item.getTitle())) {
				// 参数有误 400
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			Boolean success = itemFacade.updateItem(item, description, itemParams);
			if (!success) {
				if (LOGGER.isInfoEnabled()) {
					LOGGER.info("修改商品失败,item = {}, description = {}", item,
							description);
				}
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.build();
			}
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("修改商品成功,itemId = {}", item.getId());
			}
			//204
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			LOGGER.error("修改商品出错！ item = " + item, e);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	
}
