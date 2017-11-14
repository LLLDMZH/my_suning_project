package com.suning.facade.manager.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.suning.common.entity.BaseEntity;
@Table(name = "suning_shopping_items")
public class ItemCat extends BaseEntity{
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column suning_shopping_items.id
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column suning_shopping_items.parent_id
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column suning_shopping_items.item_name
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    private String itemName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column suning_shopping_items.is_parent
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    private Boolean isParent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column suning_shopping_items.sort_order
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    private Integer sortOrder;


    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column suning_shopping_items.status
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    private Boolean status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column suning_shopping_items.id
     *
     * @return the value of suning_shopping_items.id
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column suning_shopping_items.id
     *
     * @param id the value for suning_shopping_items.id
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column suning_shopping_items.parent_id
     *
     * @return the value of suning_shopping_items.parent_id
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column suning_shopping_items.parent_id
     *
     * @param parentId the value for suning_shopping_items.parent_id
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column suning_shopping_items.item_name
     *
     * @return the value of suning_shopping_items.item_name
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column suning_shopping_items.item_name
     *
     * @param itemName the value for suning_shopping_items.item_name
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column suning_shopping_items.is_parent
     *
     * @return the value of suning_shopping_items.is_parent
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public Boolean getIsParent() {
        return isParent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column suning_shopping_items.is_parent
     *
     * @param isParent the value for suning_shopping_items.is_parent
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column suning_shopping_items.sort_order
     *
     * @return the value of suning_shopping_items.sort_order
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column suning_shopping_items.sort_order
     *
     * @param sortOrder the value for suning_shopping_items.sort_order
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

   
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column suning_shopping_items.status
     *
     * @return the value of suning_shopping_items.status
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column suning_shopping_items.status
     *
     * @param status the value for suning_shopping_items.status
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    //为这个Bean添加两属性 EasyUI需要
	public String getText() {
		return this.getItemName();
	}
	
	public String getState() {
		return this.getIsParent() ? "closed" : "open";
	}
}