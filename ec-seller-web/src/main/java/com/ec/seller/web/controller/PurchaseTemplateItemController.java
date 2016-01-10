package com.ec.seller.web.controller;

import com.ec.seller.common.utils.CookieUtil;
import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.domain.PurchaseTemplate;
import com.ec.seller.domain.PurchaseTemplateItem;
import com.ec.seller.domain.query.PurchaseTemplateItemQuery;
import com.ec.seller.domain.query.PurchaseTemplateQuery;
import com.ec.seller.service.ItemService;
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
@RequestMapping("/purchaseTemplateItem")
public class PurchaseTemplateItemController {
	@Autowired
	private PurchaseTemplateItemService purchaseTemplateItemService;

	@Autowired
	private ItemService itemService;

	private final static Log log = LogFactory.getLog(PurchaseTemplateItemController.class);

	@RequestMapping(value="/insert", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insert(PurchaseTemplateItem purchaseTemplateItem, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			purchaseTemplateItemService.insert(purchaseTemplateItem);
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
		try{
			this.purchaseTemplateItemService.delete(id);
			result.setSuccess(true);
		}catch (Exception e){
			log.error("", e);
		}
		return result;
	}

	@RequestMapping(value="/vagueQuery", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result vagueQuery(String itemName, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			result.setResult(itemService.vagueQueryItemName(itemName));
			result.setSuccess(true);
		}catch (Exception e){
			log.error("", e);
		}
		return result;
	}

}

