+`1<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
        
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>   

<html>
<head>
<title>Luxury Watches A Ecommerce Category Flat Bootstrap Resposive Website Template | Home :: w3layouts</title>
<link href="/resourses/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--jQuery(necessary for Bootstrap's JavaScript plugins)-->
<script src="/resourses/js/jquery-1.11.0.min.js"></script>
<!--Custom-Theme-files-->
<!--theme-style-->
<link href="/resourses/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Luxury Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!-- The core Firebase JS SDK is always required and must be listed first -->


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
 <jsp:include page="header.jsp" />
	<!--top-header-->
	
	<!--top-header-->
	<!--start-logo-->
	
	<!--start-logo-->
	<!--bottom-header-->
		
		
	<!--bottom-header-->
	<!--banner-starts-->
	<div class="bnr" id="home">
		<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider4">
			    <li>
					<img src="/resourses/images/bnr-1.jpg" alt=""/>
				</li>
				<li>
					<img src="/resourses/images/bnr-2.jpg" alt=""/>
				</li>
				<li>
					<img src="/resourses/images/bnr-3.jpg" alt=""/>
				</li>
			</ul>
		</div>
		<div class="clearfix"> </div>
	</div>
	<!--banner-ends--> 
	<!--Slider-Starts-Here-->
				<script src="/resourses/js/responsiveslides.min.js"></script>
			 <script>
			    // You can also use "$(window).load(function() {"
			    $(function () {
			      // Slideshow 4
			      $("#slider4").responsiveSlides({
			        auto: true,
			        pager: true,
			        nav: true,
			        speed: 500,
			        namespace: "callbacks",
			        before: function () {
			          $('.events').append("<li>before event fired.</li>");
			        },
			        after: function () {
			          $('.events').append("<li>after event fired.</li>");
			        }
			      });
			
			    });
			  </script>
			<!--End-slider-script-->
	<!--about-starts-->
	<div class="about"> 
		<div class="container">
			<div class="about-top grid-1">
				<div class="col-md-4 about-left">
					<figure class="effect-bubba">
						<img class="img-responsive" src="/resourses/images/abt-1.jpg" alt=""/>
						<figcaption>
							<h2>Nulla maximus nunc</h2>
							<p>In sit amet sapien eros Integer dolore magna aliqua</p>	
						</figcaption>			
					</figure>
				</div>
				<div class="col-md-4 about-left">
					<figure class="effect-bubba">
						<img class="img-responsive" src="/resourses/images/abt-2.jpg" alt=""/>
						<figcaption>
							<h4>Mauris erat augue</h4>
							<p>In sit amet sapien eros Integer dolore magna aliqua</p>	
						</figcaption>			
					</figure>
				</div>
				<div class="col-md-4 about-left">
					<figure class="effect-bubba">
						<img class="img-responsive" src="/resourses/images/abt-3.jpg" alt=""/>
						<figcaption>
							<h4>Cras elit mauris</h4>
							<p>In sit amet sapien eros Integer dolore magna aliqua</p>	
						</figcaption>			
					</figure>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--about-end-->
	<!--product-starts-->
	<div class="product"> 
		<div class="container">
			<div class="product-top">
				<div class="product-one">
		           <c:forEach var="Product" items="${Products}">
					<div class="col-md-4 product-left p-left">
							<div class="product-main simpleCart_shelfItem">
							<sec:authorize access="hasAnyAuthority('admin')">
							 <a href="/admin/editProduct/${Product.id}" class="mask"><img class="img-responsive zoom-img" src="/resourses/${Product.getImages().get(0).getName() }"  alt="" /></a>
					         </sec:authorize>
					         <sec:authorize access="hasAnyAuthority('user')">
					            <a href="/luxury/single/${Product.id}" class="mask"><img class="img-responsive zoom-img" src="/resourses/${Product.getImages().get(0).getName() }"  alt="" /></a>
						 </sec:authorize>
						 <sec:authorize access="!isAuthenticated()">
						  <a href="/luxury/single/${Product.id}" class="mask"><img class="img-responsive zoom-img" src="/resourses/${Product.getImages().get(0).getName() }"  alt="" /></a>
						</sec:authorize>
						<div class="product-bottom">
					<h3>${Product.name }</h3>
		           			<h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">$ ${Product.price }</span></h4>
							</div>
							<div class="srch">
								<span>-${Product.discount }%</span>
							
						</div>
						
							</div>
						</div>
                          
						
							</c:forEach>		
					
		      </div>					
			</div>
		</div>
	</div>
	<!--product-end-->	
	 <jsp:include page="footer.jsp" />
</body>
</html>