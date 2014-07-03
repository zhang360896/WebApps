/**
 * @(#)UserBeanCR.java
 *
 *
 * @author 
 * @version 1.00 2014/6/26
 */
 package com.login;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class UserBeanCR {
    ConnDB cdb = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private int pageCount=0;//the number of total pages
    Connection ct = null;
    String table;
    
    public UserBeanCR(String table) {
		cdb = new ConnDB("userData");
		ct = cdb.getConnection();
		this.table = table;
	}
	//the function to divide pages
	public ArrayList<UserBean> divdPages(int pageSize, int pageNow)//the size of per page,the current page facing a user
	{
		
    	int rowCount=0;//the number of total rows
    	try{
    	
		 ps = ct.prepareStatement("select count(*) from "+this.table);
         rs = ps.executeQuery();
         if (rs.next()){
           rowCount = rs.getInt(1);
           
         }
        }catch(Exception e){
           e.printStackTrace();	
        }finally{
           	try{
           	   if (rs != null){
           	     rs.close();
           	     rs = null;
           	   }
           	   if (ps != null){
           	     ps.close();
           	     ps = null;
           	   }
            }
            catch(Exception ex){
               ex.printStackTrace();
            }
         }
         if (rowCount%pageSize == 0){
           this.setPageCount(rowCount/pageSize);
         }
         else {
           this.setPageCount(rowCount/pageSize+1);	
         }
        ArrayList<UserBean> al = null;
        try {
         ps = ct.prepareStatement("select top "+pageSize+" *  from userTable where (userId) not in (select top "+(pageNow-1)*pageSize+" userId from userTable)");
         //ps.setInt(1,pageSize);
         //ps.setInt(2,(pageNow-1)*pageSize);
         rs = ps.executeQuery();
         
         //the list to restore whole users
         al = new ArrayList<UserBean>();
         
         while (rs.next()){
         	//the tempal object to restore the data
            UserBean ub = new UserBean();
         	ub.setUserId(rs.getString(1));
         	ub.setName(rs.getString(2));
         	ub.setPasswd(rs.getString(3));
         	ub.setEmail(rs.getString(4));
         	ub.setGrade(rs.getInt(5));
         	al.add(ub);
         }
        }catch(Exception e){
           e.printStackTrace();	
         }finally{
            try{
           	   if (rs != null){
           	     rs.close();
           	     rs = null;
           	   }
           	   if (ps != null){
           	     ps.close();
           	     ps = null;
           	   }
           	   if (ct != null){
           	     ct.close();
           	     ct = null;
           	   }
            }
            catch(Exception ex){
               ex.printStackTrace();
            }
          }
         return al;
	}
	boolean UserCR(String usname, String psw)
	{
		try {
		   ps = ct.prepareStatement("select top 1 passwd from "+this.table+" where name='"+usname+"'");
		   rs = ps.executeQuery();
		   if (rs.next()){
		   	 String pswd = rs.getString(1);
		   	 if (pswd.equals(psw)){
		   	 	return true;
		   	 }
		   }
		}catch(Exception e){
		    e.printStackTrace();
		 }finally {
		 	try{
		 	   if (rs != null)rs.close();
		 	   if (ps != null)ps.close();
		 	   //if (ct != null)ct.close();
		 	}catch(Exception ex){
		 	   ex.printStackTrace();
		 	 }
		 }
		 return false;
	}
	boolean add(UserBean ub)
	{
		try {
		   ps = ct.prepareStatement("insert into "+table+" values('"+ub.userId+"','"+ub.name+"','"+ub.passwd+"','"+ub.email+"','"+ub.grade+"')");
	       if (!ps.execute()){
	         System.out.println("add success!!");
	         return true;
	       }
	       else {
	         System.out.println("add failed!!");
	         return false;
	       }
		}catch(Exception e){
		    e.printStackTrace();	
		 }finally{
		 	try {
		       ps.close();
		    }catch(Exception e){
		       e.printStackTrace();	
		     }	
		  }
		  return false;
	}
	boolean delet(UserBean ub)
	{
		try {
		   ps = ct.prepareStatement("delete from "+table+" where userId='"+ub.userId+"'");
	       if (!ps.execute()){
	         System.out.println("delete success!!");
	         return true;
	       }
	       else {
	         System.out.println("delete failed!!");
	         return false;
	       }
	    }catch(Exception e){
	       e.printStackTrace();
	     }finally{
	     	try {
	          ps.close();	
	     	}catch(Exception e){
	     	   e.printStackTrace();
	     	 }
	      }
	      return false;
	}
	ResultSet searchID(String ID)
	{
		try {
		   ps = ct.prepareStatement("select * from "+table+" where userId='"+ID+"')");
		   rs = ps.executeQuery();
		   return rs;
		}catch(Exception e){
		   e.printStackTrace();	
		 }finally{
		    try{
		       rs.close();
		       ps.close();
		    }catch(Exception e){
		       e.printStackTrace();
		     }
		  }
		  return rs;
	}
	boolean update(UserBean ub)
	{
		try {
			System.out.println("update "+table+" set name='"+ub.name+"', email='"+ub.email+"', grade='"+ub.grade+"', userId='"+ub.userId+"' where userId='"+ub.userId+"'");
	       ps = ct.prepareStatement("update "+table+" set name='"+ub.name+"', email='"+ub.email+"', grade='"+ub.grade+"', userId='"+ub.userId+"' where userId='"+ub.userId+"'");
	       if (!ps.execute()){
	         System.out.println("update success!!");
	         return true;
	       }
	       else {
	         System.out.println("update failed!!");
	       }
	    }catch(Exception e){
	       e.printStackTrace();	
	     }finally{
	     	try{
	     		ps.close();
	     	}catch(Exception e){
	     	    e.printStackTrace();
	     	 }
	     }
	  return false;
	}

	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount; 
	}

	public int getPageCount() {
		return (this.pageCount); 
	}
}