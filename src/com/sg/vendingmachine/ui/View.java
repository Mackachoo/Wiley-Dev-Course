package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class View {
    private UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayVendingMachineBanner() {
        io.readString("=== Vending Machine ===\n");
    }

    // Display All Items
    public void displayItemsList(Map<Item, Integer> itemList) {
        displayVendingMachineBanner();
        for (Map.Entry<Item, Integer> entry : itemList.entrySet()) {
            Item currentItem = entry.getKey();
            int quantity = entry.getValue();
            String itemInfo = String.format("%s - £%s (Available x%s)",
                    currentItem.getName(),
                    currentItem.getCost(),
                    quantity);
            io.print(itemInfo);
        }
        selectItem();
    }

    // Prompt an item
    public String selectItem() {
        return io.readString("Select item: ");
    }

    // Confirm the transaction is a success
    public void confirmTransaction(Item item) {
        io.print("You got "+ item +" for £"+ item.getCost()+ "." );
    }

    // Display change
    public void giveChange(BigDecimal change){
        io.print("Your change is £" + change);
    }

    // Invalid selection
    public void invalidSelection(Item item){
        io.print("No "+ item.getName() + " in the vending machine, try again...");
    }

    // Lack of funds message
    public void notEnoughFunds(BigDecimal money){
        io.print("Insufficient funds, balance: £" + money + ".");
    }

    // Exiting
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

}
