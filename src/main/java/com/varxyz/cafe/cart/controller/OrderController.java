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
import com.varxyz.cafe.menuItem.domain.MenuItem;
import com.varxyz.cafe.menuItem.service.MenuItemServiceImpl;

@Controller
public class OrderController {
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	CartServiceImpl service = context.getBean("cartService", CartServiceImpl.class);
	
	
	/**
	 * 물건의 갯수 * 가격을 표출하기 위해서 menuItem의 price정보,
	 * cartItem의 count를 각각 곱한것을 표출 해줘야한다
	 * 
	 * ${cartItem.menuItemName} : ${cartItem.countMenu} ea  : 
	 * total price = ${cartItem.countMenu} * ${menuItem.price}
	 * 이것들이 각 줄에 표시가 되어야 하고 최종적으로는 모든 메뉴의 가격이 밑에 합쳐져서 나와야 함
	 * 
	 * @return
	 */
	//카트의 목록 ( count 추출용 )
	@ModelAttribute("cartItemlist")
	public List<CartItem> cartItemList() {
		List<CartItem> cartlist = service.showAllCart();
		context.close();
		return cartlist;
	}
	
	//메뉴의 목록 ( price 추출용 )
	@ModelAttribute("menuItemlist")
	public List<MenuItem> menuItemList() {
		MenuItem menuItem = new MenuItem();
		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		MenuItemServiceImpl service2 = context2.getBean("menuItemService", MenuItemServiceImpl.class);
		List<MenuItem> menulist = service2.findByMenuName(menuItem);
		context2.close();
		return menulist;
	}
	
	
	@PostMapping("/kiosk/final_order")
	public String orderCart(@ModelAttribute("cartItem") CartItem cartItem, MenuItem menuItem,
			Model model) {
		model.addAttribute("cartItem", cartItem);
		model.addAttribute("menuItem", menuItem);
			
		return "kiosk/final_order";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
