package com.sg.addressbook.dto;

import java.util.*;

public class Person {
    private String firstName;
    private String lastName;
    private List<Address> addresses = new ArrayList<>();

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String parse) {
        String[] parseSpl = parse.split(";");
        firstName = parseSpl[0];
        lastName = parseSpl[1];
        for (String address : parseSpl[2].split(",")) {
            addresses.add(new Address(address));
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(firstName + ";" + lastName + ";");
        for (Address address : addresses) {
            output.append(address).append(",");
        }
        return output.toString();
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Person person = (Person) obj;
            return Objects.equals(this.firstName, person.firstName) && Objects.equals(this.lastName, person.lastName);
        } catch (Exception e) {
            return false;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public boolean removeAddress(Address address) {
        return addresses.remove(address);
    }

}
