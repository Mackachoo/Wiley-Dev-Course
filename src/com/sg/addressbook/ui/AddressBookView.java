package com.sg.addressbook.ui;


import com.sg.addressbook.dto.Address;
import com.sg.addressbook.dto.Person;

import java.util.Arrays;
import java.util.List;

public class AddressBookView {
    private UserIO io;

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add address");
        io.print("2. Remove address");
        io.print("3. Remove person");
        io.print("4. Count address book");
        io.print("5. View a person");
        io.print("6. View all people");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    // Information Requests

    public Person ask4Person() {
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        return new Person(firstName, lastName);
    }

    public Address ask4Address() {
        String street = io.readString("Please enter the street");
        String city = io.readString("Please enter the city");
        String postcode = io.readString("Please enter the postcode");
        return new Address(street, city, postcode);
    }

    // Banner Displays

    public void displayAddAddress() {
        io.print("=== Add Address ===");
    }
    public void displayRemoveAddress () {
        io.print("=== Remove Address ===");
    }
    public void displayRemovePerson () {
        io.print("=== Remove Person ===");
    }
    public void displayCount () {
        io.print("=== Count Persons ===");
    }
    public void displayPerson () {
        io.print("=== Display Person ===");
    }
    public void displayAll() {
        io.print("=== Display All Persons ===");
    }
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    // Data Displays

    public void displayCount(List<Integer> counts) {
        io.print("Address Book:");
        io.print("\t#" + counts.size() + " persons");
        io.print("\t#" + counts.stream().reduce(0, Integer::sum) + " address");
    }

    public void displayPerson(Person person) {
        io.print(person.getFirstName() + " " + person.getLastName());
        for (Address address : person.getAddresses()) {
            io.print("\t" + address.getStreet() + ", " + address.getCity()
                    + ", " + address.getPostcode());
        }
    }

    public void displayAll(List<Person> persons) {
        for (Person person : persons) {
            displayPerson(person);
            io.print("");
        }
    }

    // Other Displays
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    public void displaySuccess() {
        io.readString("Action completed.  Please hit enter to continue", true);
    }
    public void displayFailiure() {
        io.readString("Action did not complete.  Please hit enter to continue", true);
    }
}
