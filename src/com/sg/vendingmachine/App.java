package com.sg.vendingmachine;

import com.sg.vendingmachine.controller.ClassRosterController;
import com.sg.vendingmachine.dao.ClassRosterAuditDao;
import com.sg.vendingmachine.dao.ClassRosterAuditDaoFileImpl;
import com.sg.vendingmachine.dao.ClassRosterDao;
import com.sg.vendingmachine.dao.ClassRosterDaoFileImpl;
import com.sg.vendingmachine.service.ClassRosterServiceLayer;
import com.sg.vendingmachine.service.ClassRosterServiceLayerImpl;
import com.sg.vendingmachine.ui.ClassRosterView;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);

        ClassRosterController controller =
                new ClassRosterController(myService, myView);
        controller.run();
    }
}
