package com.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.userInterfaceImpl;
import com.db.DbConnection;
import com.entity.details;
import com.entity.regist;
@WebServlet("/hdetails")
@MultipartConfig
public class housedetails extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
	{
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		int houseno=Integer.parseInt(req.getParameter("houseno"));
		String state=req.getParameter("state");
		String city=req.getParameter("city");
		int zipcode=Integer.parseInt(req.getParameter("houseno"));
		Part part=req.getPart("filename");
		String filename=part.getSubmittedFileName();
		String Category=req.getParameter("category");
		HttpSession session=req.getSession();
	regist e=(regist)session.getAttribute("register");
		 userInterfaceImpl dao=new userInterfaceImpl(DbConnection.getConnection());
		details d=new details();
		
		d.setName(name);
		d.setEmail(e.getEmail());
		d.setHouseno(houseno);
		d.setState(state);
		d.setCity(city);
		d.setZipcode(zipcode);
		d.setFilename(filename);
		
		d.setUserid(e.getId());
		d.setCategory(Category);
	
		
		String path=getServletContext().getRealPath("")+"photos";
		System.out.println(path);
	
		
		File F=new File(path);
		part.write(path+File.separator+filename);
		boolean f=dao.hdetail(d);
		if(f)
		{
		
		session.setAttribute("homes",d);
		session.setAttribute("success", "you data is succefully stored");
	

		resp.sendRedirect("gold.jsp");
		}
		else {
			
			session.setAttribute("success", "you data is not stored");
			resp.sendRedirect("gold.jsp");
		}
		
		
		
		
	}

}
