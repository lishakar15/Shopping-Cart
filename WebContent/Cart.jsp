<%@page import="java.text.DecimalFormat"%>
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
	request.getSession().setAttribute("cartList", cartList);
}
 DecimalFormat dcf = new DecimalFormat("#.##");
 request.setAttribute("dcf", dcf);
 Double totalAmt = 0.00;
 
 if(null!=cartList && !cartList.isEmpty())
	{
		Iterator itr = cartList.iterator();
		while(itr.hasNext())
		{
			CartVO cartVO = (CartVO)itr.next();
			double itemAmt = cartVO.getPrice()*cartVO.getQuantity();
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
<h3>Total Price: $<%=dcf.format(totalAmt) %></h3>
<a href="#" class="mx-3 btn btn-success">Check Out</a>
</div>
<table class="table table-loght">
<tr>
<th scope="col">Name</th>
<th scope="col">Category</th>
<th scope="col">Price</th>
<th scope="col">Quantity</th>
<th scope="col"></th>
<th scope="col"></th>
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
<td><%=dcf.format(cartVO.getPrice()*cartVO.getQuantity())%></td>
<td>
<a href="cart-inc-dec?action=decrement&id=<%=cartVO.getProductId() %>"class="btn btn-sm btn-incre"><i class="fas fa-minus-square"  style="color:red"></i></a>
<input type ="text" name="quantity" style="width:50px;text-align:center;" value ="<%=cartVO.getQuantity()%>" disabled>
<a href="cart-inc-dec?action=increment&id=<%=cartVO.getProductId() %>" class="btn btn-sm btn-incre"><i class="fas fa-plus-square" style="color:green"></i></a>

</td>
<td>
<a href="cancel-item?id=<%=cartVO.getProductId() %>" class="btn btn-sm btn-danger">Cancel</a>
</td>
<td>
<a href="order-item?id=<%=cartVO.getProductId() %>" class="btn btn-sm btn-success">Buy Now</a>
</td>
</tr>

	<%}
}%>

</table>

</div>

</body>
<%@ include file="/Includes/Footer.jsp"%>
</html>