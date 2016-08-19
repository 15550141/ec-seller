package com.ec.seller.web.controller;

import com.ec.seller.common.utils.CookieUtil;
import com.ec.seller.common.utils.DateFormatUtils;
import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.dao.DeliverItemDao;
import com.ec.seller.dao.ItemDao;
import com.ec.seller.dao.ReserveItemDao;
import com.ec.seller.domain.Deliver;
import com.ec.seller.domain.DeliverItem;
import com.ec.seller.domain.Reserve;
import com.ec.seller.domain.ReserveItem;
import com.ec.seller.domain.query.DeliverItemQuery;
import com.ec.seller.domain.query.DeliverQuery;
import com.ec.seller.domain.query.ReserveItemQuery;
import com.ec.seller.domain.query.ReserveQuery;
import com.ec.seller.service.DeliverService;
import com.ec.seller.service.ReserveService;
import com.ec.seller.service.result.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.runtime.directive.Foreach;
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
@RequestMapping("/deliver")
public class DeliverController {

	@Autowired
	private ItemDao itemDao;

	@Autowired
	private DeliverService deliverService;

	@Autowired
	private DeliverItemDao deliverItemDao;

	@Autowired
	private ReserveService reserveService;
	@Autowired
	private ReserveItemDao reserveItemDao;

	private final static Log log = LogFactory.getLog(DeliverController.class);

	@RequestMapping(value="/index", method={ RequestMethod.GET, RequestMethod.POST })
	public String index(DeliverQuery query, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		query.setYn(1);
		String userName = CookieUtil.getLoginName(request);
		if(userName.equals("张宏宇")){
			query.setUserName(userName);
		}
		PaginatedList<Deliver> list = deliverService.findPage(query);
		content.put("list", list);
		content.put("query", query);
		return "reserve/index";
	}

	@RequestMapping(value="/insert", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insert(Long id, String date, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			Reserve reserve = reserveService.selectById(id);
			Deliver deliver = new Deliver();
			deliver.setStatus(0);
			deliver.setDeliverDate(reserve.getReserveDate());
			deliver.setShopName(reserve.getShopName());
			deliver.setYn(1);
			deliver.setUserId(CookieUtil.getUserId(request));
			deliver.setUserName(CookieUtil.getLoginName(request));
			Long deliverId = this.deliverService.insert(deliver);


			ReserveItemQuery query = new ReserveItemQuery();
			query.setReserveId(id);
			List<ReserveItem> list = reserveItemDao.selectByCondition(query);
			if(list != null){
				for(ReserveItem item : list){
					DeliverItem deliverItem = new DeliverItem();
					deliverItem.setDeliverId(deliverId);
					deliverItem.setItemCode(item.getItemCode());
					deliverItem.setItemName(item.getItemName());
					deliverItem.setUnit(item.getUnit());
					deliverItem.setReserveNum(item.getNum());
					deliverItemDao.insert(deliverItem);
				}
			}
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
		this.deliverService.delete(id);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/detail", method={ RequestMethod.GET, RequestMethod.POST })
	public String detail(Long id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		try{
			if(id == null || id == 0){
				return "reserve/detail";
			}
            Deliver deliver = this.deliverService.selectById(id);

			DeliverItemQuery query = new DeliverItemQuery();
			query.setDeliverId(id);
			List<DeliverItem> list = this.deliverItemDao.selectByCondition(query);
			content.put("deliver", deliver);
			content.put("list", list);
//			List<ReserveItem> list =
		}catch (Exception e){
			log.error("", e);
		}

		return "reserve/detail";
	}

	@RequestMapping(value="/addDeliverItem", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result addDeliverItem(DeliverItem deliverItem, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			deliverItemDao.insert(deliverItem);
			result.setSuccess(true);
		}catch (Exception e){
			result.setSuccess(false);
			log.error("", e);
		}
		return result;
	}

	@RequestMapping(value="/deleteDeliverItem", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result deleteDeliverItem(Long id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try {
			this.deliverItemDao.delete(id);
		}catch (Exception e){
			log.error("", e);
		}
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/updateStatus", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result updateStatus(Deliver deliver, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			deliver.setStatus(1);
			this.deliverService.modify(deliver);
		}catch (Exception e){
			log.error("", e);
		}
		result.setSuccess(true);
		return result;
	}

}

