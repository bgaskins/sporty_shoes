package com.sportyshoes.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sportyshoes.dao.Queries;
import com.sportyshoes.entity.Customer;
import com.sportyshoes.entity.Order;
import com.sportyshoes.entity.Product;
import com.sportyshoes.service.DatabaseService;

@Controller
public class DashboardController {

	@Autowired
	DatabaseService dbService;
	
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public String displayProducts(Model model)
	{
		Map<String, Product> mapOfProducts = dbService.getProductList();
		model.addAttribute("mapOfProducts", mapOfProducts);
		return "Dashboard";
	}
	
	@RequestMapping(value="/customers", method = RequestMethod.GET)
	public String displayCustomers(Model model)
	{
		Map<String, Customer> mapOfCustomers = dbService.getCustomerDetails(Queries.GET_CUSTOMERS, false, null);
		model.addAttribute("mapOfCustomers", mapOfCustomers);
		return "Dashboard";
	}
	
	@RequestMapping(value="/orders", method = RequestMethod.GET)
	public String displayOrders(Model model)
	{
		Map<String, Order> mapOfOrders = dbService.getOrderDetails(Queries.GET_ORDERS, false, null, null);
		model.addAttribute("mapOfOrders", mapOfOrders);
		return "Dashboard";
	}
}
