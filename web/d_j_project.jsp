<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Joined Project - CoLab</title>
    <style>
        body {
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            min-height: 100vh;
            font-family: 'Montserrat', sans-serif;
            margin: 0;
            padding: 20px;
        }

        .message-container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 100%;
            max-width: 600px;
            text-align: center;
        }

        .message {
            font-size: 1rem;
            color: #333;
            margin-bottom: 20px;
        }

        .form-button {
            background-color: #512da8;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
        }

        .form-button:hover {
            background-color: #1e88e5;
        }
    </style>
</head>
<body>
    <div class="message-container">
        <% 
            String dbURL = "jdbc:mysql://localhost:3306/colab";
            String dbUser = "root";
            String dbPass = "";

            String message = "";
            try {
                // Load MySQL JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                // Retrieve session email and project ID from request
                HttpSession s = request.getSession();
                String email = (String) session.getAttribute("userEmail");
                int projectId = Integer.parseInt(request.getParameter("project_id"));

                // Delete from joined_project table
                String deleteJoinedProjectQuery = "DELETE FROM joined_project WHERE email = ? AND project_id = ?";
                PreparedStatement pstmt1 = conn.prepareStatement(deleteJoinedProjectQuery);
                pstmt1.setString(1, email);
                pstmt1.setInt(2, projectId);
                int rowsAffected1 = pstmt1.executeUpdate();

                // Delete from project_members table
                String deleteProjectMembersQuery = "DELETE FROM project_members WHERE email = ? AND project_id = ?";
                PreparedStatement pstmt2 = conn.prepareStatement(deleteProjectMembersQuery);
                pstmt2.setString(1, email);
                pstmt2.setInt(2, projectId);
                int rowsAffected2 = pstmt2.executeUpdate();

                if (rowsAffected1 > 0 && rowsAffected2 > 0) {
                    message = "Successfully left the project.";
                } else {
                    message = "Failed to leave the project.";
                }

                conn.close();
            } catch (Exception e) {
                message = "Error: " + e.getMessage();
                e.printStackTrace();
            }
        %>
        <p class="message"><%= message %></p>
        <a href="joinedproject.jsp" class="form-button">Back to Enlisted Projects</a>
    </div>
</body>
</html>
