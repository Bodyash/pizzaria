package com.bodyash.pizzaria.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bodyash.pizzaria.bean.Category;
import com.bodyash.pizzaria.bean.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Product> listAllProducts() {
		List<Product> list = getSession().createCriteria(Product.class).list();
		return list;
	}

	@Override
	public void addNewProduct(Product p) {
		persist(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findProductByCategory(Category c) {
    	Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("category", c));
        return (List<Product>) crit.list();
	}

	@Override
	public Product findProductById(int id) {
		return getByKey(id);
	}

	@Override
	public void updateProduct(Product p) {
		update(p);
	}

	@Override
	public void deleteProduct(Product p) {
		delete(p);
		
	}

}
