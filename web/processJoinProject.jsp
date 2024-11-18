<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.*" %>
<%
    int projectId = Integer.parseInt(request.getParameter("project_id"));
    String memberName = request.getParameter("member_name");
    String memberSkills = request.getParameter("member_skills");
    String email = request.getParameter("email");

    String dbURL = "jdbc:mysql://localhost:3306/colab";
    String dbUser = "root";
    String dbPass = "";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        String insertMemberQuery = "INSERT INTO joined_project (project_id, member_name, member_skills, email) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertMemberQuery);
        String insertMemberQuery1 = "INSERT INTO project_members (project_id, member_name, member_skills) VALUES (?, ?, ?)";
        PreparedStatement pstmt2 = conn.prepareStatement(insertMemberQuery1);

        pstmt.setInt(1, projectId);
        pstmt.setString(2, memberName);
        pstmt.setString(3, memberSkills);
        pstmt.setString(4, email);
        pstmt.executeUpdate();

        pstmt2.setInt(1, projectId);
        pstmt2.setString(2, memberName);
        pstmt2.setString(3, memberSkills);
        pstmt2.executeUpdate();

        String updateProjectQuery = "UPDATE projects SET available_members = available_members + 1 WHERE project_id = ?";
        PreparedStatement updateProjectStmt = conn.prepareStatement(updateProjectQuery);
        updateProjectStmt.setInt(1, projectId);
        updateProjectStmt.executeUpdate();

        conn.close();
        response.sendRedirect("joinedproject.jsp");
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
