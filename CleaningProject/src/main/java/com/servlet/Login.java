package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userInterfaceImpl;
import com.db.DbConnection;
import com.entity.regist;
@WebServlet("/signin")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		HttpSession session=req.getSession();
		userInterfaceImpl us=new userInterfaceImpl(DbConnection.getConnection());
		if(email.equals("admin@gmail.com")&&password.equals("gaurav"))
		{
			
			regist reg=new regist();
			reg.setName("admin");
			session.setAttribute("userobj", reg);
			resp.sendRedirect("homepage.jsp");
			session.setAttribute("register", reg);
			
			
			
		}
		else {
			regist reg=us.user(email,password);
		
	
			if(reg!=null)
				
				
			{
				session.setAttribute("register", reg);
		
			//System.out.println(reg);
			session.setAttribute("failed",  reg.getName());
			//resp.sendRedirect("start.jsp");
				resp.sendRedirect("index.jsp");
		
			
		
	}
			else {
				
				session.setAttribute("failed", "**Email Password Incorrect");
				resp.sendRedirect("index.jsp");
				
			}
			
		}
	
	}

}
