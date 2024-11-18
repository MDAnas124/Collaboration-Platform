package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.servlet.http.*;

public final class profilev_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>CoLab - View Profile</title>\n");
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
      out.write("        .form-g{\n");
      out.write("            background-color: #2b2d42;\n");
      out.write("            color: #fff;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.35);\n");
      out.write("            padding: 20px;\n");
      out.write("            width: 400px;\n");
      out.write("            max-width: 90%;\n");
      out.write("        }\n");
      out.write("        .form-g{\n");
      out.write("            margin-bottom: 15px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-g {\n");
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
      out.write("<body>\n");
      out.write("    <header class=\"header\">\n");
      out.write("        <h1>CoLab </h1>\n");
      out.write("        <a href=\"proj.jsp\" class=\"logout-button\">Logout</a>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("        <a href=\"profilev.jsp\">View Profile</a>\n");
      out.write("        <a href=\"profilec.jsp\">Create Profile</a>\n");
      out.write("        <a href=\"newjsp.jsp\" class=\"sidebar-button\">Dashboard</a>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"form-container\">\n");
      out.write("            <h2>View Profile</h2>\n");
      out.write("\n");
      out.write("            ");
 
                // Get email from session
                HttpSession s= request.getSession();
                String email = (String) session.getAttribute("userEmail");

                if (email != null && !email.isEmpty()) {
                    // Database connection parameters
                    String dbURL = "jdbc:mysql://localhost:3306/colab";
                    String dbUser = "root";
                    String dbPass = "";

                    // Initialize variables to store profile details
                    String name = "";
                    int age = 0;
                    String gender = "";
                    Date dob = null;
                    String department = "";
                    String skills = "";
                    String phone = "";
                    String category = "";

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                        // Retrieve profile details based on email
                        String fetchQuery = "SELECT * FROM profiles WHERE email = ?";
                        PreparedStatement stmt = conn.prepareStatement(fetchQuery);
                        stmt.setString(1, email);
                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                            name = rs.getString("name");
                            age = rs.getInt("age");
                            gender = rs.getString("gender");
                            dob = rs.getDate("dob");
                            department = rs.getString("department");
                            skills = rs.getString("skills");
                            phone = rs.getString("phone");
                            category = rs.getString("category");

                            // Display profile details
                            out.println("<div class='form-group'><label>Name:</label><span>" + name + "</span></div>");
                            out.println("<div class='form-group'><label>Age:</label><span>" + age + "</span></div>");
                            out.println("<div class='form-group'><label>Gender:</label><span>" + gender + "</span></div>");
                            out.println("<div class='form-group'><label>Date of Birth:</label><span>" + dob + "</span></div>");
                            out.println("<div class='form-group'><label>Department:</label><span>" + department + "</span></div>");
                            out.println("<div class='form-group'><label>Skills:</label><span>" + skills + "</span></div>");
                            out.println("<div class='form-group'><label>Phone:</label><span>" + phone + "</span></div>");
                            out.println("<div class='form-group'><label>Email:</label><span>" + email + "</span></div>");
                            out.println("<div class='form-group'><label>Category:</label><span>" + category + "</span></div>");
                            out.println("<button onclick='goBack()' class='form-button'>Go Back</button>");
                        } else {
                            out.println("<p>No profile found for the specified email.</p>");
                        }

                        conn.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        out.println("<p>Error retrieving profile details. Please try again later.</p>");
                    }
                } else {
                    out.println("<p>You are not logged in. Please <a href='login.jsp'>login</a>.</p>");
                }
            
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function goBack() {\n");
      out.write("            window.history.back();\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>                    ");
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
