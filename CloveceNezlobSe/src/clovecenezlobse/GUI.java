/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clovecenezlobse;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;



public class GUI extends JFrame{
    private JFrame hlavni_okno;
    private Container kontejner;
    private Hra hra;
    private int pocetHracu;
    private int naRade;
    
    private boolean odehrano;
    public Hrac[] hraci;
    public JButton[] tlacitka;
    public JButton[] hernicesta;
    public int[] indexy;
    Thread vlakno;
    
    private Icon cernaKruh;
    private Icon cervenaKruh;
    private Icon zlutaKruh;
    private Icon zelenaKruh;
    private Icon modraKruh;
    private Icon cervenaFigurka;
    private Icon zelenaFigurka;
    private Icon modraFigurka;
    private Icon zlutaFigurka;
    
    
    public GUI(Hra hra){
        this.hraci = new Hrac[5];
        this.hra = hra;
        nadefinujIkony();
        hlavni_okno = null;
        vytvorHlanvniOkno();
        nastavIndexyDoPole();
        naplnOknoButtny();
        vykresliHerniCestu();
        
        
        hlavni_okno.setVisible(true);
    }
    
    private void vytvorHlanvniOkno(){
        hlavni_okno = new JFrame("Clovece nezlob se! :-)");    //Nazev
        hlavni_okno.setSize(new Dimension(715,715));          //Velikost okna
        hlavni_okno.setVisible(true);                         //Viditelnost okna
        hlavni_okno.setResizable(false);                      //Zakázání změny velikosti okna
        hlavni_okno.setLocationRelativeTo(null);              //Nastavení defaultního vycentrování okna
        hlavni_okno.setDefaultCloseOperation(EXIT_ON_CLOSE);  //Po zavreni okna se aplikace vypne
        kontejner = hlavni_okno.getContentPane();
        kontejner.setLayout(new GridLayout(13, 13));
        Menu menu = new Menu(this);
        hlavni_okno.setJMenuBar(menu.createMenu()); 
    }
    
    private void nastavIndexyDoPole(){
        int [] ind = {66,67,68,69,70,57,44,31,18,19,20,33,46,59,72,73,74,75,76,89,102,101,100,99,98,111,124,137,150,149,148,135,122,109,96,95,94,93,92,79};
        this.indexy = ind;
    }

    private void naplnOknoButtny(){
        tlacitka = new JButton[169];
        for(int i = 0; i<169;i++){
            JButton tlacitko = new JButton();
            tlacitko.setBorderPainted(false);    
            tlacitko.setEnabled(false);
            tlacitko.setBackground(Color.gray);
            tlacitko.setName("neutralni");
            tlacitka[i] = tlacitko;
            kontejner.add(tlacitko);
        }
    }
    
    private void vykresliHerniCestu(){
        hernicesta = new JButton[indexy.length];
        for(int i=0;i<indexy.length;i++){
            tlacitka[indexy[i]].setEnabled(true);
            tlacitka[indexy[i]].setIcon(this.cernaKruh);
            tlacitka[indexy[i]].setName(Integer.toString(i));
            hernicesta[i] = tlacitka[indexy[i]];
        }
        vyresliHrace();
        nastavAkceTlacitkum();
    }
    
    private void nastavAkceTlacitkum(){
        int indexy[] = {0, 14, 15, 27, 28, 23, 24, 36, 37, 140, 141, 153, 154, 131, 132, 144, 145};
        for(int i=0;i<hernicesta.length;i++){
            if(!(tlacitka[i].getName().equals("neutralni"))){
                    final JButton tlacitko;
                    tlacitko = tlacitka[i];
                    tlacitko.addActionListener( new java.awt.event.ActionListener() {
                    @Override public void actionPerformed(ActionEvent e) {
                        GUI.this.krok(tlacitko.getName());
                    }
                    } );   
            }
        }
        for(int i=1;i<indexy.length;i++){
            final JButton tlacitko;
            tlacitko = tlacitka[indexy[i]];
            tlacitko.addActionListener( new java.awt.event.ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                GUI.this.krok(tlacitko.getName());
            }
            } );  
        }
    }
    
    private void vyresliHrace(){
        vybarvyCerveny();
        vybarvyModry();
        vybarvyZeleny();
        vybarvyZluty();
    }
    
     //------------------------------------------------------------------------------
     private void vybarvyCerveny(){
            tlacitka[14].setIcon(cervenaKruh); tlacitka[14].setEnabled(true); tlacitka[14].setName("cs1");     
            tlacitka[15].setIcon(cervenaKruh); tlacitka[15].setEnabled(true); tlacitka[15].setName("cs2");
            tlacitka[27].setIcon(cervenaKruh); tlacitka[27].setEnabled(true); tlacitka[27].setName("cs3");
            tlacitka[28].setIcon(cervenaKruh); tlacitka[28].setEnabled(true); tlacitka[28].setName("cs4");
            tlacitka[80].setIcon(cervenaKruh); tlacitka[80].setEnabled(true); tlacitka[80].setName("cd1");
            tlacitka[81].setIcon(cervenaKruh); tlacitka[81].setEnabled(true); tlacitka[81].setName("cd2");
            tlacitka[82].setIcon(cervenaKruh); tlacitka[82].setEnabled(true); tlacitka[82].setName("cd3");
            tlacitka[83].setIcon(cervenaKruh); tlacitka[83].setEnabled(true); tlacitka[83].setName("cd4");
     }
     //------------------------------------------------------------------------------
     private void vybarvyModry(){
            tlacitka[23].setIcon(modraKruh); tlacitka[23].setEnabled(true); tlacitka[23].setName("ms1");      
            tlacitka[24].setIcon(modraKruh); tlacitka[24].setEnabled(true); tlacitka[24].setName("ms2");
            tlacitka[36].setIcon(modraKruh); tlacitka[36].setEnabled(true); tlacitka[36].setName("ms3");
            tlacitka[37].setIcon(modraKruh); tlacitka[37].setEnabled(true); tlacitka[37].setName("ms4");
            tlacitka[32].setIcon(modraKruh); tlacitka[32].setEnabled(true); tlacitka[32].setName("md1");
            tlacitka[45].setIcon(modraKruh); tlacitka[45].setEnabled(true); tlacitka[45].setName("md2");
            tlacitka[58].setIcon(modraKruh); tlacitka[58].setEnabled(true); tlacitka[58].setName("md3");
            tlacitka[71].setIcon(modraKruh); tlacitka[71].setEnabled(true); tlacitka[71].setName("md4");
     }
     //------------------------------------------------------------------------------
     private void vybarvyZluty(){
            tlacitka[131].setIcon(zlutaKruh); tlacitka[131].setEnabled(true); tlacitka[131].setName("ys1"); 
            tlacitka[132].setIcon(zlutaKruh); tlacitka[132].setEnabled(true); tlacitka[132].setName("ys2");
            tlacitka[144].setIcon(zlutaKruh); tlacitka[144].setEnabled(true); tlacitka[144].setName("ys3");
            tlacitka[145].setIcon(zlutaKruh); tlacitka[145].setEnabled(true); tlacitka[145].setName("ys4");
            tlacitka[136].setIcon(zlutaKruh); tlacitka[136].setEnabled(true); tlacitka[136].setName("yd1");
            tlacitka[123].setIcon(zlutaKruh); tlacitka[123].setEnabled(true); tlacitka[123].setName("yd2");
            tlacitka[110].setIcon(zlutaKruh); tlacitka[110].setEnabled(true); tlacitka[110].setName("yd3");
            tlacitka[97].setIcon(zlutaKruh); tlacitka[97].setEnabled(true); tlacitka[97].setName("yd4");
     }   
     //------------------------------------------------------------------------------
     private void vybarvyZeleny(){
            tlacitka[140].setIcon(zelenaKruh); tlacitka[140].setEnabled(true); tlacitka[140].setName("zs1");      
            tlacitka[141].setIcon(zelenaKruh); tlacitka[141].setEnabled(true); tlacitka[141].setName("zs2");
            tlacitka[153].setIcon(zelenaKruh); tlacitka[153].setEnabled(true); tlacitka[153].setName("zs3");
            tlacitka[154].setIcon(zelenaKruh); tlacitka[154].setEnabled(true); tlacitka[154].setName("zs4");
            tlacitka[88].setIcon(zelenaKruh); tlacitka[88].setEnabled(true); tlacitka[88].setName("zd1");
            tlacitka[87].setIcon(zelenaKruh); tlacitka[87].setEnabled(true); tlacitka[87].setName("zd2");
            tlacitka[86].setIcon(zelenaKruh); tlacitka[86].setEnabled(true); tlacitka[86].setName("zd3");
            tlacitka[85].setIcon(zelenaKruh); tlacitka[85].setEnabled(true); tlacitka[85].setName("zd4");
     }
    
    private void nadefinujIkony(){
        cernaKruh = new ImageIcon("../images/cerna_kruh.png");
        cervenaKruh = new ImageIcon("../images/cervena_kruh.png");
        this.zlutaKruh = new ImageIcon("../images/zluta_kruh.png");
        this.zelenaKruh = new ImageIcon("../images/zelena_kruh.png");
        this.modraKruh = new ImageIcon("../images/modra_kruh.png");
        this.cervenaFigurka = new ImageIcon("../images/cervena_figurka.png");
        this.modraFigurka = new ImageIcon("../images/modra_figurka.png");
        this.zelenaFigurka = new ImageIcon("../images/zelena_figurka.png");
        this.zlutaFigurka = new ImageIcon("../images/zluta_figurka.png");
    }    
 
    public void setPocetHracu(int pocet){
        this.pocetHracu = pocet;
    }
    
    public int getPocetHracu(){
        return this.pocetHracu;
    }
    
    private void vytvorHrace(){
        for(int i = 0;i<5;i++){
            hraci[i] = null;
        }
        for(int i=1;i<=pocetHracu;i++){
            hraci[i] = new Hrac((i), this);
            System.out.println("hrač č."+(i)+" byl vytvořen!");
        }
        System.out.println("");
        System.out.println("");
        vykresliHrace();
    }
    
    private void vykresliHrace(){
        for(int i=1;i<=this.pocetHracu;i++){
            System.out.println("Chci vykreslit hrace c:"+i);
            for(int j=1;j<5;j++){
                Figurka figurka = (Figurka) hraci[i].getFigurku(j);
                tlacitka[figurka.getStartIndex()].setIcon(figurka.getIcon());
            }
        }
    }
    
    public void novaHra(){
        odehrano = false;
        vykresliHerniCestu();     
        vytvorHrace();
        naRade = 1;
        try{
            vlakno.interrupt();
        }catch(NullPointerException e){
            System.err.print("");
        }
        System.out.println("---------------------------------------------");
        vlakno = new Thread() {
            @Override
            public void run() {
                try {
                    hraj();
                } catch (InterruptedException ex) {
                    System.err.println("vyjimka");
                }
            }
       };vlakno.start();
    }    

    public synchronized void hraj() throws InterruptedException{
        while(true){
            if(odehrano = true){
                
                try {
                    this.wait();
                    }
                catch (InterruptedException e) {
                    System.out.print("");
                }
            }
        }
    }    
    
    public synchronized void krok(String index){
        boolean status = false;
        odehrano = true;
        System.out.println("kliknuto tlacitko:"+index);
        if(pocetHracu>0){
            status = true;
        }
        if(status == true && pocetHracu>0){
            System.out.println("KROK");
            notifyAll();
        }
        
       
    }    
    
    
    
}
