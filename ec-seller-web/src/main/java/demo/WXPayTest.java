package demo;

import com.ec.seller.common.utils.JsonUtils;
import com.ec.seller.service.wx.ScanPayListener;
import com.tencent.WXPay;
import com.tencent.business.ScanPayBusiness;
import com.tencent.common.Util;
import com.tencent.protocol.pay_protocol.ScanPayReqData;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryReqData;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryResData;
import com.tencent.protocol.refund_protocol.RefundResData;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by yujianming on 2016/5/28.
 */
public class WXPayTest {
    public static void main(String[] args) throws Exception {
//        /**
//         * @param authCode 这个是扫码终端设备从用户手机上扫取到的支付授权号，这个号是跟用户用来支付的银行卡绑定的，有效期是1分钟
//         * @param body 要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
//         * @param attach 支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回
//         * @param outTradeNo 商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
//         * @param totalFee 订单总金额，单位为“分”，只能整数
//         * @param deviceInfo 商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
//         * @param spBillCreateIP 订单生成的机器IP
//         * @param timeStart 订单生成时间， 格式为yyyyMMddHHmmss，如2009年12 月25 日9 点10 分10 秒表示为20091225091010。时区为GMT+8 beijing。该时间取自商户服务器
//         * @param timeExpire 订单失效时间，格式同上
//         * @param goodsTag 商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
//         */
//
//        String authCode = "1";
//        String body = "鲜果味道微信支付订单";
//        String attach = "tingshuoyuanyangfanhui";
//        String outTradeNo = "dingdan4";
//        int totalFee = 1;
//        String deviceInfo = "燕山大街店";
//        String spBillCreateIP = "127.0.0.1";
//        String goodsTag = "";
//
//        ScanPayReqData scanPayReqData = new ScanPayReqData(authCode, body, attach, outTradeNo, totalFee, deviceInfo, spBillCreateIP, "", "", goodsTag);
//        System.out.println(JsonUtils.writeValue(scanPayReqData));
//        WXPay.doScanPayBusiness(scanPayReqData , new ScanPayListener());
//        System.out.println("支付成功");


        ScanPayQueryReqData reqData = new ScanPayQueryReqData("", "69");
        String result = WXPay.requestScanPayQueryService(reqData);
        ScanPayQueryResData refundResData = (ScanPayQueryResData) Util.getObjectFromXML(result, ScanPayQueryResData.class);
        if("SUCCESS".equals(refundResData.getTrade_state())){
            //修改数据库状态
            System.out.println("success");
        }


        System.out.println();;
    }

}
