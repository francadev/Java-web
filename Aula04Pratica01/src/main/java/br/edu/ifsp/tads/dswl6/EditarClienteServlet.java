package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editarCliente")
public class EditarClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = null;

        for (Cliente c : AdicionarClienteServlet.getClientes()) {
            if (c.getId() == id) {
                cliente = c;
                break;
            }
        }

        response.setContentType("text/html");
        StringBuilder htmlResponse = new StringBuilder();
        htmlResponse.append("<html><head><title>Editar cliente</title></head><body>");
        
        if (cliente != null) {
            htmlResponse.append("<h1>Editar cliente</h1>");
            htmlResponse.append("<form action='atualizarCliente' method='post'>");
            htmlResponse.append("<input type='hidden' name='id' value='").append(cliente.getId()).append("'/>");
            htmlResponse.append("<label for='nome'>Nome:</label>");
            htmlResponse.append("<input type='text' id='nome' name='nome' value='").append(cliente.getNome()).append("' required/>");
            htmlResponse.append("<br>");
            htmlResponse.append("<button type='submit'>Atualizar</button>");
            htmlResponse.append("</form>");
        } else {
            htmlResponse.append("<h1>Cliente não encontrado!</h1>");
        }

        htmlResponse.append("<a href='listarClientes'>Voltar</a>");
        htmlResponse.append("</body></html>");

        response.getWriter().write(htmlResponse.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        
        for (Cliente c : AdicionarClienteServlet.getClientes()) {
            if (c.getId() == id) {
                c.setNome(nome);
                break;
            }
        }

        response.sendRedirect("listarClientes");
    }
}
