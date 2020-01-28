package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FormServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw=null;
		String name=null,fname=null,mname=null,email=null,gen=null,address=null,dist=null,city=null,contact=null,ms=null,qlfy=null;
		String crs[]=null;
		String hb[]=null;
		int age=0;
		pw=res.getWriter();
		res.setContentType("text/html");
		
		//read form data
		name=req.getParameter("name");
		fname=req.getParameter("fname");
		mname=req.getParameter("mname");
		age=Integer.parseInt(req.getParameter("age"));
		email=req.getParameter("email");
		gen=req.getParameter("gen");
		address=req.getParameter("address");
		dist=req.getParameter("dist");
		city=req.getParameter("city");
		contact=req.getParameter("contact");
		ms=req.getParameter("ms");
		qlfy=req.getParameter("qlfy");
		crs=req.getParameterValues("crs");
		hb=req.getParameterValues("hb");
		
		//write b.logic
		if(gen.equalsIgnoreCase("male")) {
			if(age<=5) {
				pw.println(name+" <h2 style='color:green;'>Life is Start</h2>");
			}
			else if(age<=12) {
				pw.println(name+" <h2 style='color:yellow;'>Focus</h2>");
			}
			else if(age<=20) {
				pw.println(name+" <h2 style='color:red;'>Work Hard</h2>");
			}
			else if(age<=30) {
				pw.println(name+" <h2 style='color:pink;'>Never Give Up</h2>");
			}
			else if(age<=45) {
				pw.println(name+" <h2 style='color:orange;'>Enjoy Life</h2>");
			}
			else if(age<=65) {
				pw.println(name+" <h2 style='color:purple;'>Last Time To Enjoy Life</h2> ");
			}
			else {
				pw.println(name+" <h2 style='color:black;'>Good Bye(Happy Ending)</h2> ");				
			}
			
		}//if
		else if(gen.equalsIgnoreCase("female")) {
			if(age<=5) {
				pw.println(name+" <h2 style='color:green;'>Life is Start</h2>");
			}
			else if(age<=12) {
				pw.println(name+" <h2 style='color:yellow;'>Focus</h2>");
			}
			else if(age<=20) {
				pw.println(name+" <h2 style='color:red;'>Work Hard</h2>");
			}
			else if(age<=30) {
				pw.println(name+" <h2 style='color:pink;'>Never Give Up</h2>");
			}
			else if(age<=45) {
				pw.println(name+" <h2 style='color:orange;'>Enjoy Life</h2>");
			}
			else if(age<=65) {
				pw.println(name+" <h2 style='color:purple;'>Last Time To Enjoy Life</h2> ");
			}
			else {
				pw.println(name+" <h2 style='color:black;'>Good Bye(Happy Ending)</h2> ");				
			}
		}
		
		//display form data
		pw.println("<h3>Name::"+name+"</h3>");
		pw.println("<h3>Father Name::"+fname+"</h3>");
		pw.println("<h3>Mother Name::"+mname+"</h3>");
		pw.println("<h3>Age::"+age+"</h3>");
		pw.println("<h3>Email::"+email+"</h3>");
		pw.println("<h3>Sex::"+gen+"</h3>");
		pw.println("<h3>Address::"+address+"</h3>");
		pw.println("<h3>Distict::"+dist+"</h3>");
		pw.println("<h3>City::"+city+"</h3>");
		pw.println("<h3>Contact::"+contact+"</h3>");
		pw.println("<h3>Marraige Status::"+ms+"</h3>");
		pw.println("<h3>Qualification::"+qlfy+"</h3>");
		pw.println("<h3>Course::"+Arrays.toString(crs)+"</h3>");
		pw.println("<h3>Hobbies::"+Arrays.toString(hb)+"</h3>");
		
		//add hyperlink
		pw.println("<a href='form.html'>Home</a>");
		//close Stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
