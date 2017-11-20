package com.suning.facade.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suning.facade.manager.entity.ContentCategory;
import com.suning.facade.manager.service.ContentCategoryFacade;
import com.suning.manager.service.biz.ContentCategoryBiz;
@Service("contentCategoryFacade")
public class ContentCategoryFacadeImpl implements ContentCategoryFacade{
	@Autowired
	private ContentCategoryBiz contentCategoryBiz;

	@Override
	public List<ContentCategory> listByParentId(Long pid) {
		
		ContentCategory record = new ContentCategory();
		record.setParentId(pid);
		return this.contentCategoryBiz.listByWhere(record );
	}

	@Override
	public void saveContentCategory(ContentCategory contentCategory) {
		contentCategory.setId(null);
		contentCategory.setIsParent(false);
		contentCategory.setSortOrder(1);
		contentCategory.setStatus(1);
		this.contentCategoryBiz.save(contentCategory);
		//你需要获取他的父节点做修改
		//根据parentId去查询
		long parentId = contentCategory.getParentId();
		ContentCategory parentContentCategory = this.contentCategoryBiz.getById(parentId);
		if (!parentContentCategory.getIsParent()) {
			parentContentCategory.setIsParent(true);
			this.contentCategoryBiz.update(parentContentCategory);
		}
	}

	@Override
	public void updateContentCategory(Long id, String name) {
		ContentCategory contentCategory = new ContentCategory();
		contentCategory.setId(id);
		contentCategory.setName(name);
		this.contentCategoryBiz.updateSelective(contentCategory);
	}
	
	/**
	 * 根据id递归删除类目
	 */
	@Override
	public void deleteAll(ContentCategory contentCategory) {
		List<Object> ids = new ArrayList<Object>();
		deleteByRecursion(contentCategory,ids);
		this.contentCategoryBiz.deleteByIds(ids, ContentCategory.class, "id");
		
		//判断该节点是否有兄弟节点，如果没有 修改父节点isParent为false
		//如果只有一个兄弟的时候
		ContentCategory record = new ContentCategory();
		record.setParentId(contentCategory.getParentId());
		List<ContentCategory> siblings = this.contentCategoryBiz.listByWhere(record);
		if (null == siblings || siblings.isEmpty()) {
			ContentCategory parent = new ContentCategory();
			parent.setId(contentCategory.getParentId());
			parent.setIsParent(false);
			this.contentCategoryBiz.updateSelective(parent );
		}
		
	}

	private void deleteByRecursion(ContentCategory contentCategory,
			List<Object> ids) {
		//先加入
		Long pid = contentCategory.getId();
		ids.add(pid);
		if (!contentCategory.getIsParent()) {
			return;
		} else {
			ContentCategory record = new ContentCategory();
			record.setParentId(pid);
			List<ContentCategory> sons = this.contentCategoryBiz.listByWhere(record);
			for (ContentCategory son : sons) {
				deleteByRecursion(son, ids);
			}
		}
	}
}
