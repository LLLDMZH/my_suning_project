package com.suning.web.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suning.common.service.ApiService;

@Service
public class IndexService {
	@Autowired
	private ApiService apiService;
	
	@Value("${SUNING_MANAGER_URL}")
	private String SUNING_MANAGER_URL;
	
	@Value("${INDEX_AD1_URI}")
	private String INDEX_AD1_URI;
	
	@Value("${INDEX_AD2_URI}")
	private String INDEX_AD2_URI;
	
	public String queryIndexAD1() {
		String url = SUNING_MANAGER_URL + INDEX_AD1_URI;
		String jsonData;
		try {
			jsonData = this.apiService.doGet(url);
			if (StringUtils.isEmpty(jsonData)) {
				return null;
			}
			JSONObject parseObject = JSON.parseObject(jsonData);
			JSONArray rows = (JSONArray) parseObject.get("rows");
			List<Map<String, Object>> result = new ArrayList<>();
			for (int i = 0; i < rows.size(); i++) {
				JSONObject jsonObject = rows.getJSONObject(i);
				Map<String,Object> map = new LinkedHashMap<String, Object>();
				map.put("srcB",jsonObject.get("pic"));
				map.put("height",240);
				map.put("alt",jsonObject.get("title"));
				map.put("width",670);
				map.put("src",jsonObject.get("pic"));
				map.put("widthB", 550);
				map.put("href", jsonObject.get("url"));
				map.put("heightB", 240);
				result.add(map);
			}
			return JSON.toJSONString(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	public String queryIndexAD2() {

		String url = SUNING_MANAGER_URL + INDEX_AD2_URI;
		String jsonData;
		try {
			jsonData = this.apiService.doGet(url);
			if (StringUtils.isEmpty(jsonData)) {
				return null;
			}
			JSONObject parseObject = JSON.parseObject(jsonData);
			JSONArray rows = (JSONArray) parseObject.get("rows");
			List<Map<String, Object>> result = new ArrayList<>();
			for (int i = 0; i < rows.size(); i++) {
				JSONObject jsonObject = rows.getJSONObject(i);
				Map<String,Object> map = new LinkedHashMap<String, Object>();
				map.put("width",310);
				map.put("height",70);
				map.put("src",jsonObject.get("pic"));
				map.put("href", jsonObject.get("url"));
				map.put("alt",jsonObject.get("title"));
				map.put("widthB", 210);
				map.put("heightB", 70);
				map.put("srcB",jsonObject.get("pic"));
				result.add(map);
			}
			return JSON.toJSONString(result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	
	}

}
