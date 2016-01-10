package com.ec.seller.common.utils;

import java.math.BigDecimal;

/**
 * Created by yujianming on 2016/1/10.
 */
public class BigDecimalUtils {
    public static BigDecimal intDivide100ToBigDecimal(Integer value){
        if(value == null){
            return null;
        }
        return new BigDecimal(value).divide(new BigDecimal(100));
    }
}
