package com.suning.facade.manager.service;

import java.util.List;

import com.suning.facade.manager.entity.ContentCategory;

public interface ContentCategoryFacade {

	List<ContentCategory> listByParentId(Long pid);

	void saveContentCategory(ContentCategory contentCategory);

	void updateContentCategory(Long id, String name);

	void deleteAll(ContentCategory contentCategory);

}
