package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Exercicio04
 */
//@WebServlet("/Exercicio04")
public class Exercicio04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercicio04() {
        super();
        // TODO Auto-generated constructor stub
    }

    private int contadorAcessos = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        contadorAcessos++;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<html>");
        out.println("<head><title>Contador de Acessos</title></head>");
        out.println("<body>");
        out.println("<h1>Contador de Acessos</h1>");
        out.println("<p>Este servlet foi acessado " + contadorAcessos + " vezes.</p>");
        out.println("</body>");
        out.println("</html>");
    }

}
