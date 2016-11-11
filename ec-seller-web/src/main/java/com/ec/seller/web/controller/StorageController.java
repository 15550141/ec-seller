package com.ec.seller.web.controller;

import com.ec.seller.common.utils.CookieUtil;
import com.ec.seller.common.utils.DateFormatUtils;
import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.dao.ItemDao;
import com.ec.seller.domain.Item;
import com.ec.seller.domain.Storage;
import com.ec.seller.domain.StorageItem;
import com.ec.seller.domain.query.StorageItemQuery;
import com.ec.seller.domain.query.StorageQuery;
import com.ec.seller.service.StorageItemService;
import com.ec.seller.service.StorageService;
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
@RequestMapping("/storage")
public class StorageController {
	@Autowired
	private StorageService storageService;

	@Autowired
	private StorageItemService storageItemService;

	@Autowired
	private ItemDao itemDao;

	private final static Log log = LogFactory.getLog(StorageController.class);

	@RequestMapping(value="/index", method={ RequestMethod.GET, RequestMethod.POST })
	public String index(StorageQuery query, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		PaginatedList<Storage> list = storageService.findPage(query);
		content.put("list", list);
		content.put("query", query);
		return "storage/index";
	}

	@RequestMapping(value="/insertByPurchase", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insertByPurchase(Integer purchaseId, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			Integer id = storageService.insertByPurchase(purchaseId, CookieUtil.getUserId(request), CookieUtil.getLoginName(request));
			result.setSuccess(true);
			result.setResult(id);
		}catch (Exception e) {
			log.error("", e);
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value="/update", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result update(Storage storage, String storageDate, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			if(StringUtils.isNotBlank(storageDate)){
				storage.setStorageTime(DateFormatUtils.parseDate(storageDate, "yyyy-MM-dd"));
			}

			storage.setStatus(1);//采购完成

			//查询该采购单所有采购商品列表，计算采购商品总金额
			StorageItemQuery query = new StorageItemQuery();
			query.setStorageId(storage.getId());
			List<StorageItem> list =  this.storageItemService.findList(query);

			if(list == null){
				result.setSuccess(false);
				result.setResultMessage("没有添加入库商品！");
				return result;
			}

			storage.setTotalPrice(BigDecimal.ZERO);

			for(int i=0;i<list.size();i++){
				StorageItem storageItem = list.get(i);

				if(storageItem.getNum() != null && storageItem.getNum() != 0d){
					Item item = itemDao.selectByItemId(storageItem.getItemId());
					if(item.getStockNum() == null){
						item.setStockNum(new BigDecimal(storageItem.getNum()));
					}else {
						item.setStockNum(item.getStockNum().add(new BigDecimal(storageItem.getNum())));
					}
					itemDao.modify(item);
				}

				if(storageItem.getTotalPrice() == null){
					continue;
				}
				//采购商品总金额
				storage.setTotalPrice(storage.getTotalPrice().add(storageItem.getTotalPrice()));
			}

			this.storageService.modify(storage);
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
		this.storageService.delete(id);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping(value="/detail", method={ RequestMethod.GET, RequestMethod.POST })
	public String detail(Integer id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		try{
			if(id == null || id == 0){
				return "storage/detail";
			}
			Storage storage = this.storageService.selectById(id);
			StorageItemQuery query = new StorageItemQuery();
			query.setStorageId(id);
			content.put("storageItemList", storageItemService.findList(query));
			content.put("storage", storage);
		}catch (Exception e){
			log.error("", e);
		}

		return "storage/detail";
	}

}

