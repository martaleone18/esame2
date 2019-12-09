/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionespese;

import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class GetSpese {

    static int spese[];
    static int saldo = 0;
    static String stampaSaldo;
    static int anticipoValuta;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //inserire array per caricare un massimo di otto spese
        spese = new int[8];

        //fase input dati
        getSpese();
        // fase elaborazione dati
        //calcolo del saldo
        saldo = preparaSaldo();
        //fase output
        printSpese();

        //chiedere all'utente cosa ha anticipato e stampare l'avanzo
        anticipoValuta();
        JOptionPane.showMessageDialog(null, anticipoValuta());
    }

    static int preparaSaldo() {
        int newsaldo = 0;
        for (int i = 0; i < spese.length; i++) {
            newsaldo = newsaldo + spese[i];
        }
        return newsaldo;
    }

    static void getSpese() {

        for (int i = 0; i < spese.length; i++) {
            String strSpese = JOptionPane.showInputDialog("dimmi valore movimento (es. 0,1 o 250)");
            spese[i] = Integer.parseInt(strSpese);
            stampaSaldo += spese[i] + (i + 1) + " - ";

        }

    }

    static void printSpese() {
        String output = "";
        for (int i = 0; i < spese.length; i++) {
            output += "il saldo è di" + saldo;
            JOptionPane.showMessageDialog(null, output);
        }

    }

    static String anticipoValuta() {
        String ris = " ";
        String strAnticipo = JOptionPane.showInputDialog("dimmi quanto hai anticipato");

        if (anticipoValuta > saldo) {
            ris += preparaSaldo() + "avanzati Euro" + (anticipoValuta - saldo);
        } else {
            ris += preparaSaldo() + "devi Euro" + (saldo - anticipoValuta);
        }

        ris = preparaSaldo() + ris + "\n";

        return ris;
    }

}
