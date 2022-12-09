package com.varxyz.cafe.menuCategory.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.cafe.DataSourceConfig;
import com.varxyz.cafe.menuCategory.domain.MenuCategory;
import com.varxyz.cafe.menuCategory.service.CategoryServiceImpl;

@Controller("controller.deleteCategoryController")
public class DeleteCategoryController {
	
	CategoryServiceImpl categoryServiceImpl;
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	CategoryServiceImpl service = context.getBean("categoryService", CategoryServiceImpl.class);
	MenuCategory category = new MenuCategory();
	
	
	
//	@GetMapping("/category/before_do")
//	public String beforeDelete() {
//		return "category/before_do";
//	}
	
	@GetMapping("/category/delete_category")
	public String deleteCategoryForm() {
		return "category/delete_category";
	}
	
//	@PostMapping("/category/add_category")
//	public String afterAddCategory() {
//		
//		return "category/add_category";
//	}
	
	@PostMapping("/category/after_delete")
	public String backToDelete(MenuCategory category, Model model) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
		CategoryServiceImpl service = context.getBean("categoryService", CategoryServiceImpl.class);
		model.addAttribute("menuName", category.getCategoryName());
		
		service.deleteCategory(category);
		context.close();
		return "category/after_delete";
	}
	
	
}
