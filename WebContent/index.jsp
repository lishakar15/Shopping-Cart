<%@page import="com.shoppinCart.DBConnection.DbConnection"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.shoppingCart.model.ProductVO" %>
<%@page import="com.shoppingCart.dao.ProductDao" %>
<%@page  import="java.util.List"%>
<%@page  import="java.util.Iterator"%>
<%@page import="com.shoppingCart.model.CartVO" %>
<% 	
List<CartVO>cartList = null;
//Populate products to display
ProductDao productDao = new ProductDao(DbConnection.getConnection());
List<ProductVO> productList=productDao.getProductDetails();

//Adding cart list from session to request to display the item count in cart link in nav
cartList= (List<CartVO>)request.getSession().getAttribute("cartList");

%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/Includes/Header.jsp"%>
<meta charset="ISO-8859-1">
<title>Shop Online</title>
<%@ include file="/Includes/NavBar.jsp"%>
</head>
<body>
	<div class="container">
	<div class ="card-header my-3"> All Products</div>
	<div class= "row d-flex justify-content-between">
	<% if(!productList.isEmpty())
	{
		Iterator itr = productList.iterator();
		while(itr.hasNext())
		{
			ProductVO productVO = (ProductVO)itr.next();
		%>
			<div class="card mx-4 my-4" style="width: 20rem;">
			<img class="card-img-top" src="product-image/<%= productVO.getImageName() %>" alt="Card image cap">
			
			<div class="card-body">
				<h5 class="card-title"><%= productVO.getProductName() %></h5>
				<h6 class="price">Price: $<%= productVO.getPrice() %></h6>
				<h6 class="category">Category: <%= productVO.getCategory() %></h6>
				<div class="mt-3 d-flex justify-content-between">
				<a href="add-to-cart?id=<%=productVO.getProductId()%>" class="btn btn-primary">Add to cart</a>
				<a href="order-item?id=<%=productVO.getProductId() %>" class="btn btn-primary">Buy Now</a>
				</div>
			</div>
		</div>
			
		<%}
	}%>
		
		</div>
	</div>


</body>
<%@ include file="/Includes/Footer.jsp"%>
</html>