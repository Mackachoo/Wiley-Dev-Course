package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.Controller;
import com.sg.dvdlibrary.dao.Dao;
import com.sg.dvdlibrary.dao.DaoFileImpl;
import com.sg.dvdlibrary.ui.View;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.sg.dvdlibrary");
        appContext.refresh();

        Controller controller = appContext.getBean("controller", Controller.class);
        controller.run();
    }
}
