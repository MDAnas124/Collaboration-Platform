<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enlisted Projects - CoLab</title>
    <style>
        /* Global Styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Montserrat', sans-serif;
        }

        body {
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            min-height: 100vh;
            margin: 0;
            padding: 20px;
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
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            gap: 20px;
            max-width: 1200px;
            border-color: black;
           border-radius: 20px;
           margin-left: 15%;
            margin-top: 80px; /* Adjusted margin to accommodate fixed header */
        }

        .message-container {
            background-color: #fff;
            color: #333;
            border-color: black;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: calc(100% - 140xpx); /* Adjusted width to accommodate sidebar */
            max-width: 100%;
            text-align: center;
            overflow-x: auto; /* Enable horizontal scrolling on smaller screens */
        }

        .message-container h2 {
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 20px;
            color: #333;
        }

        .message {
            font-size: 1rem;
            color: #666;
            margin-bottom: 10px;
        }

        .project-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        .project-table th,
        .project-table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        .project-table th {
            background-color: #512da8;
            color: #fff;
        }

        .project-table tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .project-table tbody tr:hover {
            background-color: #ddd;
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
            text-decoration: none;
            display: inline-block;
        }

        .form-button:hover {
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
       input[type="submit"] {
    background-color: #512da8;
    color: #fff;
    border: none;
    padding: 10px 20px;
    border-radius: 8px;
    font-size: 1rem;
    cursor: pointer;
    text-decoration: none;
}

input[type="submit"]:hover {
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
        <div class="message-container">
            <h2>Enlisted Projects</h2>
            <%
    // Database connection parameters
    String dbURL = "jdbc:mysql://localhost:3306/colab";
    String dbUser = "root";
    String dbPass = "";

    try {
        // Load MySQL JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // Fetch projects enlisted by the user
        HttpSession s= request.getSession();
        String email = (String) session.getAttribute("userEmail");

        String selectProjectsQuery = "SELECT p.*, jp.* FROM projects p " +
                                     "JOIN joined_project jp ON p.project_id = jp.project_id " +
                                     "WHERE jp.email = ?";
        PreparedStatement pstmt = conn.prepareStatement(selectProjectsQuery);
        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();

        // Display project details in a table
        out.println("<table class='project-table'>");
        out.println("<thead><tr>");
        out.println("<th>Title</th>");
        out.println("<th>Available Members</th>");
        out.println("<th>Description</th>");
        out.println("<th>Required Skills</th>");
        out.println("<th>Category</th>");
        out.println("<th>Contact Leader</th>");
        out.println("<th>Leave</th>");
        out.println("</tr></thead>");
        out.println("<tbody>");
        while (rs.next()) {
            int projectId = rs.getInt("p.project_id");
            String projectTitle = rs.getString("p.title");
            int availableMembers = rs.getInt("p.available_members");
            String projectDescription = rs.getString("p.description");
            String requiredSkills = rs.getString("p.required_skills");
            String category = rs.getString("p.category");
            String email1 = rs.getString("p.email");
            out.println("<tr>");
            out.println("<td>" + projectTitle + "</td>");
            out.println("<td>" + availableMembers + "</td>");
            out.println("<td>" + projectDescription + "</td>");
            out.println("<td>" + requiredSkills + "</td>");
            out.println("<td>" + category + "</td>");
            out.println("<td>" + email1 + "</td>");
            out.println("<td><form action='d_j_project.jsp' method='post'><input type='hidden' name='project_id' value='" + projectId + "'><input type='submit' value='Leave'></form></td>");
            out.println("</tr>");

        }
        out.println("</tbody>");
        out.println("</table>");

        conn.close();
    } catch (Exception e) {
        out.println("<p>Error: " + e.getMessage() + "</p>");
        e.printStackTrace();
    }
%>

        </div>
    </div>
</body>

</html>
