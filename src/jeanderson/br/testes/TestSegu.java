/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeanderson.br.testes;

import java.text.DecimalFormat;
import jeanderson.br.funcoes.Funcionalidades;
import jeanderson.br.seguranca.Seguranca;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestSegu {
    public static void main(String[] args) {
//        Seguranca usuario = new Seguranca("JonathaJobs", "jean1023x");
//        Funcionalidades.gerarSeguranca(usuario);
//        Seguranca recebe = Funcionalidades.getSeguranca();
//        if(recebe.getUser().equals("JonathaJobs") && recebe.getPassword().equals("jean1023x")){
//            System.out.println("Sim senha correta");
//        }else{
//            System.out.println("Senha incorreta");
//        }
        double total = 21294;
        double valor = 10000;
        double f = (valor / total) * 100;
        System.out.println(f);
        DecimalFormat df = new DecimalFormat("###,##0.#");
        System.out.println(df.format(f));
    }

}
