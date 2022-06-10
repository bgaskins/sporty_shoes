<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>

<link href="<spring:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css">

<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>


<div align="left" >
<img alt="Sporty Shoes welcome logo" height="125px" src="<spring:url value="/resources/images/sporty-shoes-logo-small.png" />">
	<h1 style="font-family: Arial">ADMIN MENU</h1>	
	
	<a href="products" style="font-family: Arial">Review Products</a>
	<br/>
	<a href="orders" style="font-family: Arial">Purchase Reports</a>
	<br/>
	<a href="customers" style="font-family: Arial">Customer Report</a>
	<br/>
	<a href="main" style="font-family: Arial">Exit</a>	
	
</div>

<div class="products">
<br/>
<div style="width:100%" class="tableHeading">REVIEW PRODUCTS</div>
<br/>
	<table style="width:100%">
		<tr>
			<th>ID #</th>
			<th>Name</th>
			<th>Category</th>
			<th>Price</th>
			<th>Product Color</th>
		</tr>
		<c:forEach var="products" items="${mapOfProducts}">		
			<tr>
				<c:set var="pdt" value="${products.value}"></c:set>				
				<td><span style="font-family: Arial"><c:out value="${pdt.prodID}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${pdt.prodName}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${pdt.prodCategory}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${pdt.prodPrice}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${pdt.prodColor}" /></span></td>
			</tr>
		</c:forEach>		
	</table>
</div>


<div class="orders">
<br/>
<div style="width:100%" class="tableHeading">PURCHASE REPORTS</div>
	<br/>
	
	
	<div align="center">
		<form name="searchPurReport" method="post" action="searchPurReport">
			<table>
				<tr>
					<td>
						Order Date: <input type="text" name="orderDate" />						
						Category: <input type="text" name="prodCategory" />
						<input type="submit" name="btnSub" value="Submit" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<br/>
			
	<table style="width:100%">
		<tr>
			<th>ID #</th>
			<th>Bill No.</th>
			<th>Date</th>
			<th>Product Name</th>
			<th>Product Category</th>
			<th>Qty.</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Contact</th>
			<th>Amount</th>
			
		</tr>
		<c:set var="noOfOrders" value="${mapOfOrders.size()}" />
		<c:if test="${noOfOrders == 0 }">
		<tr>
		<td colspan="11" style="text-align:center">
		<span> No Records Found</span>
		</td>
		</tr>
		</c:if>
		<c:forEach var="orders" items="${mapOfOrders}">		
			<tr>
				<c:set var="ord" value="${orders.value}"></c:set>				
				<td><span style="font-family: Arial"><c:out value="${ord.orderID}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${ord.orderBillNo}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${ord.orderDate}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${ord.prodName}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${ord.ordProdCategory}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${ord.orderQty}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${ord.custFName}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${ord.custLName}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${ord.custEmail}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${ord.custPhone}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${ord.orderAmt}" /></span></td>
			</tr>
		</c:forEach>		
	</table>
</div>


<div class="users">
<br/>
<div style="width:100%" class="tableHeading">CUSTOMER REPORT</div>
	<br/>

		<div align="center">
			<form name="searchCust" method="post" action="search">
				<table>
					<tr>
						<td>
							Customer First Name: <input type="text" name="custFirstName" />
							<input type="submit" name="btnSubmit" value="Submit" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<br/>
				
		<table style="width:100%">
		<tr>
			<th>ID #</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Phone</th>
		</tr>
		
		<c:set var="noOfCustomers" value="${mapOfCustomers.size()}" />
		<c:if test="${noOfCustomers == 0 }">
		<tr>
		<td colspan="5" style="text-align:center">
		<span> No Records Found</span>
		</td>
		</tr>
		</c:if>
		
		
		<c:forEach var="customers" items="${mapOfCustomers}">		
			<tr>
				<c:set var="cust" value="${customers.value}"></c:set>				
				<td><span style="font-family: Arial"><c:out value="${cust.custID}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${cust.custFirstName}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${cust.custLastName}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${cust.custEmail}" /></span></td>
				<td><span style="font-family: Arial"><c:out value="${cust.custPhone}" /></span></td>
			</tr>
		</c:forEach>		
	</table>
</div>

</body>
</html>