package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.dto.VendingMachine;

import java.math.BigDecimal;
import java.util.List;

public interface Dao {

    // Returns all items
    public List<Item> getAll();

    // Gets price of item
    public BigDecimal getPrice(Item item);

    // Checks if item is present and returns it, null if no item
    public Item itemAccess(Item item);

    // Remove item
    public void removeItem(Item item);
}
