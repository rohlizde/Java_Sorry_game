/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clovecenezlobse;

import javax.swing.*;

public class Figurka {
    private int aktualniIndex; //aktualni policko
    private String jmenoPole; //jmeno aktualniho policka figurky
    public int usla = 0; //pocet kroku od startu
    private int startindex; // startovaci policko figurky
    private String barva; 
    public Icon ikona;
    public Icon pikona; //predchozi ikona
    
    public Figurka(int pozice, int cislo_hrace, String jmeno){
        this.jmenoPole = jmeno;
        this.startindex = this.aktualniIndex = pozice;
        //this.jmenoPole = this.hra.tlacitka[poz].getName();
        this.usla = -1; //je v domecku
        this.barva = Const.setBarva(cislo_hrace);
        this.ikona = new ImageIcon("../images/"+this.barva+"_figurka.png");
        this.pikona = new ImageIcon("../images/"+this.barva+"_kruh.png");
    }
    
    public int getStartIndex(){
        return this.startindex;
    }    
    
    public int getAktualniIndex(){
        return this.aktualniIndex;
    }

    public Icon getIcon(){
        return this.ikona;
    }
    
    public Icon getPicon(){
        return this.pikona;
    }
    
    public String getJmenoPole(){
        return this.jmenoPole;
    }
    
    /**
     * 
     * @param novapozice
     * @param usla
     * @param jmeno 
     */
    public void setFigurku(int novapozice, int usla, String jmeno){
        this.aktualniIndex = novapozice;
        this.usla = usla;
        this.jmenoPole = jmeno;
    }
    
}
