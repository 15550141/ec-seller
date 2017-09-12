package com.ec.seller.service.impl;

import com.ec.seller.dao.ItemDao;
import com.ec.seller.dao.ReturnGoodsItemDao;
import com.ec.seller.domain.Item;
import com.ec.seller.domain.ReturnGoodsItem;
import com.ec.seller.domain.query.ReturnGoodsItemQuery;
import com.ec.seller.service.ReturnGoodsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="returnGoodsItemService")
public class ReturnGoodsItemServiceImpl implements ReturnGoodsItemService {

    @Autowired
    private ReturnGoodsItemDao returnGoodsItemDao;

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<ReturnGoodsItem> findList(ReturnGoodsItemQuery query) {
        return returnGoodsItemDao.selectByCondition(query);
    }

    @Override
    public void insert(ReturnGoodsItem returnGoodsItem) {
        Item item = itemDao.selectByItemId(returnGoodsItem.getItemId());
        if(item == null){
            throw new RuntimeException("该商品不存在");
        }
        returnGoodsItem.setItemId(item.getItemId());
        returnGoodsItem.setItemName(item.getItemName());
        returnGoodsItem.setItemCode(item.getItemCode());
        returnGoodsItemDao.insert(returnGoodsItem);
    }

    @Override
    public void delete(Integer id) {
        returnGoodsItemDao.delete(id);
    }

    @Override
    public ReturnGoodsItem selectById(Integer id) {
        return this.returnGoodsItemDao.selectById(id);
    }

    @Override
    public void modify(ReturnGoodsItem object) {
        this.returnGoodsItemDao.modify(object);
    }
}
