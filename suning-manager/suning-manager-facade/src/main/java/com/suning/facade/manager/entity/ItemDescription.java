package com.suning.facade.manager.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.suning.common.entity.BaseEntity;

@Table(name = "suning_shopping_item_description")
public class ItemDescription extends BaseEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4827847480991994655L;


	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column suning_item_desc.item_id
     *
     * @mbg.generated Tue Nov 14 16:01:33 CST 2017
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

 
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column suning_item_desc.item_desc
     *
     * @mbg.generated Tue Nov 14 16:01:33 CST 2017
     */
    private String itemDescription;
    
    
    @Override
	public String toString() {
		return "ItemDescription [itemId=" + itemId + ", itemDescription=" + itemDescription
				+ ", toString()=" + super.toString() + "]";
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column suning_item_desc.item_id
     *
     * @return the value of suning_item_desc.item_id
     *
     * @mbg.generated Tue Nov 14 16:01:33 CST 2017
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column suning_item_desc.item_id
     *
     * @param itemId the value for suning_item_desc.item_id
     *
     * @mbg.generated Tue Nov 14 16:01:33 CST 2017
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

   

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column suning_item_desc.item_desc
     *
     * @return the value of suning_item_desc.item_desc
     *
     * @mbg.generated Tue Nov 14 16:01:33 CST 2017
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column suning_item_desc.item_desc
     *
     * @param itemDesc the value for suning_item_desc.item_desc
     *
     * @mbg.generated Tue Nov 14 16:01:33 CST 2017
     */
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription == null ? null : itemDescription.trim();
    }
}