<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.*" %>
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

        button {
            background-color: #512da8;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            font-size: 1rem;
            cursor: pointer;
            text-decoration: none;
        }

        button:hover {
            background-color: #1e88e5;
        }
        </style>

<%
    int projectId = Integer.parseInt(request.getParameter("project_id"));

    String dbURL = "jdbc:mysql://localhost:3306/colab";
    String dbUser = "root";
    String dbPass = "";
    
    Connection conn = null;
    PreparedStatement stmt = null;
    PreparedStatement selectProfileStmt = null;                                          
    ResultSet rs = null;
    ResultSet profileRs = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        HttpSession s = request.getSession();
        String email = (String) s.getAttribute("userEmail");

        String projectQuery = "SELECT * FROM projects WHERE project_id = ?";
        stmt = conn.prepareStatement(projectQuery);
        stmt.setInt(1, projectId);
        rs = stmt.executeQuery();

        if (rs.next()) {
            String skill=rs.getString("required_skills").toLowerCase();;
            String projectCategory = rs.getString("category").toLowerCase();

            String profileQuery = "SELECT * FROM profiles WHERE email = ?";
            selectProfileStmt = conn.prepareStatement(profileQuery);
            selectProfileStmt.setString(1, email);
            profileRs = selectProfileStmt.executeQuery();

            if (profileRs.next()) {
                String memberName = profileRs.getString("name");
                String memberSkills = profileRs.getString("skills").toLowerCase();;
                String profileCategory = profileRs.getString("category").toLowerCase();;

                if (projectCategory.equals(profileCategory)&&skill.equals(memberSkills)) {
%>
                    <script type="text/javascript">
                        function confirmJoin() {
                            var confirmation = confirm("Do you want to join the project?");
                            if (confirmation) {
                                window.location.href = "processJoinProject.jsp?project_id=<%= projectId %>&member_name=<%= memberName %>&member_skills=<%= memberSkills %>&email=<%= email %>";
                            } else {
                                history.back();
                            }
                        }
                    </script>
                    <button type="button" onclick="confirmJoin()">Confirm</button>
<%
                } else {
                    out.println("Required category not matched for: " + email);
                }
            } else {
                out.println("Profile not found for email: " + email);
            }
        } else {
            out.println("Project not found for email: " + email);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (profileRs != null) profileRs.close();
            if (stmt != null) stmt.close();
            if (selectProfileStmt != null) selectProfileStmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
