/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clovecenezlobse;

/**
 *
 * @author Rohlajz
 * trida s konstantama
 */
public class Const {
    public static final String MODRA = "modra";
    public static final String CERVENA= "cervena";
    public static final String ZELENA = "modra";
    public static final String ZLUTA = "zluta";
    
    public static final String setBarva(int cisloHrace){
        String barva;
        switch(cisloHrace){
            case 1:
                barva = CERVENA;
                break;
            case 2:
                barva = MODRA;
                break;
            case 3:
                barva = ZELENA;
                break;
            case 4:
                barva = ZLUTA;
                break;
            default:
                barva = CERVENA;
        }
        return barva;
    }
    public static final String getBarvaPrefix(int cisloHrace){
        String barva;
        switch(cisloHrace){
            case 1:
                barva = "c";
                break;
            case 2:
                barva = "m";
                break;
            case 3:
                barva = "z";
                break;
            case 4:
                barva = "y";
                break;
            default:
                barva = "c";
        }
        return barva;
    }
}
