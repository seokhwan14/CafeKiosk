package com.varxyz.cafe.menuCategory.service;

import java.util.List;

import com.varxyz.cafe.menuCategory.domain.MenuCategory;
import com.varxyz.cafe.menuCategory.domain.MenuCategoryProvider;

public interface CategoryService {
		
	/**
	 * 카테고리 추가 기능
	 * @param category
	 */
	public void addCategory(MenuCategory category);
	
	
	/**
	 * 카테고리 삭제 기능 - 카테고리 내의 메뉴가 없어야만 삭제가 가능 , join걸어뒀기때문
	 * @param category
	 */
	public void deleteCategory(MenuCategory category);
	
	/**
	 * 카테고리 전체보기 기능
	 * @param category
	 * @return
	 */
	public List<MenuCategory> allCategory(MenuCategory category);
	
	/**
	 * 카테고리 명칭 찾기 기능 - select box와의 연계 후 menuItem과 연계하여 
	 * 메뉴 추가 기능을 구현하도록 해야함
	 * @return
	 */
	public List<MenuCategoryProvider> findCategoryName();
	
	
}
