/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeanderson.br.testes;

import java.util.Random;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class testeRondom {
    public static void main(String[] args) {
        Random numeros = new Random();
        System.out.println(numeros.nextInt(50));
    }

}
