<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>   
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Luxury Watches A Ecommerce Category Flat Bootstarp Resposive Website Template | Single :: w3layouts</title>
<link href="/resourses/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--jQuery(necessary for Bootstrap's JavaScript plugins)-->
<script src="/resourses/js/jquery-1.11.0.min.js"></script>
<!--Custom-Theme-files-->
<!--theme-style-->
<link href="/resourses/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<link href='//fonts.googleapis.com/css?family=Raleway:400,100,100italic,200,200italic,300,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- The core Firebase JS SDK is always required and must be listed first -->
<script src="/__/firebase/7.14.2/firebase-app.js"></script>

<!-- TODO: Add SDKs for Firebase products that you want to use
     https://firebase.google.com/docs/web/setup#available-libraries -->

<!-- Initialize Firebase -->
<script src="/__/firebase/init.js"></script>
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Luxury Watches Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--start-menu-->
<script src="/resourses/js/simpleCart.min.js"> </script>
<link href="/resourses/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="/resourses/js/memenu.js"></script>
<script type="text/javascript" src="/resourses/js/minicart.min.js"></script>
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
	<!--top-header-->

	<!--top-header-->
	<jsp:include page="header.jsp" />
	<!--start-logo-->

	<!--bottom-header-->
	<!--start-breadcrumbs-->
	<div class="breadcrumbs">
		<div class="container">
			<div class="breadcrumbs-main">
				<ol class="breadcrumb">
					<li><a href="/luxury">Home</a></li>
					<li class="active">Single</li>
				</ol>
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
	<!--start-single-->
	<div class="single contact">
		<div class="container">
			<div class="single-main">
				<div class="col-md-9 single-main-left">
				<div class="sngl-top">
					<div class="col-md-5 single-top-left">	
						<div class="flexslider">
							  <ul class="slides">
					   
					    		  <li data-thumb="/resourses/${Product.images.get(0).name }">
					    		   <div class="thumb-image"> <img src="/resourses/${Product.images.get(0).name }" data-imagezoom="true" class="img-responsive" alt=""/> </div>
								</li>
					
							  </ul>
						</div>
						<!-- FlexSlider -->
						<script src="/resourses/js/imagezoom.js"></script>
						<script defer src="/resourses/js/jquery.flexslider.js"></script>
						<link rel="/resourses/stylesheet" href="/resourses/css/flexslider.css" type="text/css" media="screen" />

						<script>
						// Can also be used with $(document).ready()
						$(window).load(function() {
						  $('.flexslider').flexslider({
							animation: "slide",
							controlNav: "thumbnails"
						  });
						});
						</script>
					</div>	
					<div class="col-md-7 single-top-right">
						<div class="single-para simpleCart_shelfItem">
						<h2>Lorem Ipsum</h2>
							<div class="star-on">
								<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
								<div class="review">
									<a href="#"> 1 customer review </a>
									
								</div>
							<div class="clearfix"> </div>
							</div>
                     
	                            
							<h5 class="item_price"> $ ${Product.price } </h5>							
							<p>  ${Product.description }</p>
							<div class="available">
								<ul>
									<li>Color
										<select>  
										<c:forEach var="color" items="${Product.colors }">
										   
					             <option >${color.name}</option>
		 		                        
					                </c:forEach >
				
					                    </select>
					              </li>
								<li class="size-in">Size<select>
					              <c:forEach  var="size" items="${Product.sizes }">
					                     
					                          <option >${size.name}</option>
		 		   
					                     
					                 </c:forEach >
					                    </select>
					                    </li>
								<li >Offers <select>
								<c:forEach  var="offer" items="${Product.offer }">
					                           <option >${offer.name}</option>
		 		                
					                       
					                 </c:forEach >
					                    </select> 
								
								
								
								</li>
								<div class="clearfix"> </div>
							</ul>
						</div>
							<ul class="tag-men">
								<li><span>TAG</span>
								<span class="women1">: Women,</span></li>
								<li><span>SKU</span>
								<span class="women1">: CK09</span></li>
							</ul>
							
							<form action="/luxury/handle"  method="POST">
								<div class="address submit">
										<input type="hidden" name="id" value=${Product.id } />
												</div><input type="text"    name="quantity" value="">
										
										<input type="submit" name="submit"   value="Add to cart"/>
								
																			 
								</form>
								</div>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="tabs">
					<ul class="menu_drop">
				<li class="item1"><a href="#"><img src="/resourses/images/arrow.png" alt="">Description</a>
					<ul>
						<li class="subitem1"><a href="#"> 
					
					${Product.description }
					    ?>
                               </a></li>
						</ul>
				</li>
				<li class="item2"><a href="#"><img src="/resourses/images/arrow.png" alt="">Additional information</a>
					<ul>
					    <li class="subitem2"><a href="#"> Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore</a></li>
						<li class="subitem3"><a href="#">Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes </a></li>
					</ul>
				</li>
				<li class="item3"><a href="#"><img src="/resourses/images/arrow.png" alt="">Reviews (10)</a>
					<ul>
						<li class="subitem1"><a href="#">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</a></li>
						<li class="subitem2"><a href="#"> Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore</a></li>
						<li class="subitem3"><a href="#">Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes </a></li>
					</ul>
				</li>
				<li class="item4"><a href="#"><img src="/resourses/images/arrow.png" alt="">Helpful Links</a>
					<ul>
					    <li class="subitem2"><a href="#"> Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore</a></li>
						<li class="subitem3"><a href="#">Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes </a></li>
					</ul>
				</li>
				<li class="item5"><a href="#"><img src="/resourses/images/arrow.png" alt="">Make A Gift</a>
					<ul>
						<li class="subitem1"><a href="#">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</a></li>
						<li class="subitem2"><a href="#"> Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore</a></li>
						<li class="subitem3"><a href="#">Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes </a></li>
					</ul>
				</li>
	 		</ul>
				</div>
				<div class="latestproducts">
		       <div class="product-one">	
		          
						  <c:forEach  var="products" items="${Product.category.products }">
						 <div class="col-md-4 product-left p-left"> 
					<div class="product-main simpleCart_shelfItem">
					<div class="product-bottom">
					
					<a href="/luxury/single/${products.id }" class="mask"><img class="img-responsive zoom-img" src="/resourses/${products.images.get(0).getName() }" alt="" /></a>      
						
						
								<h3> ${products.name }</h3>
								 <span>${products.quantity.equals(products.sold) ? 'sold' : '' } </span>
					      <h4><a class="item_add" href="#"><i></i></a> <span class=" item_price">$ ${products.price } </span></h4>
							</div>
					
					      
							</div>
							<div class="srch">
							
								<span>-${products.discount}</span>
							</div>
							</div>
										
						
					
						 </c:forEach >
						
						
				</div>
			</div>
			</div>			
						
				<div class="col-md-3 single-right">
					<div class="w_sidebar">
						<section  class="sky-form">
							<h4>Catogories</h4>
							<div class="row1 scroll-pane">
								<div class="col col-4">
						
		                <c:forEach  var="category" items="${Categeries}">
		                      
					<label class="checkbox"><input type="checkbox" name="checkbox" ${category.name.equals(Product.category.name)? 'checked' : ''} valuue="${category.name }"} ><i></i>${category.name } </label>
					</c:forEach >
						</div>
							
						</section>

						<section  class="sky-form">
							<h4>Brand</h4>
							<div class="row1 row2 scroll-pane">
						
						
						 <c:forEach  var="brand" items="${Brands}">
		                      
					<label class="checkbox"><input type="checkbox" name="checkbox" ${brand.name.equals(Product.brand.name)? 'checked' : ''  } ><i></i>${brand.name } </label>
					</c:forEach >
						</div>
							
						</section>
						<section class="sky-form">
							<h4>Colour</h4>
								<ul class="w_nav2">
									<li><a class="color1" href="#"></a></li>
									<li><a class="color2" href="#"></a></li>
									<li><a class="color3" href="#"></a></li>
									<li><a class="color4" href="#"></a></li>
									<li><a class="color5" href="#"></a></li>
									<li><a class="color6" href="#"></a></li>
									<li><a class="color7" href="#"></a></li>
									<li><a class="color8" href="#"></a></li>
									<li><a class="color9" href="#"></a></li>
									<li><a class="color10" href="#"></a></li>
									<li><a class="color12" href="#"></a></li>
									<li><a class="color13" href="#"></a></li>
									<li><a class="color14" href="#"></a></li>
									<li><a class="color15" href="#"></a></li>
									<li><a class="color5" href="#"></a></li>
									<li><a class="color6" href="#"></a></li>
									<li><a class="color7" href="#"></a></li>
									<li><a class="color8" href="#"></a></li>
									<li><a class="color9" href="#"></a></li>
									<li><a class="color10" href="#"></a></li>
								</ul>
					</section>
					<section class="sky-form">
							<h4>discount</h4>
							<div class="row1 row2 scroll-pane">
							
					 <c:forEach  var="product" items="${Products}">
		                      
					<label class="checkbox"><input type="checkbox" name="checkbox" ${Product.discount.equals(product.discount)? 'checked' : ''  } ><i></i>${product.discount } </label>
					</c:forEach >
						
							
							</div>						
						</section>
						
					
								
						
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	 <jsp:include page="footer.jsp" />			
					
					

</body>
</html>