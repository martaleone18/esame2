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
    static int anticipoValuta;
    static String stampa;
    static int totale;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //caricare un massimo di otto spese
        spese = new int[8];

        //caricare le spese chieste nel metodo getSpese
        getSpese();
        printSpese();
// stampare l'output
        String schedaSpese = printSpese();
        JOptionPane.showMessageDialog(null, schedaSpese);
        anticipoValuta();

    }

    static void getSpese() {

        for (int i = 0; i < spese.length; i++) {
            String strSpese = JOptionPane.showInputDialog("dimmi valore movimento (es. 0,1 o 250)");
            spese[i] = Integer.parseInt(strSpese);
        }
    }

  

    static String printSpese() {
        String ris = "Elenco spese";
        int totale = 0;
        for (int i = 0; i < spese.length; i++) {
            stampa += (i + 1) + " - " + spese[i];
            totale = totale + spese[i];

        }

        ris = ris + totale + "\n";
        
        if (anticipoValuta > totale) {
            stampa += "avanzati Euro" + (anticipoValuta - totale);
        } else {
            stampa += "devi Euro" + (totale - anticipoValuta);
        }
        return ris;
    }
    
      static void anticipoValuta() {
        String strAnticipo = JOptionPane.showInputDialog("dimmi quanto hai anticipato");
    }

}
