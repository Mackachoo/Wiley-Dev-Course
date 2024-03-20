package com.sg.vendingmachine.dto;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private Map<Item, Integer> items;
    private final String filename = "vendingmachine.txt";

    public VendingMachine() throws FileNotFoundException {
        readFile();
    }

    public void readFile() throws FileNotFoundException {
        Scanner scanner;

        // Create Scanner for reading the file
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(filename)));
        } catch (FileNotFoundException e) {
            System.out.println("-_- Could not load roster data into memory.");
            throw new FileNotFoundException();
        }

        String currentLine;
        items = new HashMap<>();
        while (scanner.hasNextLine()) {
            String[] inputs = scanner.nextLine().split("::");
            items.put(new Item(inputs[0], new BigDecimal(inputs[1])), Integer.parseInt(inputs[2]));
        }
        scanner.close();

    }

    public void writeFile() throws FileNotFoundException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            System.out.println("-_- Could not load roster data into memory.");
            throw new FileNotFoundException();
        }

        for (Item item : items.keySet()) {
            out.println(item + "::" + items.get(item));
            out.flush();
        }
        out.close();

    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Item item : items.keySet()) {
            output.append(item + "::" + items.get(item));
        }
        return output.toString();
    }

    public void updateCount(Item item, int change) {
        items.replace(item, items.get(item) + change);
    }
}
