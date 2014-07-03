/**
 * @(#)UpdateUI.java
 *
 *
 * @author 
 * @version 1.00 2014/6/27
 */
package com.login;
 
import java.io.*;
import javax.servlet.http.*;

public class AddUserUI extends HttpServlet{

    public void doPost(HttpServletRequest req, HttpServletResponse res)
    {
    	res.setContentType("text/html;charset=gbk");
    
    	try{	
    		PrintWriter pw = res.getWriter();
    	pw.println("<html>");
        pw.println("<head>"); 
        pw.println("<body background=\"img/butterfly.jpg\" >"); 
	
	    pw.println("<center>");
		    pw.println("<br/><br/>");
		    pw.println("<h1>注册新用户</h1>");
		    pw.println("<form action=\"addusercr\" method=\"post\">");
			   pw.println("<font size = \"5\">用户ID&nbsp</font><input type=\"text\" name=\"userID\" style=\"height:30px;font-size:18px;\"><br/><br/>");
			   pw.println("<font size = \"5\">用户名&nbsp</font><input type=\"text\" name=\"userName\" style=\"height:30px;font-size:18px;\"><br/><br/>");
			   pw.println("<font size = \"5\">密　码&nbsp</font><input type=\"password\" name=\"userPasswd\" style=\"height:30px;font-size:18px;\"><br/><br/>");
			   
			   pw.println("<font size = \"5\">邮　箱&nbsp</font><input type=\"text\" name=\"userMail\" style=\"height:30px;font-size:18px;\"><br/><br/>");
			   pw.println("<font size = \"5\">权　限&nbsp</font><input type=\"text\" name=\"userGrade\" style=\"height:30px;font-size:18px;\"><br/><br/>");
		                             
			   pw.println("<input type=\"submit\" value=\"注册\" style=\"height:40px;font-size:20px;\"  onClick=\"return window.confirm('确定注册此用户？');\"/>&nbsp&nbsp &nbsp&nbsp<input type=\"reset\" value=\"重置\" style=\"height:40px;font-size:20px;\"/>");
			
		    pw.println("</form>");
	    pw.println("</center>");
        pw.println("</body>");
        pw.println("</head>"); 
        pw.println("</html>"); 
        }catch(Exception e){
             e.printStackTrace();	
         }
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    {
    	doPost(req, res);
    }
    
}