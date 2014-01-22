/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clovecenezlobse;

public class Hra {
    private int naRade;
    public GUI deska;
    private int pocetHracu;
    private int pocetHodu;
    private int hozeno;
    private boolean odehrano;
    private Thread vlakno;
    
    
    
    public Hra(){
        deska = new GUI(this);
        //deska.vytvorDesku();
        //deska.nadefinujHerniCestu();
        pocetHracu =0;
    }
}
