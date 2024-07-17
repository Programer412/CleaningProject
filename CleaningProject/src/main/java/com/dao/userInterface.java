package com.dao;

import java.util.List;

import com.entity.details;
import com.entity.regist;
import com.servlet.housedetails;

public interface userInterface {
public boolean userRegister(regist reg);
public regist user(String email,String password);
public boolean usercheck(String email);
public boolean hdetail(details d);
public List<details> home(String email);
public List<details> homedata();
public boolean delete(int id,int userid);
public boolean deleteall();
public void checkout(int id,int userid);
public List<details> data();
public void del(int id, int userid);
public void admincheck(int id,int userid);
public List<details> last();



}
