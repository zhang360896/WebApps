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
		    pw.println("<h1>ע�����û�</h1>");
		    pw.println("<form action=\"addusercr\" method=\"post\">");
			   pw.println("<font size = \"5\">�û�ID&nbsp</font><input type=\"text\" name=\"userID\" style=\"height:30px;font-size:18px;\"><br/><br/>");
			   pw.println("<font size = \"5\">�û���&nbsp</font><input type=\"text\" name=\"userName\" style=\"height:30px;font-size:18px;\"><br/><br/>");
			   pw.println("<font size = \"5\">�ܡ���&nbsp</font><input type=\"password\" name=\"userPasswd\" style=\"height:30px;font-size:18px;\"><br/><br/>");
			   
			   pw.println("<font size = \"5\">�ʡ���&nbsp</font><input type=\"text\" name=\"userMail\" style=\"height:30px;font-size:18px;\"><br/><br/>");
			   pw.println("<font size = \"5\">Ȩ����&nbsp</font><input type=\"text\" name=\"userGrade\" style=\"height:30px;font-size:18px;\"><br/><br/>");
		                             
			   pw.println("<input type=\"submit\" value=\"ע��\" style=\"height:40px;font-size:20px;\"  onClick=\"return window.confirm('ȷ��ע����û���');\"/>&nbsp&nbsp &nbsp&nbsp<input type=\"reset\" value=\"����\" style=\"height:40px;font-size:20px;\"/>");
			
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