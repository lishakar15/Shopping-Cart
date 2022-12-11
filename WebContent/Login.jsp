<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page  import="java.util.*"%>
	<%@page import="com.shoppingCart.model.CartVO" %>
<%
List<CartVO>cartList= (List<CartVO>)request.getSession().getAttribute("cartList");

%>
	
	
<!DOCTYPE html>
<html>
<head>
<%@ include file="/Includes/Header.jsp"%>
<%@ include file="/Includes/NavBar.jsp"%>
<meta charset="ISO-8859-1">
<title>Login Page</title>

</head>
<body>
	<div class="container">
		<div class="card w-50 mx-auto my-5 ">
			<div class="card-header text-center font-weight-bold  ">User Login</div>
			<div class="card-body">
				<form action="user-login" method="post">
					<div class="form-group">
						<label for="emailId">Email Address</label> 
						<input type="email"	class="form-control border-info" id="email" name="emailId"
							placeholder="Enter Your Email Id" />
					</div>
					<div class="form-group">
						<label for="password">Password</label> 
						<input type="password"class="form-control border-info" id="password" name="password"
							placeholder="Enter Your Password" />
					</div>
					<div class="text-center">
						<input type="submit" class="btn btn-info" value="Login" />
						<input type="reset" class="btn btn-danger" value="Reset" />
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<%@ include file="/Includes/Footer.jsp"%>
</html>