package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.Controller;
import com.sg.dvdlibrary.dao.Dao;
import com.sg.dvdlibrary.dao.DaoFileImpl;
import com.sg.dvdlibrary.ui.View;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        View myView = new View(myIo);
        Dao myDao = new DaoFileImpl();
        Controller controller =
                new Controller(myDao, myView);
        controller.run();
    }
}
