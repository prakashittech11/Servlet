package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CalculateServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		int no1=0,no2=0,fact=1;
		String comp=null;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		no1=Integer.parseInt(req.getParameter("fno"));
		no2=Integer.parseInt(req.getParameter("sno"));
	
		comp=req.getParameter("s1");
		
		//write b.logic 
		if(comp.equalsIgnoreCase("Add")) {
			pw.println("Sum:: "+(no1+no2));
		}
		else if(comp.equalsIgnoreCase("Sub")) {
			pw.println("Substract:: "+(no1-no2));
		}
		else if(comp.equalsIgnoreCase("Mul")) {
			pw.println("Multiplication  :: "+(no1*no2));
		}
		else if(comp.equalsIgnoreCase("Div")) {
			pw.println("Division  :: "+(no1/no2));
		}
		else if(comp.equalsIgnoreCase("Even/odd")) {
			if(no1%2==0)  {
				pw.println(no1+" Even No");
			}
			else {
				pw.println(no1+" Odd No");
			}
		}
		else {
			while(no2>1) {
				fact*=no2--;
			}
			pw.println("Factorial no::"+fact);
					
		}
		
		pw.println("<a href='input.html'>Home</a>");
		
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
