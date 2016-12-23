package com.ec.seller.web.controller;

import com.ec.seller.common.utils.CookieUtil;
import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.ActivityExchange;
import com.ec.seller.domain.query.ActivityExchangeQuery;
import com.ec.seller.service.ActivityExchangeService;
import com.ec.seller.service.result.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/activityExchange")
public class ActivityExchangeController {

	@Autowired
	private ActivityExchangeService activityExchangeService;

	private final static Log log = LogFactory.getLog(ActivityExchangeController.class);

	@RequestMapping(value="/index", method={ RequestMethod.GET, RequestMethod.POST })
	public String index(ActivityExchangeQuery query, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		PaginatedList<ActivityExchange> list = activityExchangeService.findPage(query);
		content.put("list", list);
		content.put("query", query);
		return "activityExchange/index";
	}

	@RequestMapping(value="/insert", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insert(ActivityExchange activityExchange, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			ActivityExchangeQuery query = new ActivityExchangeQuery();
			query.setUserMobile(activityExchange.getUserMobile());
			query.setActivityId(0l);//TODO 以后要修改，这个第一次默认为0

			PaginatedList<ActivityExchange> list = this.activityExchangeService.findPage(query);
			if(list != null && list.size() > 0){
				result.setSuccess(false);
				result.setResultMessage("该用户手机号已经领取过奖品！");
				return result;
			}

			Date date = new Date();
			activityExchange.setActivityId(0l);
			activityExchange.setActivityName("集赞领奖品");
			activityExchange.setApplyTime(date);
			activityExchange.setCreated(date);
			activityExchange.setModified(date);
			activityExchange.setStatus(1);
			activityExchange.setSendTime(new Date());
			activityExchange.setSendUserId(CookieUtil.getUserId(request));
			activityExchange.setSendUserName(CookieUtil.getLoginName(request));


			this.activityExchangeService.insert(activityExchange);
			result.setSuccess(true);
		}catch (Exception e){
			result.setSuccess(false);
			log.error("", e);
		}
		return result;
	}

	@RequestMapping(value="/add", method={ RequestMethod.GET, RequestMethod.POST })
	public String add(HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		return "activityExchange/add";
	}

	@RequestMapping(value="/delete", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result delete(Long activityExchangeId, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		this.activityExchangeService.delete(activityExchangeId);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/updateStatus", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result updateStatus(Long activityExchangeId, Integer status, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			ActivityExchange activityExchange = this.activityExchangeService.selectById(activityExchangeId);
			activityExchange.setStatus(status);
			activityExchange.setSendTime(new Date());
			activityExchange.setSendUserId(CookieUtil.getUserId(request));
			activityExchange.setSendUserName(CookieUtil.getLoginName(request));
			this.activityExchangeService.modify(activityExchange);
			result.setSuccess(true);
		}catch (Exception e){
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
			log.error("", e);
		}

		return result;
	}

}

