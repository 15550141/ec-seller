package com.ec.seller.web.controller;

import com.ec.seller.common.utils.BigDecimalUtils;
import com.ec.seller.domain.Purchase;
import com.ec.seller.domain.PurchaseItem;
import com.ec.seller.domain.query.PurchaseItemQuery;
import com.ec.seller.service.ItemService;
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
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/purchaseItem")
public class PurchaseItemController {
	@Autowired
	private PurchaseItemService purchaseItemService;
	@Autowired
	private PurchaseService purchaseService;

	@Autowired
	private ItemService itemService;

	private final static Log log = LogFactory.getLog(PurchaseItemController.class);

	@RequestMapping(value="/insert", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insert(PurchaseItem purchaseItem, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			purchaseItemService.insert(purchaseItem);
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
			this.purchaseItemService.delete(id);
			result.setSuccess(true);
		}catch (Exception e){
			log.error("", e);
		}
		return result;
	}

	@RequestMapping(value="/update", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result update(PurchaseItem purchaseItem, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			this.purchaseItemService.modify(purchaseItem);

			//修改采购单采购总金额
			PurchaseItem dbPurchaseItem = this.purchaseItemService.selectById(purchaseItem.getId());
			PurchaseItemQuery query = new PurchaseItemQuery();
			query.setPurchaseId(dbPurchaseItem.getPurchaseId());
			List<PurchaseItem> list =  this.purchaseItemService.findList(query);

			Purchase purchase = new Purchase();
			purchase.setId(dbPurchaseItem.getPurchaseId());
			purchase.setPurchaseTotalPrice(BigDecimal.ZERO);
			for(int i=0;i<list.size();i++){
				if(list.get(i).getTotalPrice() == null){
					continue;
				}
				//采购商品总金额
				purchase.setPurchaseTotalPrice(purchase.getPurchaseTotalPrice().add(list.get(i).getTotalPrice()));
			}
			//总金额 = 采购商品总金额+采购其他费用
			purchase.setTotalPrice(purchase.getPurchaseTotalPrice());
			this.purchaseService.modify(purchase);

			result.setSuccess(true);
		}catch (Exception e){
			log.error("", e);
		}
		return result;
	}

}

