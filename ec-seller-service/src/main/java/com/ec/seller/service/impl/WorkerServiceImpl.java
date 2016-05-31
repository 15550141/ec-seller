package com.ec.seller.service.impl;


import java.util.Date;
import java.util.List;

import com.ec.seller.dao.WxOrderDao;
import com.ec.seller.domain.WxOrder;
import com.ec.seller.domain.query.WxOrderQuery;
import com.tencent.WXPay;
import com.tencent.common.Util;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryReqData;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryResData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.seller.domain.PromotionInfo;
import com.ec.seller.domain.query.ItemQuery;
import com.ec.seller.manager.WorkerManager;
import com.ec.seller.service.WorkerService;


@Service(value = "workerService")
public class WorkerServiceImpl implements WorkerService{
	@Autowired
	private WorkerManager workerManager;

	@Autowired
	private WxOrderDao wxOrderDao;
	
	private final static Log LOG = LogFactory.getLog(WorkerServiceImpl.class);

	private static boolean isRun = false;

	@Override
	public void searchWxPay() {
		if(isRun){
			return;
		}
		isRun = true;
		try{

			WxOrderQuery query = new WxOrderQuery();
			query.setCreated(new Date((new Date().getTime()-(1000*60*10))));

			List<WxOrder> list = wxOrderDao.getNonePayWxOrder(query);
			for(WxOrder wxOrder : list){

				ScanPayQueryReqData reqData = new ScanPayQueryReqData("", wxOrder.getOrderId()+"");
				String result = WXPay.requestScanPayQueryService(reqData);
				ScanPayQueryResData refundResData = (ScanPayQueryResData) Util.getObjectFromXML(result, ScanPayQueryResData.class);
				if("SUCCESS".equals(refundResData.getTrade_state())){
					wxOrder.setStatus(2);
					wxOrder.setTransactionId(refundResData.getTransaction_id());
					wxOrderDao.modify(wxOrder);
					LOG.error("微信支付完成：	orderId="+wxOrder.getOrderId());
				}
			}

		}catch (Exception e){
			LOG.error("", e);
		}finally {
			isRun = false;
		}
	}

}
