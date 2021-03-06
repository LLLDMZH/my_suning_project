package com.suning.manager.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.suning.common.entity.PageBean;
import com.suning.facade.manager.service.ContentFacade;

@Controller
@RequestMapping("/api/content")
public class ApiContentController {
	@Autowired
	private ContentFacade contentFacade;
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
