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
        aux += "\n5- Exibir todos os Produtos da Lista";
        aux += "\n6- Encerrar programa";


        int opcao;
        int resposta;

        while (true) {
            opcao = parseInt(showInputDialog(aux));
            if (opcao == 6) {
                resposta = showConfirmDialog(null, "Você tem certeza que deseja encerrar o Programa?");
                if (resposta == YES_OPTION)
                    break;
            } else if (opcao > 5 || opcao < 0)
                showMessageDialog(null, "A opção deve estar entre 1 e 5");
            else {
                switch (opcao) {
                    case 1:
                        cadastrarProduto();
                        break;
                    case 2:
                        buscarProduto();
                        break;
                    case 3:
                        atualizarQuantidadeEstoque();
                        break;
                    case 4:

                    case 5:
                        exibirProdutos();
                        break;
                }
            }
        }
    }

    //Método que pesquisa o nome do produto
    private Produto pesquisarProduto() {
        String nomeProduto = showInputDialog("Digite o nome do produto");

//        for (int i = 0; i < produtos.length; i++) {
//            if (produtos[i].getNome().equals(nomeProduto)) {
//                return produtos[i];
//            }
//        }
//        return null;
        for (int i = 0; i < indexProduto; i++) {
            if (produtos[i].getNome().equalsIgnoreCase(nomeProduto)) {
                return produtos[i];
            }
        }
        return null;
    }

    //Método reponsável por cadastrar o produto no array
    private void cadastrarProduto() {

        int codigo = parseInt((showInputDialog("Digite o codigo do produto")));
        String nome = showInputDialog("Digite o nome do produto");
        int qtdEstoque = parseInt(showInputDialog(("Digite a quantidade de Estoque")));
        double preco = parseDouble(showInputDialog("Digite o preço do produto"));

        produtos[indexProduto] = new Produto(codigo, nome, qtdEstoque, preco);
        indexProduto++;
    }

    //Método responsável por buscar o produto no array para exibir o nome a quantidade de estoque e o preco
    private void buscarProduto() {
        Produto p;
        p = pesquisarProduto();
        if (p != null)
            showMessageDialog(null, p.getDados());
        else
            showMessageDialog(null, "Produto não encontrado!");
    }

    //Método para atualizar a quantidade de estoque do produto
    private void atualizarQuantidadeEstoque() {
        Produto p = pesquisarProduto();
        int qtd = 0;
        if(p == null)
            showMessageDialog(null, "Produto não encontrado!");
        else
            qtd = parseInt(showInputDialog("Digite a quantidade de Estoque que você deseja atualizar"));
            p.setQuantidadeEstoque(qtd);
    }

    private void exibirProdutos() {
        for (int i = 0; i < indexProduto; i++) {
            showMessageDialog(null, produtos[i].getDados());
        }
    }

}
