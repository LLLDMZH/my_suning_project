package com.suning.facade.manager.pojo.vo;

import org.apache.commons.lang3.StringUtils;

import com.suning.facade.manager.entity.Item;

public class ItemVo extends Item{
	public String[] getImages() {
		String image = super.getImage();
		if (image.endsWith(",")) {
			image = image.substring(0, image.length() - 1);
		}
		return StringUtils.split(image,",");
	}
}
