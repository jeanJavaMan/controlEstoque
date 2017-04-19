package jeanderson.br.testes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import jeanderson.br.produtos.Produto;
import jeanderson.br.serializacao.BancoProdutos;

public class Testes {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Produto obj = new Produto("Teste", 10, 17.50,"teste");
        BancoProdutos produtos = new BancoProdutos();
        produtos.addProduto(obj);
        File arquivo = new File("/Users/"+System.getProperty("user.name")+"/Documents/Testando/bancoDados.dat");
        File dir = new File("/Users/"+System.getProperty("user.name")+"/Documents/Testando");
        dir.mkdir();
        
        
        
        if (arquivo.exists()) {
            FileInputStream recup = new FileInputStream("/Users/"+System.getProperty("user.name")+"/Documents/Testando/bancoDados.dat");
            ObjectInputStream recupLer = new ObjectInputStream(recup);
            BancoProdutos produtos2 = new BancoProdutos();
            produtos2.recebeproduto(((BancoProdutos) recupLer.readObject()));
            recupLer.close();
            recup.close();
            produtos2.addProduto(obj);
            FileOutputStream arqGravar = new FileOutputStream("/Users/"+System.getProperty("user.name")+"/Documents/Testando/bancoDados.dat");
            ObjectOutputStream objGravar = new ObjectOutputStream(arqGravar);
            objGravar.writeObject(produtos2);
            objGravar.flush();
            objGravar.close();
            arqGravar.flush();
            arqGravar.close();

        } else {
            FileOutputStream arqGravar = new FileOutputStream("/Users/"+System.getProperty("user.name")+"/Documents/Testando/bancoDados.dat");
            ObjectOutputStream objGravar = new ObjectOutputStream(arqGravar);
            objGravar.writeObject(produtos);
            objGravar.flush();
            objGravar.close();
            arqGravar.flush();
            arqGravar.close();
        }
        FileInputStream arqLer = new FileInputStream("/Users/"+System.getProperty("user.name")+"/Documents/Testando/bancoDados.dat");
        ObjectInputStream ler = new ObjectInputStream(arqLer);
        System.out.println(((BancoProdutos)ler.readObject()).getProdutos().get(0).getNome());

    }

}
