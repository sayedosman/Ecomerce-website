<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>   
<!DOCTYPE html>
<head>
<title>Luxury Watches A Ecommerce Category Flat Bootstarp Resposive Website Template | Checkout :: w3layouts</title>
<link href="front_end/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--jQuery(necessary for Bootstrap's JavaScript plugins)-->
<script src="front_end/js/jquery-1.11.0.min.js"></script>
<!--Custom-Theme-files-->
<!--theme-style-->
<!-- The core Firebase JS SDK is always required and must be listed first -->
<script src="/__/firebase/7.14.2/firebase-app.js"></script>

<!-- TODO: Add SDKs for Firebase products that you want to use
     https://firebase.google.com/docs/web/setup#available-libraries -->

<!-- Initialize Firebase -->
<script src="/__/firebase/init.js"></script>
<link href="front_end/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Luxury Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--start-menu-->
<script src="front_end/js/simpleCart.min.js"> </script>
<link href="front_end/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="front_end/js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!--dropdown-->
<script src="front_end/js/jquery.easydropdown.js"></script>			
</head>
<body>
<jsp:include page="header.jsp" />
<div class="breadcrumbs">
		<div class="container">
			<div class="breadcrumbs-main">
				
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
	<!--start-ckeckout-->
	<div class="ckeckout">
		<div class="container">
			<div class="ckeck-top heading">
				<h2>CHECKOUT</h2>
			</div>
			<div class="ckeckout-top">
			<div class="cart-items">
			 	
				
			<div class="in-check" >
				<ul class="unit">
					<li><span>Item</span></li>
					<li><span>Product Name</span></li>		
					<li><span>Unit Price</span></li>
					<li><span>Quantity</span></li>
					<li> </li>
					<div class="clearfix"> </div>
				</ul>
	             <c:forEach var="Product" items="${products}">
	            ${Product.quantity }
	            
	            <ul class="cart-header">
					
						<li class="ring-in">  <a href="/luxury/single/${Product.id}" class="mask"><img class="img-responsive zoom-img" src="/resourses/${Product.getImages().get(0).getName() }"  alt="" /></a>
						</li>
						<li><span class="name">${Product.name }</span></li>
						<li><span class="cost">$ ${Product.price }</span></li>
						<li><form action="/luxury/handle" method="POST">
					    <input type="hidden" name="oq" value=${Product.quantity }>
				<input type="hidden" name="id2" value=${Product.id }>
						<input type="text" name="quantity" value=${Product.quantity }>
						<input type="submit" name="submit" value="Update"/>
						</form></li>
						<li><a href="/luxury/luxury/Delete/${Product.id}"><img src="/resourses/images/close.png" align="right"/></a>
						
						</li>
						
					<div class="clearfix"> </div>
				</ul>
				
	            
	            
	            </c:forEach>
	            
	            <a href="/luxury/luxury/save"><button> save</button></a>
	            

		
			</div>
			</div>  
		 </div>
		</div>
	</div>







<jsp:include page="footer.jsp" />
</body>
</html>