package jeanderson.br.funcoes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jeanderson.br.bugs.Relatar;
import jeanderson.br.cliente.BancoCliente;
import jeanderson.br.seguranca.Seguranca;
import jeanderson.br.serializacao.BancoProdutos;

public class Funcionalidades {

    public static BancoProdutos receberObjeto() {
        File pasta = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Banco de Dados");
        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Banco de Dados/Estoque.dat");
        if (pasta.exists()) {
            if (arquivo.exists()) {
                try {
                    FileInputStream recup = new FileInputStream(arquivo);
                    ObjectInputStream ler = new ObjectInputStream(recup);
                    return ((BancoProdutos) ler.readObject());
                } catch (FileNotFoundException ex) {
                    Relatar.bug(Funcionalidades.class.getName(), ex.toString());
                    JOptionPane.showMessageDialog(null, "Houve um erro no FileInputStream!", "ERRO", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    Relatar.bug(Funcionalidades.class.getName(), ex.toString());
                    JOptionPane.showMessageDialog(null, "Houve um erro no ObjectInputStream!", "ERRO", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    Relatar.bug(Funcionalidades.class.getName(), ex.toString());
                    JOptionPane.showMessageDialog(null, "Houve um erro no Cast de BancoProdutos", "ERRO", JOptionPane.ERROR_MESSAGE);
                }

            }

        } else {
            pasta.mkdir();
        }
        return null;
    }

    public static void atualizarBanco(BancoProdutos obj) {
        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Banco de Dados/Estoque.dat");
        try {
            FileOutputStream arqGravar = new FileOutputStream(arquivo);
            ObjectOutputStream gravar = new ObjectOutputStream(arqGravar);
            gravar.writeObject(obj);
            gravar.flush();
            gravar.close();
            arqGravar.flush();
            arqGravar.close();
        } catch (FileNotFoundException ex) {
            Relatar.bug(Funcionalidades.class.getName(), ex.toString());
            JOptionPane.showMessageDialog(null, "Houve um erro no FileOutputStream", "ERRO", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Relatar.bug(Funcionalidades.class.getName(), ex.toString());
            JOptionPane.showMessageDialog(null, "Houve um erro no ObjectOutputStream", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void backupAntigos(){
        // apagar backups com mais de 10 dias;
        Date data = new Date();
        File backup = null;
        File arquivo = null;
        data.setDate(data.getDate() - 14);
        for(int i = 0; i <= 15;i++){
            data.setDate(data.getDate()-1);
            backup = new File("/Users/"+System.getProperty("user.name")+"/Google Drive/Backup/"+ new SimpleDateFormat("dd-MM-yyyy").format(data));
            arquivo = new File("/Users/"+System.getProperty("user.name")+"/Google Drive/Backup/"+ new SimpleDateFormat("dd-MM-yyyy").format(data)+"/Estoque.dat");
            if(backup.exists()){
                arquivo.delete();
                backup.delete();
            }
        }
    }
    public static BancoProdutos receberObjetoAntigo(){
        Date data = new Date();
        data.setDate(data.getDate() -7);
        File backupAntigo = null;
        for(int i = 0; i <= 10; i++){
            backupAntigo = new File("/Users/"+System.getProperty("user.name")+"/Google Drive/Backup/"+ new SimpleDateFormat("dd-MM-yyyy").format(data)+"/Estoque.dat");
            if(backupAntigo.exists()){
                break;
            }else{
                data.setDate(data.getDate() -1);
            }
        }
        try {
            FileInputStream recup = new FileInputStream(backupAntigo);
            ObjectInputStream ler = new ObjectInputStream(recup);
            return ((BancoProdutos) ler.readObject());
        } catch (FileNotFoundException ex) {
            Relatar.bug(Funcionalidades.class.getName(), ex.toString());
            Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Relatar.bug(Funcionalidades.class.getName(), ex.toString());
            Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Relatar.bug(Funcionalidades.class.getName(), ex.toString());
            Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void atualizarClientes(BancoCliente obj){
        File pasta = new File("/Users/"+System.getProperty("user.name")+"/Google Drive/Clientes");
        if(!pasta.exists()){
            pasta.mkdir();
        }
        File arquivo = new File("/Users/"+System.getProperty("user.name")+"/Google Drive/Clientes/ListaClientes.dat");
        try {
            FileOutputStream arqGravar = new FileOutputStream(arquivo);
            ObjectOutputStream gravar = new ObjectOutputStream(arqGravar);
            gravar.writeObject(obj);
            gravar.flush();
            gravar.close();
            arqGravar.flush();
            arqGravar.close();
        } catch (FileNotFoundException ex) {
            Relatar.bug(Funcionalidades.class.getName(), ex.toString());
            Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Relatar.bug(Funcionalidades.class.getName(), ex.toString());
            Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static BancoCliente receberClientes(){
        File pasta = new File("/Users/"+System.getProperty("user.name")+"/Google Drive/Clientes");
        File arquivo = new File("/Users/"+System.getProperty("user.name")+"/Google Drive/Clientes/ListaClientes.dat");
        if(pasta.exists()){
            if(arquivo.exists()){
                try {
                    FileInputStream arqLer = new FileInputStream(arquivo);
                    ObjectInputStream ler = new ObjectInputStream(arqLer);
                    return (BancoCliente) ler.readObject();
                } catch (FileNotFoundException ex) {
                    Relatar.bug(Funcionalidades.class.getName(), ex.toString());
                    Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Relatar.bug(Funcionalidades.class.getName(), ex.toString());
                    Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Relatar.bug(Funcionalidades.class.getName(), ex.toString());
                    Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            pasta.mkdir();
        }
        return null;
    }
    public static void gerarSeguranca(Seguranca seg){
        File pasta = new File("/Users/"+System.getProperty("user.name")+"/Google Drive/Aplicativo/System/Segurity");
        if(!pasta.exists()){
            pasta.mkdir();
        }
        File arquivo = new File("/Users/"+System.getProperty("user.name")+"/Google Drive/Aplicativo/System/Segurity/seg.dat");
        try {
            FileOutputStream saida = new FileOutputStream(arquivo);
            ObjectOutputStream gravar = new ObjectOutputStream(saida);
            gravar.writeObject(seg);
            gravar.flush();
            gravar.close();
            saida.close();
        } catch (FileNotFoundException ex) {
            Relatar.bug(Funcionalidades.class.getName(), ex.toString());
            Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Relatar.bug(Funcionalidades.class.getName(), ex.toString());
            Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static Seguranca getSeguranca(){
        File arquivo = new File("/Users/"+System.getProperty("user.name")+"/Google Drive/Aplicativo/System/Segurity/seg.dat");
        if(arquivo.exists()){
            try {
                FileInputStream entrada = new FileInputStream(arquivo);
                ObjectInputStream ler = new ObjectInputStream(entrada);
                Seguranca seg = ((Seguranca) ler.readObject());
                ler.close();
                entrada.close();
                return seg;
            } catch (FileNotFoundException ex) {
                Relatar.bug(Funcionalidades.class.getName(), ex.toString());
                Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Relatar.bug(Funcionalidades.class.getName(), ex.toString());
                Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Relatar.bug(Funcionalidades.class.getName(), ex.toString());
                Logger.getLogger(Funcionalidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new Seguranca();
    }
    
}
