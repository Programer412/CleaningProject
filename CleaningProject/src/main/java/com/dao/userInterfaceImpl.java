package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import com.entity.details;
import com.entity.regist;

import com.servlet.housedetails;

public class userInterfaceImpl implements userInterface {
	private Connection con;
	private regist reg;

	public userInterfaceImpl(Connection con) {

		this.con = con;
	}

	@Override
	public boolean userRegister(regist reg) {
		boolean f = false;
		try {

			String sql = "insert into register(name,email,password,cpassword) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, reg.getName());
			ps.setString(2, reg.getEmail());
			ps.setString(3, reg.getPassword());
			ps.setString(4, reg.getCpassword());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override

	public boolean usercheck(String email) {
		boolean f = true;

		try {

			String sql = "select * from register where email=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			while (rs.next())

			{
				f = false;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public regist user(String email, String password) {
		regist reg = null;
		try {
			String sql = "select * from register where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reg = new regist();
				reg.setId(rs.getInt(1));
				reg.setName(rs.getString(2));
				reg.setEmail(rs.getString(3));
				reg.setPassword(rs.getString(4));
				reg.setCpassword(rs.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reg;
	}

	@Override
	public boolean hdetail(details d) {

		boolean f = false;
		try {
			String sql = "insert into homedata(name,email,houseno,state,city,zipcode,filename,userid,category) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, d.getName());
			pst.setString(2, d.getEmail());
			pst.setInt(3, d.getHouseno());
			pst.setString(4, d.getState());
			pst.setString(5, d.getCity());
			pst.setInt(6, d.getZipcode());
			pst.setString(7, d.getFilename());
			pst.setInt(8, d.getUserid());
			pst.setString(9, d.getCategory());
			int i = pst.executeUpdate();
			if (i == 1) {
				f = true;
			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}
		return f;
	}

	@Override
	public List<details> home(String email) {
		List<details> l = new ArrayList<>();
		details d = null;
		try {
			String sql = "select * from homedata where email=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String cat = null;
				d = new details();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setEmail(rs.getString(3));
				d.setHouseno(rs.getInt(4));
				d.setState(rs.getString(5));
				d.setCity(rs.getString(6));
				d.setZipcode(rs.getInt(7));
				d.setFilename(rs.getString(8));
				d.setUserid(rs.getInt(9));
				d.setCategory(rs.getString(10));
				if (d.getCategory().equals("Gold Category")) {
					d.setPrice(500);
				}
				if (d.getCategory().equals("Silver Category")) {
					d.setPrice(300);
				}
				if (d.getCategory().equals("Platinum Category")) {
					d.setPrice(200);
				}
				l.add(d);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return l;

	}

	@Override
	public boolean delete(int id, int userid) {
		boolean f = false;
		try {
			String sql = "delete from homedata where id=? and userid=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setInt(2, userid);
			int i = pst.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean deleteall() {
		boolean f = false;
		try {
			String sql = "delete from homedata";
			PreparedStatement pst = con.prepareStatement(sql);
			int i = pst.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<details> homedata() {
		List<details> l = new ArrayList<>();
		details d = null;

		try {
			String sql = "select * from homedata";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				d = new details();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setEmail(rs.getString(3));
				d.setHouseno(rs.getInt(4));
				d.setState(rs.getString(5));
				d.setCity(rs.getString(6));
				d.setZipcode(rs.getInt(7));
				d.setFilename(rs.getString(8));
				d.setUserid(rs.getInt(9));
				d.setCategory(rs.getString(10));
				if (d.getCategory().equals("Gold Category")) {
					d.setPrice(500);
				}
				if (d.getCategory().equals("Silver Category")) {
					d.setPrice(300);
				}
				if (d.getCategory().equals("Platinum Category")) {
					d.setPrice(200);
				}
				l.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void checkout(int id, int userid) {
	try {
String sql="select * from homedata where id=? and userid=?";
PreparedStatement pst=con.prepareStatement(sql);
pst.setInt(1, id);
pst.setInt(2, userid);
//Statement stmt=con.createStatement();
//((PreparedStatement) stmt).setInt(1,id);
//((PreparedStatement) stmt).setInt(2,userid);

//ResultSet rs=stmt.executeQuery(sql);

ResultSet rs=pst.executeQuery();
PreparedStatement dst=con.prepareStatement("insert into checkout(id,name,email,houseno,state,city,zipcode,filename,userid,category) values(?,?,?,?,?,?,?,?,?,?)");

while(rs.next())
{    dst.setInt(1, rs.getInt("id"));
	dst.setString(2,rs.getString("name"));
	dst.setString(3,rs.getString("email"));
	dst.setInt(4,rs.getInt("houseno"));
	dst.setString(5,rs.getString("state"));
	dst.setString(6,rs.getString("city"));
	dst.setInt(7,rs.getInt("zipcode"));
	dst.setString(8,rs.getString("filename"));
	dst.setInt(9,rs.getInt("userid"));
	dst.setString(10,rs.getString("category"));
	
	dst.executeUpdate();
		}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
	


	
}

	@Override
	public List<details> data() {
		List<details> l=new ArrayList<>();
		details d=null;
		
		try {
			String sql="select * from checkout";
			PreparedStatement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				d=new details();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setEmail(rs.getString(3));
				d.setHouseno(rs.getInt(4));
				d.setState(rs.getString(5));
				d.setCity(rs.getString(6));
				d.setZipcode(rs.getInt(7));
				d.setFilename(rs.getString(8));
				d.setUserid(rs.getInt(9));
				d.setCategory(rs.getString(10));
				if (d.getCategory().equals("Gold Category")) {
					d.setPrice(500);
				}
				if (d.getCategory().equals("Silver Category")) {
					d.setPrice(300);
				}
				if (d.getCategory().equals("Platinum Category")) {
					d.setPrice(200);
				}
				l.add(d);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public void del(int id, int userid) {
	try {	
		String sql="delete from homedata where id=? and userid=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, id);
		pst.setInt(2, userid);
		pst.executeUpdate();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	}

	@Override
	public void admincheck(int id, int userid) {


		try {
	String sql="select * from checkout where id=? and userid=?";
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setInt(1, id);
	pst.setInt(2, userid);
	ResultSet rs=pst.executeQuery();

	PreparedStatement dst=con.prepareStatement("insert into last(id,name,email,houseno,state,city,zipcode,filename,userid,category) values(?,?,?,?,?,?,?,?,?,?)");

	while(rs.next())
	{
		  dst.setInt(1, rs.getInt("id"));
			dst.setString(2,rs.getString("name"));
			dst.setString(3,rs.getString("email"));
			dst.setInt(4,rs.getInt("houseno"));
			dst.setString(5,rs.getString("state"));
			dst.setString(6,rs.getString("city"));
			dst.setInt(7,rs.getInt("zipcode"));
			dst.setString(8,rs.getString("filename"));
			dst.setInt(9,rs.getInt("userid"));
			dst.setString(10,rs.getString("category"));
			
			dst.executeUpdate();
	
}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


	
	public List<details> last() {
		List<details> l=new ArrayList<>();
		details d=null;
		
		try {
			String sql="select * from last";
			PreparedStatement pst=con.prepareStatement(sql);
	
		ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				d=new details();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setEmail(rs.getString(3));
				d.setHouseno(rs.getInt(4));
				d.setState(rs.getString(5));
				d.setCity(rs.getString(6));
				d.setZipcode(rs.getInt(7));
				d.setFilename(rs.getString(8));
				d.setUserid(rs.getInt(9));
				d.setCategory(rs.getString(10));
				if (d.getCategory().equals("Gold Category")) {
					d.setPrice(500);
				}
				if (d.getCategory().equals("Silver Category")) {
					d.setPrice(300);
				}
				if (d.getCategory().equals("Platinum Category")) {
					d.setPrice(200);
				}
				l.add(d);
	}
}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return l;
	}
}

