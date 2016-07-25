package com.niit.ShoppingCart.Dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory= sessionFactory;
	}
@Transactional
	public List<Product> list() {
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Product> listProduct= (List<Product>)
				sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listProduct;
	}
@SuppressWarnings("unchecked")
@Transactional
	public Product get(String id) {
		String hql="from Product where id=" +"'"+id+"'";
		@SuppressWarnings("deprecation")
		Query query=(Query) ((Session) sessionFactory.getSessionFactory()).createQuery(hql);
		List<Product> listProduct= (List<Product>)query.getResultList();
		if(listProduct!= null && !listProduct.isEmpty()){
			return listProduct.get(0);
		}
		return null;
	}
@Transactional
	public void saveorUpdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}
@Transactional
	public void delete(String id) {
		Product  ProductToDelete= new Product();
		ProductToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
		
	}

}
