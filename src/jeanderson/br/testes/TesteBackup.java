/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.testes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Jeanderson S.Lopes
 */
public class TesteBackup {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Documents/Testando/Teste.txt");
        File pasta = new File("/Users/" + System.getProperty("user.name") + "/Documents/Testando/Backup/Teste.txt");
        InputStream origem = new FileInputStream(arquivo);
        OutputStream destino = new FileOutputStream(pasta);
        byte[] buf = new byte[1024];// buffer de 1KB
        int lenght;
        while((lenght = origem.read(buf)) != -1){
            destino.write(buf,0,lenght);
        }
        destino.close();
        origem.close();
        
    }
    
}
