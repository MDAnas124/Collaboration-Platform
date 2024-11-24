<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.http.*, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Update</title>
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
    </style>
</head>

<body>
    <%
        // Get email from session
        HttpSession s = request.getSession();
        String email = (String) session.getAttribute("userEmail");

        if (email != null && !email.isEmpty()) {
            // Get updated profile details from the form
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String gender = request.getParameter("gender");
            String dobStr = request.getParameter("dob");
            String department = request.getParameter("department");
            String skills = request.getParameter("skills");
            String phone = request.getParameter("phone");
            String category = request.getParameter("category");

            // Database connection parameters
            String dbURL = "jdbc:mysql://localhost:3306/colab";
            String dbUser = "root";
            String dbPass = "";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                // Update profile details in the database
                String updateQuery = "UPDATE profiles SET name=?, age=?, gender=?, dob=?, department=?, skills=?, phone=?, category=? WHERE email=?";
                PreparedStatement stmt = conn.prepareStatement(updateQuery);
                stmt.setString(1, name);
                stmt.setInt(2, age);
                stmt.setString(3, gender);
                stmt.setDate(4, java.sql.Date.valueOf(dobStr));
                stmt.setString(5, department);
                stmt.setString(6, skills);
                stmt.setString(7, phone);
                stmt.setString(8, category);
                stmt.setString(9, email);

                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    out.println("<div class='message success'>Profile updated successfully!</div>");
                } else {
                    out.println("<div class='message error'>Failed to update profile. Please try again.</div>");
                }
                conn.close();
            } catch (Exception e) {
                out.println("<div class='message error'>Error: " + e.getMessage() + "</div>");
            }
        } else {
            out.println("<div class='message error'>Please login first.</div>");
        }
    %>
    <a href="settings.jsp" class="message">Back to Settings</a>
</body>

</html>
