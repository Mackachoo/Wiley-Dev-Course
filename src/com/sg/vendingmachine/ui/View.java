package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Item;

import java.util.List;

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

    // Create Student
    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }

    public Item getNewStudentInfo() {
        String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String cohort = io.readString("Please enter Cohort");
        Item currentItem = new Item(studentId);
        currentItem.setFirstName(firstName);
        currentItem.setLastName(lastName);
        currentItem.setCohort(cohort);
        return currentItem;
    }

    public void displayCreateSuccessBanner() {
        io.readString("Student successfully created.  Please hit enter to continue");
    }

    // Display All Students
    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }

    public void displayStudentList(List<Item> itemList) {
        for (Item currentItem : itemList) {
            String studentInfo = String.format("#%s : %s %s",
                    currentItem.getStudentId(),
                    currentItem.getFirstName(),
                    currentItem.getLastName());
            io.print(studentInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    // Display Single Student
    public void displayDisplayStudentBanner () {
        io.print("=== Display Student ===");
    }

    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
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
