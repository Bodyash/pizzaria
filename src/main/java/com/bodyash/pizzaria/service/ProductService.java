package com.bodyash.pizzaria.service;

import java.util.List;

import com.bodyash.pizzaria.bean.Category;
import com.bodyash.pizzaria.bean.Product;

public interface ProductService {

	
	public List<Product> listAllProducts();
	
	public void addNewProduct(Product p);
	
	public List<Product> findProductByCategory(Category c);
	
	public Product findProductById(int id);
	
	public void updateProduct(Product p);
	
	public void deleteProduct(int id);
	
}
