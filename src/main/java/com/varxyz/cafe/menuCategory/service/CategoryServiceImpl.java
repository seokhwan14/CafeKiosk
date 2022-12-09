package com.varxyz.cafe.menuCategory.service;

import java.util.List;

import com.varxyz.cafe.menuCategory.dao.CategoryDao;
import com.varxyz.cafe.menuCategory.domain.MenuCategory;
import com.varxyz.cafe.menuCategory.domain.MenuCategoryProvider;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao categoryDao = null;
	
	
	/**
	 * 여기 데이터소스 아니고 다오 넣는거임  --- 에러 많이남 조심
	 * @param categoryDao
	 */
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public void addCategory(MenuCategory category) {
		this.categoryDao.addCategory(category);
		
	}

	@Override
	public void deleteCategory(MenuCategory category) {
		this.categoryDao.deleteCategory(category);
	}

	@Override
	public List<MenuCategory> allCategory(MenuCategory category) {
		return categoryDao.allCategory(category);
	}

	/**
	 * menuCategoryName 찾는기능
	 */
	@Override
	public List<MenuCategoryProvider> findCategoryName() {
		
		return categoryDao.findCategoryName();
	}
}
