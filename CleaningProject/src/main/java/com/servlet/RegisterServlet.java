package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userInterfaceImpl;
import com.db.DbConnection;
import com.entity.regist;
@WebServlet("/signup")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	String cpassword=req.getParameter("cpassword");
	PrintWriter out=resp.getWriter();
	
	
	 regist reg=new regist();
	 reg.setName(name);
	 reg.setEmail(email);
	 reg.setPassword(password);
	 reg.setCpassword(cpassword);
	 HttpSession session=req.getSession();
	 
	 userInterfaceImpl dao=new userInterfaceImpl(DbConnection.getConnection());

 boolean f1=dao.usercheck(email);


 if(f1)
 {	
	 boolean f=dao.userRegister(reg);
	 if(f)
	 {
		session.setAttribute("success","Registration Sucessfully");
		resp.sendRedirect("register.jsp");
	 }
	 else {
		 session.setAttribute("success","Server Failed");
			resp.sendRedirect("register.jsp");
	 }
	
	}
 else {
	 
	 session.setAttribute("success","this email is in used try another email");
		resp.sendRedirect("register.jsp");
	 }
 }
	

}

