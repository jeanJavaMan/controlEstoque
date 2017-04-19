/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.funcoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeanderson.br.bugs.Relatar;

/**
 *
 * @author Jeanderson S.Lopes
 */
public class Atualizacao {

    private static final String VERSAO = "15";// quando lançar uma versão novo alterar o numero da versão.

    public static boolean novaAtualizacao() {
        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Up" + VERSAO + ".txt");
        if (arquivo.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static void atualizado() {
        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Up" + VERSAO + ".txt");
        if (arquivo.exists()) {
            arquivo.delete();
        }
    }

    public static boolean novaAtualMobile() {
        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Mobile/ControlEstoque.apk");
        File tamanho = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Mobile/tamanho.txt");
        if (arquivo.exists() && tamanho.exists()) {
            try {
                FileReader arq = new FileReader(tamanho);
                BufferedReader ler = new BufferedReader(arq);
                int tamanhoArq = Integer.parseInt(ler.readLine());
                arq.close();
                if (arquivo.length() == tamanhoArq) {
                    return true;
                }
            } catch (FileNotFoundException ex) {
                Relatar.bug(Atualizacao.class.getName(), ex.toString());
                Logger.getLogger(Atualizacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Relatar.bug(Atualizacao.class.getName(), ex.toString());
                Logger.getLogger(Atualizacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public static int verificarEnvio() {
        File arquivo1 = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Mobile/1.txt");
        File arquivo2 = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Mobile/2.txt");
        if (arquivo1.exists() && !arquivo2.exists()) {
            return 1;
        }
        if (arquivo1.exists() && arquivo2.exists()) {
            return 2;
        }
        if (!arquivo1.exists() && !arquivo2.exists()) {
            return 3;
        }
        return 0;
    }

    public static void atualDispo() {
        //responsavel para criar os txt informando para quantos dispositivos foram atualizados
        File arquivo1 = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Mobile/1.txt");
        File arquivo2 = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Mobile/2.txt");
        if (!arquivo1.exists()) {
            try {
                FileWriter arqEscrever = new FileWriter(arquivo1);
                BufferedWriter escrever = new BufferedWriter(arqEscrever);
                escrever.write("OK");
                escrever.flush();
                escrever.close();
            } catch (IOException ex) {
                Relatar.bug(Atualizacao.class.getName(), ex.toString());
                Logger.getLogger(Atualizacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (arquivo1.exists() && !arquivo2.exists()) {
            try {
                FileWriter arqEscrever = new FileWriter(arquivo2);
                BufferedWriter escrever = new BufferedWriter(arqEscrever);
                escrever.write("OK");
                escrever.flush();
                escrever.close();
            } catch (IOException ex) {
                Relatar.bug(Atualizacao.class.getName(), ex.toString());
                Logger.getLogger(Atualizacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void excluirAtualizacao() {
        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Mobile/ControlEstoque.apk");
        File tamanho = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Mobile/tamanho.txt");
        File arquivo2 = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Mobile/1.txt");
        File arquivo3 = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Mobile/2.txt");
        if (arquivo.exists() && tamanho.exists()) {
            arquivo.delete();
            tamanho.delete();
            arquivo2.delete();
            arquivo3.delete();
        }
    }

    public static boolean verificarAtualizacaoMobi(String version) {
        File file = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Aplicativo/Mobile/versao.txt");
        if (file.exists()) {
            if (novaAtualMobile()) {
                try {
                    FileReader reader = new FileReader(file);
                    BufferedReader ler = new BufferedReader(reader);
                    if (!version.equals(ler.readLine())) {
                        return true;
                    }
                } catch (FileNotFoundException ex) {
                    Relatar.bug(Atualizacao.class.getName(), ex.toString());
                    Logger.getLogger(Atualizacao.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Relatar.bug(Atualizacao.class.getName(), ex.toString());
                    Logger.getLogger(Atualizacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                return false;
            }
        }
        return false;
    }

}
