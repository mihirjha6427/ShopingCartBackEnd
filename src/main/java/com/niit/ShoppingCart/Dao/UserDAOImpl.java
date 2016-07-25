package com.niit.ShoppingCart.Dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory= sessionFactory;
	}
@Transactional
	public List<User> list() {
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<User> listUser= (List<User>)
				sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}
@SuppressWarnings("unchecked")
@Transactional
	public User get(String id) {
		String hql="from User where id=" +"'"+id+"'";
		@SuppressWarnings("deprecation")
		Query query=(Query) ((Session) sessionFactory.getSessionFactory()).createQuery(hql);
		List<User> listUser= (List<User>)query.getResultList();
		if(listUser!= null && !listUser.isEmpty()){
			return listUser.get(0);
		}
		return null;
	}
@Transactional
	public void saveorUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		
	}
@Transactional
	public void delete(String id) {
		User  UserToDelete= new User();
		UserToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
		
	}

}
