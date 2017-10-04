package com.ec.seller.web.controller;

import com.ec.seller.common.utils.CookieUtil;
import com.ec.seller.common.utils.DateFormatUtils;
import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.dao.ItemDao;
import com.ec.seller.domain.ReturnGoods;
import com.ec.seller.domain.ReturnGoodsItem;
import com.ec.seller.domain.query.ReturnGoodsItemQuery;
import com.ec.seller.domain.query.ReturnGoodsQuery;
import com.ec.seller.service.ReturnGoodsItemService;
import com.ec.seller.service.ReturnGoodsService;
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
@RequestMapping("/returnGoods")
public class ReturnGoodsController {
	@Autowired
	private ReturnGoodsService returnGoodsService;

	@Autowired
	private ReturnGoodsItemService returnGoodsItemService;

	@Autowired
	private ItemDao itemDao;

	private final static Log log = LogFactory.getLog(ReturnGoodsController.class);

	@RequestMapping(value="/index", method={ RequestMethod.GET, RequestMethod.POST })
	public String index(ReturnGoodsQuery query, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		PaginatedList<ReturnGoods> list = returnGoodsService.findPage(query);
		content.put("list", list);
		content.put("query", query);
		content.put("username", CookieUtil.getLoginName(request));
		return "returnGoods/index";
	}

	@RequestMapping(value="/insert", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insert(ReturnGoods returnGoods, String date, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		returnGoods.setReturnTime(DateFormatUtils.parseDate(date, "yyyy-MM-dd"));
		Result result = new Result();
		returnGoods.setName(CookieUtil.getLoginName(request));
		returnGoods.setUid(CookieUtil.getUserId(request));
		returnGoods.setStatus(0);
		returnGoods.setYn(1);
		this.returnGoodsService.insert(returnGoods);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/add", method={ RequestMethod.GET, RequestMethod.POST })
	public String add(Integer id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		return "returnGoods/add";
	}

	@RequestMapping(value="/update", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result update(ReturnGoods returnGoods, String date, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			if(StringUtils.isNotBlank(date)){
				returnGoods.setReturnTime(DateFormatUtils.parseDate(date, "yyyy-MM-dd"));
			}

			returnGoods.setStatus(1);//采购完成

			//查询该采购单所有采购商品列表，计算采购商品总金额
			ReturnGoodsItemQuery query = new ReturnGoodsItemQuery();
			query.setReturnGoodsId(returnGoods.getId());
			List<ReturnGoodsItem> list =  this.returnGoodsItemService.findList(query);
			if(list == null){
				result.setSuccess(false);
				result.setResultMessage("没有添加退货商品！");
				return result;
			}
			returnGoods.setTotalPrice(BigDecimal.ZERO);
			returnGoods.setReturnPrice(BigDecimal.ZERO);

			for(int i=0;i<list.size();i++){
				ReturnGoodsItem returnGoodsItem = list.get(i);

				if(returnGoodsItem.getTotalPrice() == null){
					continue;
				}
				//采购商品总金额
				returnGoods.setReturnPrice(returnGoods.getReturnPrice().add(returnGoodsItem.getTotalPrice()));
			}

			returnGoods.setTotalPrice(returnGoods.getReturnPrice());
			if(returnGoods.getOtherPrice() != null){
				//总金额 = 采购商品总金额+采购其他费用
				returnGoods.setTotalPrice(returnGoods.getTotalPrice().add(returnGoods.getOtherPrice()));
			}

			this.returnGoodsService.modify(returnGoods);
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
		this.returnGoodsService.delete(id);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/shenhe", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result shenhe(Integer id, Integer status, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		ReturnGoods returnGoods = this.returnGoodsService.selectById(id);
		returnGoods.setStatus(status);
		returnGoods.setShenheName(CookieUtil.getLoginName(request));
		returnGoods.setShenheUid(CookieUtil.getUserId(request));
		this.returnGoodsService.modify(returnGoods);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/detail", method={ RequestMethod.GET, RequestMethod.POST })
	public String detail(Integer id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		try{
			if(id == null || id == 0){
				return "returnGoods/detail";
			}
			ReturnGoods returnGoods = this.returnGoodsService.selectById(id);
			ReturnGoodsItemQuery query = new ReturnGoodsItemQuery();
			query.setReturnGoodsId(id);
			content.put("returnGoodsItemList", returnGoodsItemService.findList(query));
			content.put("returnGoods", returnGoods);
		}catch (Exception e){
			log.error("", e);
		}

		return "returnGoods/detail";
	}

}

