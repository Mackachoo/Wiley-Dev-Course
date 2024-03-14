package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import com.sg.addressbook.dto.Person;

import java.util.ArrayList;
import java.util.List;

public interface AddressBookDao {

    void addAddress(Person person, Address address) throws AddressBookDaoException;
    boolean removeAddress(Person person, Address address) throws AddressBookDaoException;
    boolean removePerson(Person person) throws AddressBookDaoException;
    Person getPerson(Person person) throws AddressBookDaoException;
    List<Person> getAllPersons() throws AddressBookDaoException;
    List<Integer> countPersons() throws AddressBookDaoException;

}
