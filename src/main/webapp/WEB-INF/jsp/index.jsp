<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">



<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<br>
	<div class="row" align="center">
		<div class="col-md-3">
		<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Product 1</h5>
		    <h6 class="card-subtitle mb-2 text-muted">product</h6>
		    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
		    <a href="/addtocart?productId=12345" class="card-link">Add to cart</a>
		    <a href="#" class="card-link">Another link</a>
		  </div>
		</div>
		</div>
		<div class="col-md-3">
		<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Card title</h5>
		    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
		    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
		      <a href="/addtocart?productId=12346&price=100" class="card-link">Add to cart</a>
		    <a href="#" class="card-link">Another link</a>
		  </div>
		</div>
		</div>
		<div class="col-md-3">
		<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Card title</h5>
		    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
		    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
		      <a href="/addtocart?productId=12347" class="card-link">Add to cart</a>
		    <a href="#" class="card-link">Another link</a>
		  </div>
		</div>
		</div>
		<div class="col-md-3">
		<div class="card" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Card title</h5>
		    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
		    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
		      <a href="/addtocart?productId=12348" class="card-link">Add to cart</a>
		    <a href="#" class="card-link">Another link</a>
		  </div>
		</div>
		</div>
	</div>
<br>
<div class="row" align="center">
<div class="col-md-3"></div>
<div class="col-md-6">
<a class="btn btn-danger btn-sm" href="/placeorder"> Place Order</a>
</div>
<div class="col-md-3"></div>
</div>


</body>
</html>