package com.cts.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pm.entities.Product;
import com.cts.pm.service.ProductService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;

	@RequestMapping("/all")
	List<Product> getAll() {
		return service.getProducts();
	}

	@RequestMapping("/{productId}")
	Product getById(@PathVariable Integer productId) {
		return service.getProductById(productId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	void addProduct(@RequestBody Product product) {
		service.addProduct(product);
	}

	@RequestMapping(method = RequestMethod.PUT)
	void updateProduct(@RequestBody Product product) {
		service.updateProduct(product);
	}
	
	@RequestMapping("/{productName")
	List<Product> getProductsByName(@PathVariable String productName){
		return service.getProductsByName(productName);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{productId}")
	void deleteProductById(@PathVariable Integer productId) {
		service.deleteProduct(productId);
	}

}
