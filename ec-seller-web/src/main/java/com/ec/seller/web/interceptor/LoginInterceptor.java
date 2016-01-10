package com.ec.seller.web.interceptor;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exc)
			throws Exception {
		
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//取cookie
		Cookie[] cookies =request.getCookies();
		boolean flag=false;
		if(cookies!=null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("loginname")&&cookie.getValue()!=null ){
					return true;
				}
			}
		}

		StringBuffer url = request.getRequestURL();
		if (request.getQueryString() != null) {
			url.append("?");
			url.append(request.getQueryString());
		}
		try{
			Cookie cookie = new Cookie("return_url", URLEncoder.encode(url.toString(), "utf-8"));
			cookie.setDomain(".binfenguoyuan.cn");
			cookie.setPath("/");
			response.addCookie(cookie);
		}catch (Exception e){
		}

		response.sendRedirect("/login");
		return false;
	}

}
