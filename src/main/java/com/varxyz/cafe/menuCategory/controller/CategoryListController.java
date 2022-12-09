package com.varxyz.cafe.menuCategory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.cafe.DataSourceConfig;
import com.varxyz.cafe.menuCategory.domain.MenuCategory;
import com.varxyz.cafe.menuCategory.domain.MenuCategoryProvider;
import com.varxyz.cafe.menuCategory.service.CategoryServiceImpl;

@Controller("categoryListController")
public class CategoryListController {
	CategoryServiceImpl categoryServiceImpl;
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	CategoryServiceImpl service = context.getBean("categoryService", CategoryServiceImpl.class);
	
	@ModelAttribute("CategoryProviderList")
	public List<MenuCategoryProvider> getCategoryProviderList() {
		List<MenuCategoryProvider> list = new ArrayList<MenuCategoryProvider>();
		service.findCategoryName().forEach(c -> list.add(new MenuCategoryProvider(c.toString())));
		context.close();
		return list;
	}
	
	
	@GetMapping("/category/search_category")
	public String categoryList(@ModelAttribute("category") MenuCategory category, Model model) {
		model.addAttribute("category", category);
		return "category/search_category";
	}
	
	
	@PostMapping("/category/search_category")
	public String backToMenu() {
		return "category/search_category";
	}
	
	
	
	
	
}
