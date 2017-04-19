/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.testes;

import java.util.ArrayList;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TesteGráfico {

    public static void main(String[] args) {
        teste2();
    }
    

    private static void teste1() {
        ArrayList<String> n1 = new ArrayList<>();
        ArrayList<String> n2 = new ArrayList<>();
        n1.add("10");
        n1.add("20");
        n2.add("10");
        int soma = 0;
        for (int i = 0; i < n1.size(); i++) {
            if(n1.size() != n2.size()){
                n2.add("0");
            }
           soma += Integer.parseInt(n1.get(i)) + Integer.parseInt(n2.get(i));
           
        }
        System.out.println(soma);

    }
    private static void teste2(){
        int i = -10;
        System.out.println(Math.abs(i));
    }
}
