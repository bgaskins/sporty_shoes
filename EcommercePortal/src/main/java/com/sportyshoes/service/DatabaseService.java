package com.sportyshoes.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.dao.DatabaseDAO;
import com.sportyshoes.entity.Customer;
import com.sportyshoes.entity.Order;
import com.sportyshoes.entity.Product;

@Service
public class DatabaseService {
		
		@Autowired
		DatabaseDAO dbDao;	
		
		public boolean validateOldPass(String userName, String oldPassword)
		{
			return dbDao.validateOldPass(userName, oldPassword);
		}
		
		public boolean resetPassword(String userName, String oldPassword, String newPassword)
		{
			return dbDao.resetPassword(userName, oldPassword, newPassword);
		}
		
		public boolean validateUser(String userName, String password)
		{
			return dbDao.validateUser(userName, password);
		}
		
		public boolean registerCustomer(Customer customer)
		{
			return dbDao.registerCustomer(customer);
		}
		
		public Map<String, Product> getProductList()
		{
			return dbDao.getProductList();
		}
		
		public Map<String, Customer> getCustomerDetails(String query, boolean searchFlag, String custFName)
		{
			return dbDao.getCustomerDetails(query, searchFlag, custFName);
		}
		
		public Map<String, Order> getOrderDetails(String query, boolean searchFlag, String orderDate, String ordProdCategory)
		{
			return dbDao.getOrderDetails(query, searchFlag, orderDate, ordProdCategory);
		}
}
