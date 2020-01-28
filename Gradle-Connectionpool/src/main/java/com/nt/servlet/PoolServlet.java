package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class PoolServlet extends HttpServlet {

@Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	
	Connection con=null;
	Statement st=null;
	ResultSetMetaData rsmd=null;
	ResultSet rs=null;
	PrintWriter pw=null;
	String tablename=null;
	int colcnt=0;
	
	pw=res.getWriter();
	//set ContentType
	res.setContentType("text/html");
	//read form data
	tablename=req.getParameter("table");
	//write jdbc code
	try {
		//get can object from jdbc can pool
		con=makeConnection();
		//create Statement obj
		st=con.createStatement();
		//send and execute sql query
		rs=st.executeQuery("select *from "+tablename);
		//get ResultsetMetaData
		rsmd=rs.getMetaData();
		//print col names
		colcnt=rsmd.getColumnCount();

		pw.println("<table border='1' bgcolor='red'>");
		pw.println("<tr bgcolor='cyan'>");
		for(int i=1;i<=colcnt;i++) {
			pw.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
		}
		pw.println("</tr>");
		//process the resultSet
		while(rs.next()) {
			pw.println("<tr>");
			for(int i=1;i<=colcnt;i++) {
				pw.println("<td>"+rs.getString(i)+"</td>");
			}
			pw.println("</tr>");
		}
		pw.println("</table>");
		//add hyperlink
		pw.println("<br><a href='input.html'>Try Again</a>");
		//close all jdbc obj
		rs.close();
		st.close();
		con.close();
	
	}//try
	catch(SQLException se){
		pw.println("<br><a href='input.html'>Try Again</a>");
		se.printStackTrace();
	}
	catch(Exception e) {
		pw.println("<br><a href='input.html'>Try Again</a>");
		e.printStackTrace();
	}
	pw.close();

}//doGet(-,-)


@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
	private Connection makeConnection() {

		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
		try {
			//locate jndi registry
			ic=new InitialContext();
			//Get DataSource Obj from jndi registry
			ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
			//get JDBC can Obj from jdbc can pool
			con=ds.getConnection();
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}//makeConnection

}//class