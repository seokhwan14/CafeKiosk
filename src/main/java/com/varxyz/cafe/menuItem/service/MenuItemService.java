package com.varxyz.cafe.menuItem.service;

import java.util.List;

import com.varxyz.cafe.menuItem.domain.MenuItem;
import com.varxyz.cafe.menuItem.domain.MenuItemCart;

public interface MenuItemService {
	
	/**
	 * 메뉴 추가 기능
	 * @param menuItem
	 */
	public void addMenu(MenuItem menuItem);
	
	
	/**
	 * 메뉴 삭제 기능
	 * @param menuItem
	 */
	public void deleteMenu(MenuItem menuItem);
	
	
	/**
	 * 메뉴 서칭 기능 ( Category의 menuName을 선택하게 되면 해당 카테고리와 연결된
	 * menuItem들의 목록이 나오도록 함
	 * @return
	 */
	public List<MenuItem> findMenuByCategory(MenuItem menuItem);
	
	
	/**
	 * 각 메뉴를 골랐을시 메뉴명에 따라 그에대한 상세정보를 뽑아내기 위한 기능
	 * @return
	 */
	public List<MenuItem> findByMenuName(MenuItem menuItem);
	
	
	
	
	
	
//	카트를 따로 만들것 같아 주석처리
	/**
	 * 서칭했던 메뉴들을 장바구니에 담아놓는 기능
	 * @return
	 */
//	public List<MenuItemCart> putInCart();
	
	/**
	 * 장바구니에 담아둔 물건들을 계산하기 위해 각 메뉴의 가격을 불러오는 기능
	 * @param menuItem
	 */
//	public void checkPrice(MenuItem menuItem);
	
	
}
