package com.jrl.springboot.service;

import java.util.List;

import com.jrl.springboot.model.Product;

public interface ProductService {

	public int deleteProduct(int id);
	public int updateProduct(Product product);
	public int addProduct(Product product);
	public List<Product> getProducts();
	
}
