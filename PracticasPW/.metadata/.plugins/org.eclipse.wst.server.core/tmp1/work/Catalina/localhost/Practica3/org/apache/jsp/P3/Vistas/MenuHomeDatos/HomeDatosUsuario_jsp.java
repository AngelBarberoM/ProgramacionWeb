/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.82
 * Generated at: 2022-08-30 16:42:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.P3.Vistas.MenuHomeDatos;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import JavaBeans.CustomerBean;
import GeneralDTO.UsuarioDTO;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public final class HomeDatosUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("JavaBeans.CustomerBean");
    _jspx_imports_classes.add("java.time.format.DateTimeFormatter");
    _jspx_imports_classes.add("GeneralDTO.UsuarioDTO");
    _jspx_imports_classes.add("java.time.LocalDateTime");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);\r\n");
      out.write("	body{\r\n");
      out.write("		background: #9aafc7;\r\n");
      out.write("	   	font-family: 'Roboto', sans-serif;\r\n");
      out.write("	   	color: #fdfdfd;\r\n");
      out.write("	}\r\n");
      out.write("	h1{\r\n");
      out.write("		font-size: 2.4em;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("	}\r\n");
      out.write("	h2{\r\n");
      out.write("		font-size: 1.8em;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("	}\r\n");
      out.write("	.container {\r\n");
      out.write("    position:fixed;\r\n");
      out.write("    font-size: 1.2 em;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    vertical-align: center;\r\n");
      out.write("    top: 50%;\r\n");
      out.write("    left: 50%;\r\n");
      out.write("    width:50em;\r\n");
      out.write("    height:32em;\r\n");
      out.write("    margin-left: -25em; /*set to a negative number 1/2 of your width*/\r\n");
      out.write("    margin-top: -16em; /*set to a negative number 1/2 of your height*/\r\n");
      out.write("    border: 3px dotted #fdfdfd;\r\n");
      out.write("	}\r\n");
      out.write("	.static{\r\n");
      out.write("		text-align: center;\r\n");
      out.write("		height: 5em;\r\n");
      out.write("		font: italic bold 1em #fdfdfd;\r\n");
      out.write("		padding:2em;\r\n");
      out.write("		margin-top: 2em;\r\n");
      out.write("	}\r\n");
      out.write("	.var {\r\n");
      out.write("		text-align: center;\r\n");
      out.write("		height: 5em;\r\n");
      out.write("		font: bold .8em #fdfdfd;\r\n");
      out.write("		padding:2em;\r\n");
      out.write("		margin-top: 2em;\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("hr{\r\n");
      out.write("    border-top: 2px solid #fdfdfd;\r\n");
      out.write("	border-radius: 1px;\r\n");
      out.write("	text-align: center;\r\n");
      out.write("	padding: 0;\r\n");
      out.write("}\r\n");
      out.write("hr.a{\r\n");
      out.write("	width: 50%;\r\n");
      out.write("}\r\n");
      out.write("hr.b{\r\n");
      out.write("  width:45%;\r\n");
      out.write("}\r\n");
      out.write("hr.c{\r\n");
      out.write(" 	width: 40%;\r\n");
      out.write("}\r\n");
      out.write("hr.d{\r\n");
      out.write("	width: 35%;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      JavaBeans.CustomerBean customerBean = null;
      synchronized (session) {
        customerBean = (JavaBeans.CustomerBean) _jspx_page_context.getAttribute("customerBean", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (customerBean == null){
          customerBean = new JavaBeans.CustomerBean();
          _jspx_page_context.setAttribute("customerBean", customerBean, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<title>Datos de usuario</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../CabeceraNavegacion.jsp", out, false);
      out.write('\r');
      out.write('\n');
 
request.getSession().getAttribute("customerBean");
if (customerBean != null) {

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("<h1>Bienvenido al panel de usuario</h1>\r\n");
      out.write("<h2>Sus Datos son:</h2>\r\n");
      out.write("	<hr class=\"a\">\r\n");
      out.write("	<a class=\"static\">Nombre de Usuario:  </a><a class=\"var\">");
      out.print( customerBean.getUsername());
      out.write("</a>\r\n");
      out.write("	<hr class=\"b\">\r\n");
      out.write("	<a class=\"static\">Nombre:  </a><a class=\"var\">");
      out.print( customerBean.getName());
      out.write("</a>\r\n");
      out.write("	<hr class=\"c\">\r\n");
      out.write("	<a class=\"static\">Rol:  </a><a class=\"var\">");
      out.print( customerBean.getRol());
      out.write("</a>\r\n");
      out.write("	<hr class=\"d\">\r\n");
      out.write("	<a class=\"static\">Correo asociado:  </a><a class=\"var\">");
      out.print(customerBean.getEmailUser());
      out.write("</a>\r\n");
      out.write("	<hr class=\"c\">\r\n");
      out.write("	<a class=\"static\">Fecha de registro:  NULL</a>\r\n");
      out.write("	<a class=\"static\">Fecha de ultima conexión:  </a><a class=\"var\">");
      out.print( customerBean.getLoggedString());
      out.write("</a>\r\n");
      out.write("	<hr class=\"a\">\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");

	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}