package br.edu.ifsp.tads.dswl6;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Exercicio01 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><p1> Boa noite! </p1></html>");
    }

}
