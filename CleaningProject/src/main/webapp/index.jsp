
<%@page import="com.entity.details"%>
<%@page import="com.entity.regist"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
  <div class="main">
<div class="navbar">
    <div class="icon">
        <h4 class="logo">Cleaning</h4>
 </div>
 <div class="menu">
    <ul>
<li><a href="index.jsp" >Home</a></li>
<li>

<%
String e=(String)session.getAttribute("failed");
if(e!=null) 
{%>

<a href="start.jsp">Service</a></li>
<%}

else{%>

<a href="index.jsp">Service</a></li>

<% }%>



<li><a href="design.jsp" >Design </a></li>
<li><a href="" >Contact</a></li>
<li><a href="game.jsp" >About</a></li>
</ul>
</div>
 
<div class="search">
<input class="srch" type="search" placeholder="type to search" name="srch">
<a href="#"><button class="btn">Search</a></button>

</div>


<%
String l=(String)session.getAttribute("failed");
if(l!=null) 
{%>
<div class="cart">
<a href="cart.jsp"><i class="fa-solid fa-cart-shopping fa-x"></i></a>
</div>
<%}

else{%>
<div class="cart">
<a href="index.jsp"><i class="fa-solid fa-cart-shopping"></i></a>
</div>
<% }%>
<div class="form">
<%
String d=(String)session.getAttribute("failed");
if(d!=null)
{%>
<h2><% out.println("Welcome "+d);%></h2>
<%}
else
{
session.removeAttribute("failed");
}	
%>
    <h2>Login Here</h2>
<form action="signin" method="post">
<input type="email" name="email" placeholder="Enter the email">
<input type="password" name="password" placeholder="Enter the password">
<input type="submit" value="Login"></form>
<p class="register">
    <br>
    Don't have an account<br>
    <a href="register.jsp">Sign up</a>
here
</p>
</div>



</div>
 </div>


</div>


</body>
</html>