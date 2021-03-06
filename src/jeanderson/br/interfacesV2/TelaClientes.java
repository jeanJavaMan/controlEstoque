/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.interfacesV2;

import javax.swing.table.DefaultTableModel;
import jeanderson.br.cliente.Clientes;
import jeanderson.br.main.Main;
import jeanderson.br.produtos.Produto;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TelaClientes extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private Main main;

    /**
     * Creates new form TelaClientes
     */
    public TelaClientes() {
        initComponents();
        modelo = (DefaultTableModel) jtProdutos.getModel();
        main = new Main();
        editavel();
        setSize(558, 636);
    }

    public void listaDeClientes() {
        jcLista.setSelectedIndex(0);
        if(jcLista.getItemCount() > 1){
            int quantidade = jcLista.getItemCount();
            for(int i = 0; i < quantidade; i ++){
                jcLista.remove(1);
            }
        }
        for (Clientes recebe : main.getClientesList()) {
            jcLista.addItem(recebe.getCliente());
        }
    }

    private void editavel() {
        txtNome.setEditable(false);
        txtUf.setEditable(false);
        txtEndereco.setEditable(false);
        txtEmail.setEditable(false);
        txtCpf.setEditable(false);
        txtCidade.setEditable(false);
        txtBairro.setEditable(false);
    }

    private void preencherInfor(int index) {
        Integer contador = 0;
        Clientes recebe = main.getClientesList().get(index);
        limparTabela();
        txtNome.setText(recebe.getCliente());
        txtBairro.setText(recebe.getBairro());
        txtCpf.setText(recebe.getCpf());
        txtEmail.setText(recebe.getEmail());
        txtEndereco.setText(recebe.getEndereco());
        txtUf.setText(recebe.getEstado());
        txtCidade.setText(recebe.getCidade());
        for (Produto receb : recebe.getLista()) {
            modelo.addRow(new String[]{contador.toString(), receb.getNome(), Integer.toString(receb.getQuantidade()), Double.toString(receb.getValor())});
            contador++;
        }
    }

    private void limparCampos() {
        txtBairro.setText(null);
        txtCidade.setText(null);
        txtCpf.setText(null);
        txtEmail.setText(null);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcLista = new javax.swing.JComboBox();
        txtEmail = new javax.swing.JTextField();
        txtUf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdutos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Clientes Cadastrados");
        getContentPane().setLayout(null);

        jLabel1.setText("Selecione o Cliente:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 16, 94, 14);

        jcLista.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um Cliente aqui" }));
        jcLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcListaActionPerformed(evt);
            }
        });
        getContentPane().add(jcLista);
        jcLista.setBounds(108, 11, 205, 25);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(70, 234, 187, 28);
        getContentPane().add(txtUf);
        txtUf.setBounds(436, 195, 47, 28);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("UF:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(414, 201, 18, 15);
        getContentPane().add(txtCidade);
        txtCidade.setBounds(70, 195, 334, 28);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Email:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(35, 240, 31, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Cidade:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(26, 201, 40, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Bairro:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(32, 167, 34, 15);
        getContentPane().add(txtBairro);
        txtBairro.setBounds(70, 161, 187, 28);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Endereço:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 128, 56, 15);
        getContentPane().add(txtEndereco);
        txtEndereco.setBounds(70, 122, 413, 28);
        getContentPane().add(txtCpf);
        txtCpf.setBounds(70, 88, 187, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("CPF:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(42, 94, 24, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nome:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 60, 36, 15);
        getContentPane().add(txtNome);
        txtNome.setBounds(70, 54, 413, 28);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Produtos Comprados");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(207, 273, 131, 17);

        jtProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Quantidade", "Valor(R$)"
            }
        ));
        jScrollPane1.setViewportView(jtProdutos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(35, 296, 452, 254);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jeanderson/br/imagens/13.jpg"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 550, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcListaActionPerformed
        if (jcLista.getSelectedIndex() == 0) {
            limparCampos();
            limparTabela();
        } else {
            preencherInfor(jcLista.getSelectedIndex() - 1);
        }
    }//GEN-LAST:event_jcListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcLista;
    private javax.swing.JTable jtProdutos;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtUf;
    // End of variables declaration//GEN-END:variables
}
