package com.ec.seller.web.interceptor;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ec.seller.common.utils.CookieUtil;
import org.apache.commons.lang.StringUtils;
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
		String path = request.getRequestURI();

		String name = CookieUtil.getLoginName(request);
		request.setAttribute("name", name);

		if(StringUtils.isNotBlank(name)){
			if(name.equals("于建明") || name.equals("杨慧斌") || name.equals("张瀚洋") || name.equals("韩建初")|| name.equals("苏立强") || name.equals("庞勇") || name.equals("王闯")
					|| name.equals("魏宇星") || name.equals("张宏宇")){
				return true;
			}

			if(path.startsWith("/purchase/index")){
				return true;
			}

			if(path.startsWith("/product/") || path.startsWith("/purchase/")
					|| path.startsWith("/purchaseTemplate/")){
				return false;
			}
			return true;
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
