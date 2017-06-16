package com.bodyash.pizzaria.service;

import com.bodyash.pizzaria.bean.Cart;

public interface CartService {
	
	Cart create(Cart cart);
	Cart read(String cartId);
	void update(String cartId, Cart cart);
	void delete(String cartId);

}
