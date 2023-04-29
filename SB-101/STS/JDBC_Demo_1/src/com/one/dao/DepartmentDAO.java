package com.one.dao;

import java.util.List;

import com.one.dto.DepartmentDTO;
import com.one.exception.NoRecordFoundException;
import com.one.exception.SomethingWentWrongException;

public interface DepartmentDAO {
    public void addNewDepartment(DepartmentDTO depObj) throws SomethingWentWrongException;
    public List<DepartmentDTO> showAllDepatment() throws SomethingWentWrongException, NoRecordFoundException;
    public void updateDepLocation(int did, String location) throws SomethingWentWrongException;
    public void deleteDepByID(int did) throws SomethingWentWrongException, NoRecordFoundException;
}
