<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Account</title>
    <style>
        body {
            background-color: #2b2d42;
            color: #fff;
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            min-height: 100vh;
        }

        .message {
            padding: 20px;
            border-radius: 5px;
            margin-top: 20px;
        }

        .success {
            background-color: #4caf50;
        }

        .error {
            background-color: #f44336;
        }

        .delete-button {
            background-color: #f44336;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            margin-top: 20px;
        }

        .delete-button:hover {
            background-color: #d32f2f;
        }

        .back-button {
            background-color: #1e88e5;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            margin-top: 20px;
            text-decoration: none;
            display: inline-block;
        }

        .back-button:hover {
            background-color: #1565c0;
        }
    </style>
    <script>
        function confirmDeletion() {
            if (confirm("Are you sure you want to delete your account? This action cannot be undone.")) {
                document.getElementById('deleteForm').submit();
            }
        }
    </script>
</head>

<body>
    <%
        // Get email from session
        HttpSession s = request.getSession();
        String email = (String) session.getAttribute("userEmail");

        if (email != null && !email.isEmpty()) {
            // Show the delete button and confirmation popup
    %>
    <form id="deleteForm" action="deleteaccount.jsp" method="post">
        <input type="hidden" name="confirmDelete" value="true">
        <button type="button" class="delete-button" onclick="confirmDeletion()">Delete Account</button>
    </form>
    <a href="settings.jsp" class="back-button">Back to Settings</a>
    <%
            if ("true".equals(request.getParameter("confirmDelete"))) {
                // Database connection parameters
                String dbURL = "jdbc:mysql://localhost:3306/colab";
                String dbUser = "root";
                String dbPass = "";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                    // Delete user from profiles, users, project_members, and joined_project tables
                    String deleteProfileQuery = "DELETE FROM profiles WHERE email = ?";
                    String deleteUserQuery = "DELETE FROM users WHERE email = ?";
                    String deleteJoinedProjectQuery = "DELETE FROM joined_project WHERE email = ?";
                    String deleteProjectsQuery = "DELETE FROM projects WHERE email = ?";

                    PreparedStatement stmtProfile = conn.prepareStatement(deleteProfileQuery);
                    stmtProfile.setString(1, email);

                    PreparedStatement stmtJoinedProject = conn.prepareStatement(deleteJoinedProjectQuery);
                    stmtJoinedProject.setString(1, email);

                    PreparedStatement stmtProjects = conn.prepareStatement(deleteProjectsQuery);
                    stmtProjects.setString(1, email);
                    
                    PreparedStatement stmtUser = conn.prepareStatement(deleteUserQuery);
                    stmtUser.setString(1, email);
                    
                    int rowsDeletedProfile = stmtProfile.executeUpdate();
                    int rowsDeletedJoinedProject = stmtJoinedProject.executeUpdate();
                    int rowsDeletedProjects = stmtProjects.executeUpdate();
                    int rowsDeletedUser = stmtUser.executeUpdate();
                    
                    if (rowsDeletedProfile > 0 && rowsDeletedUser > 0) {
                        out.println("<div class='message success'>Account and associated data deleted successfully!</div>");
                        // Invalidate session after account deletion
                        session.invalidate();
                        response.sendRedirect("login.jsp");
                    } else {
                        out.println("<div class='message error'>Failed to delete account. Please try again.</div>");
                    } 
                    conn.close();
                } catch (Exception e) {
                    out.println("<div class='message error'>Error: " + e.getMessage() + "</div>");
                    e.printStackTrace();
                }
            }
        } else {
            out.println("<div class='message error'>Please login first.</div>");
        }
    %>
</body>

</html>
