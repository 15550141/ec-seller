package com.ec.seller.web.controller;

import com.ec.seller.common.utils.CookieUtil;
import com.ec.seller.common.utils.DateFormatUtils;
import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.dao.ItemDao;
import com.ec.seller.dao.ReserveItemDao;
import com.ec.seller.domain.Item;
import com.ec.seller.domain.ItemPrice;
import com.ec.seller.domain.Reserve;
import com.ec.seller.domain.ReserveItem;
import com.ec.seller.domain.query.ItemPriceQuery;
import com.ec.seller.domain.query.ItemQuery;
import com.ec.seller.domain.query.ReserveItemQuery;
import com.ec.seller.domain.query.ReserveQuery;
import com.ec.seller.service.ItemPriceService;
import com.ec.seller.service.ItemService;
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
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/itemPrice")
public class ItemPriceController {

	@Autowired
	private ItemPriceService itemPriceService;

	@Autowired
	private ItemDao itemDao;

	@Autowired
	private ItemService itemService;

	private final static Log log = LogFactory.getLog(ItemPriceController.class);

	@RequestMapping(value="/index", method={ RequestMethod.GET, RequestMethod.POST })
	public String index(ItemPriceQuery query, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		PaginatedList<ItemPrice> list = itemPriceService.findPage(query);
		content.put("list", list);
		content.put("query", query);
		return "itemPrice/index";
	}

	@RequestMapping(value="/insert", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insert(ItemPrice itemPrice, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			itemPrice.setUserId(CookieUtil.getUserId(request));
			itemPrice.setUserName(CookieUtil.getLoginName(request));

			Item item = itemService.selectByItemId(itemPrice.getItemId());
			itemPrice.setItemCode(item.getItemCode());
			itemPrice.setItemId(item.getItemId());
			itemPrice.setItemName(item.getItemName());

			BigDecimal costPrice = itemPrice.getStockPrice().add(itemPrice.getUnit() == 1? new BigDecimal("0.15"):new BigDecimal("5"));	//运储成本
			costPrice = costPrice.divide(itemPrice.getQupi(), 4, BigDecimal.ROUND_HALF_UP);		//去皮系数
			costPrice = costPrice.divide(new BigDecimal(itemPrice.getSellNum()), 4, BigDecimal.ROUND_HALF_UP);	//所含个数
			costPrice = costPrice.divide(new BigDecimal("0.95"), 2, BigDecimal.ROUND_HALF_UP);	//损耗系数

			itemPrice.setCostPrice(costPrice);

			//TODO 这里写计算
			this.itemPriceService.insert(itemPrice);
			result.setSuccess(true);
		}catch (Exception e){
			result.setSuccess(false);
			log.error("", e);
		}
		return result;
	}

	@RequestMapping(value="/delete", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result delete(Long id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		this.itemPriceService.delete(id);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/modify", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result modify(ItemPrice itemPrice, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			ItemPrice dbItemPrice = itemPriceService.selectById(itemPrice.getId());
			dbItemPrice.setUserId(CookieUtil.getUserId(request));
			dbItemPrice.setUserName(CookieUtil.getLoginName(request));

			BigDecimal costPrice = itemPrice.getStockPrice().add(itemPrice.getUnit() == 1? new BigDecimal("0.15"):new BigDecimal("5"));	//运储成本
			costPrice = costPrice.divide(itemPrice.getQupi(), 4, BigDecimal.ROUND_HALF_UP);		//去皮系数
			costPrice = costPrice.divide(new BigDecimal(itemPrice.getSellNum()), 4, BigDecimal.ROUND_HALF_UP);	//所含个数
			costPrice = costPrice.divide(new BigDecimal("0.95"), 2, BigDecimal.ROUND_HALF_UP);	//损耗系数

			dbItemPrice.setCostPrice(costPrice);

			//TODO 这里写计算
			this.itemPriceService.modify(dbItemPrice);
			result.setResult(costPrice);
			result.setSuccess(true);
		}catch (Exception e){
			result.setSuccess(false);
			log.error("", e);
		}
		return result;
	}

}

