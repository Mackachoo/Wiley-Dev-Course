package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.Dao;
import com.sg.vendingmachine.dao.PersistenceException;
import com.sg.vendingmachine.dto.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.sg.vendingmachine.service.VendResult.*;

public class ServiceLayerImpl implements ServiceLayer {

    private Dao dao;


    public ServiceLayerImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Map<Item, Integer> getAll() {
        return dao.getAll();
    }

    @Override
    public VendResult vendItem(Item item, BigDecimal money) {
        if(item == null){
            return INVALIDITEM;
        }
        else if(dao.getCount(item) == 0){
            return NOMOREITEMS;
        }else if(money.compareTo(dao.getPrice(item)) < 0){
            return INVALIDFUNDS;
        }
        return BOUGHT;
    }

    @Override
    public Item accessItem(Item item) {
        return dao.itemAccess(item);
    }

    @Override
    public BigDecimal calculateChange(Item item, BigDecimal money) {
        money = money.subtract(dao.getPrice(item));
        return money;
    }
}

