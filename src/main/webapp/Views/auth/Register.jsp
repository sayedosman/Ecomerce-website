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
					<h3>Existing User</h3>
					<div class="account-bottom">
	          
                    <form action="/register" method="post" modelAttribute="user">
                    <input placeholder="First name" type="text" tabindex="3" required name="firstname"  value="${user.firstname }">
		    ${bindingResult.rejectValue("email", "asd") }
			    <input placeholder="Last name" type="text" tabindex="4" required name="lastname" value="${user.lastname }">
		         
               <input placeholder="Email" type="text" tabindex="3" required name="email"  value="${user.email }">
		        
			    <input placeholder="Mobile" type="text" tabindex="4" required name="phone" value="${user.phone }">
			    <input placeholder="Adrres" type="text" tabindex="4" required name="address" value="${user.address }">
		            <ul>
		            <c:forEach var="gender" items="${genders }">  
							<li><label class="radio left"><input type="radio" name="gender"  ${user.gender.equals(gender) ? 'checked' : '' } value="${gender}"><i></i>${gender}</label></li>
					</c:forEach>
							<div class="clearfix"></div>
						</ul>
		  
                        <input placeholder="Password" type="password" tabindex="4" required name ="password" value="">
					
					<input placeholder="Password" type="password" tabindex="4" required name ="confirmPassword" value="">';
					
			<div class="address submit">
							<input type="submit" value="register" name="submit">
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