/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esdraschaves
 */
public class Formatacao {
    private static int dia;
    private static int mes;
    private static int ano;
    private static String data;
    
    public static Date formataData (Calendar calendario) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date aux = null;
        
        /*dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        ano = calendario.get(Calendar.YEAR);
        
        data = "" + ano + "-" + mes + "-" + dia + "";*/
        
        data = sdf.format(calendario.getTime());
        
        try {
            aux = new java.sql.Date(sdf.parse(data).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(Formatacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return aux;
        
    }
}
