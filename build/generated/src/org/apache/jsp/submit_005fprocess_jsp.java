package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class submit_005fprocess_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>CoLab - Submit Project</title>\n");
      out.write("    <style>\n");
      out.write("        /* Your CSS styles here */\n");
      out.write("        /* Ensure to include styles for the header, container, message, etc. */\n");
      out.write("        * {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            font-family: 'Montserrat', sans-serif;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        body {\n");
      out.write("            background-color: #2b2d42;\n");
      out.write("            background: linear-gradient(to right, #e2e2e2, #c9d6ff);\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("            justify-content: center;\n");
      out.write("            flex-direction: column;\n");
      out.write("            min-height: 100vh;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        \n");
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
      out.write("        \n");
      out.write("        .header h1 {\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        \n");
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
      out.write("        \n");
      out.write("        .header .logout-button:hover {\n");
      out.write("            background-color: #1e88e5;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .container {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("            gap: 20px;\n");
      out.write("            max-width: 1200px;\n");
      out.write("            margin-top: 80px; /* Adjusted margin to accommodate fixed header */\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .message-container {\n");
      out.write("            background-color: #2b2d42;\n");
      out.write("            color: #fff;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.35);\n");
      out.write("            padding: 20px;\n");
      out.write("            width:calc(100% - 240px); /* Adjusted width to accommodate sidebar */\n");
      out.write("            max-width: 800px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .message-container h2 {\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            font-weight: bold;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            color: #fff;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .message {\n");
      out.write("            font-size: 1rem;\n");
      out.write("            color: #ccc;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .container {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("            gap: 20px;\n");
      out.write("            max-width: 1200px;\n");
      out.write("            margin-top: 80px; /* Adjusted margin to accommodate fixed header */\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .message-container button {\n");
      out.write("            background-color: #512da8;\n");
      out.write("            color: #fff;\n");
      out.write("            border: none;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            cursor: pointer;\n");
      out.write("            margin-top: 10px;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .message-container button:hover {\n");
      out.write("            background-color: #1e88e5;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header class=\"header\">\n");
      out.write("        <h1>CoLab</h1>\n");
      out.write("        <a href=\"#\" class=\"logout-button\">Logout</a>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"message-container\">\n");
      out.write("            <h2>Project Submission Result</h2>\n");
      out.write("            ");
 
                String projectTitle = request.getParameter("projectTitle");
                int availableMembers = Integer.parseInt(request.getParameter("availableMembers"));
                String projectDescription = request.getParameter("projectDescription");
                String requiredSkills = request.getParameter("requiredSkills");
                
                // Database connection parameters
                String dbURL = "jdbc:mysql://localhost:3306/colab";
                String dbUser = "root";
                String dbPass = "";
                
                try {
                    // Load MySQL JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
                    
                    // Insert project data into the database
                    String insertQuery = "INSERT INTO projects (title, available_members, description, required_skills) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(insertQuery);
                    pstmt.setString(1, projectTitle);
                    pstmt.setInt(2, availableMembers);
                    pstmt.setString(3, projectDescription);
                    pstmt.setString(4, requiredSkills);
                    
                    int rowsInserted = pstmt.executeUpdate();
                    if (rowsInserted > 0) {
                        out.println("<p>Your project has been submitted successfully.</p>");
                    } else {
                        out.println("<p>Failed to submit the project. Please try again.</p>");
                    }
                    
                    conn.close();
                } catch (Exception e) {
                    out.println("<p>Error: " + e.getMessage() + "</p>");
                    e.printStackTrace();
                }
            
      out.write("\n");
      out.write("            <a href=\"post.jsp\" class=\"form-button\">Back to Post Project</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
