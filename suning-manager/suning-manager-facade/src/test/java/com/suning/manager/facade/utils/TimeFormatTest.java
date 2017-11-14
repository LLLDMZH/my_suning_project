package com.suning.manager.facade.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TimeFormatTest {
	@Test
	public void test01() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(d);
		System.out.println(format);
	}
} 