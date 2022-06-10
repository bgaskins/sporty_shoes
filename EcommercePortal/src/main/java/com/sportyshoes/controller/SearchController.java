package com.sportyshoes.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.dao.Queries;
import com.sportyshoes.entity.Customer;
import com.sportyshoes.entity.Order;
import com.sportyshoes.service.DatabaseService;

@Controller
public class SearchController {
	
	@Autowired
	private DatabaseService dbService;
	
	@RequestMapping(value = "/search", method=RequestMethod.POST)
	public String searchCustomer(@RequestParam("custFirstName") String custFirstName, Model model)
	{
		Map<String, Customer> mapOfCustomers = dbService.getCustomerDetails(Queries.SEARCH_CUSTOMER, true, custFirstName);
		model.addAttribute("mapOfCustomers", mapOfCustomers);
		return "Dashboard";
	}
	
	@RequestMapping(value="/searchPurReport", method = RequestMethod.POST)
	public String displayOrders(@RequestParam("orderDate") String orderDate, @RequestParam("prodCategory") String prodCategory, Model model)
	{
		Map<String, Order> mapOfOrders = dbService.getOrderDetails(Queries.SEARCH_ORDERS, true, orderDate, prodCategory);
		model.addAttribute("mapOfOrders", mapOfOrders);
		return "Dashboard";
	}
}
