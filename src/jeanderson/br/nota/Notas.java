/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.nota;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeanderson.br.bugs.Relatar;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Notas {

    private String nomeCliente;
    private String endereco;
    private String cidade;
    private String bairro;
    private ArrayList<String> valor = new ArrayList<>();
    private ArrayList<String> produtos = new ArrayList<>();
    private ArrayList<String> quantidades = new ArrayList<>();

    public Notas() {

    }

    public Notas(String nome, String endereco, String cidade, String bairro) {
        this.nomeCliente = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public void addProdutos(String produto) {
        this.produtos.add(produto);
    }

    public void addQuantidades(String quantidade) {
        this.quantidades.add(quantidade);
    }

    public void addValor(String valor) {
        this.valor.add(valor);
    }

    public boolean gerarNotas(int desconto) {
        PdfPTable tabela = new PdfPTable(new float[]{0.7f, 0.18f, 0.2f});
        Document doc = new Document(PageSize.A4, 72, 72, 72, 72);
        try {
            OutputStream os = new FileOutputStream("/Users/" + System.getProperty("user.name") + "/Google Drive/Notas Fiscais/PDF/" + nomeCliente + ".pdf");
            PdfWriter.getInstance(doc, os); // instancio o pdf que vou gravar
            doc.open(); // abro o pdf
            // seleciono a fonte, tamanho
            Font f = new Font(Font.FontFamily.COURIER, 20, Font.BOLD);
            //crio o paragrafo.
            Paragraph p1 = new Paragraph("Nota Eletrônica", f);
            Paragraph p2 = new Paragraph("Comprador(a): " + nomeCliente + "\nEndereço: " + endereco + "\nBairro: " + bairro + "  "
                    + "Cidade: " + cidade + "\nVendedor: Jonatha Monteiro");
            PdfPCell celula = new PdfPCell(p1);
            celula.setColspan(3);
            celula.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(celula);
            PdfPCell celula2 = new PdfPCell(p2);
            celula2.setColspan(3);
            tabela.addCell(celula2);
            PdfPCell nProduto = new PdfPCell(new Paragraph("Produto"));
            PdfPCell nValor = new PdfPCell(new Paragraph("Valor(UN)"));
            nProduto.setHorizontalAlignment(Element.ALIGN_CENTER);
            nValor.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(nProduto);
            tabela.addCell("Quantidade");
            tabela.addCell(nValor);
            double valorTotal = 0;
            for (int i = 0; i < this.produtos.size(); i++) {
                tabela.addCell(produtos.get(i));
                tabela.addCell(quantidades.get(i));
                tabela.addCell(valor.get(i));
                valorTotal += Integer.parseInt(quantidades.get(i)) * Double.parseDouble(valor.get(i));
            }
            Paragraph p3 = null;
            if (desconto == 0) {
                p3 = new Paragraph("Data de Emissão: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
            } else {
                p3 = new Paragraph("\n\nData de Emissão: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
            }
            PdfPCell celula3 = new PdfPCell(p3);
            celula3.setColspan(1);
            tabela.addCell(celula3);
            DecimalFormat df = new DecimalFormat("###,##0.00");
            Paragraph p4 = new Paragraph("Valor Total: R$" + df.format(valorTotal));
            PdfPCell celula4 = null;
            double valorDesc = 0;
            double valorComDesc = 0;
            switch (desconto) {
                case 0:
                    celula4 = new PdfPCell(p4);
                    celula4.setColspan(2);
                    tabela.addCell(celula4);
                    break;
                case 1:
                    valorDesc = (valorTotal * 7) / 100;
                    valorComDesc = valorTotal - valorDesc;
                    celula4 = new PdfPCell(new Paragraph("Total: R$" + df.format(valorTotal) + "\n- 7% Desconto\nValor a pagar: R$" + df.format(valorComDesc)));
                    celula4.setColspan(2);
                    tabela.addCell(celula4);
                    break;
                case 2:
                    valorDesc = (valorTotal * 10) / 100;
                    valorComDesc = valorTotal - valorDesc;
                    celula4 = new PdfPCell(new Paragraph("Total: R$" + df.format(valorTotal) + "\n - 10% Desconto\nValor a pagar: R$" + df.format(valorComDesc)));
                    celula4.setColspan(2);
                    tabela.addCell(celula4);
                    break;
                case 3:
                    valorDesc = (valorTotal * 12) / 100;
                    valorComDesc = valorTotal - valorDesc;
                    celula4 = new PdfPCell(new Paragraph("Total: R$" + df.format(valorTotal) + "\n- 12% Desconto\nValor a pagar: R$" + df.format(valorComDesc)));
                    celula4.setColspan(2);
                    tabela.addCell(celula4);
                    break;
                case 4:
                    valorDesc = (valorTotal * 15) / 100;
                    valorComDesc = valorTotal - valorDesc;
                    celula4 = new PdfPCell(new Paragraph("Total: R$" + df.format(valorTotal) + "\n- 15% Desconto\nValor a pagar: R$" + df.format(valorComDesc)));
                    celula4.setColspan(2);
                    tabela.addCell(celula4);
                    break;
            }
            //tabela.addCell(celula4);
            tabela.setWidthPercentage(100.0f);
            doc.add(tabela); // adiciono a tabela
            doc.close();
            os.close();
            return false;
        } catch (FileNotFoundException ex) {
            Relatar.bug(Notas.class.getName(), ex.getLocalizedMessage());
            Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        } catch (DocumentException ex) {
            Relatar.bug(Notas.class.getName(), ex.getLocalizedMessage());
            Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        } catch (IOException ex) {
            Relatar.bug(Notas.class.getName(), ex.getLocalizedMessage());
            Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }

}
