package jeanderson.br.produtos;

import java.io.Serializable;

public class Produto implements Serializable {

    private static final long serialVersionUID = 2121945651251596496L;
    private String nome;
    private int quantidade;
    private double valor;
    private String descricao;
    private int tamanhoCel = 5;
    private int tamanhoTab = 5;
    private String[] caminhoCel;// caminhos das imagens do celular
    private String[] caminhoTab;//caminhos das imagens do tablet
    private String caminhoVideoCel;
    private String caminhoVideoTab;

    public Produto(String nome, int quantidade, double valor, String descricao) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.descricao = descricao;
        caminhoCel = new String[tamanhoCel];
        caminhoTab = new String[tamanhoTab];

    }

    public Produto() {
        caminhoCel = new String[tamanhoCel];
        caminhoTab = new String[tamanhoTab];

    }

    public void addCaminhoCel(String caminho) {
        if (getCountCaminhoCel() == tamanhoCel) {
            tamanhoCel += 5;
            String[] novaMemoria = new String[tamanhoCel];
            for (int i = 0; i < caminhoCel.length; i++) {
                novaMemoria[i] = caminhoCel[i];
            }
            caminhoCel = novaMemoria;
        }
        for (int i = 0; i < caminho.length(); i++) {
            if (caminhoCel[i] == null) {
                caminhoCel[i] = caminho;
                break;
            }
        }
    }

    public void addCaminhoTab(String caminho) {
        if (getCountCaminhoTab() == tamanhoTab) {
            tamanhoTab += 5;
            String[] novaMemoria = new String[tamanhoTab];
            for (int i = 0; i < caminhoTab.length; i++) {
                novaMemoria[i] = caminhoTab[i];
            }
            caminhoTab = novaMemoria;
        }
        for (int i = 0; i < caminhoTab.length; i++) {
            if (caminhoTab[i] == null) {
                caminhoTab[i] = caminho;
                break;
            }
        }
    }

    public int getCountCaminhoCel() {
        int quantidade = 0;
        if (caminhoCel == null) {
            caminhoCel = new String[tamanhoCel];
        }
        for (int i = 0; i < caminhoCel.length; i++) {
            if (caminhoCel[i] == null) {
                break;
            } else {
                quantidade++;
            }
        }
        return quantidade;
    }

    public int getCountCaminhoTab() {
        int quantidade = 0;
        if (caminhoTab == null) {
            caminhoTab = new String[tamanhoTab];
        }
        for (int i = 0; i < caminhoTab.length; i++) {
            if (caminhoTab[i] == null) {
                break;
            } else {
                quantidade++;
            }
        }
        return quantidade;
    }

    public String[] getCaminhoTab() {
        return caminhoTab;
    }

    public String[] getCaminhoCel() {
        return caminhoCel;
    }

    public String getCaminhoVideoCel() {
        return caminhoVideoCel;
    }

    public void setCaminhoVideoCel(String caminhoVideoCel) {
        this.caminhoVideoCel = caminhoVideoCel;
    }

    public String getCaminhoVideoTab() {
        return caminhoVideoTab;
    }

    public void setCaminhoVideoTab(String caminhoVideoTab) {
        this.caminhoVideoTab = caminhoVideoTab;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return nome + "\nQuantidade: " + quantidade;
    }

}
