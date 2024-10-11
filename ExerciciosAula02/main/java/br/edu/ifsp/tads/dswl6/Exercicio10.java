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
 * Servlet implementation class TodoListServlet
 */
public class Exercicio10 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<String> tarefas = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h1>Lista de Tarefas</h1>");
        
        out.println("<form method='post' action='todo'>");
        out.println("Tarefa: <input type='text' name='tarefa' required><br>");
        out.println("<input type='submit' value='Adicionar Tarefa'>");
        out.println("</form>");

        if (!tarefas.isEmpty()) {
            out.println("<h2>Tarefas Cadastradas</h2>");
            out.println("<ul>");
            for (String tarefa : tarefas) {
                out.println("<li>" + tarefa + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>Não há tarefas cadastradas.</p>");
        }

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String novaTarefa = request.getParameter("tarefa");

        if (novaTarefa != null && !novaTarefa.trim().isEmpty()) {
            tarefas.add(novaTarefa);
        }

        response.sendRedirect("todo");
    }
}
