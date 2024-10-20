package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/adicionarCliente")
public class AdicionarClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static List<Cliente> clientes = new ArrayList<>();
    public static List<Cliente> getClientes() {
        return clientes;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        StringBuilder htmlResponse = new StringBuilder();

        htmlResponse.append("<html><head><title>Adicionar Cliente</title></head><body>");
        String nome = request.getParameter("nome");

        if (nome != null && !nome.isEmpty()) {
            int novoId = clientes.size() + 1;
            Cliente novoCliente = new Cliente(novoId, nome, new ArrayList<>());
            clientes.add(novoCliente);

            htmlResponse.append("<h1>Cliente Adicionado com Sucesso!</h1>");
            htmlResponse.append("<p>ID: ").append(novoCliente.getId()).append("</p>");
            htmlResponse.append("<p>Nome: ").append(novoCliente.getNome()).append("</p>");
        } else {
            htmlResponse.append("<h1>Erro ao Adicionar Cliente</h1>");
            htmlResponse.append("<p>Nome do cliente não pode estar vazio!</p>");
        }

        htmlResponse.append("<a href='index.html'>Voltar</a>");
        htmlResponse.append("</body></html>");

        response.getWriter().write(htmlResponse.toString());
    }
}