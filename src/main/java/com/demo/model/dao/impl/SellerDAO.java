package com.demo.model.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.model.entities.Department;
import com.demo.model.entities.Seller;

public class SellerDAO extends GenericDAO<Seller>{

    public SellerDAO(Connection conn) {
        super(conn);
    }

    @Override
    protected Seller setRows(ResultSet rs) throws SQLException{
        Seller obj = new Seller();

        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthDate(rs.getDate("BirthDate"));
        obj.setDepartment(new Department(rs.getInt("DepartmentId"),rs.getString("DepartmentName")));
        
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
        return "SELECT seller.*,department.Name as DepartmentName FROM seller INNER JOIN department  ON seller.DepartmentId = department.Id WHERE seller.Id = ?";
    }

    @Override
    protected String getFindAllQuery() {
        return "SELECT seller.*,department.Name as DepartmentName FROM seller INNER JOIN department  ON seller.DepartmentId = department.Id";
    }
    
}
