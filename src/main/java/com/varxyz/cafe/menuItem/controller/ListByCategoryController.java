package com.varxyz.cafe.menuItem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.varxyz.cafe.DataSourceConfig;
import com.varxyz.cafe.menuCategory.domain.MenuCategoryProvider;
import com.varxyz.cafe.menuCategory.service.CategoryServiceImpl;
import com.varxyz.cafe.menuItem.domain.MenuItem;
import com.varxyz.cafe.menuItem.service.MenuItemServiceImpl;

@Controller("listByCategoryController")
public class ListByCategoryController {
	MenuItemServiceImpl menuItemServiceImpl;
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	MenuItemServiceImpl service = context.getBean("menuItemService", MenuItemServiceImpl.class);
	
	@ModelAttribute("CategoryProviderList")
	public List<MenuCategoryProvider> getCategoryProviderList() {
		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		CategoryServiceImpl service2 = context2.getBean("categoryService", CategoryServiceImpl.class);
		List<MenuCategoryProvider> list = new ArrayList<MenuCategoryProvider>();
		service2.findCategoryName().forEach(c -> list.add(new MenuCategoryProvider(c.toString())));
		context2.close();
		return list;
	}
	
	
	@GetMapping("/menuItem/search_menuItem")
	public String findMenuByCategoryForm(@ModelAttribute("menuItem") MenuItem menuItem, Model model) {
		model.addAttribute("menuItem", menuItem);
		return "menuItem/search_menuItem";
	}
	
	
	
	@PostMapping("/menuItem/search_menuItem")
	public String searchResults(@ModelAttribute("menuItem") MenuItem menuItem, Model model) {
		List<MenuItem> menulist = service.findMenuByCategory(menuItem);
		
		model.addAttribute("menulist", menulist);
		
		context.close();
		
		return "menuItem/search_menuItem_list";
	}
	
	
}
