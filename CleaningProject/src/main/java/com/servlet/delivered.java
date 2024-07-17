package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userInterfaceImpl;
import com.db.DbConnection;
import com.entity.details;
@WebServlet("/delivery")
public class delivered extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
	
		int id=Integer.parseInt(req.getParameter("id"));
		int userid=Integer.parseInt(req.getParameter("userid"));
	
		userInterfaceImpl dao=new userInterfaceImpl(DbConnection.getConnection());
	
		HttpSession session=req.getSession();
	
		details e=new details();
		e.setId(id);
		e.setUserid(userid);
		dao.admincheck(id,userid);
	String count="s";
	session.setAttribute("value",count);
	session.setAttribute("game", e);

  resp.sendRedirect("orders.jsp");
	

		
	}

}
