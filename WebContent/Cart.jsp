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
.containerA{
width:60%;
}
</style>
</head>
<body>
<div class = "container">
<div class="d-flex py-3">
<h3>Total Price: $<%=dcf.format(totalAmt) %></h3>
<a href="#" class="mx-3 btn btn-success">Check Out</a>
</div>
<hr/>
<% if(null!=cartList && !cartList.isEmpty())
	{
		Iterator itr = cartList.iterator();
		while(itr.hasNext())
		{
			CartVO cartVO = (CartVO)itr.next();
			%>
      <div class="d-flex flex-wrap ">
      <div class="containerA d-inline-flex">
        <div class="mx-2 ">
            <img class="card-img-top" style="width: 15rem" src="product-image/<%= cartVO.getImageName() %>" alt="Card image cap">
          </div>
          <!--Info panel-->
        <div class="info panel mx-4">
          <div class="">
            <h3><%=cartVO.getProductName() %></h3>
            <div class="">
              <h5>Category :  <%=cartVO.getCategory() %></h5>
            </div>
            <div class="">
              <h5>Item Available </h5>
            </div>
          </div>
          <!--Increment and Decrement Button-->
          <div>
            <a href="cart-inc-dec?action=decrement&id=<%=cartVO.getProductId() %>" class="btn btn-sm btn-incre">
              <i class="fas fa-minus-square" style="color:red"></i>
            </a>
            <input type="text" name="quantity" style="width:50px;text-align:center;" value="<%=cartVO.getQuantity()%>" disabled>
            <a href="cart-inc-dec?action=increment&id=<%=cartVO.getProductId() %>" class="btn btn-sm btn-incre">
              <i class="fas fa-plus-square" style="color:green"></i>
            </a>
          </div>
        </div>
        </div>
        <!--Rate panel-->
        <div class ="d-flex my-3" >
        <div class=" d-flex align-items-center mx-4">
          <h5>Price : $<%=dcf.format(cartVO.getPrice()*cartVO.getQuantity())%></h5>
        </div>
        <!--Buttons-->
        <div class="d-flex align-items-center mx-4">
          <a href="cancel-item?id=<%=cartVO.getProductId() %>" class="btn btn-sm btn-danger mr-3">Cancel </a>
          <a href="order-item?id=<%=cartVO.getProductId() %>" class="btn btn-sm btn-success">Buy Now </a>
        </div>
        </div>
    </div>
    <hr/>
	<%}
}%>
</body>
<%@ include file="/Includes/Footer.jsp"%>
</html>