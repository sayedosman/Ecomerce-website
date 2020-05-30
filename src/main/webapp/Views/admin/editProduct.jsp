<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>   

<!DOCTYPE html>
<html>
<title>Luxury Watches A Ecommerce Category Flat Bootstarp Resposive Website Template | Account :: w3layouts</title>
<link href="/resourses/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--jQuery (necessary for Bootstrap's JavaScript plugins)-->
<script src="/resourses/js/jquery-1.11.0.min.js"></script>
<!--Custom-Theme-files-->
<!--theme-style-->
<link href="/resourses/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<!-- The core Firebase JS SDK is always required and must be listed first -->

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
<jsp:include page="/Views/header.jsp" />

<div class="account">
		<div class="container">
		<div class="account-top heading">
				<h2>ACCOUNT</h2>
			</div>
			<div class="account-main">
				<div class="col-md-6 account-left">
					<h3>Update Product</h3>
					<div class="account-bottom">
	          
                    <form action="/admin/editProductProcess" method="post" modelAttribute="product">
                    <input placeholder=" name" type="text" tabindex="3" hidden="hidden" name="id"  value="${product.id }">
                  
                    ${message.get('name') }
                    
                    <input placeholder=" name" type="text" tabindex="3" required name="name"  value="${product.name }">
                      <table>
                    <tr>
                    <td> Category</td>
                  <td>
                   
		             <select name="category">
		              <c:forEach var="category" items="${Categeries }">  
							
							<option ${product.category.name.equals(category.name) ? 'selected' : '' } value="${category.id}">${category.name}</option>
								</c:forEach>
					 </select>
					</td>
					</tr><tr>
					<td> Brand</td>
					<td>
					   <select name="brand">
		              <c:forEach var="brand" items="${Brands }">  
							
							<option ${product.brand.name.equals(brand.name) ? 'selected' : '' } value="${brand.id}">${brand.name}</option>
								</c:forEach>
					 </select></td>
					 </tr>
					 </table>
					 ${message.get('discription') }
			    <input placeholder="Description" type="text" tabindex="4" required name="description" value="${product.description }">
		         	 ${message.get('quantity') }
               <input placeholder="quantity" type="text" tabindex="3" required name="quantity"  value="${product.quantity }">
		    
			    <input placeholder="discount" type="text" tabindex="4" required name="discount" value="${product.discount }">
			         ${message.get('price') }
			    <input placeholder="price" type="text" tabindex="4" required name="price" value="${product.price }">
		  
                        <input placeholder="sold" type="tet" tabindex="4" required name ="sold" value="${product.sold }">
                        <table>
                        <tr>
                       <td> ${message.get('colors') }</td>
                        <td>Colors</td>
					<td>
				
					<select name="colores" multiple="multiple">
		              <c:forEach var="color" items="${Colors }">  
		                  <c:forEach var="productColor" items="${product.colors }" > 
							<option ${productColor.name.equals(color.name) ? 'selected' : '' } value="${color.id }" >${color.name}</option>
							 <c:remove var = "productColore"/>
							</c:forEach>
					 </c:forEach>
					 </select></td></tr>
					<tr>
					<td>${message.get('size') }</td>
                        <td>Size</td>
                        <td>
                       
                   	 <select name="sizs" multiple="multiple">
		              <c:forEach var="size" items="${Sizes }">  
		                    <c:forEach var="productSize" items="${product.sizes }" > 
							<option ${productSize.name.equals(size.name) ? 'selected' : '' } value="${size.id}">${size.name}</option>
							
							</c:forEach>
					 </c:forEach>
					 </select></td></tr>
					<tr>
                        <td>Offer</td>
                        <td> ${message.get('offers') }</td>
                        <td>
					 <select name="offers" multiple="multiple">
		              <c:forEach var="offer" items="${Offers }">  
		                     <c:forEach var="productOffer" items="${product.offer }">  
							<option ${productOffer.name.equals(offer.name) ? 'selected' : '' } value="${offer.id}">${offer.name}</option>
						
								</c:forEach>
						</c:forEach>
					 </select></td>
					 </tr>
					 </table>
					
			<div class="address submit">
							<input type="submit" value="Add" name="submit">
						</div>
						</form>
         
			
                       
                        </div>
					</div>
				</div>
				
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
<jsp:include page="/Views/footer.jsp" />

</body>
</html>