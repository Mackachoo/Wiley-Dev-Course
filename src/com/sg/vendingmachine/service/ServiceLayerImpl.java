package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.Dao;
import com.sg.vendingmachine.dao.PersistenceException;
import com.sg.vendingmachine.dto.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.sg.vendingmachine.service.VendResult.*;

public class ServiceLayerImpl implements
        ServiceLayer {

    private Dao dao;


    public ServiceLayerImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public void createStudent(Item item) throws
            DuplicateIdException,
            DataValidationException,
            PersistenceException {

        // First check to see if there is already a student
        // associated with the given student's id
        // If so, we're all done here -
        // throw a ClassRosterDuplicateIdException
        if (dao.getStudent(item.getStudentId()) != null) {
            throw new DuplicateIdException(
                    "ERROR: Could not create student.  Student Id "
                            + item.getStudentId()
                            + " already exists");
        }

        // Now validate all the fields on the given Student object.
        // This method will throw an
        // exception if any of the validation rules are violated.
        validateStudentData(item);

        // We passed all our business rules checks so go ahead
        // and persist the Student object
        dao.addStudent(item.getStudentId(), item);

        // The student was successfully created, now write to the audit log
        auditDao.writeAuditEntry(
                "Student " + item.getStudentId() + " CREATED.");

    }
    public ServiceLayerImpl(Dao dao) {
    }


    @Override
    public Map<Item, Integer> getAll() {
        return dao.getAll();
    }

    @Override
    public VendResult vendItem(Item item, BigDecimal money) {
        if(dao.itemAccess(item) == null){
            return INVALIDITEM;
        }
        else if(dao.getCount(item) == 0){
            return NOMOREITEMS;
        }else if(money.compareTo(dao.getPrice(item)) > 0){
            return INVALIDFUNDS;
        }
        return BOUGHT;
    }

    @Override
    public BigDecimal calculateChange(Item item, BigDecimal money) {
        money = money.subtract(dao.getPrice(item));
        return money;
    }
}

