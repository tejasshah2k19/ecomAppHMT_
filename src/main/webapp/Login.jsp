<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Signup Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        .signup-container {
            width: 300px;
            margin: 80px auto;
            padding: 30px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        .signup-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .signup-container input[type="text"],
        .signup-container input[type="email"],
        .signup-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 6px 0 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .signup-container input[type="submit"] {
            width: 100%;
            background-color: #5cb85c;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .signup-container input[type="submit"]:hover {
            background-color: #4cae4c;
        }
    </style>
</head>
<body>
    <div class="signup-container">
        <h2>Login</h2>
        <form action="LoginController" method="post">
            <input type="email" name="email" placeholder="Email"  >
            <input type="password" name="password" placeholder="Password" >
            <input type="submit" value="Login">
        </form>
        <br>
        ${error }
        <br>
        <a href="Signup.jsp">New User?</a>
    </div>
</body>
</html>
