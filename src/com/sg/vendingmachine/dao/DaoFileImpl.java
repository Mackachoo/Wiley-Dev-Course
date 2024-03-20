package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;

import java.io.*;
import java.util.*;

public class DaoFileImpl implements Dao {

    private Map<String, Item> students = new HashMap<>();
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";


    @Override
    public Item addStudent(String studentId, Item item)  throws PersistenceException {
        loadRoster();
        Item newItem = students.put(studentId, item);
        writeRoster();
        return newItem;
    }


    @Override
    public List<Item> getAllStudents()
            throws PersistenceException {
        loadRoster();
        return new ArrayList(students.values());
    }

    @Override
    public Item getStudent(String studentId)
            throws PersistenceException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Item removeStudent(String studentId)
            throws PersistenceException {
        loadRoster();
        Item removedItem = students.remove(studentId);
        writeRoster();
        return removedItem;
    }

    private void loadRoster() throws PersistenceException {
        Scanner scanner;

        // Create Scanner for reading the file
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new PersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }

        String currentLine;
        Item currentItem;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentItem = Item.parseStudent(currentLine);

            students.put(currentItem.getStudentId(), currentItem);
        }
        scanner.close();
    }

    private void writeRoster() throws PersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new PersistenceException(
                    "Could not save student data.", e);
        }

        String studentAsText;
        List<Item> itemList = this.getAllStudents();
        for (Item currentItem : itemList) {
            studentAsText = currentItem.toString();
            out.println(studentAsText);
            out.flush();
        }
        out.close();
    }

}
