<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="5;url=project_history.jsp"> <!-- Redirect to project_history.jsp after 5 seconds -->
    <title>Delete Project</title>
    <style>
        /* Global Styles */
        /* Your existing styles */
    </style>
</head>

<body>
    <header class="header">
        <!-- Your header content -->
    </header>

    <div class="container">
        <div class="message-container">
            <% 
                // Get the project_id to be deleted from the request
                int projectId = Integer.parseInt(request.getParameter("project_id"));

                // Database connection parameters
                String dbURL = "jdbc:mysql://localhost:3306/colab";
                String dbUser = "root";
                String dbPass = "";

                try {
                    // Load MySQL JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                    // Delete project members from the project_members table
                    String deleteMembersQuery = "DELETE FROM project_members WHERE project_id = ?";
                    PreparedStatement pstmtMembers = conn.prepareStatement(deleteMembersQuery);
                    pstmtMembers.setInt(1, projectId);
                    pstmtMembers.executeUpdate();

                    // Delete project from the projects table
                    String deleteProjectQuery = "DELETE FROM projects WHERE project_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(deleteProjectQuery);
                    pstmt.setInt(1, projectId);
                    int rowsAffected = pstmt.executeUpdate();

                    // Display a success message if the project was deleted
                    if (rowsAffected > 0) {
            %>
                        <h2>Project Deleted Successfully</h2>
                        <p>You will be redirected to the project history page shortly...</p>
            <%
                    } else {
            %>
                        <h2>Failed to Delete Project</h2>
                        <p>Sorry, something went wrong. Please try again later.</p>
            <%
                    }

                    conn.close();
                } catch (Exception e) {
            %>
                    <h2>Error</h2>
                    <p><%= e.getMessage() %></p>
            <%
                    e.printStackTrace();
                }
            %>
        </div>
    </div>

</body>

</html>
