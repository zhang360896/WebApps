/**
 * @(#)Success.java
 *
 *
 * @author 
 * @version 1.00 2014/6/28
 */
package com.login;

import java.io.*;
import javax.servlet.http.*;

public class Success extends HttpServlet{

    	public void doPost(HttpServletRequest req, HttpServletResponse res){
    		res.setContentType("text/html;charset=gbk");
    	
    		try{
    		
	           PrintWriter pw = res.getWriter();	
            
			   pw.println("<html>");
               pw.println("<head>"); 
               pw.println("<body background=\"img/butterfly.jpg\" >"); 
	
	             pw.println("<center>");
		          pw.println("<font><h1>操作成功!</h1></font>");
	             pw.println("<a href=\"display\" align=\"center\">返回查看</a>");
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