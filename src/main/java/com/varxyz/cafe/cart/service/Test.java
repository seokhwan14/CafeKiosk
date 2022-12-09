package com.varxyz.cafe.cart.service;



import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.cafe.DataSourceConfig;
import com.varxyz.cafe.cart.dao.CartDao;
import com.varxyz.cafe.cart.domain.CartItem;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		CartServiceImpl service = context.getBean("cartService", CartServiceImpl.class);
		
		List<CartItem> cartlist = service.showAllCart();
		context.close();
		
		System.out.println(cartlist.toString());
		
	}
}
