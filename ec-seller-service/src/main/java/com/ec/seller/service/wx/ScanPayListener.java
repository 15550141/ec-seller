package com.ec.seller.service.wx;

import com.ec.seller.dao.WxOrderDao;
import com.ec.seller.domain.WxOrder;
import com.tencent.business.ScanPayBusiness;
import com.tencent.protocol.pay_protocol.ScanPayResData;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yujianming on 2016/5/28.
 */
@Service(value = "scanPayListener")
public class ScanPayListener implements ScanPayBusiness.ResultListener {

    private final static Log log = LogFactory.getLog(ScanPayListener.class);

    @Autowired
    private WxOrderDao wxOrderDao;

    @Override
    public void onFailByReturnCodeError(ScanPayResData scanPayResData) {
        if(StringUtils.isNotBlank(scanPayResData.getReturn_code()) && scanPayResData.getReturn_code().equalsIgnoreCase("FAIL")){
            throw new RuntimeException("用户支付失败，具体原因："+scanPayResData.getReturn_msg());
        }
        throw new RuntimeException("用户支付失败"+scanPayResData.getErr_code()+"，具体原因："+scanPayResData.getErr_code_des());
    }

    @Override
    public void onFailByReturnCodeFail(ScanPayResData scanPayResData) {
        if(StringUtils.isNotBlank(scanPayResData.getReturn_code()) && scanPayResData.getReturn_code().equalsIgnoreCase("FAIL")){
            throw new RuntimeException("用户支付失败，具体原因："+scanPayResData.getReturn_msg());
        }
        throw new RuntimeException("用户支付失败"+scanPayResData.getErr_code()+"，具体原因："+scanPayResData.getErr_code_des());
    }

    @Override
    public void onFailBySignInvalid(ScanPayResData scanPayResData) {
        if(StringUtils.isNotBlank(scanPayResData.getReturn_code()) && scanPayResData.getReturn_code().equalsIgnoreCase("FAIL")){
            throw new RuntimeException("用户支付失败，具体原因："+scanPayResData.getReturn_msg());
        }
        throw new RuntimeException("用户支付失败"+scanPayResData.getErr_code()+"，具体原因："+scanPayResData.getErr_code_des());
    }

    @Override
    public void onFailByAuthCodeExpire(ScanPayResData scanPayResData) {
        if(StringUtils.isNotBlank(scanPayResData.getReturn_code()) && scanPayResData.getReturn_code().equalsIgnoreCase("FAIL")){
            throw new RuntimeException("用户支付失败，具体原因："+scanPayResData.getReturn_msg());
        }
        throw new RuntimeException("用户支付失败"+scanPayResData.getErr_code()+"，具体原因："+scanPayResData.getErr_code_des());
    }

    @Override
    public void onFailByAuthCodeInvalid(ScanPayResData scanPayResData) {
        if(StringUtils.isNotBlank(scanPayResData.getReturn_code()) && scanPayResData.getReturn_code().equalsIgnoreCase("FAIL")){
            throw new RuntimeException("用户支付失败，具体原因："+scanPayResData.getReturn_msg());
        }
        throw new RuntimeException("用户支付失败"+scanPayResData.getErr_code()+"，具体原因："+scanPayResData.getErr_code_des());
    }

    @Override
    public void onFailByMoneyNotEnough(ScanPayResData scanPayResData) {
        if(StringUtils.isNotBlank(scanPayResData.getReturn_code()) && scanPayResData.getReturn_code().equalsIgnoreCase("FAIL")){
            throw new RuntimeException("用户支付失败，具体原因："+scanPayResData.getReturn_msg());
        }
        throw new RuntimeException("用户支付失败"+scanPayResData.getErr_code()+"，具体原因："+scanPayResData.getErr_code_des());
    }

    @Override
    public void onFail(ScanPayResData scanPayResData) {
        if(StringUtils.isNotBlank(scanPayResData.getReturn_code()) && scanPayResData.getReturn_code().equalsIgnoreCase("FAIL")){
            throw new RuntimeException("用户支付失败，具体原因："+scanPayResData.getReturn_msg());
        }
        throw new RuntimeException("用户支付失败"+scanPayResData.getErr_code()+"，具体原因："+scanPayResData.getErr_code_des());
    }

    @Override
    public void onSuccess(ScanPayResData scanPayResData) {
        try{
            Long orderId = Long.parseLong(scanPayResData.getOut_trade_no());
            WxOrder wxOrder = new WxOrder();
            wxOrder.setOrderId(orderId);
            wxOrder.setStatus(2);//支付成功
            wxOrderDao.modify(wxOrder);
        }catch (Exception e){
            log.error("微信支付成功，但是数据库修改没成功！", e);
            throw new RuntimeException("微信返回支付成功，请与用户核实真实支付状态");
        }
    }
}
