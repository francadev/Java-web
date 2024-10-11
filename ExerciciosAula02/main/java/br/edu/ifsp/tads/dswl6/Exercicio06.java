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
 * Servlet implementation class ComentariosServlet
 */
@WebServlet("/Exercicio06/comentarios")
public class Exercicio06 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private List<String> comentarios = new ArrayList<>();
    
    public Exercicio06() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Enviar Comentário</h1>");
        
        out.println("<form method='POST' action='comentarios'>");
        out.println("Comentário: <input type='text' name='comentario' required>");
        out.println("<input type='submit' value='Enviar'>");
        out.println("</form>");

        out.println("<h2>Comentários Submetidos:</h2>");
        out.println("<ul>");
        for (String comentario : comentarios) {
            out.println("<li>" + comentario + "</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comentario = request.getParameter("comentario");
        if (comentario != null && !comentario.trim().isEmpty()) {
            comentarios.add(comentario);
        }
        doGet(request, response);
    }
}
