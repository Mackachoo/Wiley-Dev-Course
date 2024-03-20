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

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Students");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
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
        io.readString("Please hit enter to continue.");
    }


    public String selectItem() {
        return io.readString("Select item: ");
    }
    public void confirmTransaction(Item item) {
        io.print("You got "+ item +" for £"+ item.getCost()+ "." );
    }
    public void giveChange(BigDecimal change){
        io.print("Your change is £" + change);
    }

    public void displayStudent(Item item) {
        if (item != null) {
            io.print(item.getStudentId());
            io.print(item.getFirstName() + " " + item.getLastName());
            io.print(item.getCohort());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    // Remove Student
    public void displayRemoveStudentBanner () {
        io.print("=== Remove Student ===");
    }

    public void displayRemoveResult(Item itemRecord) {
        if(itemRecord != null){
            io.print("Student successfully removed.");
        }else{
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveSuccessBanner() {
        io.print("Student successfully removed.");
        io.readString("Please hit enter to continue.");
    }

    // Exiting
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

}
