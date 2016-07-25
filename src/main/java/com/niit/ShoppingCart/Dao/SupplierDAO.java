package com.niit.ShoppingCart.Dao;

import java.util.List;

import com.niit.ShoppingCart.model.Supplier;

public interface SupplierDAO {
	
	public List<Supplier> list();
	public Supplier get(String id);
	public void saveorUpdate(Supplier supplier);
	public void delete(String  id);

}
