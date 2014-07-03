/**
 * @(#)loginCR.java
 *
 *
 * @author
 * @version 1.00 2014/6/23
 */

package com.login;

import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
public class AddUserCR extends HttpServlet{

  
	public void doPost(HttpServletRequest req, HttpServletResponse res){
    	UserBeanCR ubc = new UserBeanCR("userTable");    	
    	UserBean ub = new UserBean();
    	ub.name = req.getParameter("userName");
    	ub.userId = req.getParameter("userID");
    	System.out.println("ID:"+ub.userId);
    	ub.email = req.getParameter("userMail");
    	ub.passwd = req.getParameter("userPasswd");
    	ub.grade = Integer.parseInt(req.getParameter("userGrade"));
    	try{
   
    	if (ubc.add(ub)){
    	  res.sendRedirect("succeed");
    	}
    	else {
    	  res.sendRedirect("failed");
    	}
    	}catch(Exception e){
    	   e.printStackTrace();
    	 }finally {
    	 	try{
    	 	
    	     ubc.ct.close();
    	    }catch(Exception e){
    	         e.printStackTrace();	
    	     }	
    	  }
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
			doPost(req, res);
	}
}