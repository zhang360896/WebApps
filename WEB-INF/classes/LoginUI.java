/**
 * @(#)login.java
 *
 *
 * @author
 * @version 1.00 2014/6/23
 */
package com.login;

import java.io.*;
import javax.servlet.http.*;

public class LoginUI extends HttpServlet{

    public LoginUI() {
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res)
    {
    	try {
    		res.setContentType("text/html;charset=gbk");
			PrintWriter pw = res.getWriter();
		    pw.println("<html>");
            pw.println("<head>");
            pw.println("<body background=\"img/boysandgirls.jpg\">");
			    pw.println("<center>");
			    pw.println("<br/><br/><br/><br/><br/>");
						
				pw.println("<h1>　系　统　登　录</h1>");
                    pw.println("<form action=\"logincr\" method=\"post\">");
                        pw.println("用户名<input type=\"text\" name=\"usname\"/><br/>");
                        pw.println("密　码<input type=\"password\" name=\"passwd\"/><br/>");
						pw.println("&nbsp&nbsp");
                        pw.println("<input type=\"submit\" value=\"登录\">");
						pw.println("&nbsp&nbsp");
                        pw.println("<input type=\"reset\" value=\"重置\">");
					pw.println("</form>");
					pw.println("<img src = \"img/girl.gif\"/>");
					
					pw.println("</center>");
            pw.println("</body>");
            pw.println("</head>");
            pw.println("</html>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
    }
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	{
			doPost(req, res);
	}

}