package com.jrl.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrl.springboot.dao.ProductRepository;
import com.jrl.springboot.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;

	@Override
	public int deleteProduct(int id) {
		return productRepo.deleteProduct(id);
	}

	@Override
	public int updateProduct(Product product) {
		return productRepo.updateProduct(product);
	}

	@Override
	public int addProduct(Product product) {
		return productRepo.addProduct(product);
	}

	@Override
	public List<Product> getProducts() {
		return productRepo.getAllProducts();
	}

}
