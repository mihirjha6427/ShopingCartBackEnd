package com.eclipse.ShopingCartBackEnd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.Dao.UserDAO;
import com.niit.ShoppingCart.model.User;


public class UserTest {
	
	public static void main(String[] args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.ShoppingCart");
		context.refresh();
		
		
		UserDAO userDAO= (UserDAO) context.getBean("userDAO");
		
		User user= (User) context.getBean("user");
		user.setId("6427");
		user.setName("Mihir Kumar Jha");
		user.setPassword("040415SUJAAN");
		user.setAddress("C-84 kendriya vihar");
		user.setEMail("mihirjha6427.mj@gmail.com");
		user.setMobile("9555950396");
		
		

		userDAO.saveorUpdate(user);
		
		
		
		
		
	}
	

}
