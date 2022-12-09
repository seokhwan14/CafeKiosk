package com.varxyz.cafe.menuItem.controller;

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
import com.varxyz.cafe.menuItem.domain.MenuItem;
import com.varxyz.cafe.menuItem.service.MenuItemServiceImpl;

@Controller("controller.addMenuItemController")
public class AddMenuItemController {
	
	CategoryServiceImpl categoryServiceImpl;
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	CategoryServiceImpl service = context.getBean("categoryService", CategoryServiceImpl.class);
	MenuCategory category = new MenuCategory();
	
	

	@ModelAttribute("CategoryProviderList")
	public List<MenuCategoryProvider> getCategoryProviderList() {
		List<MenuCategoryProvider> list = new ArrayList<MenuCategoryProvider>();
		
		service.findCategoryName().forEach(c -> list.add(new MenuCategoryProvider(c.toString())));
		return list;
	}
	
	@GetMapping("/menuItem/add_menuItem")
	public String showCategory(@ModelAttribute("menuItem") MenuItem menuItem, Model model) {
		model.addAttribute("menuItem", menuItem);
		return "menuItem/add_menuItem";
	}
	
	@PostMapping("/menuItem/add_menuItem")
	public String addMenuItem(MenuItem menuItem, Model model) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		MenuItemServiceImpl menuService = context.getBean("menuItemService", MenuItemServiceImpl.class);
		
		model.addAttribute("menuItem");
		menuService.addMenu(menuItem);
		context.close();
		return "menuItem/success_add_menuItem";
	}
	
	
}
