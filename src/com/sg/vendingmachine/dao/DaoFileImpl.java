package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;

import javax.swing.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class DaoFileImpl implements Dao {

    static private Map<Item, Integer> vm = new HashMap<>();

    public static void main(String[] args) {
        vm.put(new Item("Coke", new BigDecimal("1.0")), 10);
        vm.get(new Item("Coke"));
    }
}
