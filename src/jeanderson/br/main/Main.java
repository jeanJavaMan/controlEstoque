package jeanderson.br.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jeanderson.br.backups.Backup;
import jeanderson.br.bugs.Relatar;
import jeanderson.br.cliente.BancoCliente;
import jeanderson.br.cliente.Clientes;
import jeanderson.br.funcoes.Atualizacao;
import jeanderson.br.funcoes.Conexao;
import jeanderson.br.funcoes.Funcionalidades;
import jeanderson.br.interfaces.TelaNovi;
import jeanderson.br.interfaces.TelaSeguranca;
import jeanderson.br.interfacesV2.TelaPrincipal;
import jeanderson.br.produtos.Produto;
import jeanderson.br.serializacao.BancoProdutos;
import jeanderson.br.som.Som;

public class Main {

    private static BancoProdutos estoque = new BancoProdutos();
    private static boolean recebeuDados = false;
    private static boolean viuVideo = false;
    private static TelaPrincipal tp;
    private static Som som = new Som();
    private static BancoCliente listaClientes = new BancoCliente();
    private static TelaSeguranca ts;
    private static BancoCliente clientesNotas;

    public static void main(String[] args) {
        //OBS: não esqueça de alterar a versão em Atualizacao.java
        tema();
        ts = new TelaSeguranca();
        ts.setResizable(false);
        ts.setLocationRelativeTo(null);
        ts.setVisible(true);

        // ao iniciar não esqueça de desativar backup especial para não sobrepor o backup do jonatha
        Funcionalidades.backupAntigos();
        Conexao.IniciarServidor();

    }

    public boolean adicionarProduto(Produto obj) {
        return estoque.addProduto(obj);
    }

    public void atualizarBanco() {
        Funcionalidades.atualizarBanco(estoque);
    }

    public ArrayList<Produto> getEstoque() {
        return estoque.getProdutos();
    }

    public void receberProduto() {
        estoque.recebeproduto(Funcionalidades.receberObjeto());
    }

    public boolean getRecebeuDados() {
        return recebeuDados;
    }

    public void setRecebeuDados(boolean recebeu) {
        recebeuDados = recebeu;
    }

    private static void atualizacao() {
        TelaNovi novi = new TelaNovi(null, true);
        if (Atualizacao.novaAtualizacao()) {
            if (novi.verificarArquivos()) {
                JOptionPane.showMessageDialog(null, "As imagens da Apresentação não foram todas baixadas, na proxima vez que voce abrir o programa\n"
                        + "e todas as imagens estiverem baixadas, a tela de Apresentação aparecerá!", "Apresentação não baixada!", JOptionPane.WARNING_MESSAGE);
            } else {
                som.tocar(11);
                novi.setResizable(false);
                novi.setLocationRelativeTo(null);
                novi.setVisible(true);
            }
        }
    }

    public static void verVideo() {
        if (viuVideo) {
            Atualizacao.atualizado();
        }
    }

    private static void mobileAtualizacao() {
        if (! new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/System/Upgrade/atualizado.txt").exists()) {
            if (Atualizacao.novaAtualMobile()) {
                switch (Atualizacao.verificarEnvio()) {
                    case 1:
                        //som.tocar(9);
                        JOptionPane.showMessageDialog(null, "Ainda Falta um dispositivo a ser atualizado!", "Nova Atualização", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2:
                        Atualizacao.excluirAtualizacao();
                        break;
                    case 3:
                    //som.tocar(8);
                        //JOptionPane.showMessageDialog(null, "Nova Atualização disponivel para Android!\nPorFavor clique no botão Atualizar em seu Celular/Tablet", "Nova Atualização", JOptionPane.INFORMATION_MESSAGE);
                        int selecionado = JOptionPane.showConfirmDialog(null, "Existe uma nova atualização Android Se você já atualizou Clique em SIM por favor!", "Nova atualização", JOptionPane.YES_NO_OPTION);
                        if (selecionado == 0) {
                            atualizado();
                        }
                        break;
                }

            }
        }
    }

    public static boolean getViuVideo() {
        return viuVideo;
    }

    public static void setViuVideo(boolean viuVideo) {
        Main.viuVideo = viuVideo;
    }

    public static BancoProdutos getBanco() {
        return estoque;
    }

    public static void atualizaTabela() {
        tp.atualizaTabela();
    }

    public void receberClientes() {
        listaClientes.recebeClientes(Funcionalidades.receberClientes());
    }

    public ArrayList<Clientes> getClientesList() {
        return listaClientes.getClienteList();
    }

    public void atualizarListaClientes() {
        Funcionalidades.atualizarClientes(listaClientes);
    }

    public boolean adicionarCliente(Clientes cliente) {
        return listaClientes.addCliente(cliente);
    }

    public void abrirTelaNotas(String iD, String produto, String quantidade, String valor) {
        tp.abrirTelaNota(iD, produto, quantidade, valor);
    }

    public void pararSom() {
        som.parar();
    }

    public static void abrirTelaPrincipal() {
        tp = new TelaPrincipal();
        tp.setResizable(false);
        tp.setLocationRelativeTo(null);
        tp.setVisible(true);
        ts.setVisible(false);
        listaClientes.recebeClientes(Funcionalidades.receberClientes());
        estoque.recebeproduto(Funcionalidades.receberObjeto());
        Backup.backupEspecial();
        atualizacao();
        mobileAtualizacao();
        
    }

    public static void recebeUsuario(String user, String password) {
        ts.receberUsuario(user, password);
    }

    private static void tema() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Relatar.bug(TelaPrincipal.class.getName(), ex.toString());
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Relatar.bug(TelaPrincipal.class.getName(), ex.toString());
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Relatar.bug(TelaPrincipal.class.getName(), ex.toString());
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Relatar.bug(TelaPrincipal.class.getName(), ex.toString());
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void recebeNotas(BancoCliente cliente) {
        clientesNotas = cliente;
        tp.abrirTelaNotasRecebidas();
    }

    public static BancoCliente getClientesNotas() {
        return clientesNotas;
    }

    private static void atualizado() {
        try {
            FileWriter fileWriter = new FileWriter("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/System/Upgrade/atualizado.txt");
            BufferedWriter escrever = new BufferedWriter(fileWriter);
            escrever.write("OK");
            escrever.flush();
            escrever.close();
        } catch (IOException ex) {
            Relatar.bug(TelaPrincipal.class.getName(), ex.toString());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
