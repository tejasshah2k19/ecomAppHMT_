package com.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

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

		}

	}
}
