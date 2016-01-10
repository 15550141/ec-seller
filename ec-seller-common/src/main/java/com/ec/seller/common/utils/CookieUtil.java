package com.ec.seller.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class CookieUtil {

	public static String getValue(String name, HttpServletRequest request){
		//取cookie
		Cookie[] cookies =request.getCookies();

		for(Cookie cookie : cookies){
			if(cookie.getName().equals(name)&&cookie.getValue()!=null ){
				try {
					return URLDecoder.decode(cookie.getValue(), "utf-8");
				} catch (UnsupportedEncodingException e) {
				}
			}
		}
		return null;
	}
	
	public static String getLoginName(HttpServletRequest request){
		//取cookie
		Cookie[] cookies =request.getCookies();
		
		String loginName=null;
		if(cookies==null){
			return loginName;
		}
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("loginusername")&&cookie.getValue()!=null ){
				try {
					loginName= URLDecoder.decode(cookie.getValue(), "utf-8");
				} catch (UnsupportedEncodingException e) {
				}
			}
		}
		return loginName;
	}
	
	public static Integer getUserId(HttpServletRequest request){
		//取cookie
		Cookie[] cookies =request.getCookies();
		
		Integer userId=null;
		if(cookies==null){
			return userId;
		}
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("loginname")&&cookie.getValue()!=null ){
				String loginName=cookie.getValue().substring(2);
				userId=Integer.parseInt(loginName.substring(loginName.indexOf("^")+1));
			}
		}
		return userId;
	}

}
