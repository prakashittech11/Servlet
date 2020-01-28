package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Servlet1 extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		String name=null,fname=null;
		Cookie ck1=null,ck2=null;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form1 data
		name=req.getParameter("pname");
		fname=req.getParameter("fname");
		//create cookies to store the form1 data
		ck1=new Cookie("pname", name);
		ck2=new Cookie("fname", fname);
		
		res.addCookie(ck1);
		res.addCookie(ck2);
		//we need to generate Second servlet2 Dynamically
		pw.println("<form action='f2url' method='POST'>");
		pw.println("Income for Year::<input type='text' name='income'><br>");
		pw.println("Tax::<input type='text' name='tax'><br>");
		pw.println("<input type='submit' value='Submit'>");
		pw.println("</form>");
		
		//close Stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
