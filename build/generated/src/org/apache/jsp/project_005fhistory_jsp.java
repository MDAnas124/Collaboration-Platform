package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class project_005fhistory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>CoLab - Project History</title>\n");
      out.write("    <style>\n");
      out.write("        /* CSS Styles */\n");
      out.write("        * {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            font-family: 'Montserrat', sans-serif;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        body {\n");
      out.write("            background-color: #2b2d42;\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("            justify-content: center;\n");
      out.write("            flex-direction: column;\n");
      out.write("            min-height: 100vh;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
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
      out.write("            flex-direction: column;\n");
      out.write("            max-width: 800px;\n");
      out.write("            margin-top: 80px; /* Adjusted margin to accommodate fixed header */\n");
      out.write("            background-color: #fff;\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.35);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project {\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            padding: 10px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 8px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project h3 {\n");
      out.write("            font-size: 1.2rem;\n");
      out.write("            font-weight: bold;\n");
      out.write("            margin-bottom: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .project p {\n");
      out.write("            font-size: 1rem;\n");
      out.write("            color: #666;\n");
      out.write("            margin-bottom: 5px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <header class=\"header\">\n");
      out.write("        <h1>CoLab - Project History</h1>\n");
      out.write("        <a href=\"#\" class=\"logout-button\">Logout</a>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Project History</h2>\n");
      out.write("\n");
      out.write("        ");
 
            // Database connection parameters
            String dbURL = "jdbc:mysql://localhost:3306/colab";
            String dbUser = "root";
            String dbPass = "";

            try {
                // Load MySQL JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                // Fetch project data along with members from the database
                String selectQuery = "SELECT p.*, pm.member_name, pm.member_skills FROM projects p LEFT JOIN project_members pm ON p.id = pm.project_id";
                PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                ResultSet rs = pstmt.executeQuery();

                // Display projects
                while (rs.next()) {
                    int projectId = rs.getInt("id");
                    String title = rs.getString("title");
                    int availableMembers = rs.getInt("available_members");
                    String description = rs.getString("description");
                    String requiredSkills = rs.getString("required_skills");
                    String memberName = rs.getString("member_name");
                    String memberSkills = rs.getString("member_skills");

                    // Display each project and its members in a structured format
        
      out.write("\n");
      out.write("                    <div class=\"project\">\n");
      out.write("                        <h3>");
      out.print( title );
      out.write("</h3>\n");
      out.write("                        <p><strong>Available Members:</strong> ");
      out.print( availableMembers );
      out.write("</p>\n");
      out.write("                        <p><strong>Description:</strong> ");
      out.print( description );
      out.write("</p>\n");
      out.write("                        <p><strong>Required Skills:</strong> ");
      out.print( requiredSkills );
      out.write("</p>\n");
      out.write("                        ");
 if (memberName != null && memberSkills != null) { 
      out.write("\n");
      out.write("                            <p><strong>Members:</strong> ");
      out.print( memberName );
      out.write(" - ");
      out.print( memberSkills );
      out.write("</p>\n");
      out.write("                        ");
 } else { 
      out.write("\n");
      out.write("                            <p><strong>Members:</strong> No members assigned</p>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </div>\n");
      out.write("        ");

                }

                // Close resources
                rs.close();
                pstmt.close();
                conn.close();

            } catch (Exception e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
                e.printStackTrace();
            }
        
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
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
