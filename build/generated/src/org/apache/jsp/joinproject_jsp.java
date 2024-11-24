package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.servlet.http.*;

public final class joinproject_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

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

        String projectQuery = "SELECT * FROM projects WHERE email = ?";
        stmt = conn.prepareStatement(projectQuery);
        stmt.setString(1, email);
        rs = stmt.executeQuery();

        if (rs.next()) {
            String projectCategory = rs.getString("category");

            String profileQuery = "SELECT * FROM profiles WHERE email = ?";
            selectProfileStmt = conn.prepareStatement(profileQuery);
            selectProfileStmt.setString(1, email);
            profileRs = selectProfileStmt.executeQuery();

            if (profileRs.next()) {
                String memberName = profileRs.getString("name");
                String memberSkills = profileRs.getString("skills");
                String profileCategory = profileRs.getString("category");

                if (projectCategory.equals(profileCategory)) {

      out.write("\n");
      out.write("                    <script type=\"text/javascript\">\n");
      out.write("                        function confirmJoin() {\n");
      out.write("                            var confirmation = confirm(\"Do you want to join the project?\");\n");
      out.write("                            if (confirmation) {\n");
      out.write("                                window.location.href = \"processJoinProject.jsp?project_id=");
      out.print( projectId );
      out.write("&member_name=");
      out.print( memberName );
      out.write("&member_skills=");
      out.print( memberSkills );
      out.write("&email=");
      out.print( email );
      out.write("\";\n");
      out.write("                            } else {\n");
      out.write("                                history.back();\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    </script>\n");
      out.write("                    <button type=\"button\" onclick=\"confirmJoin()\">Confirm</button>\n");

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

      out.write('\n');
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
