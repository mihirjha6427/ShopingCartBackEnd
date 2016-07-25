package com.eclipse.ShopingCartBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.Dao.SupplierDAO;

import com.niit.ShoppingCart.model.Supplier;


public class SupplierTest {
	
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.ShoppingCart");
		context.refresh();
		
		SupplierDAO supplierDAO= (SupplierDAO) context.getBean("supplierDAO");
		
		Supplier supplier= (Supplier) context.getBean("supplier");
		supplier.setId("101");
		supplier.setName("cgname120");
		supplier.setAddress("chennai");
		

		supplierDAO.saveorUpdate(supplier );
		
		
		
		
		
	}
	

}
