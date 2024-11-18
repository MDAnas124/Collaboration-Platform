<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CoLab - Notifications</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Montserrat', sans-serif;
        }

        body {
            background-color: #f8f9fa;
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
            flex-direction: column;
            align-items: center;
            max-width: 1200px;
            margin-top: 100px; /* Adjusted margin to accommodate fixed header */
            margin-left: 220px; /* Adjusted margin to accommodate sidebar */
            padding: 20px;
        }

        .container h2 {
            width: 100%;
            font-size: 2rem;
            font-weight: bold;
            margin-bottom: 20px;
            text-align: center;
        }

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

        .sidebar h2 {
            color: #fff;
            font-size: 1.5rem;
            margin-bottom: 20px;
            text-align: center;
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

        .sidebar-button {
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

        .sidebar-button:hover {
            background-color: #1e88e5;
        }

        .card {
            background-color: #ffffff; /* Light background color */
            color: #333;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: calc(50% - 20px); /* Smaller card width for             /* Smaller card width for fitting two cards in a row */
            margin-bottom: 20px;
        }

        .card h2 {
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .card p {
            font-size: 1rem;
            line-height: 1.5;
            color: #666;
        }

        .card a {
            color: #007bff;
            text-decoration: none;
        }

        .card a:hover {
            text-decoration: underline;
        }

        .card-button {
            background-color: #512da8;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            text-decoration: none;
        }

        .card-button:hover {
           background-color: #c9d6ff;
        }

        .notification-card {
            background-color: #f8d7da; /* Red for deletion */
            color: #721c24;
        }

        .notification-card.updated {
            background-color: #d4edda; /* Green for update */
            color: #155724;
        }

        .notification-card.added {
            background-color: #cce5ff; /* Blue for new addition */
            color: #004085;
        }
    </style>
</head>

<body>
    <header class="header">
        <h1>PROJNEST</h1>
        <a href="proj.jsp" class="logout-button">Logout</a>
    </header>

    <div class="sidebar">
        <h2>PROJNEST</h2>
        <a href="newjsp.jsp">Home</a>
        <a href="profilev.jsp">Profile</a>
        <a href="explore.jsp">Explore Projects</a>
        <a href="post.jsp">Post Project</a>
        <a href="joinedproject.jsp">Enlisted Project</a>
        <a href="notifications.jsp">Notifications</a>
        <a href="settings.jsp" class="sidebar-button">Settings</a>
    </div>

    <div class="container">
        <h2>Notifications</h2>
        <%
            // Database connection parameters
            String dbURL = "jdbc:mysql://localhost:3306/colab";
            String dbUser = "root";
            String dbPass = "";

            try {
                // Load MySQL JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                // Retrieve recent notifications
                String selectNotificationsQuery = "SELECT n.project_id, n.action, p.title " +
                                                  "FROM notifications n " +
                                                  "JOIN projects p ON n.project_id = p.project_id " +
                                                  "ORDER BY n.timestamp DESC";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(selectNotificationsQuery);

                while (rs.next()) {
                    int projectId = rs.getInt("project_id");
                    String action = rs.getString("action");
                    String projectTitle = rs.getString("title");

                    String cardClass = "notification-card";
                    if (action.equals("added")) {
                        cardClass += " added";
                    } else if (action.equals("updated")) {
                        cardClass += " updated";
                    } else if (action.equals("deleted")) {
                        cardClass += " deleted";
                    }
        %>
                    <div class="<%= cardClass %> card">
                        <h2><%= projectTitle %></h2>
                        <p><strong>Action:</strong> <%= action %></p>
                        <a href="project_details.jsp?project_id=<%= projectId %>" class="card-button">View Project</a>
                    </div>
        <%
                }

                conn.close();
            } catch (Exception e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
                e.printStackTrace();
            }
        %>
    </div>

</body>

</html>

