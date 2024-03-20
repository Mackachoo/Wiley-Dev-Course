package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.VendingMachine;

import javax.swing.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class DaoFileImpl implements Dao {

    VendingMachine vm = new VendingMachine();

    @Override
    public Map<Item, Integer> getAll() {
        return vm.getItems();
    }

    @Override
    public BigDecimal getPrice(Item item) {
        return null;
    }

    @Override
    public Item itemAccess(Item item) {
        return null;
    }

    @Override
    public void removeItem(Item item) {

    }
}
