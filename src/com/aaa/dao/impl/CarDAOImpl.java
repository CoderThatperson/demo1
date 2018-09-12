package com.aaa.dao.impl;

import com.aaa.dao.ICarDAO;
import com.aaa.util.DAOUtil;
import com.aaa.vo.Car;

public class CarDAOImpl implements ICarDAO{

	@Override
	public void insert(Car c) {
		String sql = "insert into car values (null,?,?,?,?,?,?)";
		
		DAOUtil.executeUpdate(sql, c.getUid(),c.getPid(),c.getPname(),
				c.getPimage(),c.getPrice(),c.getNum());
	}
	
}
