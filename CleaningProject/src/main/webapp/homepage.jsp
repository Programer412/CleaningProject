
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


<li><a href="design.jsp" >Service </a></li>


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
<a href="cart.jsp"><i class="fa-solid fa-cart-shopping fa-2x"></i></a>
</div>
<%}

else{%>
<div class="cart">
<a href="index.jsp"><i class="fa-solid fa-cart-shopping fa-2x"></i></a>
</div>
<% }%>



</div>

<div class="orders">
<h2><a href="orders.jsp">Orders</a></h2>

</div>
<div class="price">
<h2><a href="Price.jsp">Price</a></h2>

</div>



</div>





</body>
</html>