package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.servlet.http.*;

public final class deleteaccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Delete Account</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background-color: #2b2d42;\n");
      out.write("            color: #fff;\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("            justify-content: center;\n");
      out.write("            flex-direction: column;\n");
      out.write("            min-height: 100vh;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .message {\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .success {\n");
      out.write("            background-color: #4caf50;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .error {\n");
      out.write("            background-color: #f44336;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .delete-button {\n");
      out.write("            background-color: #f44336;\n");
      out.write("            color: #fff;\n");
      out.write("            border: none;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            cursor: pointer;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .delete-button:hover {\n");
      out.write("            background-color: #d32f2f;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .back-button {\n");
      out.write("            background-color: #1e88e5;\n");
      out.write("            color: #fff;\n");
      out.write("            border: none;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            cursor: pointer;\n");
      out.write("            margin-top: 20px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            display: inline-block;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .back-button:hover {\n");
      out.write("            background-color: #1565c0;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <script>\n");
      out.write("        function confirmDeletion() {\n");
      out.write("            if (confirm(\"Are you sure you want to delete your account? This action cannot be undone.\")) {\n");
      out.write("                document.getElementById('deleteForm').submit();\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    ");

        // Get email from session
        HttpSession s = request.getSession();
        String email = (String) session.getAttribute("userEmail");

        if (email != null && !email.isEmpty()) {
            // Show the delete button and confirmation popup
    
      out.write("\n");
      out.write("    <form id=\"deleteForm\" action=\"deleteaccount.jsp\" method=\"post\">\n");
      out.write("        <input type=\"hidden\" name=\"confirmDelete\" value=\"true\">\n");
      out.write("        <button type=\"button\" class=\"delete-button\" onclick=\"confirmDeletion()\">Delete Account</button>\n");
      out.write("    </form>\n");
      out.write("    <a href=\"settings.jsp\" class=\"back-button\">Back to Settings</a>\n");
      out.write("    ");

            if ("true".equals(request.getParameter("confirmDelete"))) {
                // Database connection parameters
                String dbURL = "jdbc:mysql://localhost:3306/colab";
                String dbUser = "root";
                String dbPass = "";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                    // Delete user from profiles, users, project_members, and joined_project tables
                    String deleteProfileQuery = "DELETE FROM profiles WHERE email = ?";
                    String deleteUserQuery = "DELETE FROM users WHERE email = ?";
                    String deleteJoinedProjectQuery = "DELETE FROM joined_project WHERE email = ?";
                    String deleteProjectsQuery = "DELETE FROM projects WHERE email = ?";

                    PreparedStatement stmtProfile = conn.prepareStatement(deleteProfileQuery);
                    stmtProfile.setString(1, email);

                    PreparedStatement stmtJoinedProject = conn.prepareStatement(deleteJoinedProjectQuery);
                    stmtJoinedProject.setString(1, email);

                    PreparedStatement stmtProjects = conn.prepareStatement(deleteProjectsQuery);
                    stmtProjects.setString(1, email);
                    
                    PreparedStatement stmtUser = conn.prepareStatement(deleteUserQuery);
                    stmtUser.setString(1, email);
                    
                    int rowsDeletedProfile = stmtProfile.executeUpdate();
                    int rowsDeletedJoinedProject = stmtJoinedProject.executeUpdate();
                    int rowsDeletedProjects = stmtProjects.executeUpdate();
                    int rowsDeletedUser = stmtUser.executeUpdate();
                    
                    if (rowsDeletedProfile > 0 && rowsDeletedUser > 0) {
                        out.println("<div class='message success'>Account and associated data deleted successfully!</div>");
                        // Invalidate session after account deletion
                        session.invalidate();
                        response.sendRedirect("login.jsp");
                    } else {
                        out.println("<div class='message error'>Failed to delete account. Please try again.</div>");
                    } 
                    conn.close();
                } catch (Exception e) {
                    out.println("<div class='message error'>Error: " + e.getMessage() + "</div>");
                    e.printStackTrace();
                }
            }
        } else {
            out.println("<div class='message error'>Please login first.</div>");
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
