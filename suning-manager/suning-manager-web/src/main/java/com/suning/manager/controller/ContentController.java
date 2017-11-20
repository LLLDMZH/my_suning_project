package com.suning.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.suning.common.entity.PageBean;
import com.suning.facade.manager.entity.Content;
import com.suning.facade.manager.service.ContentFacade;

@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired
	private ContentFacade contentFacade;

	/**
	 * 更新内容
	 * 
	 * @param content
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveContent(Content content) {
		try {
			this.contentFacade.saveContent(content);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	/**
	 * 根据分类ID 分页查询分类列表 按更新顺序降序
	 * @param categoryId
	 * @param pages
	 * @param rows
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<PageBean> queryContentInPages(
			@RequestParam(value = "categoryId") Long categoryId,
			@RequestParam(value = "page", defaultValue = "1") Integer pages,
			@RequestParam(value = "rows", defaultValue = "10") Integer rows) {
		try {
			PageBean itemListVo = this.contentFacade.listPageContentListByWhere(
					categoryId, pages, rows);
			return ResponseEntity.ok(itemListVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

	}

}
