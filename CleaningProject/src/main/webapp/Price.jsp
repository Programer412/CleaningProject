<%@page import="com.entity.regist"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type=text/css rel="stylesheet" href="goldstyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
<li><a href="start.jsp" >Service</a></li>
<li><a href="design.jsp" >Design </a></li>
<li><a href="" >Contact</a></li>
<li><a href="" >About</a></li>
</ul>
</div>
<div class="search">
<input class="srch" type="search" placeholder="type to search" name="srch">
<a href="#"><button class="btn">Search</a></button>

<div class="form">
<h2><%
regist rst=(regist)session.getAttribute("register");

if(session.getAttribute("success")!=null)
	
out.println(session.getAttribute("success"));
session.removeAttribute("success");
%></h2>
    <h2>House Details</h2>
<form action="hdetails" method="post" enctype="multipart/form-data">
<input type="text" name="name" placeholder="Enter the name" required>
<input type="email" name="email" id="email1" placeholder="<%=rst.getEmail()%>" readonly><br>
<input type="number" name="houseno" id="password1" placeholder="Enter the house no" required>
<span id="message" style="color:#FF7200;"></span> 
<input type="text" name="state" id="cpassword1" placeholder="Enter the state" required>
<span id="message1" style="color:#FF7200;"></span>
<input type="text" name="city" id="cpassword1" placeholder="Enter the city" required>

<input type="number" name="zipcode" id="cpassword1" placeholder="Enter the zipcode" required>
<div class="fila">
<input type="file" name="filename" id="filename"  required>
<input type="text" name="category" value="Platinum Category" readonly>
</div>
<input type="submit" value="Proceed To Payment"></form>


</div>



</div>
 </div>


</div>


</body>
</html>