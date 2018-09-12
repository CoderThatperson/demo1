package com.aaa.dao;

import java.util.List;

import com.aaa.vo.Product;

public interface IProductDAO {
	
	List<Product> getAll();
	
	Product getProductByID(int id);
	
}
