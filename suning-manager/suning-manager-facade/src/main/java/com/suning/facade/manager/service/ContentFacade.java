package com.suning.facade.manager.service;

import com.suning.common.entity.PageBean;
import com.suning.facade.manager.entity.Content;

public interface ContentFacade {

	void saveContent(Content content);

	PageBean listPageContentListByWhere(Long categoryId, Integer pages, Integer rows);


}
