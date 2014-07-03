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
public class Display extends HttpServlet{

    
 	public void doPost(HttpServletRequest req, HttpServletResponse res)
    {
    	
    	String un=req.getParameter("username");
    	int pageSize=5;//the size of per page
    	int pageNow=1;//the current page facing a user
    	res.setContentType("text/html;charset=gbk");
        HttpSession hs = req.getSession(true);
        ResultSet rs = null;
        String srch_bar = req.getParameter("search");
        //if the user login successfully, show the table,else return to the login servlet
        
        try {
            //connect the database using these three sentences below
            //Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
            //ct = DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:3045;databaseName=userData","sa","987654");
            
            String sPageNow = req.getParameter("pagenow");
            //if it isn't the first time to open the page
            if (sPageNow != null){
              pageNow = Integer.parseInt(sPageNow);
              
            }
            //System.out.println("wsadasda1");
    	    UserBeanCR ubc = new UserBeanCR("userTable");//manage the logical model    	
    	//System.out.println("wsadasda2");
            ArrayList<UserBean> user_al = new ArrayList<UserBean>();//restore the contents of database
            user_al = ubc.divdPages(pageSize, pageNow);
            PrintWriter pw = res.getWriter();	
        
			pw.println("<html>");
				pw.println("<head>");
					pw.println("<body background = \"img/beautifulgirl.jpg\">");	
						
						pw.println("<center>");
						pw.println("&nbsp");	
						pw.println("<img src = \"img/mushroom.gif\" width = 100 height = 100/>");
						//serching bar
					    pw.println("<form action=\"??\" method=\"post\" style=\"margin:0px\">");
					        pw.println("&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"search\"style=\"width:270px;\">");                                 
                            pw.println("<input type=\"submit\" value=\"搜索\" ><br/>");
                            pw.println("&nbsp&nbsp<input type=\"radio\" name=\"search\" checked=\"true\" >精确匹配");
                            pw.println("<input type=\"radio\" name=\"search\" value=\"0\">模糊匹配");
                            
                                                             
                        pw.println("</form>");
                        
                        pw.println("<table border=\"1\" cellpadding=\"10\">");//
							pw.println("<tr bgcolor=\"#ffffff\">");//align=\"center\"
							//display area
							pw.println("<th >用户ID</th><th>用户名</th><th>用户邮箱</th><th>用户等级</th><th>相关操作</th>");
							pw.println("</tr>");
							 for (int i = 0; i < user_al.size(); i ++){ 
							 	//string db_ID = re.getString(1);
							 	//string db_nam = re.getString(2);
							 	//string db_mail = re.getString(3);
							 	//string db_grade = re.getString(4);
							 	UserBean tmp = new UserBean();
							 	tmp = user_al.get(i);
							 	pw.println("<tr >");	
                                pw.println("<td align=\"center\">"+tmp.getUserId()+"</td>");
                                pw.println("<td align=\"center\">"+tmp.getName()+"</td>");
                                pw.println("<td align=\"center\">"+tmp.getEmail()+"</td>");
                                pw.println("<td align=\"center\"><font color=\"#0C869B\" size=\"5px\" style=\"font-weight:bold;\">"+tmp.getGrade()+"</font></td>");
                                pw.println("<td >");
                                  pw.println("<table>");
                                   pw.println("<tr>");
                                    pw.println("<td>");
                                    pw.println("<form action=\"update\" method=\"post\" style=\"margin:0px\">");
                                     pw.println("<input type=\"submit\" value=\"修改\">");                                 
                                     pw.println("<input type=\"hidden\" name=\"userID\" value=\""+tmp.getUserId()+"\">");
                                     pw.println("<input type=\"hidden\" name=\"userName\" value=\""+tmp.getName()+"\">");
                                     pw.println("<input type=\"hidden\" name=\"userMail\" value=\""+tmp.getEmail()+"\">");
                                     pw.println("<input type=\"hidden\" name=\"userGrade\" value=\""+tmp.getGrade()+"\">");
                                    pw.println("</form>");
                                    pw.println("</td>");
                                    pw.println("<td>");
                                    pw.println("<form action=\"deletecr\" method=\"post\" style=\"margin:0px\" >");
                                     pw.println("<input type=\"submit\" value=\"删除\" onclick=\"return window.confirm('确定要删除该用户吗？')\">");
                                     pw.println("<input type=\"hidden\" name=\"userID\" value=\""+tmp.getUserId()+"\">");
                                     pw.println("<input type=\"hidden\" name=\"userName\" value=\""+tmp.getName()+"\">");
                                     pw.println("<input type=\"hidden\" name=\"userMail\" value=\""+tmp.getEmail()+"\">");
                                     pw.println("<input type=\"hidden\" name=\"userGrade\" value=\""+tmp.getGrade()+"\">");
                                    pw.println("</form>"); 
                                    pw.println("</td>");
                                    
                                   pw.println("</tr>");
                                  pw.println("</table>");
                                
                                  
                                 
                                //pw.println("&nbsp");
                                 // pw.println("<form action=?? method=??>");
                                	 
                                 // pw.println("</form>");	
                                pw.println("</td>");
                                pw.println("</tr>");
							 }
						pw.println("</table>");
						if (pageNow != 1){
						  pw.print("<a href=display?pagenow="+(pageNow-1)+"&&username="+un+">"+"上一页"+"</a>　");
						}
						for (int i = 1; i <= ubc.getPageCount(); i ++){
							if (i == pageNow){
							  pw.print(i+"　");
							  continue;
							}
							pw.print("<a href=display?pagenow="+i+"&&username="+un+">"+i+"</a>　");
						}
						if (pageNow != ubc.getPageCount()){
						  pw.print("<a href=display?pagenow="+(pageNow+1)+"&&username="+un+">"+"下一页"+"</a>　");	
						}
						hs = req.getSession(true);
                        hs.setAttribute("pass", "true");
                
						pw.print("<a href=wel?usrname="+un+">"+"返回"+"</a>　");	
						
						pw.println("<form action=\"display\" method=\"post\">");
						pw.println("<input type=\"text\" name=\"pagenow\" style=\"width:40px;height:30px;font-size:20px;\">");
						pw.println("&nbsp<input type=\"submit\" name=\"go\" value=\"go\" >");
						pw.println("<input type=\"hidden\" name=\"username\" value="+un+">");
						
					    pw.println("</form>");
					pw.println("</center>");
					//pw.println("</img>");
					
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