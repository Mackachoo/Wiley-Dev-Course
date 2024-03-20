package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.VendingMachine;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface Dao {

    // Returns all items
    public Map<Item, Integer> getAll();

    // Gets price of item
    public BigDecimal getPrice(Item item);

    // Checks if item is present and returns it, null if no item
    public Item itemAccess(Item item);

    // Remove item
    public void removeItem(Item item);
}
