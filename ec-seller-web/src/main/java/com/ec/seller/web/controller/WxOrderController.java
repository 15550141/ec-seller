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
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/wxOrder")
public class WxOrderController {

	@Autowired
	private WxOrderDao wxOrderDao;
	@Autowired
	private ScanPayListener scanPayListener;

	private final static Log log = LogFactory.getLog(WxOrderController.class);

	@RequestMapping(value="/index", method={ RequestMethod.GET, RequestMethod.POST })
	public String index(WxOrderQuery query, String startTime, String endTime, Integer index, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		query.setYn(1);
		query.setStatus(1);
		query.setPageSize(50);

		if(StringUtils.isNotBlank(startTime)){
			try{
				Date startDate = DateFormatUtils.parseDate(startTime, "yyyy-MM-dd");
				query.setStartDate(startDate);
			}catch (Exception e){

			}
		}
		if(StringUtils.isNotBlank(endTime)){
			try{
				Date endDate = DateFormatUtils.parseDate(endTime, "yyyy-MM-dd");
				query.setEndDate(DateUtils.addDays(endDate, 1));
			}catch (Exception e){

			}
		}

		if(index == null || index == 1){
			query.setDeviceInfo("长城店");
			content.put("deviceInfo", "长城店");
		}else if(index == 2){
			query.setDeviceInfo("在水一方店");
			content.put("deviceInfo", "在水一方店");
		}else if(index == 3){
			query.setDeviceInfo("道南店");
			content.put("deviceInfo", "道南店");
		}else if(index == 4){
			query.setDeviceInfo("开发区店");
			content.put("deviceInfo", "开发区店");
		}
		else if(index == 5){
			query.setDeviceInfo("碧海云天店");
			content.put("deviceInfo", "碧海云天店");
		}
		else if(index == 6){
			query.setDeviceInfo("缤纷便利店");
			content.put("deviceInfo", "缤纷便利店");
		}else if(index == 7){
			query.setDeviceInfo("北戴河北岭店");
			content.put("deviceInfo", "北戴河北岭店");
		}else{
			query.setDeviceInfo("碧海云天店");
			content.put("deviceInfo", "碧海云天店");

		}
		PaginatedList<WxOrder> list = wxOrderDao.findPage(query);
		content.put("list", list);
		content.put("query", query);
		content.put("index", index);
		content.put("startTime", startTime);
		content.put("endTime", endTime);
		return "wxOrder/index";
	}

	@RequestMapping(value="/insert", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result insert(WxOrder wxOrder, String price, HttpServletResponse response, HttpServletRequest request, ModelMap content) {

		Result result = new Result();
		if(StringUtils.isBlank(price) || "0".equals(price)){
			result.setSuccess(false);
			result.setResultMessage("订单金额不能为空或者为0");
			return result;
		}
		try{
			BigDecimal totalFee = new BigDecimal(price);
			wxOrder.setYn(1);
			wxOrder.setStatus(0);
			wxOrder.setUserId(CookieUtil.getUserId(request));
			wxOrder.setUserName(CookieUtil.getLoginName(request));
			wxOrder.setTotalFee(totalFee.multiply(new BigDecimal(100)).intValue());

//			int totalFee = 1;
//			String deviceInfo = "燕山大街店";
			wxOrder.setBody("鲜果味道微信支付订单");
			wxOrder.setAttach("tingshuoyuanyangfanhui");

			Long orderId = this.wxOrderDao.insert(wxOrder);
			if(orderId == null || orderId == 0){
				result.setSuccess(false);
				result.setResultMessage("请重新创建订单");
				return result;
			}
			wxOrder.setOrderId(orderId);
			result.setSuccess(true);
			result.setResult(wxOrder);
		}catch (Exception e){
			result.setSuccess(false);
			result.setResultMessage("系统异常，请重试！");
			log.error("", e);
		}
		return result;
	}

	@RequestMapping(value="/authCode", method={ RequestMethod.GET, RequestMethod.POST })
	public String authCode(Long orderId, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		content.put("orderId", orderId);
		return "wxOrder/authCode";
	}

	@RequestMapping(value="/wxPay", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Result wxPay(Long orderId, String authCode, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		Result result = new Result();
		try{
			WxOrder wxOrder = this.wxOrderDao.selectById(orderId);
			wxOrder.setAuthCode(authCode);
			wxOrder.setStatus(1);//已扫码
			wxOrderDao.modify(wxOrder);

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

	@RequestMapping(value="/excel", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody void excel(String startTime, String endTime, Integer index, HttpServletResponse response, HttpServletRequest request, ModelMap content) {
		WxOrderQuery query = new WxOrderQuery();
		query.setYn(1);
		query.setStatus(1);

		if(index == null || index == 1){
			query.setDeviceInfo("长城店");
		}else if(index == 2){
			query.setDeviceInfo("在水一方店");
		}else if(index == 3){
			query.setDeviceInfo("道南店");
		}else if(index == 4){
			query.setDeviceInfo("开发区店");
		}else if(index == 5){
			query.setDeviceInfo("碧海云天店");
		}else if(index == 6){
			query.setDeviceInfo("缤纷便利店");
		}else if(index == 7){
			query.setDeviceInfo("北戴河北岭店");
		}else{
			query.setDeviceInfo("碧海云天店");
		}

		if(StringUtils.isNotBlank(startTime)){
			try{
				Date startDate = DateFormatUtils.parseDate(startTime, "yyyy-MM-dd");
				query.setStartDate(startDate);
			}catch (Exception e){

			}
		}
		if(StringUtils.isNotBlank(endTime)){
			try{
				Date endDate = DateFormatUtils.parseDate(endTime, "yyyy-MM-dd");
				query.setEndDate(DateUtils.addDays(endDate, 1));
			}catch (Exception e){

			}
		}

		List<WxOrder> list = wxOrderDao.selectAll(query);



		if(list == null){
			list = new ArrayList<WxOrder>();
		}

		try {
			// 第一步，创建一个webbook，对应一个Excel文件
			HSSFWorkbook wb = new HSSFWorkbook();
			// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet sheet = wb.createSheet("结算管理");
			// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
			HSSFRow row = sheet.createRow((int) 0);
			// 第四步，创建单元格，并设置值表头 设置表头居中
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

			HSSFCell cell = row.createCell((short) 0);
			cell.setCellValue("店铺信息");
			cell.setCellStyle(style);
			cell = row.createCell((short) 1);
			cell.setCellValue("订单号");
			cell.setCellStyle(style);
			cell = row.createCell((short) 2);
			cell.setCellValue("订单总金额");
			cell.setCellStyle(style);
			cell = row.createCell((short) 3);
			cell.setCellValue("操作人");
			cell.setCellStyle(style);
			cell = row.createCell((short) 4);
			cell.setCellValue("时间");
			cell.setCellStyle(style);
			cell = row.createCell((short) 5);
			cell.setCellValue("支付状态");
			cell.setCellStyle(style);

			for(int i=0;i<list.size();i++){
				row = sheet.createRow((int) i + 1);
				WxOrder wxOrder = (WxOrder) list.get(i);
				// 第四步，创建单元格，并设置值
				row.createCell((short) 0).setCellValue(wxOrder.getDeviceInfo());
				row.createCell((short) 1).setCellValue(wxOrder.getOrderId());

				row.createCell((short) 2).setCellValue(wxOrder.getTotalFeePrice().doubleValue());
				row.createCell((short) 3).setCellValue(wxOrder.getUserName());
				row.createCell((short) 4).setCellValue(DateFormatUtils.format(wxOrder.getCreated()));
				String status = "";
				if(wxOrder.getStatus() == 1)
					status =  "未支付";
				else if(wxOrder.getStatus() == 2)
					status =  "支付成功";
				row.createCell((short) 5).setCellValue(status);
			}

			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Content-disposition", "attachment;filename="+DateFormatUtils.format(new Date(),"yyyyMMddHHmmss")+".xls");
			wb.write(response.getOutputStream());
		} catch (IOException e) {
			log.error("", e);
		}

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

