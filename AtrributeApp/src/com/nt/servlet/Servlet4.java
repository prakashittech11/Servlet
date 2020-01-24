package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Servlet4 extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		HttpSession ses=null;
		ServletContext sc=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("Servlet4:attr1 attributes values"+req.getAttribute("attr1"));
		ses=req.getSession();
		pw.println("Servlet4:attr2 attributes values"+ses.getAttribute("attr2"));
		sc=getServletContext();
		pw.println("Servlet4:attr3 attributes values"+sc.getAttribute("attr3"));
		//forward the req to thirdServlet
//		RequestDispatcher rd=req.getRequestDispatcher("/s3url");
//		rd.forward(req,res);	
		}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	
	
}
