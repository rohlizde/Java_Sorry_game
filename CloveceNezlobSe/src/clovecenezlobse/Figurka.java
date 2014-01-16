/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clovecenezlobse;

import javax.swing.*;

public class Figurka {
    private int aktualniIndex;
    private String jmenoPole;
    private int usla;
    
    private int startindex;
    private String barva;
    public Icon ikona;
    public Icon pikona;
    private GUI hra;
    
    public Figurka(int poz, int cislo_hrace, GUI hra){
        this.startindex = poz;
        this.aktualniIndex = poz;
        this.jmenoPole = this.hra.tlacitka[poz].getName();
        this.usla = -1;
        if(cislo_hrace == 1){
            this.barva = "cervena";
            this.ikona = new ImageIcon("../images/cervena_figurka.png");
            this.pikona = new ImageIcon("../images/cervena_kruh.png");
        }else if(cislo_hrace == 2){
            this.barva = "modra";
            this.ikona = new ImageIcon("../images/modra_figurka.png");
            this.pikona = new ImageIcon("../images/modra_kruh.png");
        }else if(cislo_hrace == 3){
            this.barva = "zelena";
            this.ikona = new ImageIcon("../images/zelena_figurka.png");
            this.pikona = new ImageIcon("../images/zelena_kruh.png");
        }else if(cislo_hrace == 4){
            this.barva = "zluta";
            this.ikona = new ImageIcon("../images/zluta_figurka.png");
            this.pikona = new ImageIcon("../images/zluta_kruh.png");
        }
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
    
    public void setFigurku(int novapozice, int usla, String jmeno){
        this.aktualniIndex = novapozice;
        this.usla = usla;
        this.jmenoPole = jmeno;
    }
    
}
