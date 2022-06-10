package com.sportyshoes.utilities;

public class Utility {
	
	public static boolean checkNullOrEmpty(String input)
	{
		boolean flag = false;
		
		if(input == null || input.equals(""))
		{
			flag = true;
		}
		
		return flag;
	}
}
