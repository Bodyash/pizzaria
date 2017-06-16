package com.bodyash.pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bodyash.pizzaria.bean.Cart;
import com.bodyash.pizzaria.bean.repo.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	@Qualifier(value="CartRepository")
	private CartRepository cartRepository;
	
	@Override
	public Cart create(Cart cart) {
		return cartRepository.create(cart);
	}

	@Override
	public Cart read(String cartId) {
		System.out.println("Cart Service got cartID and sending it to CartReporsitory: " + cartId);
		return cartRepository.read(cartId);
	}

	@Override
	public void update(String cartId, Cart cart) {
		cartRepository.update(cartId, cart);
	}

	@Override
	public void delete(String cartId) {
		cartRepository.delete(cartId);
	}

}
