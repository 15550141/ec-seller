package com.ec.seller.web.work;

import org.springframework.beans.factory.annotation.Autowired;

import com.ec.seller.service.WorkerService;

public class Worker {
	
	@Autowired
	private WorkerService workerService;

	/**
	 * 查询微信支付订单
	 */
	public void searchWxPay(){
		workerService.searchWxPay();
	};
	

}
