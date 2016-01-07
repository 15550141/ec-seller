package com.ec.seller.web.controller;

import com.ec.seller.common.utils.CookieUtil;
import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.PurchaseTemplate;
import com.ec.seller.domain.PurchaseTemplateItem;
import com.ec.seller.domain.query.PurchaseTemplateItemQuery;
import com.ec.seller.domain.query.PurchaseTemplateQuery;
import com.ec.seller.service.PurchaseTemplateItemService;
import com.ec.seller.service.PurchaseTemplateService;
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
@RequestMapping("/purchaseTemplate")
public class PurchaseTemplateController {
	@Autowired
	private PurchaseTemplateService purchaseTemplateService;

	@Autowired
	private PurchaseTemplateItemService purchaseTemplateItemService;

	private final static Log log = LogFactory.getLog(PurchaseTemplateController.class);

	@RequestMapping(value="", method={ RequestMethod.GET, RequestMethod.POST })
	public String index(PurchaseTemplateQuery query, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		PaginatedList<PurchaseTemplate> list = purchaseTemplateService.findPage(query);
		content.put("list", list);
		content.put("query", query);
		return "purchaseTemplate/index";
	}

	@RequestMapping(value="/insert", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insert(PurchaseTemplate purchaseTemplate, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		purchaseTemplate.setUserId(CookieUtil.getUserId(request));
		//TODO 这里少进货人名称
		purchaseTemplate.setUserName("鲜果味道");
		this.purchaseTemplateService.insert(purchaseTemplate);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/add", method={ RequestMethod.GET, RequestMethod.POST })
	public String add(Integer purchaseTemplateId, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		return "purchaseTemplate/add";
	}

	@RequestMapping(value="/delete", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result delete(Integer id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		this.purchaseTemplateService.delete(id);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/detail", method={ RequestMethod.GET, RequestMethod.POST })
	public String detail(Integer id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		try{
			PurchaseTemplate purchaseTemplate = this.purchaseTemplateService.selectById(id);
			PurchaseTemplateItemQuery query = new PurchaseTemplateItemQuery();
			query.setPurchaseTemplateId(id);
			content.put("purchaseTemplateItem", purchaseTemplateItemService.findList(query));
			content.put("purchaseTemplate", purchaseTemplate);
		}catch (Exception e){
			log.error("", e);
		}

		return "purchaseTemplate/detail";
	}

}

