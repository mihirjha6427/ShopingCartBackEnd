package com.niit.ShoppingCart.Config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ShoppingCart.Dao.CategoryDAO;
import com.niit.ShoppingCart.Dao.CategoryDAOImpl;
import com.niit.ShoppingCart.Dao.SupplierDAO;
import com.niit.ShoppingCart.Dao.SupplierDAOImpl;
import com.niit.ShoppingCart.model.Category;
import com.niit.ShoppingCart.model.Product;
import com.niit.ShoppingCart.model.Supplier;
import com.niit.ShoppingCart.model.User;


@Configuration
@ComponentScan("com.niit.ShoppingCart")
@EnableTransactionManagement
public class ApplicationContextConfig {

	
	
	
	@Bean(name="dataSource")
	public DataSource getH2DataSource(){
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/niitdb");
		
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
	}
	
	private Properties getHibernateProperties(){
		Properties properties= new Properties();
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql","true");
		
		return properties;
		
	}
	
	@Autowired
	
	@Bean(name="sessionFactory")
	
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionBuilder= new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClasses(Supplier.class);
		sessionBuilder.addAnnotatedClasses(Product.class);
		sessionBuilder.addAnnotatedClasses(User.class);
		return sessionBuilder.buildSessionFactory();
	}
	@Autowired
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager= new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}
	@Autowired
	@Bean (name="categoryDAO")
	 public CategoryDAO getcategoryDAO(SessionFactory sessionFactory) {
        
        return new CategoryDAOImpl(sessionFactory);}
	@Autowired
	@Bean (name="supplierDAO")
	
	public SupplierDAO getsupplierDAO(SessionFactory sessionFactory){
		return new SupplierDAOImpl(sessionFactory);
	}
	
			
		
	
}
