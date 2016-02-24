package com.ec.seller.common.utils;

/**
 * Created by yujianming on 2016/2/22.
 */
public class FlagBitUtil {
    public static final int FULL_FLAG = 0XFFFFFFFF ;

    /**
     * 打标
     * @param flag 需要打标的源数
     * @param offset 标位
     */
    public static int sign(Integer flag , int offset){
        if(flag == null){
            flag = 0;
        }
        int offsetT = 1 << ( offset - 1);
        return flag | offsetT ;
    }

    /**
     * 去标
     * @param flag 需要移除标的源数
     * @param offset 标位
     */
    public static int removeSign(Integer flag , int offset){
        if(flag == null){
            flag = 0;
        }
        int offsetT = 1 << ( offset - 1);
        offsetT = FULL_FLAG ^ offsetT ;
        return flag & offsetT ;
    }

    /**
     * 检查标位是否被打标
     * @param flag
     * @param offset  标位
     * @return 该标位是否被打标
     */
    public static boolean checkSign(Integer flag , int offset){
        if(flag == null){
            return false;
        }
        int offsetT = 1 << ( offset - 1);
        return (flag & offsetT) == offsetT ;
    }
}
