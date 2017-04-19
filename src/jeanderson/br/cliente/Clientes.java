/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.cliente;

import java.io.Serializable;
import java.util.ArrayList;
import jeanderson.br.produtos.Produto;

/**
 *
 * @author Jeanderson
 */
public class Clientes implements Serializable {
    //para caso eu mudar algo na classe ela possuir a mesma versão smp!
    private static final long serialVersionUID = 8341404512949802016L;
    private String cliente;
    private String cpf;
    private String email;
    private String endereco;
    private String cidade;
    private String estado;
    private String bairro;
    private ArrayList<Produto> listaProdutos;

    public Clientes(String cliente, String cpf, String email, String endereco, String cidade, String estado, String bairro) {
        this.cliente = cliente;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        listaProdutos = new ArrayList<>();
    }

    public Clientes() {
        listaProdutos = new ArrayList<>();
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public ArrayList<Produto> getLista() {
        return listaProdutos;
    }

    public void addProduto(Produto produto) {
        this.listaProdutos.add(produto);
    }

    public void removeProduto(int index) {
        this.listaProdutos.remove(index);
    }

    @Override
    public String toString() {
        return "Clientes{" + "cliente=" + cliente + ", cpf=" + cpf + ", email=" + email + ", endereco=" + endereco + ", cidade=" + cidade + ", estado=" + estado + ", bairro=" + bairro + ", listaProdutos=" + listaProdutos + '}';
    }

}


