package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();

	       
	            int num1 = Integer.parseInt(request.getParameter("num1"));
	            int num2 = Integer.parseInt(request.getParameter("num2"));
	            String operator = request.getParameter("operator");
	            boolean calc0k = true;
	            double result = 0.0;
	            switch (operator) {
	                case "plus": result = num1 + num2; break;
	                case "mus": result = num1 - num2; break;
	                case "multiply": result = num1 * num2; break;
	                case "ahr": 
	                	if(num2 !=0){
	                		result = (double) num1 / num2; 
	                	} else {
	                		calc0k = false;
	                		
	                	}
	                	break;
	                case "skajwl":  
	                	if(num2!=0)
	                		result = num1 % num2; 
	                	else
	                		calc0k = false;
	                	
	                	break;
	            }
	            if(!calc0k) {
	            	out.println("<html><body>");
	 	            out.println("<h1>계산 결과</h1>");
	 	            out.println("<p>결과: 0으로 나눌수 없습니다.</p>");
	 	            out.println("</body></html>"); 
	            	out.println("");
	            } else {
	            out.println("<html><body>");
	            out.println("<h1>계산 결과</h1>");
	            out.println("<p>결과: " + result + "</p>");
	            out.println("</body></html>");   
	            }
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	doGet(request, response);
	    }

	}
