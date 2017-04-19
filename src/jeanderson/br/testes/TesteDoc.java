/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeanderson.br.testes;

import jeanderson.br.nota.Notas;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TesteDoc {
    public static void main(String[] args) {
        Notas obj = new Notas("Pebinha Saiu", "Quadra 14 Casa 46", "Águas Lindas", "Barragem 3");
        obj.addProdutos("Arroz tio Jorge");
        obj.addQuantidades("15");
        obj.addValor("2.50");
        obj.addProdutos("Feijão Nossa senhora que ruim");
        obj.addQuantidades("5");
        obj.addValor("0.99");
        obj.addProdutos("Macarrão");
        obj.addQuantidades("2");
        obj.addValor("4.50");
        obj.addProdutos("Leite 2L marajuara");
        obj.addQuantidades("7");
        obj.addValor("1.99");
        obj.addProdutos("Salada de cocô");
        obj.addQuantidades("20");
        obj.addValor("11.50");
        obj.addProdutos("Carrinho de bebê");
        obj.addQuantidades("5");
        obj.addValor("20.99");
        obj.addProdutos("Fraldas");
        obj.addQuantidades("2");
        obj.addValor("11.95");
        obj.addProdutos("Master Gamer");
        obj.addQuantidades("7");
        obj.addValor("1.99");
        obj.gerarNotas(3);
    }

}
