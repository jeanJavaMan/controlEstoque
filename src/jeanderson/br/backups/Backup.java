package jeanderson.br.backups;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeanderson.br.bugs.Relatar;

public class Backup {

    public static void fazerBackup() {
        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Banco de Dados/Estoque.dat");
        File pastaBackup = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Banco de Dados/Backup");
        File backup = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Banco de Dados/Backup/Estoque.dat");
        if (!pastaBackup.exists()) {
            pastaBackup.mkdir();
        }
        try {
            InputStream pegar = new FileInputStream(arquivo);
            OutputStream levar = new FileOutputStream(backup);
            byte[] buf = new byte[4096];// ler de 4 em 4 KB
            int lido;
            while ((lido = pegar.read(buf)) != -1) {
                //lido contém a quantidade de bytes lido a cada interação
                levar.write(buf, 0, lido);
            }
            levar.close();
            pegar.close();
        } catch (FileNotFoundException ex) {
            Relatar.bug(Backup.class.getName(), ex.toString());
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Relatar.bug(Backup.class.getName(), ex.toString());
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void retornarBackup() {
        File backup = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Banco de Dados/Backup/Estoque.dat");
        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Banco de Dados/Estoque.dat");
        try {
            InputStream pegar = new FileInputStream(backup);
            OutputStream levar = new FileOutputStream(arquivo);
            byte[] buf = new byte[4096];
            int lido;
            while ((lido = pegar.read(buf)) != -1) {
                levar.write(buf,0,lido);
            }
            levar.close();
            pegar.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
            Relatar.bug(Backup.class.getName(), ex.toString());
        } catch (IOException ex) {
            Relatar.bug(Backup.class.getName(), ex.toString());
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void backupEspecial(){
        String data = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Banco de Dados/Estoque.dat");
        File pastas = new File("/Users/"+System.getProperty("user.name")+"/Google Drive/Backup/"+data);
        File backup = new File("/Users/"+System.getProperty("user.name")+"/Google Drive/Backup/"+data+"/Estoque.dat");
        if(!pastas.exists()){
            pastas.mkdirs();
        }
        try{
            InputStream pegar = new FileInputStream(arquivo);
            OutputStream levar = new FileOutputStream(backup);
            byte[] buf = new byte[4096];
            int lido;
            while((lido = pegar.read(buf)) != -1){
                levar.write(buf,0,lido);
            }
            levar.flush();
            levar.close();
            pegar.close();           
            
        }catch (FileNotFoundException ex){
            Relatar.bug(Backup.class.getName(), ex.toString());
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex){
            Relatar.bug(Backup.class.getName(), ex.toString());
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
