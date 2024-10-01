package com.demo.model.dao;

import com.demo.db.DB;
import com.demo.model.dao.impl.DepartmentDAO;
import com.demo.model.dao.impl.SellerDAO;

public class DAOFactory {
    public static SellerDAO createSellerDAO(){
        return new SellerDAO(DB.getConnection());
    }

    public static DepartmentDAO createDepartmentDAO(){
        return new DepartmentDAO(DB.getConnection());
    }
}
