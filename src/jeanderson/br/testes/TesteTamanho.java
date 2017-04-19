/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.testes;

import java.io.File;
import jeanderson.br.funcoes.Atualizacao;

/**
 *
 * @author Jeanderson S.Lopes
 */
public class TesteTamanho {

    public static void main(String[] args) {
//        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Dropbox/Aplicativo/Mobile/ControlEstoque.apk");
//        int tamanho = (int) arquivo.length();
//        System.out.println(tamanho);
        String[] nomes = new String[3];
        nomes[0] = "Jean";
        nomes[1] = "Carlos";
        //nomes[2] = "Andre";
        int quantidade = 0;
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] == null) {
                break;
            } else {
                quantidade++;
            }

        }

        String[] novamemoria = new String[5];
        nomes = novamemoria;

        System.out.println(nomes.length);
    }
}
