package com.sg.classroster.controller;

import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;

public class ClassRosterController {

    private final UserIO io = new UserIOConsoleImpl();
    private final ClassRosterView view = new ClassRosterView();

    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        while (keepGoing) {

            // Why would you make a stepper function that has zero extra logic or organisation?
            menuSelection = view.printMenuAndGetSelection();

            switch (menuSelection) {
                case 1:
                    io.print("LIST STUDENTS");
                    break;
                case 2:
                    io.print("CREATE STUDENT");
                    break;
                case 3:
                    io.print("VIEW STUDENT");
                    break;
                case 4:
                    io.print("REMOVE STUDENT");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }
}
