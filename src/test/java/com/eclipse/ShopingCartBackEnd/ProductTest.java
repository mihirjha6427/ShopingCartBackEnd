package com.eclipse.ShopingCartBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.Dao.ProductDAO;
import com.niit.ShoppingCart.model.Product;

public class ProductTest {
	
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.ShoppingCart");
		context.refresh();
		
		
		ProductDAO productDAO= (ProductDAO) context.getBean("productDAO");
		
		Product product= (Product) context.getBean("product");
		product.setId("120");
		product.setName("cgname120");
		product.setDescription("cgdesc120");
		product.setPrice(7000);
		

		productDAO.saveorUpdate(product);
		
		
		
		
		
	}

}
