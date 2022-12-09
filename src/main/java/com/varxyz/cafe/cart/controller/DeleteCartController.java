package com.varxyz.cafe.cart.controller;

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
public class DeleteCartController {
	CartServiceImpl cartServiceImpl;
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	CartServiceImpl service = context.getBean("cartService", CartServiceImpl.class);
	
	
	
	@PostMapping("/kiosk/deleteMenu")
	public String deleteMenu(@ModelAttribute("cartItem") CartItem cartItem, Model model) {
		
		model.addAttribute("cartItem", cartItem);
		service.deleteFromCart(cartItem);
		context.close();
		return "kiosk/delete_success";
	}
	
	@GetMapping("/kiosk/delete_success")
	public String backToCart(@ModelAttribute("cartItem") CartItem cartItem, Model model) {
		model.addAttribute("cartItem", cartItem);
		return "kiosk/show_cart";
	}
	
	
	@PostMapping("/kiosk/deleteAll")
	public String deleteAllMenu(@ModelAttribute("cartItem") CartItem cartItem, Model model) {
		model.addAttribute("cartItem", cartItem);
		service.deleteAllFromCart(cartItem);
		context.close();
		return "kiosk/delete_success";
		
	}
	
}
