package com.varxyz.cafe.cart.service;

import java.util.List;

import com.varxyz.cafe.cart.domain.CartItem;

public interface CartService {
	
	
	/**
	 * 손님이 키오스크를 작동하여 주문버튼을 누르면 Cart Table이 생성되도록 하는 기능
	 * 생각해보니 별 필요없을거같음
	 */
//	public void createCart();
	
	
	/**
	 * 카트에 물건 하나하나 추가하는 기능
	 */
	public void addToCart(CartItem cartItem);
	
	
	/**
	 * 카트에 물건 하나하나 빼는 기능
	 */
	public void deleteFromCart(CartItem cartItem);
	
	
	/**
	 * 장바구니의 목록 전체를 삭제하는 기능
	 */
	public void deleteAllFromCart(CartItem cartItem);
	
	
	/**
	 * 카트에 담긴 물건들의 가격을 더해 최종 결제단계에서 사용할 전체 금액
	 * menuItem의 menuItemName과의 innerjoin을 통해 price값을 가져오고
	 * CartItem의 count와 곱하여 산정하는 방식 
	 */
	public double totalPrice(CartItem cartItem);
	
	
	/**
	 * 장바구니에 담긴 모든 목록들을 보여주기 위한 기능
	 * @return
	 */
	public List<CartItem> showAllCart();
	
	
	/**
	 * 최종 결제를 하게되면 카트 테이블 전체가 삭제되도록 하는 기능
	 */
	public void deleteCart();
	
	
}
