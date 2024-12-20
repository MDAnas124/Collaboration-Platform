package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class proj_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>CoLab</title>\n");
      out.write("    <style>\n");
      out.write("        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap');\n");
      out.write("\n");
      out.write("        * {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        body {\n");
      out.write("            font-family: 'Poppins', sans-serif;\n");
      out.write("            background-color: whitesmoke;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .navbar {\n");
      out.write("            width: 100%;\n");
      out.write("            position: fixed;\n");
      out.write("            top: 0;\n");
      out.write("            background-color: #2b2d42;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: space-between;\n");
      out.write("            align-items: center;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            transition: 0.5s;\n");
      out.write("            z-index: 1000;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .navbar a {\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            color: whitesmoke;\n");
      out.write("            margin: 0 40px;\n");
      out.write("            font-weight: 700;\n");
      out.write("            text-decoration: none;\n");
      out.write("            transition: 0.4s all ease-in-out;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .navbar ul {\n");
      out.write("            display: flex;\n");
      out.write("            list-style: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .navbar a:hover {\n");
      out.write("            color: #676791;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .logo {\n");
      out.write("            width: 200px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .loginsign {\n");
      out.write("            background-color: transparent;\n");
      out.write("            border-radius: 20px;\n");
      out.write("            width: 200px;\n");
      out.write("            height: 40px;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            /*box-shadow: #373638 2px 1px 2px 0.5pc;*/\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .loginsign a:hover {\n");
      out.write("            color: #512da8;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .home {\n");
      out.write("            min-height: 100vh;\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            padding-top: 120px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .home h1 {\n");
      out.write("            font-size: 4rem;\n");
      out.write("            margin-bottom: 0px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .home h2 {\n");
      out.write("            font-size: 2.5rem;\n");
      out.write("            margin-bottom: 2px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .home_img {\n");
      out.write("            width: 100%;\n");
      out.write("            max-width: 800px;\n");
      out.write("            height: auto;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .aboutus {\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            justify-content: flex-start;\n");
      out.write("            align-items: center;\n");
      out.write("            min-height: 100vh;\n");
      out.write("            background-color: rgb(204, 197, 197);\n");
      out.write("            padding: 100px 20px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .aboutus h1 {\n");
      out.write("            font-weight: 1000;\n");
      out.write("            font-size: 3rem;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .aboutus p {\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            max-width: 800px;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card-container {\n");
      out.write("            display: flex;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("            justify-content: center;\n");
      out.write("            gap: 20px;\n");
      out.write("            max-width: 1200px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card {\n");
      out.write("            background-color: #fff;\n");
      out.write("            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);\n");
      out.write("            transition: 0.3s;\n");
      out.write("            border-radius: 20px;\n");
      out.write("            padding: 20px;\n");
      out.write("            max-width: 300px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card h2 {\n");
      out.write("            color: #512da8;\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .card p {\n");
      out.write("            color: #333;\n");
      out.write("            font-size: 1rem;\n");
      out.write("            text-align: justify;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .contactus {\n");
      out.write("            display: flex;\n");
      out.write("            flex-direction: column;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            min-height: 50vh;\n");
      out.write("            background-color: whitesmoke;\n");
      out.write("            padding: 40px 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .contactus h1 {\n");
      out.write("            font-size: 3rem;\n");
      out.write("            font-weight: 1000;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .contactus p {\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            text-align: center;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .contact-info {\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .contact-info p {\n");
      out.write("            font-size: 1.5rem;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .contact-info span {\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        span {\n");
      out.write("            color: #512da8;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("            h3{\n");
      out.write("             background-color: transparent;\n");
      out.write("            border-radius: 20px;\n");
      out.write("            width: 200px;\n");
      out.write("            height: 40px;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("\n");
      out.write("        @media (max-width: 768px) {\n");
      out.write("            .navbar a {\n");
      out.write("                font-size: 1.2rem;\n");
      out.write("                margin: 0 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .home h1 {\n");
      out.write("                font-size: 2.5rem;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .home h2 {\n");
      out.write("                font-size: 2rem;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .aboutus h1 {\n");
      out.write("                font-size: 2.5rem;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .aboutus p {\n");
      out.write("                font-size: 1.2rem;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .contactus h1 {\n");
      out.write("                font-size: 2.5rem;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .contactus p {\n");
      out.write("                font-size: 1.2rem;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .card {\n");
      out.write("                max-width: 90%;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <nav class=\"navbar\" id=\"navbar\">\n");
      out.write("            <h3>PROJNEST</h3>\n");
      out.write("            <ul>\n");
      out.write("                <li class=\"loginsign\"><a href=\"analyze.jsp\">analysis</a></li>\n");
      out.write("                <li class=\"loginsign\"><a href=\"login.jsp\">Login/SignUp</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <section id=\"home\" class=\"home\">\n");
      out.write("        <h1>Hello! <span class=\"auto-typed\"></span></h1>\n");
      out.write("        <h2>Welcome to PROJNEST!</h2>\n");
      out.write("        <img class=\"home_img\" src=\"replace.png\" alt=\"image\">\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <section id=\"aboutus\" class=\"aboutus\">\n");
      out.write("        <h1>About Us</h1>\n");
      out.write("        <p>CoLab is an inclusive web development platform that empowers students, developers, and teams to connect, collaborate, and build software across diverse domains. It fosters a collaborative environment where users can discover projects, showcase expertise, and form effective teams to bring ideas to life.</p>\n");
      out.write("\n");
      out.write("        <div class=\"card-container\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <h2>Our Vision</h2>\n");
      out.write("                <p>At CoLab, we envision a world where everyone, regardless of background or experience, can contribute to groundbreaking projects. We aim to create a space where innovation flourishes and ideas become reality through collective effort.</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <h2>Community Engagement</h2>\n");
      out.write("                <p>CoLab believes in the power of community. We host regular hackathons, webinars, and meetups to bring our users together. Our forums and discussion boards provide vibrant spaces to ask questions, share knowledge, and collaborate with peers globally.</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <h2>Join Us</h2>\n");
      out.write("                <p>Whether you're a solo developer, a student eager to learn, or a company seeking collaboration, CoLab has something to offer. Join us today and become part of a dynamic community reshaping the future of web development.</p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <h2>Our Commitment</h2>\n");
      out.write("                <p>We're dedicated to continuous improvement and innovation, valuing your feedback to make CoLab the ultimate platform for collaboration. Let's work together to create tools and features that meet your needs perfectly.</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <section class=\"contactus\">\n");
      out.write("        <h1>Contact Us</h1>\n");
      out.write("        <p>If you have any questions or need support, feel free to reach out to us:</p>\n");
      out.write("        <div class=\"contact-info\">\n");
      out.write("            <p>Phone Number: <span>29727507535</span></p>\n");
      out.write("            <p>Email: <span>info@colab.com</span></p>\n");
      out.write("            <p>Address: <span>123 CoLab Street, City, Country</span></p>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("    <script src=\"https://unpkg.com/typed.js@2.1.0/dist/typed.umd.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        var typed = new Typed(\".auto-typed\", {\n");
      out.write("            strings: [\"Developer\", \"Student\"],\n");
      out.write("            typeSpeed: 200,\n");
      out.write("            backSpeed: 70,\n");
      out.write("            loop: true\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("    <script src=\"https://unpkg.com/scrollreveal\"></script>\n");
      out.write("    <script>\n");
      out.write("        const scrollRevealOption = {\n");
      out.write("            distance: \"50px\",\n");
      out.write("            origin: \"bottom\",\n");
      out.write("            duration: 1000,\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        ScrollReveal().reveal(\".home_img\", {\n");
      out.write("            ...scrollRevealOption,\n");
      out.write("            delay: 200,\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        ScrollReveal().reveal(\".home h1\", {\n");
      out.write("            ...scrollRevealOption,\n");
      out.write("            delay: 400,\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        ScrollReveal().reveal(\".home h2\", {\n");
      out.write("            ...scrollRevealOption,\n");
      out.write("            delay: 600,\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        ScrollReveal().reveal(\".aboutus h1\", {\n");
      out.write("            ...scrollRevealOption,\n");
      out.write("            delay: 100,\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        ScrollReveal().reveal(\".aboutus p\", {\n");
      out.write("            ...scrollRevealOption,\n");
      out.write("            delay: 200,\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        ScrollReveal().reveal(\".card\", {\n");
      out.write("            ...scrollRevealOption,\n");
      out.write("            delay: 300,\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        ScrollReveal().reveal(\".contactus h1\", {\n");
      out.write("            ...scrollRevealOption,\n");
      out.write("            delay: 100,\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        ScrollReveal().reveal(\".contactus p\", {\n");
      out.write("            ...scrollRevealOption,\n");
      out.write("            delay: 200,\n");
      out.write("        });\n");
      out.write("\n");
      out.write("        ScrollReveal().reveal(\".contact-info\", {\n");
      out.write("            ...scrollRevealOption,\n");
      out.write("            delay: 300,\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</body>\n");
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
