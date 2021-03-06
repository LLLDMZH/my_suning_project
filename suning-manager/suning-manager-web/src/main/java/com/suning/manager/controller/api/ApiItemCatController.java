package com.suning.manager.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.suning.facade.manager.pojo.vo.IndexVO;
import com.suning.facade.manager.service.ItemCatFacade;

@Controller
@RequestMapping("/api/item/cat")
public class ApiItemCatController {
	
	@Autowired
	private ItemCatFacade itemCatFacade;
	
	/**
	 * 对外提供接口查询所有系统类目
	 * @return
	 */
	
	//ResponseBody 返回的数据到响应之间的处理由MappingJackson2HttpMessageConverter处理
	/*@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> queryItemCatList(@RequestParam(value = "callback", required = false) String callBack) {
		try {
			IndexVO indexVo = this.itemCatFacade.listIndexItemCat();
			//为null 或者为""
			String jsonString = JSON.toJSONString(indexVo);
			if (StringUtils.isEmpty(callBack)) {
				return ResponseEntity.ok(jsonString);
			}
			//需要回调 
			return ResponseEntity.ok(callBack + "(" + jsonString + ");");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}*/
	
/*
 	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<MappingJacksonValue> queryItemCatList(@RequestParam(value = "callback", required = false) String callBack) {
		try {
			IndexVO indexVo = this.itemCatFacade.listIndexItemCat();
			MappingJacksonValue mjv = new MappingJacksonValue(indexVo); 
			mjv.setJsonpFunction(callBack);
			return ResponseEntity.ok(mjv);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
*/
 	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<IndexVO> queryItemCatList(@RequestParam(value = "callback", required = false) String callBack) {
 		try {
			IndexVO indexVo = this.itemCatFacade.listIndexItemCat();
			//jsonp 如果有callback参数传入那么最后返回的时候回调用消息转换器处理
			return ResponseEntity.ok(indexVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	}
	
}
