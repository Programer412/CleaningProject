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
@WebServlet("/delete")
public class deleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		int userid=Integer.parseInt(req.getParameter("userid"));
		userInterfaceImpl us=new userInterfaceImpl(DbConnection.getConnection());
		boolean f= us.delete(id, userid);
		
		HttpSession session=req.getSession();
	
		if(id==0&&userid==0)
		{
			boolean f1=us.deleteall();
			if(f1)
			{
				session.setAttribute("succMsg","All Order Delete  Sucessfully");
				resp.sendRedirect("cart.jsp");
			}
			else {
				session.setAttribute("succMsg","All Order Deletion failed");
				resp.sendRedirect("cart.jsp");
			}
		}
		else {
			if(f)
			{
				session.setAttribute("succMsg","Order Delete  Sucessfully");
				resp.sendRedirect("cart.jsp");
			}
			else {
				session.setAttribute("succMsg","Order Deletion failed");
				resp.sendRedirect("cart.jsp");
			}
		}
		
	}

	
}
