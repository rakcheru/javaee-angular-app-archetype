package org.learning.app.servlet;

import org.learning.app.ejb.stateless.StatelessEjb;
import org.learning.app.utility.Calculator;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AppServlet extends HttpServlet {
  
  @Inject
  Calculator calculator;
  
  @Inject
  StatelessEjb statelessEjb;
  
  public AppServlet() {
    super();
    System.out.println("AppServlet.AppServlet");
  }
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    resp.setContentType("text/html");
  
    PrintWriter pw = resp.getWriter();
    
    pw.println("Calculator => 2 + 3 = " + calculator.sum(2, 3));
    pw.println("<br>");
    pw.println("Calculator (EJB) => 6 + 2 = " + statelessEjb.delegatedSum(6, 2));
    pw.println("<br>");
    pw.println("Unit Converter(EJB) => 5.08 cm = " + statelessEjb.convertCmToInches(5.08) + " inches");
    pw.println("<br>");
    pw.println("Pi value (EJB) = " + statelessEjb.getPiValue());
    pw.println("<br>");
    pw.println(statelessEjb.createAndGetAll());
    pw.println("<br>");
    pw.println("<a href='https://google.com'>Google</a>");
  
  }
}
