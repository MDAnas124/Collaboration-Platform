<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CoLab - Project Details</title>
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
            justify-content: center;
            align-items: flex-start;
            flex-wrap: wrap;
            gap: 20px;
            max-width: 1200px;
            margin-top: 80px; /* Adjusted margin to accommodate fixed header */
            margin-left: 220px; /* Adjusted margin to accommodate sidebar */
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
            width: 100%;
            max-width: 800px;
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

        .table {
            width: 100%;
            margin-top: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .table th,
        .table td {
            padding: 12px;
            text-align: left;
            border-top: 1px solid #dee2e6;
        }

        .table thead th {
            background-color: #007bff;
            color: #ffffff;
        }

        .table tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .comment-section {
            margin-top: 20px;
            width: 100%;
        }

        .comment-section h3 {
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .comment-section .comment-form {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .comment-section .comment-form textarea {
            width: 100%;
            padding: 10px;
            border-radius: 8px;
            border: 1px solid #ddd;
        }

        .comment-section .comment-form button {
            background-color: #512da8;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
        }

        .comment-section .comment-form button:hover {
            background-color: #1e88e5;
        }

        .comment-list {
            margin-top: 20px;
        }

        .comment-list .comment {
            background-color: #fff;
            padding: 10px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-bottom: 10px;
        }

        .join-button {
            background-color: #28a745;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            margin-top: 20px;
        }

        .join-button:hover {
            background-color: #218838;
        }
    </style>
</head>

<body>
    <header class="header">
        <h1>CoLab </h1>
        <a href="explore.jsp" class="logout-button">Go Back</a>
        <a href="proj.jsp" class="logout-button">Logout</a>
    </header>

    <div class="container">
        <div class="card">
            <h2>Project Details</h2>
            <%
                int projectId = Integer.parseInt(request.getParameter("project_id"));
                String dbURL = "jdbc:mysql://localhost:3306/colab";
                String dbUser = "root";
                String dbPass = "";

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                    String selectProjectQuery = "SELECT * FROM projects WHERE project_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(selectProjectQuery);
                    pstmt.setInt(1, projectId);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        String projectTitle = rs.getString("title");
                        int availableMembers = rs.getInt("available_members");
                        String projectDescription = rs.getString("description");
                        String requiredSkills = rs.getString("required_skills");
                        String category = rs.getString("category");

                        out.println("<p><strong>Title:</strong> " + projectTitle + "</p>");
                        out.println("<p><strong>Available Members:</strong> " + availableMembers + "</p>");
                        out.println("<p><strong>Description:</strong> " + projectDescription + "</p>");
                        out.println("<p><strong>Required Skills:</strong> " + requiredSkills + "</p>");
                        out.println("<p><strong>Category:</strong> " + category + "</p>");
                    } else {
                        out.println("<p>Project not found.</p>");
                    }

                    String selectMembersQuery = "SELECT * FROM project_members WHERE project_id = ?";
                    pstmt = conn.prepareStatement(selectMembersQuery);
                    pstmt.setInt(1, projectId);
                    rs = pstmt.executeQuery();

                    out.println("<h3>Project Members</h3>");
                    out.println("<table class='table'><thead><tr><th>Name</th><th>Skills</th></tr></thead><tbody>");

                    while (rs.next()) {
                        String memberName = rs.getString("member_name");
                        String memberSkills = rs.getString("member_skills");
                        out.println("<tr><td>" + memberName + "</td><td>" + memberSkills + "</td></tr>");
                    }

                    out.println("</tbody></table>");

                    conn.close();
                } catch (Exception e) {
                    out.println("<p>Error: " + e.getMessage() + "</p>");
                    e.printStackTrace();
                }
            %>
          <a href="joinproject.jsp?project_id=<%= projectId %>" class="join-button">Join Project</a>
        </div>

        <div class="card comment-section">
            <h3>Comments</h3>
            <div class="comment-list">
                <%
                    try {
                        Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
                        String selectCommentsQuery = "SELECT * FROM comments WHERE project_id = ? ORDER BY comment_id DESC";
                        PreparedStatement pstmt = conn.prepareStatement(selectCommentsQuery);
                        pstmt.setInt(1, projectId);
                        
                        ResultSet rs = pstmt.executeQuery();

                        while (rs.next()) {
                            String commentText = rs.getString("comment_text");
                            String email=rs.getString("email");
                            out.println("<div class='comment'><p>" + commentText + "</p>");
                            out.println("<p>" + email + "</p></div>");
                        }

                        conn.close();
                    } catch (Exception e) {
                        out.println("<p>Error: " + e.getMessage() + "</p>");
                        e.printStackTrace();
                    }
                %>
            </div>
            <form class="comment-form" method="post" action="post_comment.jsp">
                <textarea name="comment_text" rows="3" placeholder="Write a comment..."></textarea>
                <input type="hidden" name="project_id" value="<%= projectId %>">
                <button type="submit">Post Comment</button>
            </form>
        </div>
    </div>
</body>

</html>
