package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import com.sg.addressbook.dto.AddressBook;
import com.sg.addressbook.dto.Person;

import java.io.*;
import java.util.*;

public class AddressBookDaoFileImpl implements AddressBookDao {

    private AddressBook adbook;
    public static final String ADDRESS_FILE = "addressbook.txt";

    private void loadBook() throws AddressBookDaoException {
        Scanner scanner;

        // Create Scanner for reading the file
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ADDRESS_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException(
                    "-_- Could not load address book data into memory.", e);
        }

        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        scanner.close();
        adbook = new AddressBook(lines);
    }

    private void writeBook() throws AddressBookDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        } catch (IOException e) {
            throw new AddressBookDaoException(
                    "Could not save student data.", e);
        }

        for (Person line : adbook.accessAll()) {
            out.println(line);
            out.flush();
        }
        out.close();
    }

    @Override
    public void addAddress(Person person, Address address) throws AddressBookDaoException {
        loadBook();
        adbook.accessPerson(person).addAddress(address);
        writeBook();
    }

    @Override
    public boolean removeAddress(Person person, Address address) throws AddressBookDaoException {
        loadBook();
        boolean result = adbook.accessPerson(person).removeAddress(address);
        writeBook();
        return result;
    }

    @Override
    public boolean removePerson(Person person) throws AddressBookDaoException {
        loadBook();
        boolean result = adbook.removePerson(person);
        writeBook();
        return result;
    }

    @Override
    public Person getPerson(Person person) throws AddressBookDaoException {
        loadBook();
        return adbook.accessPerson(person);
    }

    @Override
    public List<Person> getAllPersons() throws AddressBookDaoException {
        loadBook();
        return adbook.accessAll();
    }

    @Override
    public List<Integer> countPersons() throws AddressBookDaoException {
        loadBook();
        List<Integer> count = new ArrayList<>();
        for (Person person: adbook.accessAll()) {
            count.add(person.getAddresses().size());
        }
        return count;
    }
}
