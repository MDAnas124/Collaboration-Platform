<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CoLab - Settings</title>
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
            transition: background-color 0.5s, color 0.5s;
        }

        .dark-mode {
            background-color: #2b2d42;
            background: linear-gradient(to right, #434343, #2b2d42);
            color: #fff;
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
            align-items: flex-start;
            flex-wrap: wrap;
            gap: 20px;
            max-width: 1200px;
            margin-top: 80px; /* Adjusted margin to accommodate fixed header */
        }

        .card {
            background-color: #2b2d42;
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
        <h1>PROJNEST</h1>
        <a href="proj.jsp" class="logout-button">Logout</a>
    </header>

    <div class="sidebar">
        <a href="settings.jsp">Edit Profile</a>
        <a href="newjsp.jsp">Dashboard</a>
        <a href="deleteaccount.jsp">Delete Account</a>
        <button onclick="toggleDarkMode()">Toggle Dark Mode</button>
    </div>
    
    <div class="container">
        <div class="form-container">
            <h2>Edit Profile</h2>
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

                            // Display profile edit form
                            out.println("<form action='updateProfile.jsp' method='post'>");
                            out.println("<div class='form-group'><label for='name'>Name:</label><input type='text' name='name' value='" + name + "' required></div>");
                            out.println("<div class='form-group'><label for='age'>Age:</label><input type='number' name='age' value='" + age + "' required></div>");
                            out.println("<div class='form-group'><label for='gender'>Gender:</label><input type='text' name='gender' value='" + gender + "' required></div>");
                            out.println("<div class='form-group'><label for='dob'>Date of Birth:</label><input type='date' name='dob' value='" + dob + "' required></div>");
                            out.println("<div class='form-group'><label for='department'>Department:</label><input type='text' name='department' value='" + department + "' required></div>");
                            out.println("<div class='form-group'><label for='skills'>Skills:</label><input type='text' name='skills' value='" + skills + "' required></div>");
                            out.println("<div class='form-group'><label for='phone'>Phone:</label><input type='text' name='phone' value='" + phone + "' required></div>");
                            out.println("<div class='form-group'><label for='category'>Category:</label><input type='text' name='category' value='" + category + "' required></div>");
                            out.println("<button type='submit' class='form-button'>Update Profile</button>");
                            out.println("</form>");
                        } else {
                            out.println("<p>Profile not found.</p>");
                        }
                        conn.close();
                    } catch (Exception e) {
                        out.println("<p>Error: " + e.getMessage() + "</p>");
                    }
                } else {
                    out.println("<p>Please login first.</p>");
                }
            %>
        </div>
    </div>

    <script>
        function toggleDarkMode() {
            document.body.classList.toggle('dark-mode');
        }
    </script>
</body>

</html>

