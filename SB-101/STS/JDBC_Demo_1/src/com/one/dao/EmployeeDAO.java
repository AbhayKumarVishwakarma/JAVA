package com.one.dao;

import com.one.dto.EmployeeDTO;
import com.one.exception.NoRecordFoundException;
import com.one.exception.SomethingWentWrongException;

public interface EmployeeDAO {
    public void registerEmpWithoutID(EmployeeDTO empObj) throws SomethingWentWrongException;
    public void assignDeptId(int empId, int depId) throws SomethingWentWrongException;
    public String loginEmployee(String email, String password) throws SomethingWentWrongException, NoRecordFoundException;
    public void updateEmpPassword(int empId, String password) throws SomethingWentWrongException;
}
