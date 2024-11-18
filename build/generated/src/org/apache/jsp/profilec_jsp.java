package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class profilec_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>CoLab - Profile Creation</title>\n");
      out.write("    <style>\n");
      out.write("        * {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            font-family: 'Montserrat', sans-serif;\n");
      out.write("        }\n");
      out.write("\n");
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
      out.write("        .header input[type=\"text\"] {\n");
      out.write("            padding: 10px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            border: none;\n");
      out.write("            width: 60%;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            font-size: 1rem;\n");
      out.write("        }\n");
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
      out.write("\n");
      out.write("        .container {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("            gap: 20px;\n");
      out.write("            max-width: 1200px;\n");
      out.write("            margin-top: 80px; /* Adjusted margin to accommodate fixed header */\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card {\n");
      out.write("            background-color: #2b2d42; /* Same color for both cards */\n");
      out.write("            color: #fff;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.35);\n");
      out.write("            padding: 20px;\n");
      out.write("            width: 300px;\n");
      out.write("            max-width: 90%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card h2 {\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            font-weight: bold;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            color: #fff;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card p {\n");
      out.write("            font-size: 1rem;\n");
      out.write("            line-height: 1.5;\n");
      out.write("            color: #ccc;\n");
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
      out.write("            margin-top: 10px;\n");
      out.write("            display: block;\n");
      out.write("            width: 100%;\n");
      out.write("            text-align: center;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card-button:hover {\n");
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
      out.write("        button {\n");
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
      out.write("        button:hover {\n");
      out.write("            background-color: #1e88e5;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-container {\n");
      out.write("            background-color: #2b2d42;\n");
      out.write("            color: #fff;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.35);\n");
      out.write("            padding: 20px;\n");
      out.write("            width: 400px;\n");
      out.write("            max-width: 90%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-container h2 {\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            font-weight: bold;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            color: #fff;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-group {\n");
      out.write("            margin-bottom: 15px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-group label {\n");
      out.write("            display: block;\n");
      out.write("            margin-bottom: 5px;\n");
      out.write("            color: #ccc;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-group input,\n");
      out.write("        .form-group select {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 10px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
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
      out.write("            width: 100%;\n");
      out.write("            text-align: center;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-button:hover {\n");
      out.write("            background-color: #1e88e5;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <header class=\"header\">\n");
      out.write("        <h1>CoLab </h1>\n");
      out.write("        <input type=\"text\" placeholder=\"Search...\">\n");
      out.write("        <a href=\"#\" class=\"logout-button\">Logout</a>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("        <a href=\"profilec.jsp\">Create Profile</a>\n");
      out.write("        <a href=\"profilev.jsp\">View Profile</a>\n");
      out.write("        <a href=\"newjsp.jsp\" class=\"sidebar-button\">Dashboard</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"form-container\">\n");
      out.write("            <h2>Create Profile</h2>\n");
      out.write("            <form method=\"post\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"name\">Name:</label>\n");
      out.write("                    <input type=\"text\" id=\"name\" name=\"name\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"age\">Age:</label>\n");
      out.write("                    <input type=\"number\" id=\"age\" name=\"age\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"gender\">Gender:</label>\n");
      out.write("                    <select id=\"gender\" name=\"gender\" required>\n");
      out.write("                        <option value=\"male\">Male</option>\n");
      out.write("                        <option value=\"female\">Female</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"dob\">Date of Birth:</label>\n");
      out.write("                    <input type=\"date\" id=\"dob\" name=\"dob\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"department\">Department:</label>\n");
      out.write("                    <input type=\"text\" id=\"department\" name=\"department\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"skills\">Skills:</label>\n");
      out.write("                    <input type=\"text\" id=\"skills\" name=\"skills\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"phone\">Telephone Number:</label>\n");
      out.write("                    <input type=\"tel\" id=\"phone\" name=\"phone\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"email\">Email</label>\n");
      out.write("                    <input type=\"email\" id=\"email\" name=\"email\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"Category\">Category:</label>\n");
      out.write("                    <select id=\"Category\" name=\"Category\" required>\n");
      out.write("                        <option value=\"student\">student</option>\n");
      out.write("                        <option value=\"developer\">developer</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                <button type=\"submit\" class=\"form-button\">Create Profile</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ");

        // Database connection parameters
        String dbURL = "jdbc:mysql://localhost:3306/colab";
        String dbUser = "root";
        String dbPass = "";

        // Form input parameters
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String department = request.getParameter("department");
        String skills = request.getParameter("skills");
        String phone = request.getParameter("phone");
        String email=request.getParameter("email");
        String category=request.getParameter("Category");
        if (name != null && age != null && gender != null && dob != null && department != null && skills != null && phone != null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                // Check if a profile already exists
                String checkProfileQuery = "SELECT COUNT(*) FROM profiles";
                PreparedStatement checkProfileStmt = conn.prepareStatement(checkProfileQuery);
       
                ResultSet rs = checkProfileStmt.executeQuery();
                rs.next();
                int count = rs.getInt(1);

                if (count == 0) {
                    // Insert profile into the database
                    String insertQuery = "INSERT INTO profiles (name, age, gender, dob, department, skills, phone,email,category) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmt = conn.prepareStatement(insertQuery);
                    stmt.setString(1, name);
                    stmt.setString(2, age);
                    stmt.setString(3, gender);
                    stmt.setString(4, dob);
                    stmt.setString(5, department);
                    stmt.setString(6, skills);
                    stmt.setString(7, phone);
                    stmt.setString(8, email);
                    stmt.setString(9, category);
                    int rowsInserted = stmt.executeUpdate();
                    if (rowsInserted > 0) {
                        out.println("<p>Profile created successfully!</p>");
                    }
                } else {
                    out.println("<p>Profile already exists!</p>");
                }

                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
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
