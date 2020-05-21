<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>   
<!DOCTYPE html>
<head>
<title>Luxury Watches A Ecommerce Category Flat Bootstarp Resposive Website Template | Checkout :: w3layouts</title>
<link href="/resourses/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--jQuery(necessary for Bootstrap's JavaScript plugins)-->
<script src="/resourses/js/jquery-1.11.0.min.js"></script>
<!--Custom-Theme-files-->
<!--theme-style-->
<!-- The core Firebase JS SDK is always required and must be listed first -->
<link href="/resourses/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Luxury Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--start-menu-->
<script src="/resourses/js/simpleCart.min.js"> </script>
<link href="/resourcses/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="/resourses/js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!--dropdown-->
<script src="/resourses/js/jquery.easydropdown.js"></script>	
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!--dropdown-->
<script src="js/jquery.easydropdown.js"></script>	
<script type="text/javascript">
	$(function() {
	
	    var menu_ul = $('.menu_drop > li > ul'),
	           menu_a  = $('.menu_drop > li > a');
	    
	    menu_ul.hide();
	
	    menu_a.click(function(e) {
	        e.preventDefault();
	        if(!$(this).hasClass('active')) {
	            menu_a.removeClass('active');
	            menu_ul.filter(':visible').slideUp('normal');
	            $(this).addClass('active').next().stop(true,true).slideDown('normal');
	        } else {
	            $(this).removeClass('active');
	            $(this).next().stop(true,true).slideUp('normal');
	        }
	    });
	
	});
</script>		
		
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
				<h2>MyORDERS</h2>
			</div>
			<div class="ckeckout-top">
			<div class="cart-items">
			 <div class="in-check" >
			<c:forEach var="order" items="${orders}">
			 <ul >
			 <li><span>Date</span></li>
			<li><span>${order.date }</span></li>		
			 </ul>
			 <div class="tabs">
					<ul class="menu_drop">
				<li class="item1"><a href="#"><img src="/resourses/images/arrow.png" alt="">Products</a>
					<ul>
						<li class="subitem1"><a href="#"> 
					
				 <c:forEach var="Product" items="${order.products}">
	       
	            
	            <ul class="cart-header">
					       <li class="ring-in">  <img class="img-responsive zoom-img" src="/resourses/${Product.getImages().get(0).getName() }"  alt="" />
						</li>
						<li><span class="name">${Product.name }</span></li>
						<li><span class="cost">$ ${Product.price }</span></li>
						
					<div class="clearfix"> </div>
				</ul>
				
	            
	            
	            </c:forEach>
					    
                               </a></li>
						</ul>
				</li>
				</ul>
				</div> 
				
				</c:forEach>
			 
			 
			 
			 
			 
			 
			 </div>
			 	

			</div>  
		 </div>
		</div>
	</div>







<jsp:include page="footer.jsp" />
</body>
</html>