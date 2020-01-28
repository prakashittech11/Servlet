package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SumServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter pw=null;
		int a=0,b=0,sum=0;
		pw=res.getWriter();
		res.setContentType("text/html");
	
		//read form data
		a=Integer.parseInt(req.getParameter("fno"));
		b=Integer.parseInt(req.getParameter("sno"));
		
		//perfomr some b.logic addition
		sum=a+b;
		pw.println("Sum of the No::"+sum);

		pw.println("<a href='input.html'>Home</a>");
		//close the stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
