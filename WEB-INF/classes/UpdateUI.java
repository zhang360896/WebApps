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

public class UpdateUI extends HttpServlet{

    public void doPost(HttpServletRequest req, HttpServletResponse res)
    {
    	res.setContentType("text/html;charset=gbk");
    	try{
    	
    	PrintWriter pw = res.getWriter();
    	String userId = req.getParameter("userID");
    	String userNam = req.getParameter("userName");
    	String userEml = req.getParameter("userMail");
    	int userGrad = Integer.parseInt(req.getParameter("userGrade"));
    	
    	pw.println("<html>");
        pw.println("<head>"); 
        pw.println("<body background=\"img/butterfly.jpg\" >"); 
	
	    pw.println("<center>");
		    pw.println("<br/><br/>");
		    pw.println("<h1>修改当前用户信息</h1>");
		    pw.println("<form action=\"updatecr\" method=\"post\">");
			   pw.println("</font><input type=\"hidden\" name=\"userID\" value=\""+userId+"\" style=\"height:30px;font-size:18px;\"><br/><br/>");
			   pw.println("<font size = \"5\">用户名&nbsp</font><input type=\"text\" name=\"userName\" value=\""+userNam+"\" style=\"height:30px;font-size:18px;\"><br/><br/>");
			   pw.println("<font size = \"5\">邮　箱&nbsp</font><input type=\"text\" name=\"userMail\" value=\""+userEml+"\" style=\"height:30px;font-size:18px;\"><br/><br/>");
			   pw.println("<font size = \"5\">权　限&nbsp</font><input type=\"text\" name=\"userGrade\" value=\""+userGrad+"\" style=\"height:30px;font-size:18px;\"><br/><br/>");
		                             
			   pw.println("<input type=\"submit\" value=\"修改\" style=\"height:40px;font-size:20px;\"  onClick=\"return window.confirm('确定修改此用户？');\"/>&nbsp&nbsp &nbsp&nbsp<input type=\"reset\" value=\"重置\" style=\"height:40px;font-size:20px;\"/>");
			
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