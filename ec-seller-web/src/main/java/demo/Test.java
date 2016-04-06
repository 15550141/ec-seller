package demo;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by yujianming on 2016/4/5.
 */
public class Test {

    public static void main(String[] arg){
        File file = new File("D:/1234.txt");
        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
        try {
            List<String> list = FileUtils.readLines(file, "utf-8");
            for(String detail : list){
                String [] arr = detail.split(";");
                if(arr != null && arr.length > 6 && StringUtils.isNotBlank(arr[6]) && "二号店".equals(arr[12])){
                    try{
                        BigDecimal money = new BigDecimal(arr[6].replace(",",""));
                        String date = getDate(arr[1]);
                        BigDecimal value = map.get(date);
                        if(value == null){
                            value = BigDecimal.ZERO;
                        }
                        if(money.compareTo(new BigDecimal(110)) == 0){
                            money = new BigDecimal(100);
                        }
                        if(money.compareTo(new BigDecimal(215)) == 0){
                            money = new BigDecimal(200);
                        }
                        map.put(date, value.add(money));
                    }catch (Exception e){
                        e.printStackTrace();
                        continue;
                    }
                }
            }

            for(String key : map.keySet()){
                System.out.println(key+"    "+map.get(key));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getDate(String date) throws DateParseException {
        return date.split(" ")[0];
    }
}
