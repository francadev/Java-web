package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removerCliente")
public class RemoverClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        AdicionarClienteServlet.getClientes().removeIf(c -> c.getId() == id);
        
        response.sendRedirect("listarClientes");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        response.setContentType("text/html");
        StringBuilder htmlResponse = new StringBuilder();
        htmlResponse.append("<html><head><title>Remover cliente</title></head><body>");
        htmlResponse.append("<h1>Confirmar remoção</h1>");
        htmlResponse.append("<p>Você tem certeza que deseja remover o cliente com ID: ").append(id).append("?</p>");
        htmlResponse.append("<form action='removerCliente' method='post'>");
        htmlResponse.append("<input type='hidden' name='id' value='").append(id).append("'/>");
        htmlResponse.append("<button type='submit'>Confirmar</button>");
        htmlResponse.append("</form>");
        htmlResponse.append("<a href='listarClientes'>Cancelar</a>");
        htmlResponse.append("</body></html>");
        response.getWriter().write(htmlResponse.toString());
    }
}
