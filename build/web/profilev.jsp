<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CoLab - View Profile</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Montserrat', sans-serif;
        }

        body {
            background-color: #2b2d42;
            background: linear-gradient(to right, #e2e2e2, #c9d6ff);
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            min-height: 100vh;
            margin: 0;
            padding: 0;
        }

        .header {
            width: 100%;
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
            text-align: center;
            position: fixed;
            top: 0;
            left: 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
            z-index: 1000;
        }

        .header h1 {
            font-size: 1.5rem;
            font-weight: bold;
        }
        .header input[type="text"] {
            padding: 10px;
            border-radius: 5px;
            border: none;
            width: 60%;
            margin-bottom: 20px;
            font-size: 1rem;
        }
        .header .logout-button {
            background-color: #512da8;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            text-decoration: none;
        }

        .header .logout-button:hover {
            background-color: #1e88e5;
        }


        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            gap: 20px;
            max-width: 1200px;
            margin-top: 80px; /* Adjusted margin to accommodate fixed header */
        }

        .card {
            background-color: #2b2d42; /* Same color for both cards */
            color: #fff;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.35);
            padding: 20px;
            width: 300px;
            max-width: 90%;
        }

        .card h2 {
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 10px;
            color: #fff;
        }

        .card p {
            font-size: 1rem;
            line-height: 1.5;
            color: #ccc;
        }

        .card-button {
            background-color: #512da8;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            margin-top: 10px;
            display: block;
            width: 100%;
            text-align: center;
            text-decoration: none;
        }

        .card-button:hover {
            background-color: #1e88e5;
        }

        /* Sidebar Styles */
        .sidebar {
            position: fixed;
            left: 0;
            top: 80px; /* Matched with margin-top of .container */
            height: calc(100vh - 80px);
            width: 200px;
            background-color: #333;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            z-index: 999;
        }

        .sidebar a {
            color: #fff;
            text-decoration: none;
            font-size: 1rem;
            margin-bottom: 10px;
            width: 100%;
            display: block;
            padding: 10px 0;
            text-align: center;
        }

        .sidebar a:hover {
            background-color: #1e88e5;
        }

        button {
            background-color: #512da8;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            margin-top: 20px;
            width: 100%;
            display: block;
            text-align: center;
            text-decoration: none;
        }

        button:hover {
            background-color: #1e88e5;
        }

        .form-container {
            background-color: #2b2d42;
            color: #fff;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.35);
            padding: 20px;
            width: 400px;
            max-width: 90%;
        }

        .form-container h2 {
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 20px;
            color: #fff;
        }
        .form-g{
            background-color: #2b2d42;
            color: #fff;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.35);
            padding: 20px;
            width: 400px;
            max-width: 90%;
        }
        .form-g{
            margin-bottom: 15px;
        }

        .form-g {
            display: block;
            margin-bottom: 5px;
            color: #ccc;
        }

        .form-group input,
        .form-group select {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #ccc;
        }

        .form-group input,
        .form-group select {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
        }

        .form-button {
            background-color: #512da8;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            margin-top: 10px;
            width: 100%;
            text-align: center;
            text-decoration: none;
        }

        .form-button:hover {
            background-color: #1e88e5;
        }
    </style>
</head>
<body>
    <header class="header">
        <h1>PROJNEST </h1>
        <a href="proj.jsp" class="logout-button">Logout</a>
    </header>

    <div class="sidebar">
        <a href="profilev.jsp">View Profile</a>
        <a href="profilec.jsp">Create Profile</a>
        <a href="newjsp.jsp" class="sidebar-button">Dashboard</a>
    </div>
    
    <div class="container">
        <div class="form-container">
            <h2>View Profile</h2>

            <% 
                // Get email from session
                HttpSession s= request.getSession();
                String email = (String) session.getAttribute("userEmail");

                if (email != null && !email.isEmpty()) {
                    // Database connection parameters
                    String dbURL = "jdbc:mysql://localhost:3306/colab";
                    String dbUser = "root";
                    String dbPass = "";

                    // Initialize variables to store profile details
                    String name = "";
                    int age = 0;
                    String gender = "";
                    Date dob = null;
                    String department = "";
                    String skills = "";
                    String phone = "";
                    String category = "";

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                        // Retrieve profile details based on email
                        String fetchQuery = "SELECT * FROM profiles WHERE email = ?";
                        PreparedStatement stmt = conn.prepareStatement(fetchQuery);
                        stmt.setString(1, email);
                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                            name = rs.getString("name");
                            age = rs.getInt("age");
                            gender = rs.getString("gender");
                            dob = rs.getDate("dob");
                            department = rs.getString("department");
                            skills = rs.getString("skills");
                            phone = rs.getString("phone");
                            category = rs.getString("category");

                            // Display profile details
                            out.println("<div class='form-group'><label>Name:</label><span>" + name + "</span></div>");
                            out.println("<div class='form-group'><label>Age:</label><span>" + age + "</span></div>");
                            out.println("<div class='form-group'><label>Gender:</label><span>" + gender + "</span></div>");
                            out.println("<div class='form-group'><label>Date of Birth:</label><span>" + dob + "</span></div>");
                            out.println("<div class='form-group'><label>Department:</label><span>" + department + "</span></div>");
                            out.println("<div class='form-group'><label>Skills:</label><span>" + skills + "</span></div>");
                            out.println("<div class='form-group'><label>Phone:</label><span>" + phone + "</span></div>");
                            out.println("<div class='form-group'><label>Email:</label><span>" + email + "</span></div>");
                            out.println("<div class='form-group'><label>Category:</label><span>" + category + "</span></div>");
                            out.println("<button onclick='goBack()' class='form-button'>Go Back</button>");
                        } else {
                            out.println("<p>No profile found for the specified email.</p>");
                        }

                        conn.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        out.println("<p>Error retrieving profile details. Please try again later.</p>");
                    }
                } else {
                    out.println("<p>You are not logged in. Please <a href='login.jsp'>login</a>.</p>");
                }
            %>
        </div>
    </div>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>

</body>
</html>                    