package com.suning.manager.service.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.suning.facade.manager.service.ItemCatFacade;

public class FacadeImplGetTest {
	public static void main(String[] args) {
		String[] resourcesFile = {"spring/applicationContext.xml"};
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(resourcesFile);
	}
}
