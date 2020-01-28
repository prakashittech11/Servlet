package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class CheckinputFilter implements Filter {


	public CheckinputFilter() {
		System.out.println("CheckinputFilter.CheckinputFilter()");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("CheckinputFilter.init()");
	}
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("CheckinputFilter.doFilter()");
		PrintWriter pw=null;
		int a=0,b=0;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		
		//read form data
		a=Integer.parseInt(req.getParameter("fno"));
		b=Integer.parseInt(req.getParameter("sno"));
		
		//check input
		if(a<0 || b<0) {
			pw.println("Input Must be Positive");
			pw.println("<a href='input.html'>Home</a>");
		}
		else {
			System.out.println("CheckinputFilterBefore.doFilter()");
			chain.doFilter(req,res);
			System.out.println("CheckinputFilterAfter.doFilter()");
			pw.println("<a href='input.html'>Home</a>");
		}
		
	}
	
	@Override
	public void destroy() {
		System.out.println("CheckinputFilter.destroy()");
	}

}
