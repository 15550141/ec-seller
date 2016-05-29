package com.ec.seller.web.controller;

import com.ec.seller.common.utils.CookieUtil;
import com.ec.seller.common.utils.DateFormatUtils;
import com.ec.seller.common.utils.PaginatedList;
import com.ec.seller.dao.WxOrderDao;
import com.ec.seller.domain.DailySalesStatistics;
import com.ec.seller.domain.WxOrder;
import com.ec.seller.domain.query.DailySalesStatisticsQuery;
import com.ec.seller.domain.query.WxOrderQuery;
import com.ec.seller.service.DailySalesStatisticsService;
import com.ec.seller.service.result.Result;
import com.ec.seller.service.wx.ScanPayListener;
import com.tencent.WXPay;
import com.tencent.protocol.pay_protocol.ScanPayReqData;
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
@RequestMapping("/wxOrder")
public class WxOrderController {

	@Autowired
	private WxOrderDao wxOrderDao;
	@Autowired
	private ScanPayListener scanPayListener;

	private final static Log log = LogFactory.getLog(WxOrderController.class);

	@RequestMapping(value="/index", method={ RequestMethod.GET, RequestMethod.POST })
	public String index(WxOrderQuery query, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		query.setYn(1);
		PaginatedList<WxOrder> list = wxOrderDao.findPage(query);
		content.put("list", list);
		content.put("query", query);
		return "wxOrder/index";
	}

	@RequestMapping(value="/insert", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insert(WxOrder wxOrder, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			wxOrder.setYn(1);
			wxOrder.setUserId(CookieUtil.getUserId(request));
			wxOrder.setUserName(CookieUtil.getLoginName(request));


//			int totalFee = 1;
//			String deviceInfo = "燕山大街店";
			wxOrder.setBody("新接入测试");
			wxOrder.setAttach("tingshuoyuanyangfanhui");

			Long orderId = this.wxOrderDao.insert(wxOrder);
			if(orderId == null || orderId == 0){
				result.setSuccess(false);
				result.setResultMessage("请重新创建订单");
			}
			wxOrder.setOrderId(orderId);
			result.setSuccess(true);
			result.setResult(wxOrder);
		}catch (Exception e){
			result.setSuccess(false);
			log.error("", e);
		}
		return result;
	}

	@RequestMapping(value="/payPage", method={ RequestMethod.GET, RequestMethod.POST })
	public String payPage(WxOrder wxOrder, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		content.put("wxOrder", wxOrder);
		return "wxOrder/payPage";
	}

	@RequestMapping(value="/pay", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result pay(Long orderId, String autoCode, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			WxOrder wxOrder = this.wxOrderDao.selectById(orderId);
			wxOrder.setAuthCode(autoCode);
			this.wxPay(wxOrder);
			result.setSuccess(true);
			result.setResult(wxOrder);
		}catch (Exception e){
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
			log.error("", e);
		}
		return result;
	}

	@RequestMapping(value="/add", method={ RequestMethod.GET, RequestMethod.POST })
	public String add(HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		return "wxOrder/add";
	}

	@RequestMapping(value="/detail", method={ RequestMethod.GET, RequestMethod.POST })
	public String detail(Long id, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		try{
			if(id == null || id == 0){
				return "dailySalesStatisticsService/detail";
			}
			WxOrder detail = this.wxOrderDao.selectById(id);
			content.put("detail", detail);
		}catch (Exception e){
			log.error("", e);
		}

		return "wxOrder/detail";
	}

	private void wxPay(WxOrder wxOrder) throws Exception {
		String authCode = wxOrder.getAuthCode();
		String body = wxOrder.getBody();
		String attach = wxOrder.getAttach();
		String outTradeNo = wxOrder.getOrderId().toString();
		int totalFee = wxOrder.getTotalFee();
		String deviceInfo = wxOrder.getDeviceInfo();
		String spBillCreateIP = "127.0.0.1";
		String goodsTag = "";

		ScanPayReqData scanPayReqData = new ScanPayReqData(authCode, body, attach, outTradeNo, totalFee, deviceInfo, spBillCreateIP, "", "", goodsTag);

		WXPay.doScanPayBusiness(scanPayReqData , scanPayListener);
	}
}

