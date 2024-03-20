package com.sg.vendingmachine.dao;

public interface ClassRosterAuditDao {

    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;

}
