package com.hyb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)  
    	    throws ServletException, IOException {  
    	        response.setContentType("text/html;charset=UTF-8");  
    	        PrintWriter out = response.getWriter();  
    	        try {  
    	            response.setContentType("text/html");  
    	            response.setHeader("Cache-Control", "no-store");  
    	            response.setHeader("Pragma", "no-cache");  
    	            response.setDateHeader("Expires", 0);  
    	            String name = request.getParameter("id");  
    	            if(name.equals("hyb")) {  
    	                out.write("OK");  
    	            }  
    	            else {  
    	                out.write("NO");  
    	            }  
    	        } finally {   
    	            out.close();  
    	        }  
    	    }   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	 @Override  
	    public String getServletInfo() {  
	        return "Short description";  
	    }  
	  

}
