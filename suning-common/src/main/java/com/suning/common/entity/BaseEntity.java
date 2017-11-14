package com.suning.common.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1258920669696861731L;

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column suning_shopping_items.created_time
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    private Date createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column suning_shopping_items.updated_time
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    private Date updatedTime;
    
    
    
    
    @Override
	public String toString() {
		return "BaseEntity [createdTime=" + createdTime + ", updatedTime="
				+ updatedTime + "]";
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column suning_shopping_items.created_time
     *
     * @return the value of suning_shopping_items.created_time
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column suning_shopping_items.created_time
     *
     * @param createdTime the value for suning_shopping_items.created_time
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column suning_shopping_items.updated_time
     *
     * @return the value of suning_shopping_items.updated_time
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column suning_shopping_items.updated_time
     *
     * @param updatedTime the value for suning_shopping_items.updated_time
     *
     * @mbg.generated Mon Nov 13 20:48:54 CST 2017
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

}
