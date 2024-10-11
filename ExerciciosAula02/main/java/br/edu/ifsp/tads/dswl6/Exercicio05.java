package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Exercicio05
 */
@WebServlet("/Exercicio05/addNome")
public class Exercicio05 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Lista para armazenar os nomes
    private List<String> nomes = new ArrayList<>();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exercicio05() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        if (nome != null && !nome.trim().isEmpty()) {
            nomes.add(nome);
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Nomes Armazenados:</h1>");
        out.println("<ul>");

        for (String n : nomes) {
            out.println("<li>" + n + "</li>");
        }

        out.println("</ul>");
        out.println("</body></html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
