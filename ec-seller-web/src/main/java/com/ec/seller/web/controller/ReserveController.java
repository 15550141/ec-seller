package com.ec.seller.web.controller;

import com.ec.seller.common.utils.CookieUtil;
import com.ec.seller.common.utils.DateFormatUtils;
import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.dao.ReserveDao;
import com.ec.seller.domain.DailySalesStatistics;
import com.ec.seller.domain.Reserve;
import com.ec.seller.domain.ReserveItem;
import com.ec.seller.domain.query.DailySalesStatisticsQuery;
import com.ec.seller.domain.query.ReserveQuery;
import com.ec.seller.service.DailySalesStatisticsService;
import com.ec.seller.service.ReserveService;
import com.ec.seller.service.result.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/reserve")
public class ReserveController {

	@Autowired
	private ReserveService reserveService;

	private final static Log log = LogFactory.getLog(ReserveController.class);

	@RequestMapping(value="/index", method={ RequestMethod.GET, RequestMethod.POST })
	public String index(ReserveQuery query, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		query.setYn(1);
		String userName = CookieUtil.getLoginName(request);
		if(userName.equals("张宏宇")){
			query.setUserName(userName);
		}
		PaginatedList<Reserve> list = reserveService.findPage(query);
		content.put("list", list);
		content.put("query", query);
		return "reserve/index";
	}

	@RequestMapping(value="/insert", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insert(Reserve reserve, String date, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
            reserve.setYn(1);
            reserve.setReserveDate(DateFormatUtils.parseDate(date, "yyyy-MM-dd"));
            reserve.setStatus(0);
            reserve.setUserId(CookieUtil.getUserId(request));
            reserve.setUserName(CookieUtil.getLoginName(request));
			this.reserveService.insert(reserve);
			result.setSuccess(true);
		}catch (Exception e){
			result.setSuccess(false);
			log.error("", e);
		}
		return result;
	}

	@RequestMapping(value="/add", method={ RequestMethod.GET, RequestMethod.POST })
	public String add(HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		return "reserve/add";
	}

	@RequestMapping(value="/delete", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result delete(Long id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		this.reserveService.delete(id);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/detail", method={ RequestMethod.GET, RequestMethod.POST })
	public String detail(Integer id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		try{
			if(id == null || id == 0){
				return "reserve/detail";
			}
            Reserve reserve = this.reserveService.selectById(id);
			content.put("reserve", reserve);
//			List<ReserveItem> list =
		}catch (Exception e){
			log.error("", e);
		}

		return "reserve/detail";
	}

}

