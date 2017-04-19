/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.interfacesV2;

import java.awt.Color;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;
import jeanderson.br.cliente.Clientes;
import jeanderson.br.converte.Converte;
import jeanderson.br.main.Main;
import jeanderson.br.nota.Notas;
import jeanderson.br.produtos.Produto;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TelaNotasRecebidas extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private JButton btnOk;
    private JFrame janela;
    /**
     * Creates new form TelaNotasRecebidas
     */
    public TelaNotasRecebidas() {
        initComponents();
        modelo = (DefaultTableModel) jtProdutos.getModel();
        btnOk = new JButton("OK");
        janela = new JFrame();
        eventoBtnOk();
        setSize(642, 625);
    }
    public void recebeNotas(){
        for(Clientes clientes : Main.getClientesNotas().getClienteList()){
            jcCliente.addItem(clientes.getCliente());
        }
    }
    private void limparCampos() {
        txtBairro.setText(null);
        txtCidade.setText(null);
        txtEndereco.setText(null);
        txtNome.setText(null);
        txtUf.setText(null);
        txtNome.requestFocus();
    }
    private void limparTabela() {
        int quantidade = modelo.getRowCount();
        for (int i = 0; i < quantidade; i++) {
            modelo.removeRow(0);
        }
    }
    private void progresso() {
        // configuro o jframe
        janela.setSize(400, 200);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.setTitle("Executando Tarefas");
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLayout(new MigLayout("center"));
        // Instancio os objetos
        JLabel txtSituacao = new JLabel("Executando Tarefas...");
        JLabel espaco = new JLabel();
        JProgressBar progresso = new JProgressBar();
        //Configuro os objetos
        txtSituacao.setSize(130, 28);
        progresso.setSize(100, 28);
        btnOk.setSize(50, 28);
        btnOk.setEnabled(false);
        progresso.setStringPainted(true);
        //Adiciono os objetos
        janela.add(espaco, "wrap 30");
        janela.add(txtSituacao, "center,wrap 10");
        janela.add(progresso, "center,wrap 10");
        janela.add(btnOk, "center");
        janela.setVisible(true);
        // funções
        new Thread() {

            @Override
            public void run() {
                progresso.setValue(0);
                Random numerosAleatorios = new Random();
                progresso.setValue(numerosAleatorios.nextInt(20)+1);
                Notas nota = new Notas(txtNome.getText().trim(), txtEndereco.getText(), txtCidade.getText() + " - " + txtUf.getText(), txtBairro.getText());
                int desconto = jcDesconto.getSelectedIndex();
                progresso.setValue(numerosAleatorios.nextInt(50) + 21);
                for (int i = 0; i < jtProdutos.getRowCount(); i++) {
                    nota.addProdutos(jtProdutos.getValueAt(i, 1).toString());
                    nota.addQuantidades(jtProdutos.getValueAt(i, 2).toString());
                    nota.addValor(jtProdutos.getValueAt(i, 3).toString());
                }
                progresso.setValue(numerosAleatorios.nextInt(70) + 51);
                if (nota.gerarNotas(desconto)) {
                    progresso.setForeground(Color.red);
                    progresso.setString("Falha! O Documento está aberto em outro programa!");
                    btnOk.setEnabled(true);
                    //JOptionPane.showMessageDialog(null, "O Documento está aberto em outro programa não é possivel altera-ló", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    progresso.setValue(numerosAleatorios.nextInt(95) + 71);
                    Converte.converter(txtNome.getText().trim());
                    progresso.setValue(100);
                    btnOk.setEnabled(true);
                    //JOptionPane.showMessageDialog(rootPane, "Nota eletrônica & Conversão feita com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }.start();
    }
    private void eventoBtnOk() {
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerforned(evt);
            }
        });
    }
    private void btnOkActionPerforned(java.awt.event.ActionEvent evt) {
        janela.dispose();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcCliente = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUf = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcDesconto = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdutos = new javax.swing.JTable();
        btnGerar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Selecionar Cliente:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 21, 100, 15);

        jcCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cliente não cadastrado" }));
        jcCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jcCliente);
        jcCliente.setBounds(114, 18, 295, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 63, 36, 15);
        getContentPane().add(txtNome);
        txtNome.setBounds(70, 57, 272, 28);
        getContentPane().add(txtBairro);
        txtBairro.setBounds(384, 96, 217, 28);
        getContentPane().add(txtEndereco);
        txtEndereco.setBounds(70, 96, 272, 28);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Bairro:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(346, 102, 34, 15);

        jLabel8.setText("UF:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(357, 149, 30, 14);
        getContentPane().add(txtUf);
        txtUf.setBounds(387, 142, 77, 28);
        getContentPane().add(txtCidade);
        txtCidade.setBounds(70, 142, 272, 28);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Cidade:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(26, 148, 40, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Desconto:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 191, 56, 15);

        jcDesconto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcDesconto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sem Desconto", "7% - Desconto", "10% - Desconto", "12% - Desconto", "15% - Desconto" }));
        getContentPane().add(jcDesconto);
        jcDesconto.setBounds(70, 188, 130, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Produtos");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(286, 220, 56, 17);

        jtProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produto", "Quantidade", "Valor(R$)"
            }
        ));
        jtProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProdutos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 243, 593, 249);

        btnGerar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGerar.setText("Gerar Nota");
        btnGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGerar);
        btnGerar.setBounds(46, 503, 120, 25);

        btnLimpar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimpar.setText("Limpar Tudo");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar);
        btnLimpar.setBounds(415, 503, 140, 25);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jeanderson/br/imagens/8.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 630, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcClienteActionPerformed
        if(jcCliente.getSelectedIndex() == 0){
            limparCampos();
            limparTabela();
        }else{
            txtNome.setText(Main.getClientesNotas().getClienteList().get(jcCliente.getSelectedIndex() - 1).getCliente());
            txtBairro.setText(Main.getClientesNotas().getClienteList().get(jcCliente.getSelectedIndex() - 1).getBairro());
            txtCidade.setText(Main.getClientesNotas().getClienteList().get(jcCliente.getSelectedIndex() - 1).getCidade());
            txtEndereco.setText(Main.getClientesNotas().getClienteList().get(jcCliente.getSelectedIndex() - 1).getEndereco());
            txtUf.setText(Main.getClientesNotas().getClienteList().get(jcCliente.getSelectedIndex() - 1).getEstado());
            Clientes cliente = Main.getClientesNotas().getClienteList().get(jcCliente.getSelectedIndex() - 1);
            int contador = 0;
            for(Produto produto : cliente.getLista()){
                modelo.addRow(new String[]{Integer.toString(contador),produto.getNome(),Integer.toString(produto.getQuantidade()),Double.toString(produto.getValor())});
                contador++;
            }
        }
    }//GEN-LAST:event_jcClienteActionPerformed

    private void jtProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutosMouseClicked

    }//GEN-LAST:event_jtProdutosMouseClicked

    private void btnGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarActionPerformed
        if(jcCliente.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(rootPane, "PorFavor selecione um cliente antes de gerar a nota","CLIENTE NÃO SELECIONADO",JOptionPane.ERROR_MESSAGE);
            return;
        }
        progresso();
        
    }//GEN-LAST:event_btnGerarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
        limparTabela();
    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGerar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcCliente;
    private javax.swing.JComboBox jcDesconto;
    private javax.swing.JTable jtProdutos;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}
