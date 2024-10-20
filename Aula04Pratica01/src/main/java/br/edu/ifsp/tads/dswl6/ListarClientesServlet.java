package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listarClientes")
public class ListarClientesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        StringBuilder htmlResponse = new StringBuilder();
        htmlResponse.append("<html><head><title>Lista de clientes</title></head><body>");
        htmlResponse.append("<h1>Lista de clientes</h1>");

        List<Cliente> clientes = AdicionarClienteServlet.getClientes();

        if (clientes.isEmpty()) {
            htmlResponse.append("<p>Nenhum cliente cadastrado ainda.</p>");
        } else {
            for (Cliente cliente : clientes) {
                htmlResponse.append("<p>ID: ").append(cliente.getId())
                    .append(" - Nome: ").append(cliente.getNome())
                    .append(" - <a href='editarCliente?id=").append(cliente.getId()).append("'>Editar</a>")
                    .append(" - <a href='removerCliente?id=").append(cliente.getId()).append("'>Remover</a>")
                    .append("</p>");
            }
        }

        htmlResponse.append("<a href='index.html'>Voltar</a>");
        htmlResponse.append("</body></html>");

        response.getWriter().write(htmlResponse.toString());
    }
}