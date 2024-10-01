package com.demo.model.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.model.entities.Department;

public class DepartmentDAO extends GenericDAO<Department>{

    public DepartmentDAO(Connection conn) {
        super(conn);
    }

    @Override
    protected Department setRows(ResultSet rs) throws SQLException {
        Department obj = new Department();

        obj.setId(rs.getInt("DepartmentId"));
        obj.setName(rs.getString("DepartmentName"));

        return obj;
    }
    
    @Override
    protected String getInsertQuery() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInsertQuery'");
    }

    @Override
    protected String getUpdatetQuery() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUpdatetQuery'");
    }

    @Override
    protected String getDeleteByIdQuery() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeleteByIdQuery'");
    }

    @Override
    protected String getFindByIdQuery() {
        return "SELECT Id AS DepartmentId, Name AS DepartmentName FROM department WHERE Id = ?";
    }

    @Override
    protected String getFindAllQuery() {
        return "SELECT Id AS DepartmentId, Name AS DepartmentName FROM department";
    }
  
}
