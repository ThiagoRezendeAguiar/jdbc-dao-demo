package com.demo;

import com.demo.model.dao.DAOFactory;
import com.demo.model.dao.impl.DepartmentDAO;
import com.demo.model.dao.impl.SellerDAO;

public class Main {
    public static void main(String[] args) {
        SellerDAO sellerDAO = DAOFactory.createSellerDAO();
        DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();

        departmentDAO.findAll().forEach(System.out::println);
        sellerDAO.findAll().forEach(System.out::println);
    }
}