/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.testes;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Jeanderson S.Lopes
 */
public class Usuario {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Endereço: " + InetAddress.getByName("localhost").getHostAddress() );
    }
}
