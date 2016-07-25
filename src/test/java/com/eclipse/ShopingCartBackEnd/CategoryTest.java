package com.eclipse.ShopingCartBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.Dao.CategoryDAO;
import com.niit.ShoppingCart.model.Category;


public class CategoryTest {
	
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.ShoppingCart");
		context.refresh();
		
		
		CategoryDAO categoryDAO= (CategoryDAO) context.getBean("categoryDAO");
		
		Category category= (Category) context.getBean("category");
		category.setId("120");
		category.setName("cgname120");
		category.setDescription("cgdesc120");
		

		categoryDAO.saveorUpdate(category);
		
		
		
		
		
	}
	

}
