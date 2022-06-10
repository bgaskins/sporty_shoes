package com.sportyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.entity.User;
import com.sportyshoes.service.DatabaseService;
import com.sportyshoes.utilities.Utility;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class LoginController {
	
	@Autowired
	private DatabaseService dbService;
	
	@RequestMapping(value = "/dispResetPass", method = RequestMethod.GET) 
	public String displayPass(Model model) 
	{ 	     
	    return "ResetPass"; 
	}
	
	@RequestMapping(value = "/resetPass", method = RequestMethod.POST) 
	public String resetPass(Model model, @RequestParam("userName") String userName, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword) 
	{ 	
		String forwardPage = "ResetPass";
		String message = "";
		
		if(!Utility.checkNullOrEmpty(userName) && !Utility.checkNullOrEmpty(oldPassword) && !Utility.checkNullOrEmpty(newPassword) && !Utility.checkNullOrEmpty(confirmPassword))
		{	
			if(dbService.validateOldPass(userName, oldPassword))
			{
				if(newPassword.equals(confirmPassword))
				{
					dbService.resetPassword(userName, oldPassword, newPassword);
					message = "Password Reset Successful!";
				}
				else
				{
					message = "New Password and Confirmation Passsword must match.";
				}
			}
			else
			{
				message = "Password is incorrect.";
			}
		}
		else
		{
			message = "Empty Password field."; 
		}
		
		model.addAttribute("errorMessage", message);
	 
		return forwardPage;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String displayLogin(Model model) 
	{ 
	    model.addAttribute("user", new User()); 
	    return "Login"; 
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String showLogin(Model model) 
	{ 
	    model.addAttribute("user", new User()); 
	    return "Login"; 
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/authenticate")
	public String validateLogin(@ModelAttribute("user") User user, Model model)
	{
		String userID = user.getUserID();
		String userPass = user.getUserPass();
		boolean userValid = false;
		
		if(!Utility.checkNullOrEmpty(userID) && !Utility.checkNullOrEmpty(userPass))
		{			
			userValid = dbService.validateUser(userID, userPass);
			if(userValid)
			{				
				return "Dashboard";
			}
			else
			{
				model.addAttribute("errorMessage", "Login failed."); 
				return "Login";
			}
		}
		else
		{
			model.addAttribute("errorMessage", "Both Username and Password must be entered.");
			return "Login";
		}		
		
	}	
}
