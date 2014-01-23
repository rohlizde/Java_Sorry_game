/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clovecenezlobse;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class Kostka {

    public Icon kostka1;
    public Icon kostka2;
    public Icon kostka3;
    public Icon kostka4;
    public Icon kostka5;
    public Icon kostka6;
    private Icon ikony[];
    private JButton tlacitko;
    public boolean aktivni = false;
    public int pocetHodu = 0;
    public int hozeno = 0;
    public int ritKonstanta = 0;
    public int pocetHracu;

    public Kostka(JButton tlacitko) {
        this.tlacitko = tlacitko;
        this.tlacitko.setEnabled(true);
        ikony = new Icon[6];
        for (int i = 0; i < 6; i++) {
            String cislo = Integer.toString(i + 1);
            ikony[i] = new ImageIcon("../images/kostka/kostka_" + cislo + ".png");

        }
        this.tlacitko.setIcon(ikony[2]);

    }

    public void nastavIkonuKostka(int i) {
        this.tlacitko.setIcon(ikony[i - 1]);
    }

    public void nastavFunkciKostka() {
        this.tlacitko.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!aktivni) {
                    hod();
                }
            }
        });
    }

    public void hod() {
        int x = 0;
        if (this.ritKonstanta > 0) {
            x = this.ritKonstanta;
        } else {
            x = (int) (1 + Math.random() * 6);
        }
        System.out.println("hozeno:" + x);
        this.nastavIkonuKostka(x);
        this.aktivni = true;
        this.hozeno = x;
        
        
//        if (x > hozeno) {
//            hozeno = x;
//        }
    }

    public void aktivuj() {
        this.aktivni = true;
    }

    public boolean getAktivni() {
        return this.aktivni;
    }

    public int getNaRade() {
        int delitel = 0;
        if(this.pocetHodu < this.pocetHracu * 3)
        {
            delitel = (int)(this.pocetHodu / 3);
            System.out.println(delitel + " delitel");
            return (delitel % 2) + 1;
        }
        else{
            return (this.pocetHodu % 2) + 1;
        }
    }
    public void prictiHod(){
        if(this.pocetHodu < (pocetHracu * 3)){
            if(((this.pocetHodu) % 3) == 2 && hozeno == 6){
            }
            else{
                this.pocetHodu++;
            }
        }
        else{
            if(this.hozeno != 6){
                pocetHodu++;
            }
        }
        System.out.println("Pocet " + this.pocetHodu + " Hodil " + this.hozeno);
    }
}
