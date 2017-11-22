package com.suning.common.spring.extend.converter.json;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;

public class CallbackMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

	// 做jsonp的支持的标识，在请求参数中加该参数
	private String callbackName;

	@Override
	protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		// 从threadLocal中获取当前的Request对象
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
		JsonGenerator generator = this.objectMapper.getFactory().createGenerator(outputMessage.getBody(), encoding);
		String callbackParam = request.getParameter(callbackName);
		if(StringUtils.isEmpty(callbackParam)){
			// 没有找到callback参数，直接返回json数据
			String result =JSON.toJSONString(object);
			generator.writeRaw(result);
			generator.flush();
		}else{
			try {
				String result =callbackParam+"("+JSON.toJSONString(object)+");";
				generator.writeRaw(result);
				generator.flush();
			}
			catch (JsonProcessingException ex) {
				throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
			}
		}
		
	}

	public String getCallbackName() {
		return callbackName;
	}

	public void setCallbackName(String callbackName) {
		this.callbackName = callbackName;
	}

}
