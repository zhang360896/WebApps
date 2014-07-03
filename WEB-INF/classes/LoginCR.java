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
public class LoginCR extends HttpServlet{

  
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		UserBeanCR ubc = null;
		try {
            
			String user = req.getParameter("usname");
			String pwd = req.getParameter("passwd");
			String db_name = "", db_pswd = "";
		    ubc = new UserBeanCR("userTable");
		    System.out.println("name:"+user+"  pwd:"+pwd);
			if (ubc.UserCR(user, pwd)){
				PrintWriter pw = res.getWriter();
                HttpSession hs = req.getSession(true);
                hs.setAttribute("pass", "true");
                hs.setAttribute("name", user);
                
                hs.setMaxInactiveInterval(10);
				res.sendRedirect("wel?usrname="+user);
            }
			else {
                PrintWriter pw = res.getWriter();
                HttpSession hs = req.getSession(true);
                hs.setAttribute("pass", "false");
				res.sendRedirect("login");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
		       if (ubc.ct != null)ubc.ct.close();
		    }catch(Exception e){
		         e.printStackTrace();	
		     }	
		 }
	}

}