package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/associarProdutoCliente")
public class AssociarProdutoClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clienteId = Integer.parseInt(request.getParameter("clienteId"));
        int produtoId = Integer.parseInt(request.getParameter("produtoId"));

        Cliente cliente = AdicionarClienteServlet.getClientes().stream()
                .filter(c -> c.getId() == clienteId)
                .findFirst()
                .orElse(null);

        Produto produto = AdicionarProdutoServlet.getProdutos().stream()
                .filter(p -> p.getId() == produtoId)
                .findFirst()
                .orElse(null);

        if (cliente != null && produto != null) {
            cliente.adicionarProduto(produto);
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Produto associado ao cliente com sucesso!</h1>");
            out.println("</body></html>");
        } else {
        	PrintWriter out = response.getWriter();
        	out.println("<html><body>");
            out.println("<h1>Cliente ou produto nao encontrado.</h1>");
            out.println("</body></html>");
            response.getWriter().println("");
        }
        response.getWriter().println("<a href='index.html'>Voltar</a>");
    }
}