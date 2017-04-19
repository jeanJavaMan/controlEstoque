/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.converte;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import jeanderson.br.bugs.Relatar;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author Jeanderson S.Lopes
 */
public class Converte {

    public static void converter(String nome) {
        File arquivo = new File("/Users/" + System.getProperty("user.name") + "/Google Drive/Notas Fiscais/PDF/" + nome + ".pdf");
        if (arquivo.exists()) {
            try {
                PDDocument documento = PDDocument.load(arquivo);
                List<PDPage> lista = documento.getDocumentCatalog().getAllPages();
                int numeroDePagina = 1;
                for (PDPage paginas : lista) {
                    BufferedImage imagem = paginas.convertToImage();
                    File saida = new File("/Users/"+System.getProperty("user.name")+"/Google Drive/Notas Fiscais/PNG/"+nome+numeroDePagina+".png");
                    ImageIO.write(imagem, "png", saida);
                    numeroDePagina++;
                }
                documento.close();
            } catch (IOException ex) {
                Relatar.bug(Converte.class.getName(), ex.toString());
                Logger.getLogger(Converte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
