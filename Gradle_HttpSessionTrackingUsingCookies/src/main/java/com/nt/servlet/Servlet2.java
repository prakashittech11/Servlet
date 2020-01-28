package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Servlet2 extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw=null;
		String income=null,tax=null;
		String name=null,fname=null;;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form2 data
		income=req.getParameter("income");
		tax=req.getParameter("tax");
		
		//read form1 data from cookies
		Cookie ck[]=req.getCookies();
		if(ck!=null) {
			name=ck[0].getValue();
			fname=ck[1].getValue();
		}//if
		
		try {
			//jdbc code  
			//generate jdbc driver class obj
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establised the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","krishana");
			//prepared statement
			if(con!=null) {
				ps=con.prepareStatement("insert into tax_tab values(?,?,?,?)");
			}
			//set param values
			if(ps!=null) {
				ps.setString(1, name);
				ps.setString(2, fname);
				ps.setString(3, income);
				ps.setString(4, tax);
			}	
 			if(ps!=null) {
				result=ps.executeUpdate();
			}
			if(result==1) {
				pw.println("Record inserted Succesfully");
			}
			else {
				pw.println("REcord not inserted");
			}
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//display the form data
		pw.println("Form1 data"+name+" "+fname);
		pw.println("form2 data"+income+" "+tax);
		
		//close stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}




}


