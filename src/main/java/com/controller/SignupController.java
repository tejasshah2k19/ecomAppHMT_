package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DbConnection;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
//first change
		//second change 
		boolean isError = false;

		if (firstName == null || firstName.isBlank()) {
			isError = true;
			request.setAttribute("firstNameError", "Please Enter FirstName");
		}

		if (lastName == null || lastName.isBlank()) {
			isError = true;
			request.setAttribute("lastNameError", "Please Enter LastName");
		}

		if (email == null || email.isBlank()) {
			isError = true;
		}

		if (password == null || password.isBlank()) {
			isError = true;
		}

		if (isError == true) {
			// go back to Signup.jsp
			RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");
			rd.forward(request, response);
		} else {
			String role = "CUSTOMER";
			boolean active = true;
			LocalDateTime createdAt = LocalDateTime.now();

			// db connection
			// insert
			// login

			try {
				Connection con = DbConnection.getConnection();
				
				PreparedStatement pstmt  = con.prepareStatement("insert into users (firstName,lastName,email,password,role,createdAt,active) values (?,?,?,?,?,?,?)");

				pstmt.setString(1, firstName);
				pstmt.setString(2, lastName);
				pstmt.setString(3, email);
				pstmt.setString(4, password);
				pstmt.setString(5,role);
				pstmt.setString(6,createdAt.toString());
				pstmt.setBoolean(7, active);
				
				pstmt.executeUpdate(); 
				
				
				response.sendRedirect("Login.jsp");;
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
