package com.suning.facade.manager.pojo.vo;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.suning.facade.manager.pojo.dto.ItemCatDTO;

public class IndexVO {
//		@JsonProperty("data")
		@JSONField(name = "data")
		private List<ItemCatDTO> itemCats = new ArrayList<ItemCatDTO>();

		public List<ItemCatDTO> getItemCats() {
			return itemCats;
		}

		public void setItemCats(List<ItemCatDTO> itemCats) {
			this.itemCats = itemCats;
		}
}
