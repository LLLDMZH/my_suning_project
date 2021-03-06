package com.suning.manager.service.dao;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.suning.facade.manager.entity.Content;

public interface ContentDao extends Mapper<Content>{
	/**
	 * 根据categoryId查询内容列表，并且按照更新时间倒序排序
	 * @return
	 */
	public List<Content> listByCategoryId(Long categoryId);
}
