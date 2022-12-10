<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h3>Total Price: $250</h3>
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
<tr>
<td>Men Watch</td>
<td> Watch</td>
<td>$90</td>
<td>
<form action="#" class="form-inline">
<input type="hidden" value="1"/>
<a href="#" class="btn btn-sm btn-incre"><i class="fas fa-minus-square"  style="color:red"></i></a>
<input type ="text" name="quantity" value ="1">
<a href="#" class="btn btn-sm btn-incre"><i class="fas fa-plus-square" style="color:green"></i></a>
</form>
</td>
<td>
<a href="#" class="btn btn-sm btn-danger">Cancel</a>
</td>
</tr>

</table>

</div>

</body>
<%@ include file="/Includes/Footer.jsp"%>
</html>