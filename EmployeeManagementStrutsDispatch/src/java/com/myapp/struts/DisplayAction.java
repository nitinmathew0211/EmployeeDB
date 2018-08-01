/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;
import java.sql.*;
import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Administrator
 */
public class DisplayAction extends DispatchAction {

    /* forward name="success" path="" */
    
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward display(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","root");
            List<DisplayActionFormBean> result=new ArrayList<>();
            PreparedStatement stmt=con.prepareStatement("select * from emp");
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                DisplayActionFormBean emp=new DisplayActionFormBean();
                emp.setId(rs.getInt(1));
                emp.setName(rs.getString(2));
                emp.setMob(rs.getString(3));
                emp.setEmail(rs.getString(4));
                emp.setRole(rs.getString(5));
                result.add(emp);
            }
            request.setAttribute("res", result);
            con.close();
        }catch(Exception e){e.printStackTrace();}
        return mapping.findForward("display");
    }
    
    public ActionForward insertform(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward("index");
    }
    
    public ActionForward insert(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","root");
            PreparedStatement stmt=con.prepareStatement("insert into emp(name,mob,email,role) values(?,?,?,?)");
            stmt.setString(1,request.getParameter("name"));
            stmt.setString(2,request.getParameter("mob"));
            stmt.setString(3,request.getParameter("email"));
            stmt.setString(4,request.getParameter("role"));
            stmt.executeUpdate();
            con.close();
        }catch(Exception e){e.printStackTrace();}
        return mapping.findForward("index");
    }
    
    public ActionForward updateform(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id=Integer.parseInt(request.getParameter("id"));
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","root");
            PreparedStatement stmt=con.prepareStatement("select * from emp where id=?");
            stmt.setInt(1,id);
            ResultSet rs=stmt.executeQuery();
            rs.next();
            request.setAttribute("i",id);
            request.setAttribute("n",rs.getString(2));
            request.setAttribute("m",rs.getString(3));
            request.setAttribute("e",rs.getString(4));
            request.setAttribute("r",rs.getString(5));
            con.close();
        }catch(Exception e){e.printStackTrace();}
        return mapping.findForward("update");
    }
    
    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id=Integer.parseInt(request.getParameter("id"));
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","root");
            PreparedStatement stmt=con.prepareStatement("update emp set name=?,mob=?,email=?,role=? where id=?");
            stmt.setString(1,request.getParameter("name"));
            stmt.setString(2,request.getParameter("mob"));
            stmt.setString(3,request.getParameter("email"));
            stmt.setString(4,request.getParameter("role"));
            stmt.setInt(5,id);
            stmt.executeUpdate();
            con.close();
        }catch(Exception e){e.printStackTrace();}
        return mapping.findForward("index");
    }
    
    public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id=Integer.parseInt(request.getParameter("id"));
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false","root","root");
            PreparedStatement stmt=con.prepareStatement("delete from emp where id=?");
            stmt.setInt(1,id);
            stmt.executeUpdate();
            con.close();
        }catch(Exception e){e.printStackTrace();}
        return mapping.findForward("index");
    }
}
