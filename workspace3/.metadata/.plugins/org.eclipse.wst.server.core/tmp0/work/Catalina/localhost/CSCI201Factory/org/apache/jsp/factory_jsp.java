/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M15
 * Generated at: 2017-02-08 22:21:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import utilities.ColorTools;

public final class factory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("utilities.ColorTools");
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
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<!--This hur is important. -->\n");

	ColorTools colorTools = new ColorTools();
	int r = colorTools.getRed();
	int g = colorTools.getGreen();
	int b = colorTools.getBlue();

	String name = (String) session.getAttribute("name");
	String color = (String) session.getAttribute("color");

      out.write("\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>CSCI201 Factory Simulator</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"css/main.css\">\n");
      out.write("<script src=\"js/WebSocketEndpoint.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"js/Factory.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"js/FactoryWorker.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"js/FactoryResource.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"js/FactoryWall.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"js/FactoryTaskBoard.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write(".colorable {\n");
      out.write("\tbackground-color: ");
      out.print(color);
      out.write(";\n");
      out.write("}\n");
      out.write("\n");
      out.write("#factory-controller-container {\n");
      out.write("\tbackground-color: rgb(");
      out.print(r);
      out.write(',');
      out.write(' ');
      out.print(g);
      out.write(',');
      out.write(' ');
      out.print(b);
      out.write(");\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<table id=\"factory-container\">\n");
      out.write("\t\t<tr id=\"factory-container-top\">\n");
      out.write("\t\t\t<td id=\"factory-simulation-container\"><span\n");
      out.write("\t\t\t\tid=\"factory-simulation-heading\"></span>\n");
      out.write("\t\t\t\t<div id=\"factory-simulation-container2\">\n");
      out.write("\t\t\t\t\t<table id=\"factory-simulation\"></table>\n");
      out.write("\t\t\t\t</div></td>\n");
      out.write("\t\t\t<td class=\"colorable\" id=\"factory-product-table-container\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t<h3 style=\"text-align: center;\"> Manager: ");
      out.print(name);
      out.write("</h3>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t<table id=\"factory-product-table\"></table> <!-- This hur is important -->\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<form name=\"managerNotes\"\n");
      out.write("\t\t\t\t\taction=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/NotesServlet\"\n");
      out.write("\t\t\t\t\tmethod=\"GET\"></form>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr id=\"factory-container-bottom\">\n");
      out.write("\t\t\t<td class=\"colorable\" id=\"factory-messages-container\">\n");
      out.write("\t\t\t\t<ul id=\"factory-messages\">\n");
      out.write("\t\t\t\t\t<li>Waiting for factory configuration from server...</li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t<td class=\"colorable\">\n");
      out.write("\t\t\t\t<button id=\"open-factory-controller\">Controller</button>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t</table>\n");
      out.write("\t<div id=\"factory-controller-container\" class=\"popup\">\n");
      out.write("\t\t<div class=\"popup-heading\">Factory Controller</div>\n");
      out.write("\t\t<div class=\"popup-close\">close</div>\n");
      out.write("\t\t<div id=\"factory-controller-buttons\">\n");
      out.write("\t\t\t<button id=\"factory-controller-pause\">Pause</button>\n");
      out.write("\t\t\t<button id=\"factory-controller-continue\">Continue</button>\n");
      out.write("\t\t\t<button id=\"factory-controller-reset\">Reset</button>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"factory-slider-container\">\n");
      out.write("\t\t\t<b>Speed Controller:</b> <input type=\"range\" id=\"factory-slider\"\n");
      out.write("\t\t\t\tvalue=50 />\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
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
