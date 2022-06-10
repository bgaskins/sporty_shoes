package com.sportyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sportyshoes.entity.Customer;
import com.sportyshoes.service.DatabaseService;
import com.sportyshoes.utilities.Utility;

@Controller
public class RegistrationController {
	
	@Autowired
	DatabaseService dbService;
	
	@RequestMapping(value = "/dispRegister", method = RequestMethod.GET) 
	public String displayRegister(Model model) 
	{ 	     
		model.addAttribute("customer", new Customer());
	    return "RegisterUser"; 
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST) 
	public String register(@ModelAttribute("customer") Customer customer, Model model ) 
	{
		String custFirstName = customer.getCustFirstName();
		String custLastName = customer.getCustLastName();
		String custEmail = customer.getCustEmail();
		String custPhone = customer.getCustPhone();
		String userID = customer.getUserID();
		String userPass = customer.getUserPass();
		
		String message = "";
		
		if(!Utility.checkNullOrEmpty(custFirstName) && !Utility.checkNullOrEmpty(custLastName) && !Utility.checkNullOrEmpty(custEmail) && !Utility.checkNullOrEmpty(custPhone) && !Utility.checkNullOrEmpty(userID) && !Utility.checkNullOrEmpty(userPass))
		{
			boolean flag = dbService.registerCustomer(customer);
			if(flag)
			{
				message = "Registration succssful.";
			}
			else
			{
				message = "Registration failed.";
			}
		}
		else
		{
			message = "All fields are required.";
		}		
		
		model.addAttribute("customer", new Customer());
		
		model.addAttribute("message", message);
		
		return "RegisterUser";
	}
	
}
