package demo;

import com.ec.seller.common.utils.MD5Util;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by yujianming on 2016/4/5.
 */
public class Test {

    public static void main(String[] arg){
//        File file = new File("D:/1234.txt");
//        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
//        try {
//            List<String> list = FileUtils.readLines(file, "utf-8");
//            for(String detail : list){
//                String [] arr = detail.split(";");
//                if(arr != null && arr.length > 6 && StringUtils.isNotBlank(arr[6]) && "二号店".equals(arr[12])){
//                    try{
//                        BigDecimal money = new BigDecimal(arr[6].replace(",",""));
//                        String date = getDate(arr[1]);
//                        if(arr[1].startsWith("2016/3/11 ")){
//                            System.out.println(detail);
//                            BigDecimal value = map.get(date);
//                            if(value == null){
//                                value = BigDecimal.ZERO;
//                            }
////                            if(money.compareTo(new BigDecimal(110)) == 0){
////                                money = new BigDecimal(100);
////                            }
////                            if(money.compareTo(new BigDecimal(215)) == 0){
////                                money = new BigDecimal(200);
////                            }
//                            map.put(date, value.add(money));
//                        }
//                    }catch (Exception e){
//                        e.printStackTrace();
//                        continue;
//                    }
//                }
//            }
//
//            BigDecimal sum = new BigDecimal(0);
//            for(String key : map.keySet()){
//                sum = sum.add(map.get(key));
//                System.out.println(key+","+map.get(key));
//            }
//            System.out.println(sum);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        System.out.println(MD5Util.md5Hex("123123").toUpperCase());

//        //方法一：中文操作系统中打印GBK
//        System.out.println(System.getProperty("file.encoding"));
//
//        //方法二：中文操作系统中打印GBK
//        System.out.println(Charset.defaultCharset());


        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
        map.put("1111", new BigDecimal(1));
        map.remove("1111");
        System.out.println(map.size());
        if(map.size() == 0){
            System.out.println("OK");
        }
    }

    private static String getDate(String date) throws DateParseException {
        return date.split(" ")[0];
    }
}
