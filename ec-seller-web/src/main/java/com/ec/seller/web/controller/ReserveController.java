package com.ec.seller.web.controller;

import com.ec.seller.common.utils.CookieUtil;
import com.ec.seller.common.utils.DateFormatUtils;
import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.dao.ItemDao;
import com.ec.seller.dao.ReserveItemDao;
import com.ec.seller.domain.Item;
import com.ec.seller.domain.Reserve;
import com.ec.seller.domain.ReserveItem;
import com.ec.seller.domain.query.ReserveItemQuery;
import com.ec.seller.domain.query.ReserveQuery;
import com.ec.seller.service.ReserveService;
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
import java.util.List;

@Controller
@RequestMapping("/reserve")
public class ReserveController {

	@Autowired
	private ReserveService reserveService;

	@Autowired
	private ReserveItemDao reserveItemDao;
	@Autowired
	private ItemDao itemDao;

	private final static Log log = LogFactory.getLog(ReserveController.class);

	@RequestMapping(value="/index", method={ RequestMethod.GET, RequestMethod.POST })
	public String index(ReserveQuery query, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		query.setYn(1);
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
	public String detail(Long id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		try{
			if(id == null || id == 0){
				return "reserve/detail";
			}
            Reserve reserve = this.reserveService.selectById(id);

			ReserveItemQuery query = new ReserveItemQuery();
			query.setReserveId(id);
			List<ReserveItem> list = this.reserveItemDao.selectByCondition(query);
			content.put("reserve", reserve);
			content.put("list", list);
//			List<ReserveItem> list =
		}catch (Exception e){
			log.error("", e);
		}

		return "reserve/detail";
	}

	@RequestMapping(value="/addReserveItem", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result addReserveItem(ReserveItem reserveItem, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			reserveItemDao.insert(reserveItem);
			result.setSuccess(true);
		}catch (Exception e){
			result.setSuccess(false);
			log.error("", e);
		}
		return result;
	}

	@RequestMapping(value="/deleteReserveItem", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result deleteReserveItem(Long id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try {
			this.reserveItemDao.delete(id);
		}catch (Exception e){
			log.error("", e);
		}
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/updateStatus", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result updateStatus(Long id, String remark, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			Reserve reserve = this.reserveService.selectById(id);
			reserve.setStatus(1);
			reserve.setRemark(remark);
			this.reserveService.modify(reserve);
			result.setSuccess(true);
		}catch (Exception e){
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
			log.error("", e);
		}

		return result;
	}

}

