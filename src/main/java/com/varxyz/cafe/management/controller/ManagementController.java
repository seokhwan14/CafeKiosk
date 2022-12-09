package com.varxyz.cafe.management.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.cafe.DataSourceConfig;
import com.varxyz.cafe.menuCategory.domain.MenuCategory;
import com.varxyz.cafe.menuCategory.service.CategoryServiceImpl;

@Controller("controller.managementController")
public class ManagementController {
	
	@GetMapping("index")
	public String beforeAdd() {
		return "index";
	}
	
	@GetMapping("/cafeManager/managementPage")
	public String toManagement() {
		return "cafeManager/managementPage";
	}
	
	@GetMapping("/kiosk/kiosk")
	public String toKiosk() {
		return "kiosk/kiosk";
	}
	
	
	
}