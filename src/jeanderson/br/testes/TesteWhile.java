/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeanderson.br.testes;

import jeanderson.br.bugs.Relatar;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TesteWhile {
    public static void main(String[] args) {
       String nome = "Bug no Joption.pane";
       String ex = "Erro ao iniciar joption.pane";
        Relatar.bug(TesteWhile.class.getName(), ex);
    }

}
