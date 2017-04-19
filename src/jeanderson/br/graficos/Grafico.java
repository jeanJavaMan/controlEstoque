/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.graficos;

import javax.swing.JPanel;
import jeanderson.br.funcoes.Funcionalidades;
import jeanderson.br.main.Main;
import jeanderson.br.serializacao.BancoProdutos;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Grafico {

    public static JPanel gerarGrafico() {
        BancoProdutos estoqueAntigo = new BancoProdutos();
        estoqueAntigo.recebeproduto(Funcionalidades.receberObjetoAntigo());
        BancoProdutos estoqueAtual = new BancoProdutos();
        estoqueAtual.recebeproduto(Main.getBanco());
        int valorAntigo = 0;
        int valorAtual = 0;
        int ganho = 0;
        for (int i = 0; i < estoqueAntigo.getProdutos().size(); i++) {
            if (estoqueAntigo.getProdutos().get(i).getNome().equals(estoqueAtual.getProdutos().get(i).getNome())) {
                valorAntigo += estoqueAntigo.getProdutos().get(i).getQuantidade();
                valorAtual += estoqueAtual.getProdutos().get(i).getQuantidade();
            }
        }
        ganho = valorAntigo - valorAtual;
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        if(valorAntigo <= valorAtual){
            ds.addValue(valorAntigo, "Total de Estoque Passado", "Estoque Passado");
            ds.addValue(valorAtual, "Total de Estoque Atual", "Estoque Atual");
            ds.addValue(Math.abs(ganho), "Aumento de Estoque", "Aumento");
        }else{
            ds.addValue(valorAntigo, "Total de Estoque Passado", "Estoque Passado");
            ds.addValue(valorAtual, "Total de Estoque Atual", "Estoque Atual");
            ds.addValue(Math.abs(ganho),"Quantidade Vendida", "Vendidos");
        }
        JFreeChart grafico = ChartFactory.createBarChart3D("Gráfico De Vendas", "Produtos", "Quantidade de Produtos", ds, PlotOrientation.VERTICAL, true, true, false);
        return new ChartPanel(grafico);

    }

}
