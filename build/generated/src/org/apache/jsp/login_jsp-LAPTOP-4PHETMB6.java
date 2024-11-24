package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Login Page</title>\n");
      out.write("    <style>\n");
      out.write("        *{\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            font-family: 'Montserrat', sans-serif;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        body{\n");
      out.write("            background-color: #2b2d42;\n");
      out.write("            background: linear-gradient(to right, #e2e2e2, #c9d6ff);\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("            justify-content: center;\n");
      out.write("            flex-direction: column;\n");
      out.write("            height: 100vh;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container{\n");
      out.write("            background-color: #fff;\n");
      out.write("            border-radius: 30px;\n");
      out.write("            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.35);\n");
      out.write("            position: relative;\n");
      out.write("            overflow: hidden;\n");
      out.write("            width: 768px;\n");
      out.write("            max-width: 100%;\n");
      out.write("            min-height: 480px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container p{\n");
      out.write("            font-size: 14px;\n");
      out.write("            line-height: 20px;\n");
      out.write("            letter-spacing: 0.3px;\n");
      out.write("            margin: 20px 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container span{\n");
      out.write("            font-size: 12px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container a{\n");
      out.write("            color: #333;\n");
      out.write("            font-size: 13px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            margin: 15px 0 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container button{\n");
      out.write("            background-color: #2b2d42;\n");
      out.write("            color: #fff;\n");
      out.write("            font-size: 12px;\n");
      out.write("            padding: 10px 45px;\n");
      out.write("            border: 1px solid transparent;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            font-weight: 600;\n");
      out.write("            letter-spacing: 0.5px;\n");
      out.write("            text-transform: uppercase;\n");
      out.write("            margin-top: 10px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container button.hidden{\n");
      out.write("            background-color: transparent;\n");
      out.write("            border-color: #fff;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container form{\n");
      out.write("            background-color: #fff;\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("            justify-content: center;\n");
      out.write("            flex-direction: column;\n");
      out.write("            padding: 0 40px;\n");
      out.write("            height: 100%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container input{\n");
      out.write("            background-color: #eee;\n");
      out.write("            border: none;\n");
      out.write("            margin: 8px 0;\n");
      out.write("            padding: 10px 15px;\n");
      out.write("            font-size: 13px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            width: 100%;\n");
      out.write("            outline: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-container{\n");
      out.write("            position: absolute;\n");
      out.write("            top: 0;\n");
      out.write("            height: 100%;\n");
      out.write("            transition: all 0.6s ease-in-out;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sign-in{\n");
      out.write("            left: 0;\n");
      out.write("            width: 50%;\n");
      out.write("            z-index: 2;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container.active .sign-in{\n");
      out.write("            transform: translateX(100%);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .sign-up{\n");
      out.write("            left: 0;\n");
      out.write("            width: 50%;\n");
      out.write("            opacity: 0;\n");
      out.write("            z-index: 1;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container.active .sign-up{\n");
      out.write("            transform: translateX(100%);\n");
      out.write("            opacity: 1;\n");
      out.write("            z-index: 5;\n");
      out.write("            animation: move 0.6s;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        @keyframes move{\n");
      out.write("            0%, 49.99%{\n");
      out.write("                opacity: 0;\n");
      out.write("                z-index: 1;\n");
      out.write("            }\n");
      out.write("            50%, 100%{\n");
      out.write("                opacity: 1;\n");
      out.write("                z-index: 5;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .social-icons{\n");
      out.write("            margin: 20px 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .social-icons a{\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 20%;\n");
      out.write("            display: inline-flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            margin: 0 3px;\n");
      out.write("            width: 40px;\n");
      out.write("            height: 40px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .toggle-container{\n");
      out.write("            position: absolute;\n");
      out.write("            top: 0;\n");
      out.write("            left: 50%;\n");
      out.write("            width: 50%;\n");
      out.write("            height: 100%;\n");
      out.write("            overflow: hidden;\n");
      out.write("            transition: all 0.6s ease-in-out;\n");
      out.write("            border-radius: 150px 0 0 100px;\n");
      out.write("            z-index: 1000;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container.active .toggle-container{\n");
      out.write("            transform: translateX(-100%);\n");
      out.write("            border-radius: 0 150px 100px 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .toggle{\n");
      out.write("            background-color: #512da8;\n");
      out.write("            height: 100%;\n");
      out.write("            background: linear-gradient(to right, #2b2d42, #2b2d42);\n");
      out.write("            color: #fff;\n");
      out.write("            position: relative;\n");
      out.write("            left: -100%;\n");
      out.write("            height: 100%;\n");
      out.write("            width: 200%;\n");
      out.write("            transform: translateX(0);\n");
      out.write("            transition: all 0.6s ease-in-out;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container.active .toggle{\n");
      out.write("            transform: translateX(50%);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .toggle-panel{\n");
      out.write("            position: absolute;\n");
      out.write("            width: 50%;\n");
      out.write("            height: 100%;\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("            justify-content: center;\n");
      out.write("            flex-direction: column;\n");
      out.write("            padding: 0 30px;\n");
      out.write("            text-align: center;\n");
      out.write("            top: 0;\n");
      out.write("            transform: translateX(0);\n");
      out.write("            transition: all 0.6s ease-in-out;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .toggle-left{\n");
      out.write("            transform: translateX(-200%);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container.active .toggle-left{\n");
      out.write("            transform: translateX(0);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .toggle-right{\n");
      out.write("            right: 0;\n");
      out.write("            transform: translateX(0);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container.active .toggle-right{\n");
      out.write("            transform: translateX(200%);\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");

    // Handle sign up
    if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("signup") != null) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/colab", "root", "");
            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.executeUpdate();
            conn.close();
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Registration failed. Please try again.</p>");
        }
    }

    // Handle sign in
    if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("signin") != null) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/colab", "root", "");
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
              HttpSession s = request.getSession();
                s.setAttribute("userEmail", email);
                response.sendRedirect("newjsp.jsp");
            } else {
                out.println("<p>Invalid email or password.</p>");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Login failed. Please try again.</p>");
        }
    }

      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"container\" id=\"container\">\n");
      out.write("        <div class=\"form-container sign-up\">\n");
      out.write("            <form method=\"post\">\n");
      out.write("                <h1>Create Account</h1>\n");
      out.write("                <span>or use your email for registration</span>\n");
      out.write("                <input type=\"text\" name=\"name\" placeholder=\"Name\" required>\n");
      out.write("                <input type=\"email\" name=\"email\" placeholder=\"Email\" required>\n");
      out.write("                <input type=\"password\" name=\"password\" placeholder=\"Password\" required>\n");
      out.write("                <button type=\"submit\" name=\"signup\">Sign Up</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-container sign-in\">\n");
      out.write("            <form method=\"post\">\n");
      out.write("                <h1>Sign In</h1>\n");
      out.write("                <span>or use your email account</span>\n");
      out.write("                <input type=\"email\" name=\"email\" placeholder=\"Email\" required>\n");
      out.write("                <input type=\"password\" name=\"password\" placeholder=\"Password\" required>\n");
      out.write("                <a href=\"#\">Forgot Your Password?</a>\n");
      out.write("                <button type=\"submit\" name=\"signin\">Sign In</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"toggle-container\">\n");
      out.write("            <div class=\"toggle\">\n");
      out.write("                <div class=\"toggle-panel toggle-left\">\n");
      out.write("                    <h1>Welcome Back!</h1>\n");
      out.write("                    <p>To keep connected with us please login with your personal info</p>\n");
      out.write("                    <button class=\"hidden\" id=\"login\">Sign In</button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"toggle-panel toggle-right\">\n");
      out.write("                    <h1>Hello, Friend!</h1>\n");
      out.write("                    <p>Enter your personal details and start journey with us</p>\n");
      out.write("                    <button class=\"hidden\" id=\"register\">Sign Up</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        const container = document.getElementById('container');\n");
      out.write("        const registerBtn = document.getElementById('register');\n");
      out.write("        const loginBtn = document.getElementById('login');\n");
      out.write("\n");
      out.write("        registerBtn.addEventListener('click', () => {\n");
      out.write("            container.classList.add(\"active\");\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        loginBtn.addEventListener('click', () => {\n");
      out.write("            container.classList.remove(\"active\");\n");
      out.write("        });\n");
      out.write("    </script>\n");
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
