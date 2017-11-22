package com.suning.facade.manager.pojo.dto;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemCatDTO  {
	
//	@JsonProperty("u")
	@JSONField(name = "u", ordinal = 1)
	private String url;
	
//	@JsonProperty("n")
	@JSONField(name = "n", ordinal = 2)
	private String name;
	
//	@JsonProperty("i")
	@JSONField(name = "i", ordinal = 3)
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
