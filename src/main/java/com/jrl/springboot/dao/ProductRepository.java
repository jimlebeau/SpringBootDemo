package com.jrl.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jrl.springboot.model.Product;

@Repository
public class ProductRepository {

	@Autowired
	JdbcTemplate template;
	
	public List<Product> getAllProducts() {
		List<Product> products = template.query("select id, product_name from products", (result, rowNum)->new Product(result.getInt("id"), result.getString("product_name")));
		return products;
	}
	
	public int deleteProduct(int id) {
		String query = "DELETE FROM PRODUCTS WHERE ID =?";
		return template.update(query, id);
	}
	
	public int addProduct(Product product) {
		String query = "INSERT INTO PRODUCTS VALUES(?,?)";
		return template.update(query, product.getId(), product.getName());
	}
	
	public int updateProduct(Product product) {
		String query = "UPDATE PRODUCT SET(?) WHERE ID =?";
		return template.update(query, product.getName(), product.getId());
	}
}
