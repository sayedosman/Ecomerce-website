<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>  
       
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>   
<!DOCTYPE html>
<html>
<title>Luxury Watches A Ecommerce Category Flat Bootstrap Resposive Website Template | Home :: w3layouts</title>
<link href="/resourses/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--jQuery(necessary for Bootstrap's JavaScript plugins)-->
<script src="/resourses/js/jquery-1.11.0.min.js"></script>
<!--Custom-Theme-files-->
<!--theme-style-->
<link href="/resourses/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<!-- The core Firebase JS SDK is always required and must be listed first -->
<script src="/__/firebase/7.14.2/firebase-app.js"></script>

<!-- TODO: Add SDKs for Firebase products that you want to use
     https://firebase.google.com/docs/web/setup#available-libraries -->

<!-- Initialize Firebase -->
<script src="/__/firebase/init.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Luxury Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--start-menu-->
<script src="/resourses/js/simpleCart.min.js"> </script>
<link href="/resourses/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="/resourses/js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!--dropdown-->
<script src="/resourses/js/jquery.easydropdown.js"></script>			
</head>
<body>

<!--top-header-->
	<div class="top-header">
		<div class="container">
			<div class="top-header-main">
				<div class="col-md-6 top-header-left">
					<div class="drop">
						<div class="box">
							<select tabindex="4" class="dropdown drop">
								<option value="" class="label">Dollar :</option>
								<option value="1">Dollar</option>
								<optiosn value="2">Euro</option>
							</select>
						</div>
						<div class="box1">
							<select tabindex="4" class="dropdown">
								<option value="" class="label">English :</option>
								<option value="1">English</option>
								<option value="2">French</option>
								<option value="3">German</option>
							</select>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="box1">
					 <div style=color:white;> 
					 <sec:authorize access="isAuthenticated()">
					 welcome
					 <sec:authentication property="principal.user.firstname"/>
               </sec:authorize>
			
				</div>
				</div>
				<div class="col-md-6 top-header-left">
					<div class="cart box_1">
						<a href="Checkout.jsp">
							 <div class="total">
							 <%
							
								if(session.getAttribute("price")!=null)
								{%>
								$<%=session.getAttribute("price") %>
								
								<%} %></div>
								<img src="/resourses/images/cart-1.png" alt="" />
						</a>
						<p><a href="/luxury_site/Empty" class="simpleCart_empty">Empty Cart</a></p>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--top-header-->
	<!--start-logo-->
	<div class="logo">
		<a href="index.html"><h1>Luxury Watches</h1></a>
	</div>
	<!--start-logo-->
	<!--bottom-header-->
		<div class="header-bottom">
		<div class="container">
			<div class="header">
				<div class="col-md-9 header-left">
				<div class="top-nav">
				<ul class="memenu skyblue"><li class="active"><a href="">Home</a></li>
					<li class="grid"><a href="#">Category</a>
						<div class="mepanel">
					<div class="col1 me-one">
					
					    <ul>
					 <c:forEach var="category" items="${Categeries}">
					  <li><a  href="searchCatogery.jsp?id=${category.id}" method="post">${category.name}</a></li>
						</c:forEach>
						
						</ul>
							</div>
							</div>
					</li>
					
					<li class="grid"><a href="#">Brands</a>
						<div class="mepanel">
					<div class="col1 me-one">
					
					    <ul>
					     <ul>
					 <c:forEach var="brand" items="${Brands}">
					  <li><a  href="searchCatogery.jsp?id=${brand.id}" method="post">${brand.name}</a></li>
						</c:forEach>
						
						</ul>
					    
					    </ul>
							</div>
							</div>
					</li>
					<li class="grid"><a href="contact.jsp">Contact</a>
						</li>
						
						<sec:authorize access="!isAuthenticated()">
						<li class="grid"><a href="Login.jsp">Login</a>
						</li>
						<li class="grid"><a href="Register.jsp">Register</a>
						</li>
		               </sec:authorize>
						<sec:authorize access="isAuthenticated()">
						<li class="grid"><a href="Logout.jsp">Logout</a>
						</li> 
		               </sec:authorize>
						
						
			
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
				<div class="col-md-3 header-right"> 
				<div class="search-bar">
				<form action="/luxury/handl" method="POST">
					<input type="text"   name="name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
					<input type="submit" name="submit1"   value="search"/>
									
				</div>
			</div>
			<div class="clearfix"> </div>
			</div>
		</div>
	</div>
</body>
</html>
