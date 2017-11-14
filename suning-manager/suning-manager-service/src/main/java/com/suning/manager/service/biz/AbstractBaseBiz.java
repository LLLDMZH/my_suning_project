package com.suning.manager.service.biz;

import java.util.Date;
import java.util.List;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suning.common.entity.BaseEntity;

public abstract class AbstractBaseBiz<T extends BaseEntity> {
	
	public abstract Mapper<T> getMapper();
	
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	public T getById(Long id) {
		return this.getMapper().selectByPrimaryKey(id);
	}
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<T> listAll() {
		return this.getMapper().select(null);
	}
	
	/**
	 * 根据条件查询一条数据
	 * @param record 条件
	 * @return
	 */
	public T getByWhere(T record) {
		return this.getMapper().selectOne(record);
	}
	
	/**
	 * 根据条件查询多条数据
	 * @param record
	 * @return
	 */
	public List<T> listByWhere(T record) {
		return this.getMapper().select(record);
	}
	
	/**
	 * 根据条件分页查询数据
	 * @param record
	 * @param page
	 * @param rows
	 * @return
	 */
	public PageInfo<T> listPageByWhere(T record, Integer page, Integer rows) {
		//设置分页参数
		PageHelper.startPage(page, rows);
		List<T> list = this.getMapper().select(record);
		return new PageInfo<T>(list);
	}
	
	/**
	 * 新增数据
	 * @param record
	 * @return
	 */
	public Integer save(T record) {
		record.setCreatedTime(new Date());
		record.setUpdatedTime(record.getCreatedTime());
		return this.getMapper().insert(record);
	}
	
	/**
	 * 保存一个实体，null的属性不会保存，会使用数据库默认值
	 * @param record
	 * @return
	 */
	public Integer saveSelective(T record) {
		record.setCreatedTime(new Date());
		record.setUpdatedTime(record.getCreatedTime());
		return this.getMapper().insertSelective(record);
	}
	
	/**
	 * 更新数据
	 * @param record
	 * @return
	 */
	public Integer update(T record) {
		record.setUpdatedTime(new Date());
		return this.getMapper().updateByPrimaryKey(record);
	}
	
	/**
	 * 根据主键更新属性不为null的值
	 * @param record
	 * @return
	 */
	public Integer updateSelective(T record) {
		record.setUpdatedTime(new Date());
		record.setCreatedTime(null);//永远不会更新created
		return this.getMapper().updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 根据主键删除数据  物理删除
	 * @param id
	 * @return
	 */
	public Integer deleteById(Long id) {
		return this.getMapper().deleteByPrimaryKey(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @param clazz
	 * @param property
	 * @return
	 */
	public Integer deleteByIds(List<Object> ids, Class<T> clazz, String property) {
		Example example = new Example(clazz);
		example.createCriteria().andIn(property, ids);
		return this.getMapper().deleteByExample(example );
	}
	
	/**
	 * 根据条件删除
	 * @param record
	 * @return
	 */
	public Integer deleteByWhere(T record) {
		return this.getMapper().delete(record);
	}
}
