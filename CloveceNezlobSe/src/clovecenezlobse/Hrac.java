/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clovecenezlobse;

import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Hrac {
    public List figurky;
    private int startovaciIndex;
    public Icon prazdneKolecko;
    public Icon plneKolecko;
    private GUI hra;
   
    
    public Hrac(int cislo_hrace, GUI hra){
        this.hra = hra;
        String barvy[] = {"cervena", "modra", "zelena", "zluta"}; 
        int startIndex[] = {0, 0, 10, 20, 30};
        int indexy[] = {0, 14, 15, 27, 28, 23, 24, 36, 37, 140, 141, 153, 154, 131, 132, 144, 145};
        figurky = new ArrayList();
        for(int i=1;i<5;i++){
            Figurka figurka;
            figurka = new Figurka(indexy[(((cislo_hrace-1)*4)+i)], cislo_hrace, hra);
            figurky.add(figurka);
        }
        this.startovaciIndex = startIndex[cislo_hrace];
        this.prazdneKolecko = new ImageIcon("./images/"+barvy[cislo_hrace-1]+"_kruh.png");
        this.plneKolecko = new ImageIcon("./images/"+barvy[cislo_hrace-1]+"_figurka.png");
    }
    
    public boolean maFigurkuNaIndexu(String index){
        for(int i=0;i<4;i++){
            Figurka figurka= (Figurka)figurky.get(i);
            if(figurka.getJmenoPole().equals(index)){
                return true;
            } 
        }
        return false;
    }
    
    public int getStartIndex(){
        return this.startovaciIndex;
    }
    
    public Figurka getFigurku(int pozice){
        for(int i=0;i<4;i++){
            Figurka figurka = (Figurka) figurky.get(i);
            if(figurka.getAktualniIndex() == pozice){
                return figurka;
            }
        }
        return null;
    }
}
