package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.userInterfaceImpl;
import com.db.DbConnection;
import com.entity.details;
@WebServlet("/checkout")
public class checkout extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
	    int userid=Integer.parseInt(req.getParameter("userid"));
	    userInterfaceImpl dao=new userInterfaceImpl(DbConnection.getConnection());
	  
	     dao.checkout(id,userid);
	     dao.del(id, userid);
	
	    System.out.println(id);
	    System.out.println(userid);

		resp.sendRedirect("cart.jsp");

}

	
	
	
}
