package SistemaDeProdutos;

import java.util.Random;

public class Produto {
    private int codigo;
    private String nome;
    private int quantidadeEstoque;
    private double preco;

    public Produto(int codigo, String nome, int quantidadeEstoque, double preco) {
        this.codigo = validarCodigo(codigo);
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
    }

    public int validarCodigo(int codigo) {
        Random rand = new Random();
        if (codigo > 50 || codigo < 0)
            return this.codigo = rand.nextInt(0, 51);
        return codigo;
    }

    public String getDados() {
        return "Produto: "+ nome + "\n" +  "Quantidade de Estoque: " + quantidadeEstoque + "\n" + "Preço: "+ preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
