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
<jsp:include page="/Views/header.jsp" />

<div class="account">
		<div class="container">
		<div class="account-top heading">
				<h2>ACCOUNT</h2>
			</div>
			<div class="account-main">
				<div class="col-md-6 account-left">
					<h3>Existing User</h3>hdhdfjh
					<div class="account-bottom">
                    <form:form  action="/login" method="POST">

                <input placeholder="username" type="text" tabindex="3" required="required"  name="username" />
		        
			   <input placeholder="Password" type="password" tabindex="4" required="required"  name="password" />
		<div class="address submit">
							 <input type="submit" value="login" name="submit" />
							</div>	  
							</form:form>
                        
							
							

							
                        
                      
                        </div>
					</div>
				</div>
				<div class="col-md-6 account-right account-left">
					<h3>New User? Create an Account</h3>
					<p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.</p>
					<a href="Register.jsp">Create an Account</a>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>


<jsp:include page="/Views/footer.jsp" />
</body>
</html>