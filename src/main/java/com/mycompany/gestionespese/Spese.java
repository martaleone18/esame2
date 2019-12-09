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

    static int spese[];
    static String stampaReport;
    static int totale;
    static int anticipoValuta;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //caricare un massimo di otto spese
        spese = new int[8];

        //caricare le spese chieste nel metodo getSpese
        getSpese();
        totale = stampaReport();
        printSpese();
// stampare l'output
        JOptionPane.showMessageDialog(null, printSpese());
        anticipoValuta();
        JOptionPane.showMessageDialog(null, anticipoValuta());
    }

    static void getSpese() {

        for (int i = 0; i < spese.length; i++) {
            String strSpese = JOptionPane.showInputDialog("dimmi valore movimento (es. 0,1 o 250)");
            spese[i] = Integer.parseInt(strSpese);
        }
    }

    static int stampaReport() {
        int newsaldo = 0;
        for (int i = 0; i < spese.length; i++) {
            newsaldo = newsaldo + spese[i];
            stampaReport += (i + 1) + " - " + spese[i];
        }
        return newsaldo;

    }

    static String printSpese() {
        String output = " Elenco spese: ";
        for (int i = 0; i < spese.length; i++) {
            output += "il saldo è di" + totale;
        }
        return output;
    }

    static String anticipoValuta() {
        String avanzo = " ";
        String strAnticipo = JOptionPane.showInputDialog("dimmi quanto hai anticipato");

        if (anticipoValuta > totale) {
            avanzo += printSpese() + "avanzati Euro" + (anticipoValuta - totale);
        } else {
            avanzo += printSpese() + "devi Euro" + (totale - anticipoValuta);
        }

        avanzo = printSpese() + totale + "\n";

        return avanzo;
    }
}
