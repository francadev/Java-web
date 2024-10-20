package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editarProduto")
public class EditarProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Produto produto = null;

        for (Produto p : AdicionarProdutoServlet.getProdutos()) {
            if (p.getId() == id) {
                produto = p;
                break;
            }
        }

        response.setContentType("text/html");
        StringBuilder htmlResponse = new StringBuilder();
        htmlResponse.append("<html><head><title>Editar Produto</title></head><body>");
        
        if (produto != null) {
            htmlResponse.append("<h1>Editar Produto</h1>");
            htmlResponse.append("<form action='atualizarProduto' method='post'>");
            htmlResponse.append("<input type='hidden' name='id' value='").append(produto.getId()).append("'/>");
            htmlResponse.append("<label for='nome'>Nome:</label>");
            htmlResponse.append("<input type='text' id='nome' name='nome' value='").append(produto.getNome()).append("' required/>");
            htmlResponse.append("<br>");
            htmlResponse.append("<label for='preco'>Preço:</label>");
            htmlResponse.append("<input type='text' id='preco' name='preco' value='").append(produto.getPreco()).append("' required/>");
            htmlResponse.append("<br>");
            htmlResponse.append("<button type='submit'>Atualizar</button>");
            htmlResponse.append("</form>");
        } else {
            htmlResponse.append("<h1>Produto não encontrado!</h1>");
        }

        htmlResponse.append("<a href='listarProdutos'>Voltar</a>");
        htmlResponse.append("</body></html>");

        response.getWriter().write(htmlResponse.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        double preco = Double.parseDouble(request.getParameter("preco"));
        
        for (Produto p : AdicionarProdutoServlet.getProdutos()) {
            if (p.getId() == id) {
                p.setNome(nome);
                p.setPreco(preco);
                break;
            }
        }

        response.sendRedirect("listarProdutos");
    }
}