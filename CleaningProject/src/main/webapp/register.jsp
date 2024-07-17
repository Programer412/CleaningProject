<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type=text/css rel="stylesheet" href="Styles.css">
</head>
<body>
<script>
function myfun()
{
	var a=document.getElementById("email1").value;
	var b=document.getElementById("password1").value;
	var c=document.getElementById("cpassword1").value;

	if(b.length<6 || b.indexOf("@")==null)
		{
		
		document.getElementById("message").innerHTML="<br><br>**Your Password Length Should be 6 or more and use @,$ # these type of symbol";
		return false;
		
		}
	
	
	
	if(c!=b)
		{
		document.getElementById("message1").innerHTML="<br><br>**Password is not same";
		return false;
		}
	
	
	}


</script>
    <div class="main">
<div class="navbar">
    <div class="icon">
        <h4 class="logo">Cleaning</h4>
 </div>
 <div class="menu">
    <ul>
<li><a href="index.jsp" >Home</a></li>
<li><a href="" >Service</a></li>
<li><a href="" >Design </a></li>
<li><a href="" >Contact</a></li>
<li><a href="" >About</a></li>
</ul>
</div>
<div class="search">
<input class="srch" type="search" placeholder="type to search" name="srch">
<a href="#"><button class="btn">Search</a></button>

<div class="form">
<h2><%
if(session.getAttribute("success")!=null)
	
out.println(session.getAttribute("success"));
session.removeAttribute("success");
%></h2>
    <h2>Signup Here</h2>
<form onsubmit="return myfun()" action="signup" method="post">
<input type="text" name="name" placeholder="Enter the name" required>
<input type="email" name="email" id="email1" placeholder="Enter the email" required>
<input type="password" name="password" id="password1" placeholder="Enter the password" required>
<span id="message" style="color:#FF7200;"></span> 
<input type="password" name="cpassword" id="cpassword1" placeholder="Confirm your password" required>
<span id="message1" style="color:#FF7200;"></span>
<input type="submit" value="Register"></form>



</div>



</div>
 </div>


</div>


</body>
</html>