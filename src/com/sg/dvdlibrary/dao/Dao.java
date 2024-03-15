package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.util.List;

public interface Dao {
    //Allow the user to add a DVD to the collection
    boolean addDVD(String title) throws DaoException;

    //Allow the user to remove a DVD from the collection
    boolean removeDVD(String title) throws DaoException;

    //Allow the user to edit the information for an existing DVD in the collection
    boolean updateDVD(String title, String[] metaArgs) throws DaoException;

    //Allow the user to list the DVDs in the collection
    List<DVD> getAllDVDs() throws DaoException;

    //Allow the user to display the information for a particular DVD
    DVD getDVD(String title) throws DaoException;

    //Allow the user to search for a DVD by title
    List<DVD> searchDVDs(String search) throws DaoException;
}
