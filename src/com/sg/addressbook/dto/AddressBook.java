package com.sg.addressbook.dto;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Person> addressbook = new ArrayList<>();
    public AddressBook() {}
    public AddressBook(List<String> lines) {
        for (String line : lines) {
            addressbook.add(new Person(line));
        }
    }

    public Person accessPerson(Person person) {
        if (!addressbook.contains(person)) {
            addressbook.add(person);
        }
        return addressbook.get(addressbook.indexOf(person));
    }

    public boolean removePerson(Person person) {
        return addressbook.remove(person);
    }

    public List<Person> accessAll() {
        return addressbook;
    }

}
