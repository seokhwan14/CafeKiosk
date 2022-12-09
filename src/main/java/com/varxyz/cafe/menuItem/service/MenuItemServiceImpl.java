package com.varxyz.cafe.menuItem.service;

import java.util.List;

import com.varxyz.cafe.menuItem.dao.MenuItemDao;
import com.varxyz.cafe.menuItem.domain.MenuItem;
import com.varxyz.cafe.menuItem.domain.MenuItemCart;

public class MenuItemServiceImpl implements MenuItemService	{

	MenuItemDao menuItemDao = null;
	
	
	public MenuItemServiceImpl(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}
	
	
	@Override
	public void addMenu(MenuItem menuItem) {
		this.menuItemDao.addMenu(menuItem);
		
	}

	@Override
	public void deleteMenu(MenuItem menuItem) {
		this.menuItemDao.deleteMenu(menuItem);
	}

	@Override
	public List<MenuItem> findMenuByCategory(MenuItem menuItem) {
		return menuItemDao.findMenuByCategory(menuItem);
	}


	@Override
	public List<MenuItem> findByMenuName(MenuItem menuItem) {
		return menuItemDao.findByMenuName(menuItem);
	}

	
	
	
	/*  카트를 따로 만들것같아 주석처리
	@Override
	public List<MenuItemCart> putInCart() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void checkPrice(MenuItem menuItem) {
		// TODO Auto-generated method stub
		
	}
	 */

}
