package com.niit.ShoppingCart.Dao;

import java.util.List;

import com.niit.ShoppingCart.model.User;

public interface UserDAO {
	
	public List<User> list();
	public User get(String id);
	public void saveorUpdate(User user);
	public void delete(String  id);

}
