package br.edu.ifsp.tads.dswl6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

/**
 * Servlet implementation class CadastroProdutoServlet
 */
public class Exercicio08 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private List<Produto> produtos = new ArrayList<>();

    public Exercicio08() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nomeProduto = request.getParameter("nomeProduto");
        String precoProdutoStr = request.getParameter("precoProduto");
        
        double precoProduto = 0;
        try {
            precoProduto = Double.parseDouble(precoProdutoStr);
        } catch (NumberFormatException e) {
            precoProduto = 0;
        }
        
        Produto produto = new Produto(nomeProduto, precoProduto);
        produtos.add(produto);
        
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Cadastro de Produtos</h1>");
        out.println("<form method='post' action='cadastroProduto'>");
        out.println("Nome do Produto: <input type='text' name='nomeProduto' required><br>");
        out.println("Preço do Produto: <input type='text' name='precoProduto' required><br>");
        out.println("<input type='submit' value='Cadastrar Produto'>");
        out.println("</form>");
        
        if (!produtos.isEmpty()) {
            out.println("<h2>Produtos Cadastrados</h2>");
            out.println("<ul>");
            for (Produto produto : produtos) {
                out.println("<li>" + produto.getNome() + " - R$ " + String.format("%.2f", produto.getPreco()) + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>Nenhum produto cadastrado ainda.</p>");
        }

        out.println("</body></html>");
    }
}
