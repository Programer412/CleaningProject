<%@page import="com.entity.regist"%>
<%@page import="com.servlet.RegisterServlet"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DbConnection"%>
<%@page import="com.dao.userInterfaceImpl"%>
<%@page import="com.entity.details"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link type="text/css" rel="stylesheet" href="cart.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<li><a href="" >Design </a></li>
<li><a href="" >Contact</a></li>
<li><a href="Oder.jsp" >Orders</a></li>
</ul>
</div>
<div class="search">
<input class="srch" type="search" placeholder="type to search" name="srch">
<a href="#"><button class="btn">Search</a></button><a href="cart.jsp"><i class="fa-solid fa-cart-shopping"></i></a></div><br><br>
</div>

<table style="width:80%; margin-left:30px; margin-top:10px;">

	<tr>
					<th>Username</th>
					<th>House Photos</th>
					<th >Category</th>
					<th >price</th>
					<th>Status</th>
					
					
					</tr>
				
	<% userInterfaceImpl us=new userInterfaceImpl(DbConnection.getConnection());
	
regist r=(regist)session.getAttribute("register");
int total=0;


List<details> d=us.data();




String p=(String)session.getAttribute("value");

	for(details o:d)
	{ 
		total=total+o.getPrice();
	 
	%>			
				<tr class="space">
				<td style="width: 200px;height: 200px">  <%=o.getName()%></td>
				<td> <img src="photos/<%=o.getFilename() %>" style="width:120px; height:120px;"> </td>
				<td> <%=o.getCategory()%></td>
				<td><%=o.getPrice() %>$</td>
				<td style="width:100px; height:200px;">
				
<a href="delete?id=<%=o.getId()%>&&userid=<%=o.getUserid()%>"><button class="btn2">Not Cleaned</button></a>
</td>
<%}%>


<% details g=(details)session.getAttribute("game");
List<details> l=us.last();

	for(details o:l)
	{ 
		total=total+o.getPrice();
	 
%>

				<tr class="space">
				<td style="width: 200px;height: 200px">  <%=o.getName()%></td>
				<td> <img src="photos/<%=o.getFilename() %>" style="width:120px; height:120px;"> </td>
				<td> <%=o.getCategory()%></td>
				<td><%=o.getPrice() %>$</td>
				<td style="width:100px; height:200px;">
				
<button class="btn2">Cleaned</button>
</td>



<%} %>




</table>
<br>
</div>


</body>
</html>