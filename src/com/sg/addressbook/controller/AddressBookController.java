package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoException;
import com.sg.addressbook.dto.Address;
import com.sg.addressbook.dto.Person;
import com.sg.addressbook.ui.AddressBookView;

import java.util.List;

public class AddressBookController {

    private final AddressBookView view;
    private final AddressBookDao dao;

    public AddressBookController(AddressBookDao dao, AddressBookView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        try {
            while (keepGoing) {

                // Why would you make a stepper function that has zero extra logic or organisation?
                menuSelection = view.printMenuAndGetSelection();

                switch (menuSelection) {
                    case 1:
                        addAddress();
                        break;
                    case 2:
                        removeAddress();
                        break;
                    case 3:
                        removePerson();
                        break;
                    case 4:
                        countPersons();
                        break;
                    case 5:
                        viewPerson();
                        break;
                    case 6:
                        viewAllPersons();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        view.displayUnknownCommandBanner();
                }
            }
            view.displayExitBanner();
        } catch (AddressBookDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void addAddress() throws AddressBookDaoException {
        view.displayAddAddress();
        Person person = view.ask4Person();
        Address address = view.ask4Address();
        dao.addAddress(person, address);
        view.displaySuccess();
    }
    private void removeAddress() throws AddressBookDaoException {
        view.displayRemoveAddress();
        Person person = view.ask4Person();
        Address address = view.ask4Address();
        if (dao.removeAddress(person, address)) {
            view.displaySuccess();
        } else {
            view.displayFailiure();
        }
    }

    private void removePerson() throws AddressBookDaoException {
        view.displayRemovePerson();
        Person person = view.ask4Person();
        if (dao.removePerson(person)) {
            view.displaySuccess();
        } else {
            view.displayFailiure();
        }
    }

    private void countPersons() throws AddressBookDaoException {
        view.displayCount();
        List<Integer> count = dao.countPersons();
        view.displayCount(count);
        view.displaySuccess();
    }

    private void viewPerson() throws AddressBookDaoException {
        view.displayPerson();
        Person person = view.ask4Person();
        view.displayPerson(dao.getPerson(person));
        view.displaySuccess();
    }

    private void viewAllPersons() throws AddressBookDaoException {
        view.displayPerson();
        List<Person> persons = dao.getAllPersons();
        view.displayAll(persons);
        view.displaySuccess();

    }




}
