<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CoLab - Submit Project</title>
    <style>
        /* Your CSS styles here */
        /* Ensure to include styles for the header, container, message, etc. */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Montserrat', sans-serif;
        }

        body {
            background-color: #2b2d42;
            background: linear-gradient(to right, #e2e2e2, #c9d6ff);
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
            align-items: center;
            flex-wrap: wrap;
            gap: 20px;
            max-width: 1200px;
            margin-top: 80px; /* Adjusted margin to accommodate fixed header */
        }

        .message-container {
            background-color: #2b2d42;
            color: #fff;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.35);
            padding: 20px;
            width: calc(100% - 240px); /* Adjusted width to accommodate sidebar */
            max-width: 800px;
            text-align: center;
        }

        .message-container h2 {
            font-size: 1.5rem;
            font-weight: bold;
            margin-bottom: 20px;
            color: #fff;
        }

        .message {
            font-size: 1rem;
            color            : #ccc;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-wrap: wrap;
            gap: 20px;
            max-width: 1200px;
            margin-top: 80px; /* Adjusted margin to accommodate fixed header */
        }

        .message-container button {
            background-color: #512da8;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            width: 50%;
            height: 50%;
            font-size: 1rem;
            cursor: pointer;
            margin-top: 10px;
            text-decoration: none;
        }

        .message-container button:hover {
            background-color: #1e88e5;
        }
    </style>
</head>
<body>
    <header class="header">
        <h1>CoLab</h1>
        <a href="proj.html" class="logout-button">Logout</a>
    </header>

    <div class="container">
        <div class="message-container">
            <h2>Project Submission Result</h2>
            <% 
                HttpSession s= request.getSession();
                String email = (String) session.getAttribute("userEmail");
                String projectTitle = request.getParameter("projectTitle");
                int availableMembers = Integer.parseInt(request.getParameter("availableMembers"));
                String projectDescription = request.getParameter("projectDescription");
                String requiredSkills = request.getParameter("requiredSkills");
                String category=request.getParameter("Category");
                // Members data
                String[] memberNames = request.getParameterValues("memberNames");
                String[] memberSkills = request.getParameterValues("memberSkills");
                // Database connection parameters
                String dbURL = "jdbc:mysql://localhost:3306/colab";
                String dbUser = "root";
                String dbPass = "";
                
                try {
                    // Load MySQL JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
                  
                    // Insert project data into the database
                    String insertProjectQuery = "INSERT INTO projects (title, available_members, description, required_skills,category,email) VALUES (?,?,?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(insertProjectQuery, Statement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1, projectTitle);
                    pstmt.setInt(2, availableMembers);
                    pstmt.setString(3, projectDescription);
                    pstmt.setString(4, requiredSkills);
                    pstmt.setString(5, category);
                    pstmt.setString(6, email);

                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        ResultSet generatedKeys = pstmt.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            int projectId = generatedKeys.getInt(1);
                            
                            // Insert members data into the database
                            String insertMembersQuery = "INSERT INTO project_members (project_id, member_name, member_skills) VALUES (?, ?, ?)";
                            PreparedStatement pstmtMembers = conn.prepareStatement(insertMembersQuery);
                            for (int i = 0; i < memberNames.length; i++) {
                                pstmtMembers.setInt(1, projectId);
                                pstmtMembers.setString(2, memberNames[i]);
                                pstmtMembers.setString(3, memberSkills[i]);
                                pstmtMembers.addBatch();
                            }
                            
                            int[] membersInserted = pstmtMembers.executeBatch();
                            if (membersInserted.length == memberNames.length) {
                                out.println("<p>Your project and members have been submitted successfully.</p>");
                            } else {
                                out.println("<p>Failed to submit the project members. Please try again.</p>");
                            }
                        } else {
                            out.println("<p>Failed to retrieve project ID. Please try again.</p>");
                        }
                    } else {
                        out.println("<p>Failed to submit the project. Please try again.</p>");
                    }
                    
                    conn.close();
                } catch (Exception e) {
                    out.println("<p>Error: " + e.getMessage() + "</p>");
                    e.printStackTrace();
                }
            %>
            <a href="post.jsp" class="form-button">Back to Post Project</a>
        </div>
    </div>

</body>
</html>

