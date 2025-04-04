package SistemaDeProdutos;

import static javax.swing.JOptionPane.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;


public class Program {

    private Produto[] produtos = new Produto[5];
    private int indexProduto = 0;

    public void menu() {
        String aux = "\n1- Cadastrar Produto";
        aux += "\n2- Buscar informações do Produto";
        aux += "\n3- Atualizar quantidade em Estoque";
        aux += "\n4- Exbiir Produtos com Estoque baixo";
        aux += "\n5- Exibir relatório";
        aux += "\n6- Encerrar programa";


        int opcao;
        int resposta;

        while (true) {
            opcao = parseInt(showInputDialog(aux));
            if (opcao == 6) {
                resposta = showConfirmDialog(null, "Você tem certeza que deseja encerrar o Programa?");
                if (resposta == YES_OPTION)
                    break;
                else if (opcao > 5 || opcao < 0)
                    showMessageDialog(null, "A opção deve estar entre 1 e 5");
                else {
                    switch (opcao) {
                        case 1:
                            cadastrarProduto();
                            break;
                        case 2:
                            buscarProduto();
                            break;
                    }
                }
            }
        }
    }

    //Método que pesquisa o nome do produto
    public Produto pesquisarProduto(String nomeProduto) {
        while (indexProduto < produtos.length) {
            if (produtos[indexProduto].getNome().equalsIgnoreCase(nomeProduto)) {
                return produtos[indexProduto];
            }
        }
        return null;
    }

    //Método reponsável por cadastrar o produto no array
    public void cadastrarProduto() {

        int codigo = parseInt((showInputDialog("Digite o codigo do produto")));
        String nome = showInputDialog("Digite o nome do produto");
        int qtdEstoque = parseInt(showInputDialog(("Digite a quantidade de Estoque")));
        double preco = parseDouble(showInputDialog("Digite o preço do produto"));

        produtos[indexProduto] = new Produto(codigo, nome, qtdEstoque, preco);
        indexProduto++;
    }

    //Método responsável por buscar o produto no array para exibir o nome a quantidade de estoque e o preco
    public void buscarProduto() {
        Produto p;
        String nomeProduto = showInputDialog("Digite o nome do produto");
        p = pesquisarProduto(nomeProduto);
        if (p != null)
            showMessageDialog(null, p.getDados());
        else
            showMessageDialog(null, "Produto não encontrado!");


    }
}
