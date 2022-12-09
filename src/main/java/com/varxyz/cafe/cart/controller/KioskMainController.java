package com.varxyz.cafe.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.cafe.DataSourceConfig;
import com.varxyz.cafe.cart.domain.CartItem;
import com.varxyz.cafe.cart.service.CartServiceImpl;
import com.varxyz.cafe.menuCategory.domain.MenuCategoryProvider;
import com.varxyz.cafe.menuCategory.service.CategoryServiceImpl;
import com.varxyz.cafe.menuItem.domain.MenuItem;
import com.varxyz.cafe.menuItem.service.MenuItemServiceImpl;

@Controller("kioskMainController")
public class KioskMainController {
	CartServiceImpl cartServiceImpl;
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	CartServiceImpl service = context.getBean("cartService", CartServiceImpl.class);
	
	@ModelAttribute("CategoryProviderList")
	public List<MenuCategoryProvider> getCategoryProviderList() {
		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		CategoryServiceImpl service2 = context2.getBean("categoryService", CategoryServiceImpl.class);
		List<MenuCategoryProvider> list = new ArrayList<MenuCategoryProvider>();
		service2.findCategoryName().forEach(c -> list.add(new MenuCategoryProvider(c.toString())));
		context2.close();
		return list;
	}
	
	
	
	/**
	 * 
	 */
	@GetMapping("/kiosk/kioskMain")
	public String welcomeUser(@ModelAttribute("menuItem") MenuItem menuItem, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();

		session.getAttribute("menuItem");
		model.addAttribute("menuItem", menuItem);
		
		
		return "kiosk/kioskMain";
	}
	
	/**
	 * 세션 생성
	 */
	@PostMapping("/kiosk/kioskMain")
	public String goToOrder(@ModelAttribute("menuItem") MenuItem menuItem, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.getAttribute("menuItem");
		
		AnnotationConfigApplicationContext context3 = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		MenuItemServiceImpl service3 = context3.getBean("menuItemService", MenuItemServiceImpl.class);
		
		List<MenuItem> menulist = service3.findMenuByCategory(menuItem);
		model.addAttribute("menulist", menulist);
		session.setAttribute("menuItem", menuItem);
		session.setAttribute("menulist", menulist);
		context3.close();
		System.out.println("세션 들어간다");
		return "kiosk/ex_order";
	}
	
	
}
