package com.ec.seller.web.controller;

import com.ec.seller.domain.Addr;
import com.ec.seller.domain.Category;
import com.ec.seller.domain.query.AddrQuery;
import com.ec.seller.service.AddrService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/addr")
public class AddrController {
	@Autowired
	private AddrService addrService;
	private final static Log LOG = LogFactory.getLog(CategoryController.class);

	
//	@RequestMapping(value="/getLevelOne", method={ RequestMethod.GET, RequestMethod.POST })
//	public String queryPromotion(HttpServletRequest reuqest,HttpServletResponse response, ModelMap context){
//
//		return "product/product";
//	}

	@RequestMapping(value="/getAddress", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, Object> getAddress(Integer pId,HttpServletResponse response, HttpServletRequest request, ModelMap map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Category category=new Category();
		try {	
			AddrQuery addressQuery=new AddrQuery();
			//设置查询几级分类
			if(pId!=null){
				addressQuery.setAddressFid(pId);
			}
			
			List<Addr> addressList= addrService.selectByCondition(addressQuery);
			resultMap.put("msg","success");
			resultMap.put("addressList",addressList);//登录成功后，跳转到的页面
//			resultMap.put("category",category);//登录成功后，跳转到的页面
		} catch (Exception e) {
			LOG.error("AddressController.getAddress===", e);
		}
		return resultMap;
	}


	
}

