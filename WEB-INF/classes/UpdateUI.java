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
		    pw.println("<h1>�޸ĵ�ǰ�û���Ϣ</h1>");
		    pw.println("<form action=\"updatecr\" method=\"post\">");
			   pw.println("</font><input type=\"hidden\" name=\"userID\" value=\""+userId+"\" style=\"height:30px;font-size:18px;\"><br/><br/>");
			   pw.println("<font size = \"5\">�û���&nbsp</font><input type=\"text\" name=\"userName\" value=\""+userNam+"\" style=\"height:30px;font-size:18px;\"><br/><br/>");
			   pw.println("<font size = \"5\">�ʡ���&nbsp</font><input type=\"text\" name=\"userMail\" value=\""+userEml+"\" style=\"height:30px;font-size:18px;\"><br/><br/>");
			   pw.println("<font size = \"5\">Ȩ����&nbsp</font><input type=\"text\" name=\"userGrade\" value=\""+userGrad+"\" style=\"height:30px;font-size:18px;\"><br/><br/>");
		                             
			   pw.println("<input type=\"submit\" value=\"�޸�\" style=\"height:40px;font-size:20px;\"  onClick=\"return window.confirm('ȷ���޸Ĵ��û���');\"/>&nbsp&nbsp &nbsp&nbsp<input type=\"reset\" value=\"����\" style=\"height:40px;font-size:20px;\"/>");
			
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