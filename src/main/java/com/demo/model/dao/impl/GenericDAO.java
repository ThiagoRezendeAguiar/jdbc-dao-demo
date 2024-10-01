package com.demo.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.db.DbException;
import com.demo.model.dao.DAO;

public abstract class GenericDAO<T> implements DAO<T> {

    protected Connection conn;

    public GenericDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(T obj) {

    }

    @Override
    public void update(T obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public T findById(Integer id) {
        try (PreparedStatement st = conn.prepareStatement(getFindByIdQuery())) {
            st.setInt(1, id);

            try (ResultSet rs = st.executeQuery()) {
                return rs.next() ? setRows(rs) : null;
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<T> findAll() {
        List<T> list = new ArrayList<>();
        try (PreparedStatement st = conn.prepareStatement(getFindAllQuery())) {
            
            try (ResultSet rs = st.executeQuery()) {
                while(rs.next()){
                    list.add(setRows(rs));
                }
                return list;
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    protected abstract T setRows(ResultSet rs) throws SQLException;

    protected abstract String getInsertQuery();

    protected abstract String getUpdatetQuery();

    protected abstract String getDeleteByIdQuery();

    protected abstract String getFindByIdQuery();

    protected abstract String getFindAllQuery();
}
