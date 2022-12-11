<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light ">
<div class="container ">
  <a class="navbar-brand  font-weight-bold" href="index.jsp">Alter <text style="color:red"> Shop </text> Zone</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Cart.jsp">My Cart <span class="badge badge-danger">${cartList.size()}</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="Orders.jsp">Orders</a>
      </li>
      <%if(null == request.getSession().getAttribute("userName")) {%>
      <li class="nav-item">
        <a class="nav-link " href="Login.jsp">Login</a>
      </li>
      <%} 
      else { %>
      <li class="nav-item">
        <a class="nav-link " href="user-logout">Logout</a>
      </li>
      <%} %>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2 border-info" type="search" placeholder="Search" aria-label="Search">
    </form>
  </div>
  </div>
</nav>
</body>
</html>