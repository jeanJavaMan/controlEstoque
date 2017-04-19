package jeanderson.br.serializacao;

import java.io.Serializable;
import java.util.ArrayList;
import jeanderson.br.produtos.Produto;

public class BancoProdutos implements Serializable {

    private ArrayList<Produto> produtos = new ArrayList<>();

    public boolean addProduto(Produto obj) {
        //caso já exista um produto com o mesmo nome
        for (int i = 0; i < this.produtos.size(); i++) {
            if (this.produtos.get(i).getNome().equals(obj.getNome())) {
                return true;
            }
        }
        this.produtos.add(obj);
        return false;
    }

    public ArrayList<Produto> getProdutos() {
        return this.produtos;
    }

    public void recebeproduto(BancoProdutos obj) {
        if (obj == null) {
            System.out.println("Objeto Nulo, recebeProduto");
        } else {
            this.produtos = obj.getProdutos();
            
        }
    }

    @Override
    public String toString() {
        return "BancoProdutos{" + "produtos=" + produtos + '}';
    }
    

}
