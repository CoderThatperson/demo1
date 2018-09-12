package com.aaa.dao.impl;

import java.util.List;
import java.util.Map;

import com.aaa.dao.IUserDAO;
import com.aaa.util.DAOUtil;
import com.aaa.vo.User;

public class UserDAOImpl implements IUserDAO{

	@Override
	public void insert(User u) {
		String sql = "insert into user (username,password,telephone) values (?,?,?) ";
		DAOUtil.executeUpdate(sql, u.getUsername(),u.getPassword(),u.getTelephone());
	}

	@Override
	public boolean isExist(String telephone) {
		String sql = "select * from user where telephone = ?";
		List<Map<String, Object>> list = DAOUtil.executeQuery(sql, telephone);
		return list.size()>0;
	}

	@Override
	public User login(String telephone, String password) {
        String sql = "select * from user where telephone = ? and password = ?";
        
        List<User> list = DAOUtil.seelectList(sql, User.class, telephone,password);
        
        if(list.size() > 0){
        	return list.get(0);
        }
		return null;
	}

}
