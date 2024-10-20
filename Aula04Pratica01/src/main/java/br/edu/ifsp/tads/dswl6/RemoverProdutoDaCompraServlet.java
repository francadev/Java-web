package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/removerProdutoDaCompra")
public class RemoverProdutoDaCompraServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clienteId = Integer.parseInt(request.getParameter("clienteId"));
        int produtoId = Integer.parseInt(request.getParameter("produtoId"));

        Cliente cliente = null;
        for (Cliente c : AdicionarClienteServlet.getClientes()) {
            if (c.getId() == clienteId) {
                cliente = c;
                break;
            }
        }

        if (cliente != null) {
            List<Produto> produtosComprados = cliente.getProdutosComprados();
            boolean produtoRemovido = false;

            for (Produto produto : produtosComprados) {
                if (produto.getId() == produtoId) {
                    produtosComprados.remove(produto);
                    produtoRemovido = true;
                    break;
                }
            }

            if (!produtoRemovido) {
                System.out.println("Produto não encontrado na lista de compras.");
            }
        }

        response.sendRedirect("listarComprasCliente?clienteId=" + clienteId);
    }
}
