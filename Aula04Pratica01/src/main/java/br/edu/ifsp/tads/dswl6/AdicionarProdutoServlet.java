package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/adicionarProduto")
public class AdicionarProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static ArrayList<Produto> produtos = new ArrayList<>();
    private static int produtoIdCounter = 1;

    public static ArrayList<Produto> getProdutos() {
        return produtos;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        StringBuilder htmlResponse = new StringBuilder();
        htmlResponse.append("<html><head><title>Adicionar Produto</title></head><body>");
        
        String nome = request.getParameter("nome");
        double preco = 0.0;

        try {
            preco = Double.parseDouble(request.getParameter("preco"));
            Produto novoProduto = new Produto(produtoIdCounter++, nome, preco);
            produtos.add(novoProduto);

            htmlResponse.append("<h1>Produto Adicionado com Sucesso!</h1>");
            htmlResponse.append("<p>ID: ").append(novoProduto.getId()).append("</p>");
            htmlResponse.append("<p>Nome: ").append(novoProduto.getNome()).append("</p>");
            htmlResponse.append("<p>Preço: R$ ").append(String.format("%.2f", novoProduto.getPreco())).append("</p>");
        } catch (NumberFormatException e) {
            htmlResponse.append("<h1>Erro ao Adicionar Produto</h1>");
            htmlResponse.append("<p>Preço inválido!</p>");
        } catch (Exception e) {
            htmlResponse.append("<h1>Erro ao Adicionar Produto</h1>");
            htmlResponse.append("<p>Ocorreu um erro inesperado!</p>");
        }

        htmlResponse.append("<a href='index.html'>Voltar</a>");
        htmlResponse.append("</body></html>");

        response.getWriter().write(htmlResponse.toString());
    }
}
