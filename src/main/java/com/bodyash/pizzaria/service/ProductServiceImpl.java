package com.bodyash.pizzaria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodyash.pizzaria.bean.Category;
import com.bodyash.pizzaria.bean.Product;
import com.bodyash.pizzaria.dao.ProductDao;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Product> listAllProducts() {
		return productDao.listAllProducts();
	}

	@Override
	public void addNewProduct(Product p) {
		productDao.addNewProduct(p);
	}

	@Override
	public List<Product> findProductByCategory(Category c) {
		return productDao.findProductByCategory(c);
	}

	@Override
	public Product findProductById(int id) {
		return productDao.findProductById(id);
	}

	@Override
	public void updateProduct(Product p) {
		productDao.updateProduct(p);
	}

	@Override
	public void deleteProduct(int id) {
		Product p = productDao.findProductById(id);
		if (p != null){
			productDao.deleteProduct(p);
		}
	}

	@Override
	public List<Product> findProductByName(String keyword) {
		return productDao.findProductByName(keyword);
	}
	
	

}
