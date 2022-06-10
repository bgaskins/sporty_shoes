package com.sportyshoes.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	private String orderID;
	private String orderBillNo;
	private Date orderDate;
	private String prodName;
	private String ordProdCategory;
	private int orderQty;
	private String custFName;
	private String custLName;
	private String custEmail;
	private String custPhone;
	private BigDecimal orderAmt;
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getOrderBillNo() {
		return orderBillNo;
	}
	public void setOrderBillNo(String orderBillNo) {
		this.orderBillNo = orderBillNo;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getOrdProdCategory() {
		return ordProdCategory;
	}
	public void setOrdProdCategory(String ordProdCategory) {
		this.ordProdCategory = ordProdCategory;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public String getCustFName() {
		return custFName;
	}
	public void setCustFName(String custFName) {
		this.custFName = custFName;
	}
	public String getCustLName() {
		return custLName;
	}
	public void setCustLName(String custLName) {
		this.custLName = custLName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public BigDecimal getOrderAmt() {
		return orderAmt;
	}
	public void setOrderAmt(BigDecimal orderAmt) {
		this.orderAmt = orderAmt;
	}
}
