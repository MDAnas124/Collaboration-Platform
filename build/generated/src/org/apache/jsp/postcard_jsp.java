package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class postcard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Tweet Card</title>\n");
      out.write("    <style>\n");
      out.write("        /* Add your CSS styles here */\n");
      out.write("        .tweet-card {\n");
      out.write("            background-color: #fff;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("        .tweet-card .avatar {\n");
      out.write("            cursor: pointer;\n");
      out.write("            width: 40px;\n");
      out.write("            height: 40px;\n");
      out.write("            border-radius: 50%;\n");
      out.write("        }\n");
      out.write("        .tweet-card .username {\n");
      out.write("            font-weight: bold;\n");
      out.write("            margin-right: 10px;\n");
      out.write("        }\n");
      out.write("        .tweet-card .timestamp {\n");
      out.write("            color: #666;\n");
      out.write("            font-size: 0.8rem;\n");
      out.write("        }\n");
      out.write("        .tweet-card .content {\n");
      out.write("            margin-top: 10px;\n");
      out.write("        }\n");
      out.write("        .tweet-card .image {\n");
      out.write("            max-width: 100%;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            margin-top: 10px;\n");
      out.write("        }\n");
      out.write("        .tweet-card .actions {\n");
      out.write("            margin-top: 10px;\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("            justify-content: space-between;\n");
      out.write("        }\n");
      out.write("        .tweet-card .action {\n");
      out.write("            display: flex;\n");
      out.write("            align-items: center;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("        .tweet-card .action p {\n");
      out.write("            margin-left: 5px;\n");
      out.write("            color: #666;\n");
      out.write("        }\n");
      out.write("        .tweet-card .action.retweeted {\n");
      out.write("            color: #1e88e5;\n");
      out.write("        }\n");
      out.write("        .tweet-card .action.liked {\n");
      out.write("            color: #f50057;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"tweet-card\">\n");
      out.write("    <div class=\"flex space-x-5\">\n");
      out.write("        <a href=\"");
      out.print( request.getContextPath() );
      out.write("/profile/6\">\n");
      out.write("            <img class=\"avatar\" src=\"https://th.bing.com/th/id/OIP.FspfEEDx4Eqv7-IsrqaYhwHaEK?rs=1&pid=ImgDetMain.png\" alt=\"avatar\">\n");
      out.write("        </a>\n");
      out.write("        <div class=\"w-full\">\n");
      out.write("            <div class=\"flex justify-between items-center\">\n");
      out.write("                <div class=\"flex cursor-pointer items-center space-x-2\">\n");
      out.write("                    <span class=\"username\">Varshithreddy</span>\n");
      out.write("                    <span class=\"timestamp\">@varshithreddy . 2m</span>\n");
      out.write("                    <img class=\"ml-2 w-5 h-5\" src=\"https://th.bing.com/th?id=OIP.bqHONDoH01A9lATI5G8AlwHaHv&w=244&h=255&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2.png\" alt=\"verified\">\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <!-- Your dropdown or menu button here -->\n");
      out.write("                    <button onclick=\"toggleMenu()\">More</button>\n");
      out.write("                    <div id=\"menu\" style=\"display: none;\">\n");
      out.write("                        <a href=\"#\" onclick=\"handleDeleteTweet()\">Delete</a>\n");
      out.write("                        <a href=\"#\">Edit</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mt-2\">\n");
      out.write("                <div class=\"cursor-pointer\">\n");
      out.write("                    <p class=\"mb-2 p-0\">CoLab - hackathon</p>\n");
      out.write("                    <img class=\"image\" src=\"https://th.bing.com/th/id/OIP.aE29Ug82GDR8A4Dyf4u3awAAAA?rs=1&pid=ImgDetMain.png\" alt=\"tweet image\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"py-5 flex flex-wrap justify-between items-center\">\n");
      out.write("                    <div class=\"space-x-3 flex items-center text-gray-600\">\n");
      out.write("                        <div class=\"action\" onclick=\"handleOpenReplyModel()\">\n");
      out.write("                            <i class=\"far fa-comment\"></i>\n");
      out.write("                            <p>43</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"space-x-3 flex items-center text-gray-600\">\n");
      out.write("                        <div class=\"action retweet\" onclick=\"handleCreateRetweet()\">\n");
      out.write("                            <i class=\"fas fa-retweet\"></i>\n");
      out.write("                            <p>64</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"space-x-3 flex items-center text-gray-600\">\n");
      out.write("                        <div class=\"action like\" onclick=\"handleToggleLike()\">\n");
      out.write("                            <i class=\"far fa-heart\"></i>\n");
      out.write("                            <p>54</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"space-x-3 flex items-center text-gray-600\">\n");
      out.write("                        <div class=\"action\">\n");
      out.write("                            <i class=\"fas fa-chart-bar\"></i>\n");
      out.write("                            <p>430</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    function toggleMenu() {\n");
      out.write("        var menu = document.getElementById('menu');\n");
      out.write("        if (menu.style.display === 'none' || menu.style.display === '') {\n");
      out.write("            menu.style.display = 'block';\n");
      out.write("        } else {\n");
      out.write("            menu.style.display = 'none';\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function handleDeleteTweet() {\n");
      out.write("        console.log(\"delete Post\");\n");
      out.write("        // Add your delete logic here, e.g., send request to delete tweet from database\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function handleOpenReplyModel() {\n");
      out.write("        console.log(\"open model\");\n");
      out.write("        // Add logic to open reply modal or navigate to reply page\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function handleToggleLike() {\n");
      out.write("        var likeIcon = document.querySelector('.action.like i');\n");
      out.write("        if (likeIcon.classList.contains('far')) {\n");
      out.write("            likeIcon.classList.remove('far');\n");
      out.write("            likeIcon.classList.add('fas');\n");
      out.write("        } else {\n");
      out.write("            likeIcon.classList.remove('fas');\n");
      out.write("            likeIcon.classList.add('far');\n");
      out.write("        }\n");
      out.write("        // Add logic to update like status in database\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    function handleCreateRetweet() {\n");
      out.write("        var retweetIcon = document.querySelector('.action.retweet i');\n");
      out.write("        if (retweetIcon.classList.contains('fas')) {\n");
      out.write("            retweetIcon.classList.remove('fas');\n");
      out.write("            retweetIcon.classList.add('far');\n");
      out.write("        } else {\n");
      out.write("            retweetIcon.classList.remove('far');\n");
      out.write("            retweetIcon.classList.add('fas');\n");
      out.write("        }\n");
      out.write("        // Add logic to create or delete retweet in database\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
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
