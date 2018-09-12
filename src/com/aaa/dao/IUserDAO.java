package com.aaa.dao;

import com.aaa.vo.User;

public interface IUserDAO {
	
	void insert(User u);
	
	boolean isExist(String telephone);
	
	User login(String telephone,String password);

}
