package com.ec.seller.web.controller;

import com.ec.seller.domain.Storage;
import com.ec.seller.domain.StorageItem;
import com.ec.seller.domain.query.StorageItemQuery;
import com.ec.seller.service.ItemService;
import com.ec.seller.service.StorageItemService;
import com.ec.seller.service.StorageService;
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
@RequestMapping("/storageItem")
public class StorageItemController {
	@Autowired
	private StorageItemService storageItemService;
	@Autowired
	private StorageService storageService;

	@Autowired
	private ItemService itemService;

	private final static Log log = LogFactory.getLog(StorageItemController.class);

	@RequestMapping(value="/insert", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insert(StorageItem storageItem, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			storageItemService.insert(storageItem);
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
			this.storageItemService.delete(id);
			result.setSuccess(true);
		}catch (Exception e){
			log.error("", e);
		}
		return result;
	}

	@RequestMapping(value="/update", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result update(StorageItem storageItem, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{

			if(storageItem.getNum() != null && storageItem.getPrice() != null){
				storageItem.setTotalPrice(storageItem.getPrice().multiply(new BigDecimal(storageItem.getNum())));
			}

			this.storageItemService.modify(storageItem);

			//修改采购单采购总金额
			StorageItem dbStorageItem = this.storageItemService.selectById(storageItem.getId());
			StorageItemQuery query = new StorageItemQuery();
			query.setStorageId(dbStorageItem.getStorageId());
			List<StorageItem> list =  this.storageItemService.findList(query);

			Storage storage = new Storage();
			storage.setId(dbStorageItem.getStorageId());
			storage.setTotalPrice(BigDecimal.ZERO);

			for(int i=0;i<list.size();i++){
				if(list.get(i).getTotalPrice() == null){
					continue;
				}
				//采购商品总金额
				storage.setTotalPrice(storage.getTotalPrice().add(list.get(i).getTotalPrice()));
			}

			this.storageService.modify(storage);

			result.setSuccess(true);
		}catch (Exception e){
			log.error("", e);
		}
		return result;
	}

}

