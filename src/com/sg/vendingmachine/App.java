package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.Controller;
import com.sg.vendingmachine.dao.AuditDao;
import com.sg.vendingmachine.dao.AuditDaoFileImpl;
import com.sg.vendingmachine.dao.Dao;
import com.sg.vendingmachine.dao.DaoFileImpl;
import com.sg.vendingmachine.service.ServiceLayer;
import com.sg.vendingmachine.service.ServiceLayerImpl;
import com.sg.vendingmachine.ui.View;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        View myView = new View(myIo);
        Dao myDao = new DaoFileImpl();
        AuditDao myAuditDao = new AuditDaoFileImpl();
        ServiceLayer myService = new ServiceLayerImpl(myDao, myAuditDao);

        Controller controller =
                new Controller(myService, myView);
        controller.run();
    }
}
