package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class ContadorAcessosServlet
 */
public class Exercicio07 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private Map<String, Integer> contadorAcessos = new HashMap<>();
    
    public Exercicio07() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String nome = request.getParameter("nome");
        
        if (nome == null || nome.trim().isEmpty()) {
            out.println("<html><body>");
            out.println("<h1>Erro: Nome do usuário não fornecido!</h1>");
            out.println("</body></html>");
            return;
        }
        
        contadorAcessos.put(nome, contadorAcessos.getOrDefault(nome, 0) + 1);
        
        out.println("<html><body>");
        out.println("<h1>Olá, " + nome + "!</h1>");
        out.println("<p>Você já acessou esta página " + contadorAcessos.get(nome) + " vezes.</p>");
        out.println("<h2>Todos os acessos:</h2>");
        out.println("<ul>");
        for (Map.Entry<String, Integer> entry : contadorAcessos.entrySet()) {
            out.println("<li>" + entry.getKey() + ": " + entry.getValue() + " acessos</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }
}
