package com.jrl.springboot.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jrl.springboot.dao.ProductRepository;
import com.jrl.springboot.exception.ProductNotFoundException;
import com.jrl.springboot.model.Product;
import com.jrl.springboot.service.ProductService;
import com.jrl.springboot.service.ProductServiceImpl;

@RestController
public class ProductController {
	
	ProductServiceImpl productServiceImpl;
	
	@Autowired
	public ProductController(ProductServiceImpl productServiceImpl) {
		this.productServiceImpl = productServiceImpl;
	}
	
	   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> delete(@PathVariable("id") int id) { 
	      int deletedId = productServiceImpl.deleteProduct(id);
	      return new ResponseEntity<>("Product is " + deletedId + " deleted successsfully", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Object> updateProduct(@PathVariable("id") int id, @RequestBody Product product) { 
	      int updatedId = productServiceImpl.updateProduct(product);
	      return new ResponseEntity<>("Product " + updatedId + " is updated successsfully", HttpStatus.OK);
	   }
	   
	   @RequestMapping(value = "/products", method = RequestMethod.POST)
	   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
	      int createdId = productServiceImpl.addProduct(product);
	      return new ResponseEntity<>("Product " + createdId + " is created successfully", HttpStatus.CREATED);
	   }
	   
	   @RequestMapping(value = "/products")
	   public ResponseEntity<Object> getProduct() {
	      return new ResponseEntity<>(productServiceImpl.getProducts(), HttpStatus.OK);
	   }

}
