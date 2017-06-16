package com.bodyash.pizzaria.bean.repo;

import com.bodyash.pizzaria.bean.Cart;

public interface CartRepository {
	Cart create (Cart cart);
	Cart read(String cartId);
	void update(String cartId, Cart cart);
	void delete(String cartId);
}
