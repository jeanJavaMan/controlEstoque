/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeanderson.br.testes;

import jeanderson.br.cliente.BancoCliente;
import jeanderson.br.cliente.Clientes;
import jeanderson.br.funcoes.Funcionalidades;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TesteClientes {
    public static void main(String[] args) {
        //Clientes cliente = new Clientes("SAULO SAMUEL","CPF não cadastrado", "semEmail@email.com","QUADRA 64 LOTE 06"," AGUAS LINDAS", "GO", " BARRAGEM IV");
        BancoCliente lista = new BancoCliente();
        lista.recebeClientes(Funcionalidades.receberClientes());
        System.out.println(lista.getClienteList().toString());
    }

}
