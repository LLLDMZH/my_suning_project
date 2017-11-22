<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%
	//这里返回的是js脚本 alert是一个方法名
	//out.print("alert({\"abc\" : \"123\"});");
	String callback = request.getParameter("callback");
	if (null == callback || "".equals(callback)) {
		out.print("{\"abc\" : \"123\"}");
	} else {
		out.print(callback + "({\"abc\" : \"123\"});");
	}
%>