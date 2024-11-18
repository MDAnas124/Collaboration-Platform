<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    HttpSession s= request.getSession();
    String email = (String) session.getAttribute("userEmail");
    String commentText = request.getParameter("comment_text");
    int projectId = Integer.parseInt(request.getParameter("project_id"));

    String dbURL = "jdbc:mysql://localhost:3306/colab";
    String dbUser = "root";
    String dbPass = "";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        String insertCommentQuery = "INSERT INTO comments (project_id,email ,comment_text) VALUES (?,?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertCommentQuery);
        pstmt.setInt(1, projectId);
        pstmt.setString(2, email);
        pstmt.setString(3, commentText);
        pstmt.executeUpdate();

        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    response.sendRedirect("project_details.jsp?project_id=" + projectId);
%>
