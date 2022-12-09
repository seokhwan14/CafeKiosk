package com.varxyz.cafe.cart.controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.cafe.DataSourceConfig;
import com.varxyz.cafe.cart.domain.CartItem;
import com.varxyz.cafe.cart.service.CartServiceImpl;

@Controller
public class ShowCartController {
	CartServiceImpl cartServiceImpl;
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	CartServiceImpl service = context.getBean("cartService", CartServiceImpl.class);
	
	
	
	@ModelAttribute("cartItemlist")
	public List<CartItem> cartItemList() {
		List<CartItem> cartlist = service.showAllCart();
		context.close();
		return cartlist;
	}
	
	@GetMapping("/kiosk/show_cart")
	public String showCartget(@ModelAttribute("cartItem") CartItem cartItem, Model model) {
		
		model.addAttribute("cartItem", cartItem);
		
		return "kiosk/show_cart";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
