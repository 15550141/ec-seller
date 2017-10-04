package com.ec.seller.web.controller;

import com.ec.seller.domain.Purchase;
import com.ec.seller.domain.PurchaseItem;
import com.ec.seller.domain.ReturnGoods;
import com.ec.seller.domain.ReturnGoodsItem;
import com.ec.seller.domain.query.PurchaseItemQuery;
import com.ec.seller.domain.query.ReturnGoodsItemQuery;
import com.ec.seller.service.*;
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
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/returnGoodsItem")
public class ReturnGoodsItemController {
	@Autowired
	private ReturnGoodsItemService returnGoodsItemService;
	@Autowired
	private ReturnGoodsService returnGoodsService;

	@Autowired
	private ItemService itemService;

	private final static Log log = LogFactory.getLog(ReturnGoodsItemController.class);

	@RequestMapping(value="/insert", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insert(ReturnGoodsItem returnGoodsItem, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			returnGoodsItemService.insert(returnGoodsItem);
			//修改采购单采购总金额
			updateReturnGoodsTotalPrice(returnGoodsItem.getReturnGoodsId());
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
			ReturnGoodsItem dbReturnGoodsItem = this.returnGoodsItemService.selectById(id);
			this.returnGoodsItemService.delete(id);
			//修改采购单采购总金额
			updateReturnGoodsTotalPrice(dbReturnGoodsItem.getReturnGoodsId());
			result.setSuccess(true);
		}catch (Exception e){
			log.error("", e);
		}
		return result;
	}

	@RequestMapping(value="/update", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result update(ReturnGoodsItem returnGoodsItem, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			this.returnGoodsItemService.modify(returnGoodsItem);
			ReturnGoodsItem dbReturnGoodsItem = this.returnGoodsItemService.selectById(returnGoodsItem.getId());
			//修改采购单采购总金额
			updateReturnGoodsTotalPrice(dbReturnGoodsItem.getReturnGoodsId());

			result.setSuccess(true);
		}catch (Exception e){
			log.error("", e);
		}
		return result;
	}


	private void updateReturnGoodsTotalPrice(Integer returnGoodsId){
		ReturnGoodsItemQuery query = new ReturnGoodsItemQuery();
		query.setReturnGoodsId(returnGoodsId);
		List<ReturnGoodsItem> list =  this.returnGoodsItemService.findList(query);

		ReturnGoods returnGoods = new ReturnGoods();
		returnGoods.setId(returnGoodsId);
		returnGoods.setTotalPrice(BigDecimal.ZERO);
		returnGoods.setReturnPrice(BigDecimal.ZERO);

		for(int i=0;i<list.size();i++){
			if(list.get(i).getTotalPrice() == null){
				continue;
			}
			//采购商品总金额
			returnGoods.setReturnPrice(returnGoods.getReturnPrice().add(list.get(i).getTotalPrice()));
		}
		//总金额 = 采购商品总金额+采购其他费用
		returnGoods.setTotalPrice(returnGoods.getReturnPrice());
		this.returnGoodsService.modify(returnGoods);
	}
}

