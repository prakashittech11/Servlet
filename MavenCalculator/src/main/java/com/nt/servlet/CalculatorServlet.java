package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CalculatorServlet extends HttpServlet {


@Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	PrintWriter pw=null;
	int no1=0,no2=0;
	String comp=null;
	
	pw=res.getWriter();
	res.setContentType("text/html");
	//read form data
	no1=Integer.parseInt(req.getParameter("fno"));
	no2=Integer.parseInt(req.getParameter("sno"));
	comp=req.getParameter("s1");
	//b.logic to find arithemetic operation
	
	if(comp.equalsIgnoreCase("ADD")) {
		pw.println("Sum of "+(no1+no2));
	}
	else if(comp.equalsIgnoreCase("Substract")) {
		pw.println("Substract of " +(no1-no2));		
	}
	else if(comp.equalsIgnoreCase("Multiplication")) {
		pw.println("Multiplication "+(no1*no2));		
	}
	else {
		pw.println("Division "+(no1/no2));				
	}
	
	//add hyperlink
	pw.println("<a href='input.html'>Home</a>");
	
	//close stream
	pw.close();
	
}



@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}






}
