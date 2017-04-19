/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeanderson.br.testes;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import jeanderson.br.bugs.Relatar;
import org.jfree.data.time.Hour;

/**
 *
 * @author Jeanderson S.Lopes
 */
public class TesteData {

    public static void main(String[] args) throws MalformedURLException {
        //System.out.println(new GregorianCalendar().get(Calendar.ALL_STYLES));
//        Date data = new Date();
//        data.setDate(data.getDate() - 14);
        //System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(data));
//        for(int i = 0; i < 10;i++){
//            int teste = 1;
//            data.setDate(data.getDate()-teste);
//            System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(data));
//        }
        double numero = 617 / 95;
        System.out.printf("%.2f",numero);
    }

}
