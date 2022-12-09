package com.varxyz.cafe.menuItem.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.cafe.DataSourceConfig;
import com.varxyz.cafe.menuItem.domain.MenuItem;
import com.varxyz.cafe.menuItem.service.MenuItemServiceImpl;

@Controller("deleteMenuItemController")
public class DeleteMenuItemController {
	
	MenuItemServiceImpl menuItemServiceImpl;
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	MenuItemServiceImpl service = context.getBean("menuItemService", MenuItemServiceImpl.class);
	
	@GetMapping("menuItem/delete_menuItem")
	public String deleteMenuItemForm() {
		return "menuItem/delete_menuItem";
	}
	
	@PostMapping("/menuItem/delete_menuItem")
	public String afterDeleteMenuItem(MenuItem menuItem, Model model) {
		model.addAttribute("menuItem", menuItem.getMenuItemName());
		
		service.deleteMenu(menuItem);
		context.close();
		
		return "menuItem/success_delete_menuItem";
	}
	
}
