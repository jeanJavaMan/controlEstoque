package jeanderson.br.funcoes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jeanderson.br.backups.Backup;
import jeanderson.br.bugs.Relatar;
import jeanderson.br.cliente.BancoCliente;
import jeanderson.br.main.Main;
import jeanderson.br.som.Som;

public class Conexao{

    private static Som som = new Som();

    public static void IniciarServidor() {
        try {
            ServerSocket servidor = new ServerSocket(9696);
            while (true) {
                Socket cliente = servidor.accept();
                ObjectInputStream ler = new ObjectInputStream(cliente.getInputStream());
                int motivo = ler.readInt();
                switch (motivo) {
                    case 1:
                        enviarBanco(cliente);
                        break;
                    case 2:
                        receberBanco(cliente, ler);
                        break;
                    case 3:
                        enviarAtualizacao(cliente);
                        //Atualizacao.atualDispo();
                        break;
                    case 4:
                        Main.recebeNotas(recebeNotas(ler));
                        break;
                    case 5:
                         verificarAtualizacaoMobi(cliente,ler);
                        break;
                    default:
                        ler.close();
                        cliente.close();
                }

            }
        } catch (IOException ex) {
            som.tocar(5);
            Relatar.bug(Conexao.class.getName(), ex.toString());
            JOptionPane.showMessageDialog(null, "Errou ao Iniciar Servidor", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void enviarBanco(Socket cliente) throws IOException {
        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Banco de Dados/Estoque.dat");
        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());

        saida.writeUTF(arquivo.getName());
        saida.writeLong(arquivo.length());
        FileInputStream estoque = new FileInputStream(arquivo);
        byte[] buf = new byte[4096];
        while (true) {
            int len = estoque.read(buf);
            if (len == -1) {
                break;
            }
            saida.write(buf, 0, len);
        }
        saida.close();
        estoque.close();
        cliente.close();
        som.tocar(4);
    }

    private static void receberBanco(Socket cliente, ObjectInputStream enviar) throws IOException {
        Main main = new Main();
        Backup.fazerBackup(); //  faz o backup do banco de Dados antes de receber o novo!!!
        String nomeArquivo = enviar.readUTF();
        long size = enviar.readLong();
        FileOutputStream estoque = new FileOutputStream("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Banco de Dados/" + nomeArquivo);
        byte[] buf = new byte[4096];
        while (true) {
            int len = enviar.read(buf);
            if (len == -1) {
                break;
            }
            estoque.write(buf, 0, len);
        }
        estoque.flush();
        estoque.close();
        enviar.close();
        cliente.close();
        main.setRecebeuDados(true);
        som.tocar(6);
    }

    private static void enviarAtualizacao(Socket cliente) {
        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Mobile/ControlEstoque.apk");
        if (arquivo.exists()) {
            try {
                ObjectOutputStream enviar = new ObjectOutputStream(cliente.getOutputStream());
                enviar.writeUTF(arquivo.getName());
                enviar.writeLong(arquivo.length());
                FileInputStream arq = new FileInputStream(arquivo);
                byte[] buf = new byte[4096];
                while (true) {
                    int len = arq.read(buf);
                    if (len == -1) {
                        break;
                    }
                    enviar.write(buf, 0, len);
                }
                enviar.flush();
                enviar.close();
                //arq.close();
                cliente.close();
                som.tocar(7);
            } catch (IOException ex) {
                Relatar.bug(Conexao.class.getName(), ex.toString());
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                cliente.close();
            } catch (IOException ex) {
                Relatar.bug(Conexao.class.getName(), ex.toString());
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private static BancoCliente recebeNotas(ObjectInputStream ler) {
        try {
            return (BancoCliente) ler.readObject();
        } catch (IOException ex) {
            Relatar.bug(Conexao.class.getName(), ex.toString());
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Relatar.bug(Conexao.class.getName(), ex.toString());
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static void verificarAtualizacaoMobi(Socket cliente, ObjectInputStream ler) {
        try {
            ObjectOutputStream responder = new ObjectOutputStream(cliente.getOutputStream());
            if(Atualizacao.verificarAtualizacaoMobi(ler.readUTF())){
                responder.writeBoolean(true);
            }else{
                responder.writeBoolean(false);
            }
            responder.flush();
            responder.close();
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
