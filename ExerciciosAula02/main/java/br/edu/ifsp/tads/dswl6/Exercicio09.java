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
 * Servlet implementation class RemoverNomeServlet
 */
public class Exercicio09 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<String> nomes = new ArrayList<>();

    public Exercicio09() {
        super();
        nomes.add("Maria");
        nomes.add("João");
        nomes.add("Ana");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String nomeParaRemover = request.getParameter("nome");

        if (nomeParaRemover != null && nomes.contains(nomeParaRemover)) {
            nomes.remove(nomeParaRemover);
            out.println("<p>Nome removido: " + nomeParaRemover + "</p>");
        } else {
            if (nomeParaRemover != null) {
                out.println("<p>Nome não encontrado: " + nomeParaRemover + "</p>");
            }
        }

        out.println("<h1>Remover Nome</h1>");
        out.println("<form method='get' action='removeNome'>");
        out.println("Nome: <input type='text' name='nome' required><br>");
        out.println("<input type='submit' value='Remover Nome'>");
        out.println("</form>");

        out.println("<h2>Nomes na Lista</h2>");
        if (!nomes.isEmpty()) {
            out.println("<ul>");
            for (String nome : nomes) {
                out.println("<li>" + nome + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>A lista está vazia.</p>");
        }

        out.println("</body></html>");
    }
}
