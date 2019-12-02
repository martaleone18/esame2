/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionespese;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class Spese {

    static int[] spese;
    static int max_spese = 8;
    static int totale = 0;
    static int anticipoValuta;
    static int reportSpese;
static String stampa;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        spese = new int[max_spese];
        getSpese();
        ottieniAnticipoValuta();
        totale = ottieniTotaleSaldo();
        reportSpese();
        printstampaSpese();
    }

    static void getSpese() {

        for (int i = 0; i < spese.length; i++) {
            spese[i] = mySpesa();

        }

    }

    static int ottieniTotaleSaldo() {
        int newsaldo = 0;
        for (int i = 0; i < spese.length; i++) {
            newsaldo = newsaldo + spese[i];
        }
        return newsaldo;

    }

    static int mySpesa() {
        int ris = 0;
        String strmov = JOptionPane.showInputDialog("dimmi valore movimento (es. 0,1 o 250)");

        return ris;
    }

    static int ottieniAnticipoValuta() {
        int ris = 0;
        JOptionPane.showInputDialog("quanto hai anticipato");

        return ris;
    }

    static int reportSpese() {
        int ris = 0;
                reportSpese = totale - anticipoValuta;

if (reportSpese < anticipoValuta) {
                    stampa += " hai avanzato " + reportSpese;
} else {
    stampa += " devi avere " + (anticipoValuta * (-1));
    
}
return ris;
    }

    static void printstampaSpese() {
        String stampa = "";
        //inizio fase lettura e conti vari

        for (int i = 0; i < spese.length; i++) {
            int nriga = i + 1;
            stampa += nriga + "  ";
            if (spese[i] > 0) {
                stampa += " + " + spese[i] + "\n";

            } else {
                stampa += spese[i] + "\n";

            }

            stampa += " il saldo totale è di " + reportSpese() + totale;
            JOptionPane.showMessageDialog(null, stampa);
        }

    }

}
