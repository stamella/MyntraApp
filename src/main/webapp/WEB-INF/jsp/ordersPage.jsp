<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp"%>

<div class="ml-5 mr-5" align="center">
<h2>Orders</h2>
	<table class="table table-bordered">
		<thead align="center">
			<tr>
				<th scope="col">Order Id</th>
				<th scope="col">Total</th>
				<th scope="col">Date</th>
				<th scope="col">Status</th>
				
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach var="i" items="${orders}">
				<tr>
				<td>${i.orderId}</td>
				<td>${i.total}</td>
				<td>${i.date}</td>
				<td>${i.status}</td>
				<td><a href="" class="btn btn-danger btn-sm disabled">Cancel</a> <a href="" class="btn btn-success btn-sm disabled">Show Detail</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	</div>

</body>
</html>