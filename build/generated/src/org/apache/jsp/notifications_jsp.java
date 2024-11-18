package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class notifications_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>CoLab - Notifications</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <style>\n");
      out.write("        * {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            font-family: 'Montserrat', sans-serif;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        body {\n");
      out.write("            background-color: #f8f9fa;\n");
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
      out.write("            flex-direction: column;\n");
      out.write("            align-items: center;\n");
      out.write("            max-width: 1200px;\n");
      out.write("            margin-top: 100px; /* Adjusted margin to accommodate fixed header */\n");
      out.write("            margin-left: 220px; /* Adjusted margin to accommodate sidebar */\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container h2 {\n");
      out.write("            width: 100%;\n");
      out.write("            font-size: 2rem;\n");
      out.write("            font-weight: bold;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
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
      out.write("        .sidebar h2 {\n");
      out.write("            color: #fff;\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            text-align: center;\n");
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
      out.write("\n");
      out.write("        .card {\n");
      out.write("            background-color: #ffffff; /* Light background color */\n");
      out.write("            color: #333;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);\n");
      out.write("            padding: 20px;\n");
      out.write("            width: calc(50% - 20px); /* Smaller card width for             /* Smaller card width for fitting two cards in a row */\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card h2 {\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            font-weight: bold;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card p {\n");
      out.write("            font-size: 1rem;\n");
      out.write("            line-height: 1.5;\n");
      out.write("            color: #666;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card a {\n");
      out.write("            color: #007bff;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card a:hover {\n");
      out.write("            text-decoration: underline;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card-button {\n");
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
      out.write("        .card-button:hover {\n");
      out.write("           background-color: #c9d6ff;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .notification-card {\n");
      out.write("            background-color: #f8d7da; /* Red for deletion */\n");
      out.write("            color: #721c24;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .notification-card.updated {\n");
      out.write("            background-color: #d4edda; /* Green for update */\n");
      out.write("            color: #155724;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .notification-card.added {\n");
      out.write("            background-color: #cce5ff; /* Blue for new addition */\n");
      out.write("            color: #004085;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <header class=\"header\">\n");
      out.write("        <h1>CoLab</h1>\n");
      out.write("        <a href=\"#\" class=\"logout-button\">Logout</a>\n");
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
      out.write("        <a href=\"#\" class=\"sidebar-button\">Settings</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Notifications</h2>\n");
      out.write("        ");

            // Database connection parameters
            String dbURL = "jdbc:mysql://localhost:3306/colab";
            String dbUser = "root";
            String dbPass = "";

            try {
                // Load MySQL JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                // Retrieve recent notifications
                String selectNotificationsQuery = "SELECT n.project_id, n.action, p.title " +
                                                  "FROM notifications n " +
                                                  "JOIN projects p ON n.project_id = p.project_id " +
                                                  "ORDER BY n.timestamp DESC";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(selectNotificationsQuery);

                while (rs.next()) {
                    int projectId = rs.getInt("project_id");
                    String action = rs.getString("action");
                    String projectTitle = rs.getString("title");

                    String cardClass = "notification-card";
                    if (action.equals("added")) {
                        cardClass += " added";
                    } else if (action.equals("updated")) {
                        cardClass += " updated";
                    } else if (action.equals("deleted")) {
                        cardClass += " deleted";
                    }
        
      out.write("\n");
      out.write("                    <div class=\"");
      out.print( cardClass );
      out.write(" card\">\n");
      out.write("                        <h2>");
      out.print( projectTitle );
      out.write("</h2>\n");
      out.write("                        <p><strong>Action:</strong> ");
      out.print( action );
      out.write("</p>\n");
      out.write("                        <a href=\"project_details.jsp?project_id=");
      out.print( projectId );
      out.write("\" class=\"card-button\">View Project</a>\n");
      out.write("                    </div>\n");
      out.write("        ");

                }

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
