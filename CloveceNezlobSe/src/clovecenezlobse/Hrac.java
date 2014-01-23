/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clovecenezlobse;

import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Hrac {

    public List figurky = new ArrayList(); //figurky
    public String barvaHrace; //barva
    private int startovaciIndex; //startovni pozice
    public Icon prazdneKolecko;
    public Icon plneKolecko;
    public int cisloHrace;

    public Hrac(int cislo_hrace) {
        this.cisloHrace = cislo_hrace;
        System.out.println("vytvarim hrace číslo:" + cislo_hrace);
        this.barvaHrace = Const.setBarva(cislo_hrace);
        this.setFigurky();
        this.startovaciIndex = (cislo_hrace - 1)*10; // 0, 10, 20, 30
        this.prazdneKolecko = new ImageIcon("./images/" + this.barvaHrace + "_kruh.png");
        this.plneKolecko = new ImageIcon("./images/" + this.barvaHrace + "_figurka.png");
    }
    /**
     * 
     * @param index
     * @return 
     */
    public int maFigurkuNaIndexu(String index) {
        for (int i = 1; i < 5; i++) {
            Figurka fig = (Figurka) this.figurky.get(i);
            //System.out.println(fig.getAktualniIndex());
            Figurka figurka = (Figurka) figurky.get(i);
            if (index.equals(figurka.getJmenoPole())) {
                return i;
            }
        }
        return 0;
    }
    /**
     * nastav figurky
     */
    public void setFigurky(){
        int indexy[] = {0, 14, 15, 27, 28, 23, 24, 36, 37, 140, 141, 153, 154, 131, 132, 144, 145}; // indexy domecku
        this.figurky.add(null); // pridam nulty prvek abych mel cisla v domecku od 1
        String prefix = Const.getBarvaPrefix(cisloHrace);
        for (int i = 1; i < 5; i++) {
            Figurka figurka;
            //System.out.println(prefix + "d" + i);
            figurka = new Figurka(indexy[(((this.cisloHrace - 1) * 4) + i)], this.cisloHrace, prefix + "s" + i);
            this.figurky.add(figurka);
        }
    }
    public int getStartIndex() {
        return this.startovaciIndex;
    }

    public Figurka getFigurku(int pozice) {
        return (Figurka) figurky.get(pozice);
    }
    
    public boolean jeNaRade(int poradi){
        if(poradi == this.cisloHrace){
            return true;
        }
        else{
            return false;
        }
    }
}
