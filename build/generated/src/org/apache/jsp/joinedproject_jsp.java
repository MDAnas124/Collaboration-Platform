package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.servlet.http.*;

public final class joinedproject_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Enlisted Projects - CoLab</title>\n");
      out.write("    <style>\n");
      out.write("        /* Global Styles */\n");
      out.write("        * {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            font-family: 'Montserrat', sans-serif;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        body {\n");
      out.write("            background-color: #f0f0f0;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            flex-direction: column;\n");
      out.write("            min-height: 100vh;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .header {\n");
      out.write("            width: 100%;\n");
      out.write("            background-color: #333;\n");
      out.write("            color: #fff;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            text-align: center;\n");
      out.write("            position: fixed;\n");
      out.write("            top: 0;\n");
      out.write("            left: 0;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: space-between;\n");
      out.write("            align-items: center;\n");
      out.write("            z-index: 1000;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .header h1 {\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .header .logout-button {\n");
      out.write("            background-color: #512da8;\n");
      out.write("            color: #fff;\n");
      out.write("            border: none;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            cursor: pointer;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .header .logout-button:hover {\n");
      out.write("            background-color: #1e88e5;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("            gap: 20px;\n");
      out.write("            max-width: 1200px;\n");
      out.write("            border-color: black;\n");
      out.write("           border-radius: 20px;\n");
      out.write("           margin-left: 17%;\n");
      out.write("            margin-top: 80px; /* Adjusted margin to accommodate fixed header */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .message-container {\n");
      out.write("            background-color: #fff;\n");
      out.write("            color: #333;\n");
      out.write("            border-color: black;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);\n");
      out.write("            padding: 20px;\n");
      out.write("            width: calc(100% - 140xpx); /* Adjusted width to accommodate sidebar */\n");
      out.write("            max-width: 100%;\n");
      out.write("            text-align: center;\n");
      out.write("            overflow-x: auto; /* Enable horizontal scrolling on smaller screens */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .message-container h2 {\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            font-weight: bold;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .message {\n");
      out.write("            font-size: 1rem;\n");
      out.write("            color: #666;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project-table {\n");
      out.write("            width: 100%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project-table th,\n");
      out.write("        .project-table td {\n");
      out.write("            padding: 12px;\n");
      out.write("            text-align: left;\n");
      out.write("            border-bottom: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project-table th {\n");
      out.write("            background-color: #512da8;\n");
      out.write("            color: #fff;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project-table tbody tr:nth-child(even) {\n");
      out.write("            background-color: #f2f2f2;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project-table tbody tr:hover {\n");
      out.write("            background-color: #ddd;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-button {\n");
      out.write("            background-color: #512da8;\n");
      out.write("            color: #fff;\n");
      out.write("            border: none;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            cursor: pointer;\n");
      out.write("            margin-top: 10px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            display: inline-block;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-button:hover {\n");
      out.write("            background-color: #1e88e5;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Sidebar Styles */\n");
      out.write("        .sidebar {\n");
      out.write("            position: fixed;\n");
      out.write("            left: 0;\n");
      out.write("            top: 80px; /* Matched with margin-top of .container */\n");
      out.write("            height: calc(100vh - 80px);\n");
      out.write("            width: 200px;\n");
      out.write("            background-color: #333;\n");
      out.write("            padding: 20px;\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            align-items: center;\n");
      out.write("            justify-content: flex-start;\n");
      out.write("            z-index: 999;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar a {\n");
      out.write("            color: #fff;\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            width: 100%;\n");
      out.write("            display: block;\n");
      out.write("            padding: 10px 0;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar a:hover {\n");
      out.write("            background-color: #1e88e5;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar-button {\n");
      out.write("            background-color: #512da8;\n");
      out.write("            color: #fff;\n");
      out.write("            border: none;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            cursor: pointer;\n");
      out.write("            margin-top: 20px;\n");
      out.write("            width: 100%;\n");
      out.write("            display: block;\n");
      out.write("            text-align: center;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sidebar-button:hover {\n");
      out.write("            background-color: #1e88e5;\n");
      out.write("        }\n");
      out.write("       input[type=\"submit\"] {\n");
      out.write("    background-color: #512da8;\n");
      out.write("    color: #fff;\n");
      out.write("    border: none;\n");
      out.write("    padding: 10px 20px;\n");
      out.write("    border-radius: 8px;\n");
      out.write("    font-size: 1rem;\n");
      out.write("    cursor: pointer;\n");
      out.write("    text-decoration: none;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=\"submit\"]:hover {\n");
      out.write("    background-color: #1e88e5;\n");
      out.write("}\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <header class=\"header\">\n");
      out.write("        <h1>CoLab </h1>\n");
      out.write("        <a href=\"proj.jsp\" class=\"logout-button\">Logout</a>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("        <h2>CoLab</h2>\n");
      out.write("        <a href=\"newjsp.jsp\">Home</a>\n");
      out.write("        <a href=\"profilev.jsp\">Profile</a>\n");
      out.write("        <a href=\"explore.jsp\">Explore Projects</a>\n");
      out.write("        <a href=\"post.jsp\">Post Project</a>\n");
      out.write("        <a href=\"joinedproject.jsp\">Enlisted Project</a>\n");
      out.write("        <a href=\"notifications.jsp\">Notifications</a>\n");
      out.write("        <a href=\"settings.jsp\" class=\"sidebar-button\">Settings</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"message-container\">\n");
      out.write("            <h2>Enlisted Projects</h2>\n");
      out.write("            ");

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

      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
