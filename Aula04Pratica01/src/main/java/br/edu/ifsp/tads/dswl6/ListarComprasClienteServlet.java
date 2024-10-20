package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/listarComprasCliente")
public class ListarComprasClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String clienteIdParam = request.getParameter("clienteId");

        if (clienteIdParam != null) {
            try {
                int clienteId = Integer.parseInt(clienteIdParam);

                List<Cliente> clientes = AdicionarClienteServlet.getClientes();
                Cliente cliente = null;

                for (Cliente c : clientes) {
                    if (c.getId() == clienteId) {
                        cliente = c;
                        break;
                    }
                }

                if (cliente != null) {
                    out.println("<html><body>");
                    out.println("<h1>Compras do cliente: " + cliente.getNome() + "</h1>");

                    List<Produto> produtosComprados = cliente.getProdutosComprados();

                    if (produtosComprados.isEmpty()) {
                        out.println("<p>Este cliente ainda não comprou produtos.</p>");
                    } else {
                        out.println("<ul>");
                        for (Produto produto : produtosComprados) {
                            out.println("<li>" + produto.getNome() + " - R$ " + produto.getPreco() + " ");
                            out.println("<form action='removerProdutoDaCompra' method='post' style='display:inline;'>");
                            out.println("<input type='hidden' name='clienteId' value='" + clienteId + "'/>");
                            out.println("<input type='hidden' name='produtoId' value='" + produto.getId() + "'/>");
                            out.println("<button type='submit'>Remover</button>");
                            out.println("</form>");
                            out.println("</li>");
                        }
                        out.println("</ul>");
                    }

                    out.println("<a href='index.html'>Voltar</a>");
                    out.println("</body></html>");
                } else {
                    out.println("<p>Cliente não encontrado</p>");
                    out.println("<a href='index.html'>Voltar</a>");
                }
            } catch (NumberFormatException e) {
                out.println("<p>ID de cliente inválido</p>");
                out.println("<a href='index.html'>Voltar</a>");
            }
        } else {
            out.println("<p>ID de cliente não fornecido</p>");
            out.println("<a href='index.html'>Voltar</a>");
        }
    }
}