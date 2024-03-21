package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DaoFileImpl implements Dao {

    private List<DVD> dvdlibrary;
    public static final String FILE = "dvdLibrary.txt";

    private void loadData() throws DaoException {
        Scanner scanner;

        // Create Scanner for reading the file
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(FILE)));
        } catch (FileNotFoundException e) {
            throw new DaoException(
                    "-_- Could not load roster data into memory.", e);
        }

        String currentLine;
        dvdlibrary = new ArrayList<>();
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            dvdlibrary.add(DVD.parseDVD(currentLine));
        }
        scanner.close();
    }

    private void writeData() throws DaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(FILE));
        } catch (IOException e) {
            throw new DaoException(
                    "Could not save student data.", e);
        }

        for (DVD dvd : dvdlibrary) {
            out.println(dvd);
            out.flush();
        }
        out.close();
    }

    private DVD access(String title) {
        int i = dvdlibrary.indexOf(new DVD(title));
        if (i == -1) return null;
        return dvdlibrary.get(i);
    }

    @Override
    public boolean addDVD(String title) throws DaoException {
        loadData();
        DVD newDVD = new DVD(title);
        if (dvdlibrary.contains(newDVD)) return false;
        dvdlibrary.add(newDVD);
        writeData();
        return true;
    }

    @Override
    public boolean removeDVD(String title) throws DaoException {
        loadData();
        boolean out = dvdlibrary.remove(new DVD(title));
        writeData();
        return out;
    }

    @Override
    public boolean updateDVD(String title, String[] metaArgs) throws DaoException {
        loadData();
        DVD dvd = access(title);
        if (dvd == null) return false;
        if (!metaArgs[0].isBlank()) dvd.setRelease(metaArgs[0]);
        if (!metaArgs[1].isBlank()) dvd.setRating(metaArgs[1]);
        if (!metaArgs[2].isBlank()) dvd.setDirector(metaArgs[2]);
        if (!metaArgs[3].isBlank()) dvd.setStudio(metaArgs[3]);
        if (!metaArgs[4].isBlank()) dvd.setReview(metaArgs[4]);
        writeData();
        return true;
    }

    @Override
    public List<DVD> getAllDVDs() throws DaoException {
        loadData();
        return dvdlibrary;
    }

    @Override
    public DVD getDVD(String title) throws DaoException {
        loadData();
        return access(title);
    }

    @Override
    public List<DVD> searchDVDs(String search) throws DaoException {
        loadData();
        Stream<DVD> filtered =
                dvdlibrary.stream().filter(dvd -> dvd.getTitle().toLowerCase().contains(search.toLowerCase()) ||
                        search.toLowerCase().contains(dvd.getTitle().toLowerCase()));
        return filtered.collect(Collectors.toList());
    }
}
