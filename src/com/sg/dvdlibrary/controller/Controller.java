package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.Dao;
import com.sg.dvdlibrary.dao.DaoException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.View;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    private final View view;
    private final Dao dao;

    public Controller(Dao dao, View view) {
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
                        addDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        updateDVD();
                        break;
                    case 4:
                        displayDVD();
                        break;
                    case 5:
                        displayAll();
                        break;
                    case 6:
                        searchDVD();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        view.displayUnknownCommandBanner();
                }
            }
            view.displayExitBanner();
        } catch (DaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void addDVD() throws DaoException{
        view.displayAddDVD();
        String title = view.ask4Title();
        if (dao.addDVD(title)) {
            if (dao.updateDVD(title, view.ask4Meta())) view.displaySuccess();
        } else {
            view.displayFailiure();
        }
    }

    private void removeDVD() throws DaoException{
        view.displayRemoveDVD();
        if (dao.removeDVD(view.ask4Title())) {
            view.displaySuccess();
        } else {
            view.displayFailiure();
        }
    }

    private void updateDVD() throws DaoException{
        view.displayUpdateDVD();
        String title = view.ask4Title();
        if (dao.getDVD(title) != null) {
            if (dao.updateDVD(title, view.ask4Meta())) {
                view.displaySuccess();
            } else {
                view.displayFailiure();
            }
        } else {
            view.displayFailiure();
        }
    }

    private void displayDVD() throws DaoException{
        view.displayDVD();
        DVD dvd = dao.getDVD(view.ask4Title());
        if (dvd == null) {
            view.displayFailiure();
        } else {
            view.displayDVD(dvd);
            view.displaySuccess();
        }
    }

    private void displayAll() throws DaoException{
        view.displayDVDs();
        view.displayDVDs(dao.getAllDVDs());
        view.displaySuccess();
    }

    private void searchDVD() throws DaoException{
        view.displaySearchDVDs();
        view.displayDVDs(dao.searchDVDs(view.ask4Search()));
        view.displaySuccess();
    }




}
