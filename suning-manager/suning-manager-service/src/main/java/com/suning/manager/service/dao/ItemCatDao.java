package com.suning.manager.service.dao;

import com.suning.facade.manager.entity.ItemCat;
import com.suning.facade.manager.entity.ItemCatExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ItemCatDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table suning_shopping_items
     *
     * @mbg.generated Mon Nov 13 17:55:17 CST 2017
     */
    long countByExample(ItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table suning_shopping_items
     *
     * @mbg.generated Mon Nov 13 17:55:17 CST 2017
     */
    int deleteByExample(ItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table suning_shopping_items
     *
     * @mbg.generated Mon Nov 13 17:55:17 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table suning_shopping_items
     *
     * @mbg.generated Mon Nov 13 17:55:17 CST 2017
     */
    int insert(ItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table suning_shopping_items
     *
     * @mbg.generated Mon Nov 13 17:55:17 CST 2017
     */
    int insertSelective(ItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table suning_shopping_items
     *
     * @mbg.generated Mon Nov 13 17:55:17 CST 2017
     */
    List<ItemCat> selectByExample(ItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table suning_shopping_items
     *
     * @mbg.generated Mon Nov 13 17:55:17 CST 2017
     */
    ItemCat selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table suning_shopping_items
     *
     * @mbg.generated Mon Nov 13 17:55:17 CST 2017
     */
    int updateByExampleSelective(@Param("record") ItemCat record, @Param("example") ItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table suning_shopping_items
     *
     * @mbg.generated Mon Nov 13 17:55:17 CST 2017
     */
    int updateByExample(@Param("record") ItemCat record, @Param("example") ItemCatExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table suning_shopping_items
     *
     * @mbg.generated Mon Nov 13 17:55:17 CST 2017
     */
    int updateByPrimaryKeySelective(ItemCat record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table suning_shopping_items
     *
     * @mbg.generated Mon Nov 13 17:55:17 CST 2017
     */
    int updateByPrimaryKey(ItemCat record);
}