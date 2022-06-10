package com.sportyshoes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.sportyshoes.entity.Customer;
import com.sportyshoes.entity.Order;
import com.sportyshoes.entity.Product;
import com.sportyshoes.utilities.Database;


@Component
public class DatabaseDAO {
	public boolean validateOldPass(String userName, String oldPassword){
		
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		boolean flag = false;

		try
		{
			Class.forName(Database.DB_CLASS_NAME);
			con = DriverManager.getConnection(Database.DB_URL, Database.DB_USER, Database.DB_PASS);

			pStmt = con.prepareStatement(Queries.USERS_VAL_OLD_PASS);
			pStmt.setString(1, userName);
			pStmt.setString(2, oldPassword);

			rs = pStmt.executeQuery();

			while (rs.next())
			{
				int val = rs.getInt(1);
				if (val > 0)
				{
					flag = true;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
					pStmt.close();
					rs.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	public boolean validateUser(String userName, String password)
	{
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		boolean flag = false;

		try
		{
			Class.forName(Database.DB_CLASS_NAME);
			con = DriverManager.getConnection(Database.DB_URL, Database.DB_USER, Database.DB_PASS);

			pStmt = con.prepareStatement(Queries.VALIDATE_USERS);
			pStmt.setString(1, userName);
			pStmt.setString(2, password);

			rs = pStmt.executeQuery();

			while (rs.next())
			{
				int val = rs.getInt(1);
				if (val > 0)
				{
					flag = true;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
					pStmt.close();
					rs.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	public Map<String, String> getData(String sql)
	{
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		Map<String, String> collection = new TreeMap<String, String>();

		try
		{
			Class.forName(Database.DB_CLASS_NAME);
			con = DriverManager.getConnection(Database.DB_URL, Database.DB_USER, Database.DB_PASS);

			pStmt = con.prepareStatement(sql);

			rs = pStmt.executeQuery();

			while (rs.next())
			{
				collection.put(rs.getString(1), rs.getString(2));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
					pStmt.close();
					rs.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		return collection;
	}

	public boolean resetPassword(String userName, String oldPassword, String newPassword)
	{
		Connection con = null;
		PreparedStatement pStmt = null;
		boolean flag = false;

		try
		{
			Class.forName(Database.DB_CLASS_NAME);
			con = DriverManager.getConnection(Database.DB_URL, Database.DB_USER, Database.DB_PASS);

			pStmt = con.prepareStatement(Queries.USERS_UPD_PASS);

			pStmt.setString(1, newPassword);
			pStmt.setString(2, userName);
			pStmt.setString(3, oldPassword);

			flag = pStmt.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			flag = false;
		}
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
					pStmt.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	public boolean registerCustomer(Customer customer)
	{
		Connection con = null;
		PreparedStatement pStmt = null;
		boolean flag = false;

		try
		{
			Class.forName(Database.DB_CLASS_NAME);
			con = DriverManager.getConnection(Database.DB_URL, Database.DB_USER, Database.DB_PASS);

			pStmt = con.prepareStatement(Queries.REG_CUSTOMER);

			pStmt.setString(1, customer.getCustFirstName());
			pStmt.setString(2, customer.getCustLastName());
			pStmt.setString(3, customer.getCustEmail());
			pStmt.setString(4, customer.getCustPhone());

			pStmt.execute();

			pStmt.close();

			pStmt = con.prepareStatement(Queries.REG_LOGIN);

			pStmt.setString(1, customer.getUserID());
			pStmt.setString(2, customer.getUserPass());
			pStmt.setString(3, "customer");

			pStmt.execute();

			flag = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
					pStmt.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	public Map<String, Product> getProductList()
	{
		Map<String, Product> mapOfProducts = new TreeMap<String, Product>();

		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		try
		{
			Class.forName(Database.DB_CLASS_NAME);
			con = DriverManager.getConnection(Database.DB_URL, Database.DB_USER, Database.DB_PASS);
			Product products = null;

			pStmt = con.prepareStatement(Queries.GET_PRODUCTS);

			rs = pStmt.executeQuery();

			while (rs.next())
			{
				products = new Product();
				products.setProdID(String.valueOf(rs.getInt(1)));
				products.setProdName(rs.getString(2));
				products.setProdCategory(rs.getString(3));
				products.setProdPrice(rs.getString(4));
				products.setProdColor(rs.getString(5));

				mapOfProducts.put(products.getProdID(), products);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
					pStmt.close();
					rs.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		return mapOfProducts;
	}

	public Map<String, Customer> getCustomerDetails(String query, boolean searchFlag, String custFName)
	{
		Map<String, Customer> mapOfCustomers = new TreeMap<String, Customer>();

		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		try
		{
			Class.forName(Database.DB_CLASS_NAME);
			con = DriverManager.getConnection(Database.DB_URL, Database.DB_USER, Database.DB_PASS);
			Customer customer = null;

			pStmt = con.prepareStatement(query);
			
			if(searchFlag)
			{
				pStmt.setString(1, custFName);				
			}

			rs = pStmt.executeQuery();

			while (rs.next())
			{
				customer = new Customer();
				customer.setCustID(String.valueOf(rs.getInt(1)));
				customer.setCustFirstName(rs.getString(2));
				customer.setCustLastName(rs.getString(3));
				customer.setCustEmail(rs.getString(4));
				customer.setCustPhone(rs.getString(5));

				mapOfCustomers.put(customer.getCustID(), customer);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
					pStmt.close();
					rs.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		return mapOfCustomers;
	}
	
	public Map<String, Order> getOrderDetails(String query, boolean searchFlag, String orderDate, String ordProdCategory)
	{
		Map<String, Order> mapOfOrders = new TreeMap<String, Order>();

		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;

		try
		{
			Class.forName(Database.DB_CLASS_NAME);
			con = DriverManager.getConnection(Database.DB_URL, Database.DB_USER, Database.DB_PASS);
			Order order = null;

			pStmt = con.prepareStatement(query);
			
			if(searchFlag)
			{
				pStmt.setString(1, orderDate);
				pStmt.setString(2, ordProdCategory);
			}

			rs = pStmt.executeQuery();

			while (rs.next())
			{
				order = new Order();
				order.setOrderID(String.valueOf(rs.getInt(1)));
				order.setOrderBillNo(String.valueOf(rs.getInt(2)));
				order.setOrderDate(rs.getDate(3));
				order.setProdName(rs.getString(4));
				order.setOrdProdCategory(rs.getString(5));
				order.setOrderQty(rs.getInt(6));
				order.setCustFName(rs.getString(7));
				order.setCustLName(rs.getString(8));
				order.setCustEmail(rs.getString(9));
				order.setCustPhone(rs.getString(10));
				order.setOrderAmt(rs.getBigDecimal(11));

				mapOfOrders.put(order.getOrderID(), order);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (con != null)
			{
				try
				{
					con.close();
					pStmt.close();
					rs.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}

		return mapOfOrders;
	}
}
