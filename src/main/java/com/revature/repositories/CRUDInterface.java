package com.revature.repositories;
import com.revature.models.Model;
import com.revature.models.UserModel;

import java.util.List;

public interface CRUDInterface <T extends Model>{
    public T create(T Model);
    public T update(T Model);
    public T delete(T Model);
   // public T read(String name);
    public T read(T Model);
    public List<T> getAll();
}
