package com.ec.seller.service.impl;

import com.ec.BaseTest;
import com.ec.seller.common.utils.BigDecimalUtils;
import com.ec.seller.dao.ItemDao;
import com.ec.seller.dao.SkuDao;
import com.ec.seller.domain.Item;
import com.ec.seller.domain.Sku;
import com.ec.seller.domain.query.ItemQuery;
import com.ec.seller.service.ItemService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yujianming on 2016/1/12.
 */
public class UserServiceImplTest extends BaseTest {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private SkuDao skuDao;

    @org.junit.Test
    public void testQueryUser() throws Exception {

    }

    @org.junit.Test
    public void testQueryByMobile() throws Exception {
        List<Item> itemList = this.readFileByLines("d:/chushihua.txt");
        Item item = null;
        int j = 0;
        int k = 0;
        for(int i=0;i<itemList.size();i++){
            item = itemList.get(i);

            List<Item> dbItemList = itemDao.selectByItemName(item.getItemName());
            if(dbItemList != null && dbItemList.size() > 0){
                System.out.println("商品已存在："+item.getItemName());
                j++;
                continue;
            }

            item.setYn(1);
            item.setItemType(1);
            /** 商品一级分类ID */
            item.setCategoryId1(11);
            /** 商品二级分类ID */
            item.setCategoryId2(12);
            /** 商品三级分类ID */
            item.setCategoryId3(13);
            /** 商品四级分类ID */
            item.setCategoryId4(15);
            /** 商家ID */
            item.setVenderUserId(10000);
            /** 商品状态 */
            item.setItemStatus(1);
            /** 创建时间 */
            item.setCreated(new Date());
            item.setOnShelfTime(new Date());

            Integer itemId = itemDao.insert(item);
            Sku sku = new Sku();
            sku.setItemId(itemId);
            sku.setLeastBuy(1);
            sku.setOriginalPrice(item.getReferenceSellPrice());
            sku.setSalePrice(item.getReferenceSellPrice());
            sku.setStock(10000);
            sku.setCreated(new Date());
            sku.setYn(1);
            skuDao.insert(sku);
            k++;
        }
        System.out.println("插入成功数量："+k);
        System.out.println("已存在商品数量："+j);
    }

    private List<Item> readFileByLines(String fileName) {
        List<Item> list = new ArrayList<Item>();
        File file = new File(fileName);
        BufferedReader reader = null;
        Item item = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                String[] params = tempString.split(",");
                item = new Item();
                item.setItemName(params[0]);
                item.setUnit(Integer.parseInt(params[1]));
                item.setReferenceUnit(Integer.parseInt(params[2]));
                if(params.length == 4){
                    if(item.getUnit() == 1){
                        item.setReferenceSellPrice((new BigDecimal(params[3]).multiply(new BigDecimal(50))).intValue());
                    }else{
                        item.setReferenceSellPrice((new BigDecimal(params[3]).multiply(new BigDecimal(100))).intValue());
                    }
                }
                list.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return list;
    }

    @org.junit.Test
    public void testAddUser() throws Exception {

    }

    @org.junit.Test
    public void testUpdateUser() throws Exception {

    }
}