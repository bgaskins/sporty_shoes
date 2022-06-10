package com.sportyshoes.dao;

public class Queries {
	public static String VALIDATE_USERS = "select count(*) from users where USER_NAME=? and USER_PASS=?";
	public static String USERS_VAL_OLD_PASS = "select count(*) from users where USER_NAME=? and USER_PASS=?";
	public static String USERS_UPD_PASS = "update users set USER_PASS=? where USER_NAME=? and USER_PASS=? ";
	public static String REG_CUSTOMER = "insert into customers(CUST_FIRST_NAME, CUST_LAST_NAME, EMAIL, PHONE) VALUES (?,?,?,?)";
	public static String REG_LOGIN = "insert into users(USER_NAME, USER_PASS, USER_ROLE) VALUES (?,?,?)";
	
	public static String GET_PRODUCTS = "SELECT * FROM PRODUCTS";
	public static String GET_CUSTOMERS = "SELECT * FROM CUSTOMERS";
	public static String GET_ORDERS = "SELECT * FROM ORDERS";
	public static String SEARCH_CUSTOMER = "SELECT * FROM CUSTOMERS where CUST_FIRST_NAME=?";
	public static String SEARCH_ORDERS = "SELECT * FROM ORDERS where convert(ORDER_DATE, DATE)=? and ORDER_PROD_CAT=?";
}
