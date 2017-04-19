/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeanderson.br.testes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TesteConvert {
    public static void main(String[] args) {
        //Converte.converter("b1");
        JFrame janela = new JFrame();
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
        JButton btnOk = new JButton("OK");
        //Configuro os objetos
        txtSituacao.setSize(130, 28);
        progresso.setSize(100,28);
        btnOk.setSize(50, 28);
        progresso.setStringPainted(true);
        //Adiciono os objetos
        janela.add(espaco,"wrap 30");
        janela.add(txtSituacao, "center,wrap 10");
        janela.add(progresso,"center,wrap 10");
        janela.add(btnOk,"center");
        janela.setVisible(true);
        int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite a porcentagem"));
        progresso.setString("Pronto");
        progresso.setValue(valor);
        
        
    }

}
