<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>
<div class="ml-5 mr-5" align="center">
<h2>Cart Items</h2>
	<table class="table table-bordered">
		<thead align="center">
			<tr>
				<th scope="col">Item Id</th>
				<th scope="col">Product Id</th>
				<th scope="col">Quantity</th>
				<th scope="col">Price</th>
				<th scope="col">Delete</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach var="i" items="${sessionScope.cart}">
				<tr>
				<td>${i.itemId}</td>
				<td>${i.productId}</td>
				<td>${i.quantity}</td>
				<td>${i.price}</td>
				<td><a href="" class="btn btn-danger btn-sm disabled">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
			
				<td></td>
				<td></td>
				<td></td>
				<td><h4>Total:</h4> </td>
				<td><h4>${sessionScope.total}</h4></td>
				</tr>
		</tbody>
	</table>
	
	</div>
	


</body>
</html>