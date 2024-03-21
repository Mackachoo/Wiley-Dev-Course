package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class View {
    private final UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Update DVD");
        io.print("4. Display DVD");
        io.print("5. Display all DVDs");
        io.print("6. Search DVDs");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 8);
    }

    // Information Requests
    public String ask4Title () {
        return io.readString("Please enter DVD title:");
    }

    public String[] ask4Meta () {
        String[] metas = new String[5];
        metas[0] = io.readString("Please enter DVD's Release Date (dd-mm-yyyy):");
        metas[1] = io.readString("Please enter DVD's MPAA Rating:");
        metas[2] = io.readString("Please enter DVD's Director:");
        metas[3] = io.readString("Please enter DVD's Studio:");
        metas[4] = io.readString("Please enter DVD's User Review:");
        return metas;
    }

    public String ask4Search () {
        return io.readString("Please enter search:");
    }

    // Banner Displays

    public void displayAddDVD () {
        io.print("=== Add DVD ===");
    }
    public void displayRemoveDVD () {
        io.print("=== Remove DVD ===");
    }
    public void displayUpdateDVD () {
        io.print("=== Update DVD ===");
    }
    public void displayDVD () {
        io.print("=== Display DVD ===");
    }
    public void displayDVDs() {
        io.print("=== Display All DVDs ===");
    }
    public void displaySearchDVDs () {
        io.print("=== Search DVDs ===");
    }
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    // Data Displays

    public void displayDVD(DVD dvd) {
        io.print(" ___ " + dvd.getTitle() + " ___ ");
        io.print("  " + dvd.getRating() + " - " + dvd.getRelease());
        io.print("  " + dvd.getDirector() + " - " + dvd.getStudio());
        io.print("  " + dvd.getReview());
    }

    public void displayDVDs(List<DVD> dvds) {
        for (DVD dvd : dvds) {
            displayDVD(dvd);
            io.print("");
        }
    }

    // Other Displays
    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    public void displaySuccess() {
        io.readString("Action completed.  Please hit enter to continue");
    }
    public void displayFailiure() {
        io.readString("Action did not complete.  Please hit enter to continue");
    }
}