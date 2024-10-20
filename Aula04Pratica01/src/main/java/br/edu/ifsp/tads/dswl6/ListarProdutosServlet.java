package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listarProdutos")
public class ListarProdutosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        StringBuilder htmlResponse = new StringBuilder();
        htmlResponse.append("<html><head><title>Lista de produtos</title></head><body>");
        htmlResponse.append("<h1>Lista de produtos</h1>");

        List<Produto> produtos = AdicionarProdutoServlet.getProdutos();

        if (produtos.isEmpty()) {
            htmlResponse.append("<p>Nenhum produto cadastrado ainda.</p>");
        } else {
            for (Produto produto : produtos) {
                htmlResponse.append("<p>ID: ").append(produto.getId())
                    .append(" - Nome: ").append(produto.getNome())
                    .append(" - Preço: R$ ").append(produto.getPreco())
                    .append(" - <a href='editarProduto?id=").append(produto.getId()).append("'>Editar</a>")
                    .append(" - <a href='removerProduto?id=").append(produto.getId()).append("'>Remover</a>")
                    .append("</p>");
            }
        }

        htmlResponse.append("<a href='index.html'>Voltar</a>");
        htmlResponse.append("</body></html>");

        response.getWriter().write(htmlResponse.toString());
    }
}