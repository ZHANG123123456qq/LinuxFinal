package com.southwind.controller;

import com.southwind.entity.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import com.google.gson.*;

@WebServlet("/student")
public class Student extends HttpServlet {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://114.55.7.3:3306/linux_final?serverTimezone=GMT%2B8";
    static final String USER = "root";
    static final String PASS = "hspedu100";

     public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select studentId,studentName,age from t_student where studentId=4";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int studentId = rs.getInt("studentId");
                String studentName = rs.getString("studentName");
		String age=rs.getString("age");
		 Gson gson = new Gson();
		student st=new student(studentId,studentName,age);
	     String json = gson.toJson(st);
      		out.println(json);
      		out.flush();
		out.close();
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
