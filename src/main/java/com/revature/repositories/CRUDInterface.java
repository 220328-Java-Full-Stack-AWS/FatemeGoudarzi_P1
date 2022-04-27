package com.revature.repositories;

import com.revature.models.Model;

import java.sql.SQLException;
import java.util.List;

public interface CRUDInterface <T extends Model>{
    public T create(T Model) throws SQLException;
    public T update(T Model) throws SQLException;
    public T delete(T Model) throws SQLException;
   // public T read(String name);
    public T read(T Model) throws SQLException;
    public List<T> getAll()throws SQLException;
}
