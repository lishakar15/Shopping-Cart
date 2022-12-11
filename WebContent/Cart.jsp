<%@page import="com.shoppingCart.dao.ProductDao"%>
<%@page import="com.shoppingCart.model.ProductVO"%>
<%@page import="com.shoppinCart.DBConnection.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.shoppingCart.model.CartVO" %>
<%@page  import="java.util.List"%>
<%@page  import="java.util.Iterator"%>
 <%
 List<CartVO>cartVOList= (List<CartVO>)request.getSession().getAttribute("cartList");
 List<CartVO>cartList = null;
 if(null != cartVOList)
{
	ProductDao productDao = new ProductDao(DbConnection.getConnection());
	cartList = productDao.getProductDetailsById(cartVOList);
}
 Double totalAmt = 0.0;
 
 if(null!=cartList && !cartList.isEmpty())
	{
		Iterator itr = cartList.iterator();
		while(itr.hasNext())
		{
			CartVO cartVO = (CartVO)itr.next();
			double itemAmt = Double.parseDouble(cartVO.getPrice().replace("$", ""))*cartVO.getQuantity();
			totalAmt = totalAmt+itemAmt;
		}
	}
 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
<%@ include file="/Includes/NavBar.jsp" %>
<%@ include file="/Includes/Header.jsp" %>
<style type="text/css">
.btn-incre,.btn-decre{
font-size: 25px;
}

</style>
</head>
<body>
<div class = "container">
<div class="d-flex py-3">
<h3>Total Price: $<%=totalAmt %></h3>
<a href="#" class="mx-3 btn btn-success">Check Out</a>
</div>
<table class="table table-loght">
<tr>
<th scope="col">Name</th>
<th scope="col">Category</th>
<th scope="col">Price</th>
<th scope="col">Quantity</th>
<th scope="col">Cancel</th>
</tr>
<% if(null!=cartList && !cartList.isEmpty())
	{
		Iterator itr = cartList.iterator();
		while(itr.hasNext())
		{
			CartVO cartVO = (CartVO)itr.next();
			%>
<tr>
<td><%=cartVO.getProductName() %></td>
<td> <%=cartVO.getCategory() %></td>
<td><%=cartVO.getPrice() %></td>
<td>
<form action="#" class="form-inline">
<input type="hidden" value="1"/>
<a href="#" class="btn btn-sm btn-incre"><i class="fas fa-minus-square"  style="color:red"></i></a>
<input type ="text" name="quantity" value ="1" disabled>
<a href="#" class="btn btn-sm btn-incre"><i class="fas fa-plus-square" style="color:green"></i></a>
</form>
</td>
<td>
<a href="#" class="btn btn-sm btn-danger">Cancel</a>
</td>
</tr>

	<%}
}%>

</table>

</div>

</body>
<%@ include file="/Includes/Footer.jsp"%>
</html>