package com.suning.manager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.suning.facade.manager.entity.ItemCat;
import com.suning.facade.manager.service.ItemCatFacade;

@Controller
@RequestMapping("/item/cats")
/**
 * 物品类目
 * @author Administrator
 *
 *	//你需要一个DTO
 */
public class ItemCatController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemCatController.class);
	@Autowired
	private ItemCatFacade itemCatFacade;

	/**
	 * 根据parentid 查询所有类别
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ItemCat>> queryAllItemCats(@RequestParam(value="id", defaultValue="0") Long id) {
		try {
			List<ItemCat> list = itemCatFacade.listItemsByParentId(id);
			if (null == list || list.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
	/**
	 * 根据ID查询指定类别
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ItemCat> queryItemCat(@PathVariable(value="id") Long id) {
		try {
			ItemCat itemCat = itemCatFacade.getItemById(id);
			if (null == itemCat) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
			return ResponseEntity.ok(itemCat);
		} catch (Exception e) {
			LOGGER.debug("查询类目名称失败  id =" + id, e);
		}
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
}
