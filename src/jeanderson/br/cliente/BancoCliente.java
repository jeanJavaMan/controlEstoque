/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.cliente;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class BancoCliente implements Serializable {
    private static final long serialVersionUID = -2058542439863694642L;

    private ArrayList<Clientes> listaClientes = new ArrayList<>();

    public boolean addCliente(Clientes cliente) {
        for (Clientes recebe : listaClientes) {
            if (recebe.getCliente().equals(cliente.getCliente()) && recebe.getEndereco().equals(cliente.getEndereco())) {
                return true;
            }
        }
        listaClientes.add(cliente);
        return false;
        
    }

    public void removeCliente(int index) {
        this.listaClientes.remove(index);
    }

    public ArrayList<Clientes> getClienteList() {
        return this.listaClientes;
    }

    public void recebeClientes(BancoCliente obj) {
        if (obj == null) {
            System.out.println("Objeto nulo");
        } else {
            this.listaClientes = obj.getClienteList();
        }
    }
    

}
