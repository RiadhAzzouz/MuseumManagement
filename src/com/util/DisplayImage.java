package com.util;

import javax.servlet.http.HttpServlet;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayImage extends HttpServlet {
	
	 private static final long serialVersionUID = 4593558495041379082L;
	 
	 @Override
	    public void doGet(HttpServletRequest request,
	            HttpServletResponse response)
	            throws ServletException, IOException {
	        Statement stmt = null;
	        ResultSet rs;
	        InputStream sImage;
	        
	        try {
	 
	            String id = request.getParameter("id");
	            System.out.println("inside servlet–>" + id);
	 
	            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","gm","gm");
	            
	            stmt = con.createStatement();
	            String strSql = "select image from article where id='" + id + "' ";
	            rs = stmt.executeQuery(strSql);
	            if (rs.next()) {
	                byte[] bytearray = new byte[1048576];
	                int size = 0;
	                sImage = rs.getBinaryStream(1);
	                response.reset();
	                response.setContentType("image/jpeg");
	                while ((size = sImage.read(bytearray)) != -1) {
	                    response.getOutputStream().
	                            write(bytearray, 0, size);
	                }
	            }
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
