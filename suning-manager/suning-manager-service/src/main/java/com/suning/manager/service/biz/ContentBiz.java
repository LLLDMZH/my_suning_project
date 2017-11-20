package com.suning.manager.service.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suning.common.entity.PageBean;
import com.suning.facade.manager.entity.Content;
import com.suning.manager.service.dao.ContentDao;

@Service("contentBiz")
public class ContentBiz extends BaseBiz<Content>{

	@Autowired
	private ContentDao contentDao;
	public PageBean listPageContentListByWhere(Long categoryId, Integer pages,
			Integer rows) {
		PageHelper.startPage(pages, rows);
		List<Content> list = contentDao.listByCategoryId(categoryId);
		PageInfo<Content> pageInfo = new PageInfo<Content>(list);
		return new PageBean(pageInfo.getSize(), pageInfo.getList());
	}
}
