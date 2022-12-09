package com.varxyz.cafe.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.cafe.DataSourceConfig;
import com.varxyz.cafe.cart.domain.CartItem;
import com.varxyz.cafe.cart.service.CartServiceImpl;
import com.varxyz.cafe.menuCategory.domain.MenuCategoryProvider;
import com.varxyz.cafe.menuCategory.service.CategoryServiceImpl;
import com.varxyz.cafe.menuItem.domain.MenuItem;
import com.varxyz.cafe.menuItem.service.MenuItemServiceImpl;

@Controller("addCartController")
public class AddCartController {
	CartServiceImpl cartServiceImpl;
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	CartServiceImpl service = context.getBean("cartService", CartServiceImpl.class);
	
	
//	@ModelAttribute("MenuItemList")
//	public List<MenuItem> getMenuItemList(MenuItem menuItem) {
//		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(DataSourceConfig.class);
//		MenuItemServiceImpl service2 = context2.getBean("menuItemService", MenuItemServiceImpl.class);
//		List<MenuItem> list = new ArrayList<MenuItem>();
//		service2.findByMenuName(menuItem).forEach(c -> list.add(new MenuItem(c.toString())));
//		context2.close();
//		return list;
//	}
	
	
	@GetMapping("/kiosk/ex_order")
	public String KioskMainForm(
			@RequestParam(required = false, value = "status.count") Integer status,
			@ModelAttribute("menuItem") MenuItem menuItem,  Model model, HttpServletRequest request) {
		System.out.println(menuItem);
		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("menuItem") != null) {
			menuItem = (MenuItem)session.getAttribute("menuItem");
//			menuItem1 = menuItem;
			model.addAttribute("menuItem", menuItem);
			model.addAttribute("price", menuItem.getPrice());
			model.addAttribute("menuImage", menuItem.getMenuImage());
			model.addAttribute("menuDesc", menuItem.getMenuDesc());
			System.out.println("눌값이 아닌데요");
			
		}else {
			model.addAttribute("menuItem", menuItem);
			model.addAttribute("price", menuItem.getPrice());
			model.addAttribute("menuImage", menuItem.getMenuImage());
			model.addAttribute("menuDesc", menuItem.getMenuDesc());
			System.out.println("눌눌눌");
		}
		
		
		
		
		return "kiosk/ex_order";
	}
	
	
	@PostMapping("/kiosk/ex_order")
	public String forOrder(@ModelAttribute("menuItem") MenuItem menuItem,  Model model) {
		
		AnnotationConfigApplicationContext context3 = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		MenuItemServiceImpl service3 = context3.getBean("menuItemService", MenuItemServiceImpl.class);
		
		List<MenuItem> menulist = service3.findByMenuName(menuItem);
		model.addAttribute("menulist", menulist);
		context3.close();		
		return "kiosk/do_order";
	}
	
	
	
	@GetMapping("/kiosk/do_order")
	public String addCart(@ModelAttribute("menuItem") CartItem cartItem, Model model) {
		model.addAttribute("cartItem", cartItem);
		return "kiosk/do_order";
	}
	
	
	@PostMapping("/kiosk/do_order")
	public String addCartSuccess(CartItem cartItem, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.getAttribute("menuItem");
		
		model.addAttribute("cartItem", cartItem);
		service.addToCart(cartItem);
		context.close();
		return "kiosk/add_cart";
	}
	
	@GetMapping("/kiosk/add_cart")
	public String after_add(@ModelAttribute("cartItem") CartItem cartItem, Model model) {
		model.addAttribute("cartItem", cartItem);
		
		return "kiosk/add_cart";
	}
	
	
	
	
	
	
	
	
	
}
