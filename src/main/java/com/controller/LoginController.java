package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.DbConnection;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
//this is change 
		//second change
		boolean isError = false;

		if (email == null || email.isBlank()) {
			isError = true;
			request.setAttribute("emailError", "Please Enter Email");
		}
		// password

		if (isError) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			//
			try {
				Connection con = DbConnection.getConnection();

				PreparedStatement pstm = con.prepareStatement("select * from users where email = ? and password = ? ");
				pstm.setString(1, email);
				pstm.setString(2, password);

				ResultSet rs = pstm.executeQuery(); // data

				HttpSession session = request.getSession();//server side storage -> information 

				if (rs.next()) {
					// data found
					String role = rs.getString("role");
					int userId = rs.getInt("userId");//db userId 
					session.setAttribute("userId", userId);//session value set 
					
					if (role == null) {

						request.setAttribute("error", "Invalid Credentials");// carry
						request.getRequestDispatcher("Login.jsp").forward(request, response);
					} else if (role.equals("CUSTOMER")) {
						
						response.sendRedirect("CustomerHome.jsp");// new request
					} else if (role.equals("ADMIN")) {
						
						response.sendRedirect("AdminHome.jsp");// new request
					}

				} else {
					// no data found
					request.setAttribute("error", "Invalid Credentials");// carry
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
