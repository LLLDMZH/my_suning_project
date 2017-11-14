package com.suning.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manager")
public class PageController {
    
    /**
     * 具体的跳转页面逻辑        
     * @param pageName
     * @return 视图名
     */
    @RequestMapping(value = "/{pageName}", method=RequestMethod.GET)
    public String toPage(@PathVariable("pageName") String pageName){
        return pageName;
    }
}
