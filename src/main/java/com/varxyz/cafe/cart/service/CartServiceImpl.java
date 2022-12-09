package com.varxyz.cafe.cart.service;

import java.util.List;

import com.varxyz.cafe.cart.dao.CartDao;
import com.varxyz.cafe.cart.domain.CartItem;
import com.varxyz.cafe.menuItem.domain.MenuItem;

public class CartServiceImpl implements CartService{

	CartDao cartDao = null;
	
	public CartServiceImpl(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	
//	@Override
//	public void createCart() {
//		this.cartDao.createCart();
//	}

	@Override
	public void addToCart(CartItem cartItem) {
		this.cartDao.addToCart(cartItem);
	}

	@Override
	public void deleteFromCart(CartItem cartItem) {
		this.cartDao.deleteFromCart(cartItem);
	}

	@Override
	public void deleteAllFromCart(CartItem cartItem) {
		this.cartDao.deleteAllFromCart(cartItem);
	}

	@Override
	public double totalPrice(CartItem cartItem) {
		MenuItem menuItem = new MenuItem();
		double price = 0;
		double count = 0;
		
		this.cartDao.checkPrice(cartItem);
		price = menuItem.getPrice();
		
		this.cartDao.checkCount(cartItem);
		count = cartItem.getCountMenu();
		return (price * count);
		
	}

	@Override
	public List<CartItem> showAllCart() {
		return cartDao.showAllCart();
	}

	@Override
	public void deleteCart() {
		this.cartDao.deleteCart();
	}

}
