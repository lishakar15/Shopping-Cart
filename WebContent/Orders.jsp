<%@page import="com.shoppinCart.DBConnection.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.shoppingCart.model.UserVO" %>
    <%@page import="com.shoppingCart.model.OrdersVO" %>
    <%@page import="com.shoppingCart.dao.OrdersDao"%>
    <%@page  import="java.util.*"%>
<%
UserVO userVO= (UserVO)request.getSession().getAttribute("user");
List<OrdersVO> ordersList = null;
if(null != userVO)
{
	OrdersDao ordersDao = new OrdersDao(DbConnection.getConnection());
	ordersList = ordersDao.getOrderDetails(userVO.getId());
}
if(null == userVO)
{
	response.sendRedirect("Login.jsp");
}
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Page</title>
<%@ include file="/Includes/Header.jsp" %>
<%@ include file="/Includes/NavBar.jsp" %>
</head>
<body>
<div class="container">
	<div class ="card-header my-3"> All Products</div>
	<div class= "row d-flex justify-content-between">
	<table class="table table-loght">
	<tr>
	<th>Order Date</th>
	<th>Product Name</th>
	<th>Category</th>
	<th>Quantity</th>
	<th>Price</th>
	<th></th>
	</tr>
	<% if(null != ordersList && !ordersList.isEmpty()) 
	{
		Iterator itr = ordersList.iterator();
		while(itr.hasNext())
		{
			OrdersVO ordersVO = (OrdersVO)itr.next();
	%>
	<tr>
	<td><%= ordersVO.getOrderDate() %></th>
	<td><%= ordersVO.getProductName() %></th>
	<th><%=ordersVO.getProductCategory() %></th>
	<th><%=ordersVO.getQuantity() %></th>
	<th><%=ordersVO.getTotalAmount() %></th>
	</tr>
	<%} 
	}%>
	</table>
	</div>
	</div>


</body>
<%@ include file="/Includes/Footer.jsp"%>
</html>