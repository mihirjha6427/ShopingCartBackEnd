package com.niit.ShoppingCart.Dao;

import java.util.List;

import com.niit.ShoppingCart.model.Category;

public interface CategoryDAO {
	
	public List<Category> list();
	public Category get(String id);
	public void saveorUpdate(Category category);
	public void delete(String  id);

}
