package com.varxyz.cafe.cart.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.cafe.DataSourceConfig;
import com.varxyz.cafe.cart.domain.CartItem;
import com.varxyz.cafe.cart.service.CartServiceImpl;

@Controller("welcomeCartController")
public class WelcomeCartController {
	
	CartServiceImpl cartServiceImpl;
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	CartServiceImpl service = context.getBean("cartService", CartServiceImpl.class);

	



}
