package com.ec.seller.web.controller;

import com.ec.seller.common.utils.CookieUtil;
import com.ec.seller.common.utils.DateFormatUtils;
import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.DailySalesStatistics;
import com.ec.seller.domain.query.DailySalesStatisticsQuery;
import com.ec.seller.service.DailySalesStatisticsService;
import com.ec.seller.service.result.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/sales")
public class DailySalesStatisticsController {

	@Autowired
	private DailySalesStatisticsService dailySalesStatisticsService;

	private final static Log log = LogFactory.getLog(DailySalesStatisticsController.class);

	@RequestMapping(value="/index", method={ RequestMethod.GET, RequestMethod.POST })
	public String index(DailySalesStatisticsQuery query, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		PaginatedList<DailySalesStatistics> list = dailySalesStatisticsService.findPage(query);
		content.put("list", list);
		content.put("query", query);
		return "dailySalesStatistics/index";
	}

	@RequestMapping(value="/insert", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insert(DailySalesStatistics dailySalesStatistics, String date, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			dailySalesStatistics.setStatisticsDate(DateFormatUtils.parseDate(date, "yyyy-MM-dd"));
			dailySalesStatistics.setYn(1);
			dailySalesStatistics.setUserId(CookieUtil.getUserId(request));
			dailySalesStatistics.setUserName(CookieUtil.getLoginName(request));
			this.dailySalesStatisticsService.insert(dailySalesStatistics);
			result.setSuccess(true);
		}catch (Exception e){
			result.setSuccess(false);
			log.error("", e);
		}
		return result;
	}

	@RequestMapping(value="/add", method={ RequestMethod.GET, RequestMethod.POST })
	public String add(HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		return "dailySalesStatistics/add";
	}

	@RequestMapping(value="/delete", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result delete(Integer id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		this.dailySalesStatisticsService.delete(id);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/detail", method={ RequestMethod.GET, RequestMethod.POST })
	public String detail(Integer id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		try{
			if(id == null || id == 0){
				return "dailySalesStatisticsService/detail";
			}
			DailySalesStatistics detail = this.dailySalesStatisticsService.selectById(id);
			content.put("detail", detail);
		}catch (Exception e){
			log.error("", e);
		}

		return "dailySalesStatistics/detail";
	}

}

