package com.ec.seller.web.controller;

import com.ec.seller.common.utils.CookieUtil;
import com.ec.seller.common.utils.DateFormatUtils;
import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.Purchase;
import com.ec.seller.domain.query.PurchaseItemQuery;
import com.ec.seller.domain.query.PurchaseQuery;
import com.ec.seller.service.PurchaseItemService;
import com.ec.seller.service.PurchaseService;
import com.ec.seller.service.result.Result;
import org.apache.commons.lang.StringUtils;
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
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;

	@Autowired
	private PurchaseItemService purchaseItemService;

	private final static Log log = LogFactory.getLog(PurchaseController.class);

	@RequestMapping(value="/index", method={ RequestMethod.GET, RequestMethod.POST })
	public String index(PurchaseQuery query, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		PaginatedList<Purchase> list = purchaseService.findPage(query);
		content.put("list", list);
		content.put("query", query);
		return "purchase/index";
	}

	@RequestMapping(value="/insertByTemplate", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insertByTemplate(Integer purchaseTemplateId, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			Integer id = purchaseService.insertByTemplate(purchaseTemplateId, CookieUtil.getUserId(request), CookieUtil.getLoginName(request));
			result.setSuccess(true);
			result.setResult(id);
		}catch (Exception e) {
			log.error("", e);
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value="/insert", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insert(Purchase purchase, String date, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		purchase.setPurchaseTime(DateFormatUtils.parseDate(date, "yyyy-MM-dd"));
		Result result = new Result();
		purchase.setPurchaseName(CookieUtil.getLoginName(request));
		purchase.setPurchaseUid(CookieUtil.getUserId(request));
		purchase.setStatus(0);
		purchase.setYn(1);
		this.purchaseService.insert(purchase);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/add", method={ RequestMethod.GET, RequestMethod.POST })
	public String add(Integer purchaseId, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		return "purchase/add";
	}

	@RequestMapping(value="/update", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result update(Purchase purchase, String purchaseDate, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		if(StringUtils.isNotBlank(purchaseDate)){
			purchase.setPurchaseTime(DateFormatUtils.parseDate(purchaseDate, "yyyy-MM-dd"));
		}
		purchase.setStatus(1);//采购完成
		try{
			this.purchaseService.modify(purchase);
			result.setSuccess(true);
		}catch (Exception e){
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
			log.error("", e);
		}
		return result;
	}

	@RequestMapping(value="/delete", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result delete(Integer id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		this.purchaseService.delete(id);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/detail", method={ RequestMethod.GET, RequestMethod.POST })
	public String detail(Integer id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		try{
			if(id == null || id == 0){
				return "purchase/detail";
			}
			Purchase purchase = this.purchaseService.selectById(id);
			PurchaseItemQuery query = new PurchaseItemQuery();
			query.setPurchaseId(id);
			content.put("purchaseItemList", purchaseItemService.findList(query));
			content.put("purchase", purchase);
		}catch (Exception e){
			log.error("", e);
		}

		return "purchase/detail";
	}

}

