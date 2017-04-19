/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.bugs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeanderson S.lopes
 */
public class Relatar {

    public static void bug(String nome, String ex) {
        int contador = 0;
        File bug = null;
        while (true) {
            bug = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/System/Bugs/" + nome + contador + ".txt");
            if (bug.exists()) {
                contador++;
            } else {
                break;
            }
        }
        try {
            FileWriter fw = new FileWriter(bug);
            BufferedWriter escrever = new BufferedWriter(fw);
            escrever.write(ex);
            escrever.flush();
            escrever.close();
        } catch (IOException ex1) {
            Logger.getLogger(Relatar.class.getName()).log(Level.SEVERE, null, ex1);
        }

    }

    public static void invasao(String user, String password) {
        File pasta = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/System/Logs");
        if (!pasta.exists()) {
            pasta.mkdir();
        }
        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/System/Logs/log.txt");
        int contador = 1;
        while (arquivo.exists()) {
            arquivo = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/System/Logs/log" + contador + ".txt");
            contador++;
        }
        try {
            FileWriter arqEscrever = new FileWriter(arquivo);
            BufferedWriter escrever = new BufferedWriter(arqEscrever);
            escrever.write("Tentativa de Logar com o Usuario: " + user + " Com a senha: " + password);
            escrever.newLine();
            escrever.write("Hora da Tentativa: " + new SimpleDateFormat("h:mm - a").format(new Date()));
            escrever.newLine();
            escrever.write("Data da Tentativa: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
            escrever.flush();
            escrever.close();
        } catch (IOException ex) {
            Logger.getLogger(Relatar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
