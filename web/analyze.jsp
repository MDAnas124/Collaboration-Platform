<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CoLab - Analysis</title>
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

        .statistics-container {
            width: 80%;
            max-width: 1200px;
            margin-top: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .statistics-container h2 {
            font-size: 2rem;
            font-weight: bold;
            margin-bottom: 20px;
            color: #fff;
        }

        .statistics-card {
            background-color: #2b2d42;
            color: #fff;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.35);
            padding: 20px;
            margin: 10px;
            width: 300px;
            text-align: center;
        }

        .chart-container {
            width: 100%;
            max-width: 800px;
            margin-top: 20px;
        }
    </style>
</head>

<body>
    <header class="header">
        <h1>PROJNEST</h1>
        <input type="text" placeholder="Search...">
        <a href="proj.jsp" class="logout-button">Go Back</a>
    </header>

    
    <div class="container">
        <div class="statistics-container">
            <h2>Analysis</h2>
            <%
                // Database connection parameters
                String dbURL = "jdbc:mysql://localhost:3306/colab";
                String dbUser = "root";
                String dbPass = "";

                int userCount = 0;
                int projectCount = 0;
                int projectMemberCount = 0;

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                    // Query to get the number of users
                   String userQuery = "SELECT COUNT(*) AS count FROM users";
                    PreparedStatement userStmt = conn.prepareStatement(userQuery);
                    ResultSet userRs = userStmt.executeQuery();
                    if (userRs.next()) {
                        userCount = userRs.getInt("count");
                    }

                    // Query to get the number of projects
                    String projectQuery = "SELECT COUNT(*) AS count FROM projects";
                    PreparedStatement projectStmt = conn.prepareStatement(projectQuery);
                    ResultSet projectRs = projectStmt.executeQuery();
                    if (projectRs.next()) {
                        projectCount = projectRs.getInt("count");
                    }

                    // Query to get the number of project members
                    String projectMemberQuery = "SELECT COUNT(*) AS count FROM project_members";
                    PreparedStatement projectMemberStmt = conn.prepareStatement(projectMemberQuery);
                    ResultSet projectMemberRs = projectMemberStmt.executeQuery();
                    if (projectMemberRs.next()) {
                        projectMemberCount = projectMemberRs.getInt("count");
                    }

                    conn.close();
                } catch (Exception e) {
                    out.println("<p>Error: " + e.getMessage() + "</p>");
                }
            %>
            <div class="statistics-card">
                <h3>Total Users</h3>
                <p><%= userCount %></p>
            </div>
            <div class="statistics-card">
                <h3>Total Projects</h3>
                <p><%= projectCount %></p>
            </div>
            <div class="statistics-card">
                <h3>Total Project Members</h3>
                <p><%= projectMemberCount %></p>
            </div>
        </div>

        <div class="chart-container">
            <canvas id="analysisChart"></canvas>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        function toggleDarkMode() {
            document.body.classList.toggle('dark-mode');
        }

        const ctx = document.getElementById('analysisChart').getContext('2d');
        const analysisChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ['Users', 'Projects', 'Project Members'],
                datasets: [{
                    label: 'Count',
                    data: [<%= userCount %>, <%= projectCount %>, <%= projectMemberCount %>],
                    backgroundColor: [
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255,                        206, 86, 0.2)'
                    ],
                    borderColor: [
                        'rgba(75, 192, 192, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    </script>
</body>

</html>


