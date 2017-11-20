package com.suning.common.pojo.dto;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemCatDTO  {
	
//	@JSONField(name = "u", ordinal = 1)
	@JsonProperty("u")
	private String url;
	
//	@JSONField(name = "n", ordinal = 2)
	@JsonProperty("n")
	private String name;
	
//	@JSONField(name = "i", ordinal = 3)
	@JsonProperty("i")
	private List<?> items;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<?> getItems() {
		return items;
	}

	public void setItems(List<?> items) {
		this.items = items;
	}
	
	

}
