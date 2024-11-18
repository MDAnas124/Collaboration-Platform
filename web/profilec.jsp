<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CoLab - Profile Creation</title>
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
            margin-top: 80px;
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

        .sidebar {
            position: fixed;
            left: 0;
            top: 80px;
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

        .message {
            background-color: #512da8;
            color: #fff;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.35);
            padding: 20px;
            width: 400px;
            max-width: 90%;
            text-align: center;
            font-size: 1.2rem;
        }
    </style>
</head>

<body>
    <header class="header">
        <h1>PROJNEST</h1>
        <a href="proj.jsp" class="logout-button">Logout</a>
    </header>

    <div class="sidebar">
        <a href="profilev.jsp">View Profile</a>
        <a href="profilec.jsp">Create Profile</a>
        <a href="newjsp.jsp" class="sidebar-button">Dashboard</a>
    </div>

    <div class="container">
        <%
            // Database connection parameters
            String dbURL = "jdbc:mysql://localhost:3306/colab";
            String dbUser = "root";
            String dbPass = "";

            HttpSession s = request.getSession();
            String email = (String) session.getAttribute("userEmail");
            boolean profileExists = false;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                // Check if a profile already exists
                String checkProfileQuery = "SELECT COUNT(*) FROM profiles WHERE email = ?";
                PreparedStatement checkProfileStmt = conn.prepareStatement(checkProfileQuery);
                checkProfileStmt.setString(1, email);
                ResultSet rs = checkProfileStmt.executeQuery();
                rs.next();
                profileExists = rs.getInt(1) > 0;

                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (profileExists) {
        %>
            <div class="message">
                <p>Profile already exists!</p>
            </div>
        <%
            } else {
        %>
            <div class="form-container">
                <h2>Create Profile</h2>
                <form method="post">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="age">Age:</label>
                        <input type="number" id="age" name="age" required>
                    </div>
                    <div class="form-group">
                        <label for="gender">Gender:</label>
                        <select id="gender" name="gender" required>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="dob">Date of Birth:</label>
                        <input type="date" id="dob" name="dob" required>
                    </div>
                    <div class="form-group">
                        <label for="department">Department:</label>
                        <input type="text" id="department" name="department" required>
                    </div>
                    <div class="form-group">
                        <label for="skills">Skills:</label>
                        <input type="text" id="skills" name="skills" required>
                    </div>
                    <div class="form-group">
                        <label for="phone">Telephone Number:</label>
                        <input type="tel" id="phone" name="phone" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" value="<%= email %>" readonly required>
                    </div>
                    <div class="form-group">
                        <label for="Category">Category:</label>
                        <select id="Category" name="Category" required>
                            <option value="student">Student</option>
                            <option value="developer">Developer</option>
                        </select>
                    </div>
                    <button type="submit" class="form-button">Create Profile</button>
                </form>
            </div>
        <%
            }
        %>

        <%
            if (request.getMethod().equalsIgnoreCase("POST")) {
                String name = request.getParameter("name");
                String age = request.getParameter("age");
                String gender = request.getParameter("gender");
                String dob = request.getParameter("dob");
                String department = request.getParameter("department");
                String skills = request.getParameter("skills");
                String phone = request.getParameter("phone");
                String category = request.getParameter("Category");

                if (name != null && age != null && gender != null && dob != null && department != null && skills != null && phone != null) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                        // Insert profile into the database
                        String insertQuery = "INSERT INTO profiles (name, age, gender, dob, department, skills, phone, email, category) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement stmt = conn.prepareStatement(insertQuery);
                        stmt.setString(1, name);
                        stmt.setString(2, age);
                        stmt.setString(3, gender);
                        stmt.setString(4, dob);
                        stmt.setString(5, department);
                        stmt.setString(6, skills);
                        stmt.setString(7, phone);
                        stmt.setString(8, email);
                        stmt.setString(9, category);
                        int rowsInserted = stmt.executeUpdate();
                        if (rowsInserted > 0) {
                            %>
                            <div class="message">
                <p>Profile created Successfully!</p>
            </div>
                            <%
                        }

                        conn.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        %>
    </div>
</body>

</html>
