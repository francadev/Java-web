package br.edu.ifsp.tads.dswl6;

import java.util.ArrayList;

public class Cliente {
    private int id;
    private String nome;
    private ArrayList<Produto> produtosComprados;

    public Cliente(int id, String nome, ArrayList<?> arrayList) {
        this.id = id;
        this.nome = nome;
        this.produtosComprados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Produto> getProdutosComprados() {
        return produtosComprados;
    }

    public void adicionarProduto(Produto produto) {
        produtosComprados.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtosComprados.remove(produto);
    }
}
