package com.aaa.dao.impl;

import java.util.List;

import com.aaa.dao.IProductDAO;
import com.aaa.util.DAOUtil;
import com.aaa.vo.Product;

public class ProductDAOImpl implements IProductDAO{

	@Override
	public List<Product> getAll() {
		
		String sql = "select * from product";
		
		return DAOUtil.seelectList(sql, Product.class);
	}

	@Override
	public Product getProductByID(int id) {
		String sql = "select * from product where pid = ?";
		
		List<Product> list = DAOUtil.seelectList(sql, Product.class, id);
		
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
