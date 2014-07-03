/**
 * @(#)welcm.java
 *
 *
 * @author
 * @version 1.00 2014/6/23
 */

package com.login;

import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
public class Welcm extends HttpServlet{

    
 	public void doPost(HttpServletRequest req, HttpServletResponse res)
    {
    	
    	String un="";
    	int pageSize=5;//the size of per page
    	int pageNow=1;//the current page facing a user
    	res.setContentType("text/html;charset=gbk");
        HttpSession hs = req.getSession(true);
        String login_sccs = (String)hs.getAttribute("pass");
        Connection ct = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //if the user login successfully, show the table,else return to the login servlet
        if (login_sccs == null){
            try {
                PrintWriter pw = res.getWriter();
                //pw.print("login again!");
                res.sendRedirect("login");
             }
             catch(Exception e){
                e.printStackTrace();
             }    
        }
        if (login_sccs.equals("true")){
            un = req.getParameter("usrname");   
        } 
        else {
           
             try {
                PrintWriter pw = res.getWriter();
                res.sendRedirect("login");
             }
             catch(Exception e){
                e.printStackTrace();
             }    
        }
        try {
        PrintWriter pw = res.getWriter();
        pw.print("<html>");
        pw.print("<head>"); 
        pw.print("<body background=\"img/bkg.jpg\" >"); 
	     pw.print("<center>");
	      pw.print("<br/><br/><br/><br/>");
	      pw.print("<h1>"+(String)hs.getAttribute("name")+",欢迎您登陆</h1></a>");
	      pw.print("<h2><font size=\"5\"><p  style=\"font-family:verdana;color:red\">请选择您需要的操作</p></font></h2>");
	      pw.print("<a href = display?username="+un+"><font size=\"5\">显示全部用户</font></a><br/><br/>");
	      pw.print("<a href = adduser?username="+un+"><font size=\"5\">增加用户</font></a><br/><br/>");
	     pw.print("</center>");
        pw.print("</body>"); 
        pw.print("</head>"); 
        pw.print("</html>"); 
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
			doPost(req, res);
	}

}