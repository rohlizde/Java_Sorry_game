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

public class GUI extends JFrame {

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
    public Kostka kostka;

    public GUI(Hra hra) {
        this.hraci = new Hrac[5];
        this.hra = hra;
        nadefinujIkony();
        hlavni_okno = null;
        vytvorHlanvniOkno();
        nastavIndexyDoPole();
        naplnOknoButtony();
        vykresliHerniCestu();
        this.kostka = new Kostka(this.tlacitka[84]);


        hlavni_okno.setVisible(true);
    }

    private void vytvorHlanvniOkno() {
        hlavni_okno = new JFrame("Clovece nezlob se! :-)");    //Nazev
        hlavni_okno.setSize(new Dimension(715, 715));          //Velikost okna
        hlavni_okno.setVisible(true);                         //Viditelnost okna
        hlavni_okno.setResizable(false);                      //Zakázání změny velikosti okna
        hlavni_okno.setLocationRelativeTo(null);              //Nastavení defaultního vycentrování okna
        hlavni_okno.setDefaultCloseOperation(EXIT_ON_CLOSE);  //Po zavreni okna se aplikace vypne
        kontejner = hlavni_okno.getContentPane();
        kontejner.setLayout(new GridLayout(13, 13));
        Menu menu = new Menu(this);
        hlavni_okno.setJMenuBar(menu.createMenu());
    }

    private void nastavIndexyDoPole() {
        int[] ind = {66, 67, 68, 69, 70, 57, 44, 31, 18, 19, 20, 33, 46, 59, 72, 73, 74, 75, 76, 89, 102, 101, 100, 99, 98, 111, 124, 137, 150, 149, 148, 135, 122, 109, 96, 95, 94, 93, 92, 79};
        this.indexy = ind;
    }

    private void naplnOknoButtony() {
        tlacitka = new JButton[169];
        for (int i = 0; i < 169; i++) {
            JButton tlacitko = new JButton();
            tlacitko.setBorderPainted(false);
            tlacitko.setEnabled(false);
            tlacitko.setBackground(Color.gray);
            tlacitko.setName("neutralni");
            tlacitka[i] = tlacitko;
            kontejner.add(tlacitko);
        }
    }

    private void vykresliHerniCestu() {
        this.hernicesta = new JButton[this.indexy.length];
        for (int i = 0; i < this.indexy.length; i++) {
            tlacitka[this.indexy[i]].setEnabled(true);
            tlacitka[this.indexy[i]].setIcon(this.cernaKruh);
            tlacitka[this.indexy[i]].setName(Integer.toString(i));
            this.hernicesta[i] = tlacitka[this.indexy[i]];
        }
        this.vyresliHrace();
        this.nastavAkceTlacitkum();
    }

    private void nastavAkceTlacitkum() {
        int indexy[] = {0, 14, 15, 27, 28, 23, 24, 36, 37, 140, 141, 153, 154, 131, 132, 144, 145, 80, 81, 82, 83, 32, 45, 58, 71, 85, 86, 87, 88, 97, 110, 123, 136};
        for (int i = 0; i < hernicesta.length; i++) {
            final JButton tlacitko;
            tlacitko = this.hernicesta[i];
            tlacitko.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GUI.this.krok(tlacitko.getName());
                }
            });
        }
        for (int i = 1; i < indexy.length; i++) {
            final JButton tlacitko;
            tlacitko = tlacitka[indexy[i]];
            tlacitko.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GUI.this.krok(tlacitko.getName());
                }
            });
        }
    }

    /**
     * Vykresli ikony
     */
    private void vyresliHrace() {
        this.vybarvyCerveny();
        this.vybarvyModry();
        this.vybarvyZeleny();
        this.vybarvyZluty();
    }

    //------------------------------------------------------------------------------
    private void vybarvyCerveny() {
        tlacitka[14].setIcon(cervenaKruh);
        tlacitka[14].setEnabled(true);
        tlacitka[14].setName("cs1"); //cervena start 1
        tlacitka[15].setIcon(cervenaKruh);
        tlacitka[15].setEnabled(true);
        tlacitka[15].setName("cs2");
        tlacitka[27].setIcon(cervenaKruh);
        tlacitka[27].setEnabled(true);
        tlacitka[27].setName("cs3");
        tlacitka[28].setIcon(cervenaKruh);
        tlacitka[28].setEnabled(true);
        tlacitka[28].setName("cs4");
        tlacitka[80].setIcon(cervenaKruh);
        tlacitka[80].setEnabled(true);
        tlacitka[80].setName("cd1"); //cerveny domecek 1
        tlacitka[81].setIcon(cervenaKruh);
        tlacitka[81].setEnabled(true);
        tlacitka[81].setName("cd2");
        tlacitka[82].setIcon(cervenaKruh);
        tlacitka[82].setEnabled(true);
        tlacitka[82].setName("cd3");
        tlacitka[83].setIcon(cervenaKruh);
        tlacitka[83].setEnabled(true);
        tlacitka[83].setName("cd4");

        hernicesta[0].setIcon(cervenaKruh);
        hernicesta[0].setEnabled(true);
        hernicesta[0].setName("0");
    }
    //------------------------------------------------------------------------------

    private void vybarvyModry() {
        tlacitka[23].setIcon(modraKruh);
        tlacitka[23].setEnabled(true);
        tlacitka[23].setName("ms1");
        tlacitka[24].setIcon(modraKruh);
        tlacitka[24].setEnabled(true);
        tlacitka[24].setName("ms2");
        tlacitka[36].setIcon(modraKruh);
        tlacitka[36].setEnabled(true);
        tlacitka[36].setName("ms3");
        tlacitka[37].setIcon(modraKruh);
        tlacitka[37].setEnabled(true);
        tlacitka[37].setName("ms4");
        tlacitka[32].setIcon(modraKruh);
        tlacitka[32].setEnabled(true);
        tlacitka[32].setName("md1");
        tlacitka[45].setIcon(modraKruh);
        tlacitka[45].setEnabled(true);
        tlacitka[45].setName("md2");
        tlacitka[58].setIcon(modraKruh);
        tlacitka[58].setEnabled(true);
        tlacitka[58].setName("md3");
        tlacitka[71].setIcon(modraKruh);
        tlacitka[71].setEnabled(true);
        tlacitka[71].setName("md4");

        hernicesta[10].setIcon(modraKruh);
        hernicesta[10].setEnabled(true);
        hernicesta[10].setName("10");
    }
    //------------------------------------------------------------------------------

    private void vybarvyZluty() {
        tlacitka[131].setIcon(zlutaKruh);
        tlacitka[131].setEnabled(true);
        tlacitka[131].setName("ys1");
        tlacitka[132].setIcon(zlutaKruh);
        tlacitka[132].setEnabled(true);
        tlacitka[132].setName("ys2");
        tlacitka[144].setIcon(zlutaKruh);
        tlacitka[144].setEnabled(true);
        tlacitka[144].setName("ys3");
        tlacitka[145].setIcon(zlutaKruh);
        tlacitka[145].setEnabled(true);
        tlacitka[145].setName("ys4");
        tlacitka[136].setIcon(zlutaKruh);
        tlacitka[136].setEnabled(true);
        tlacitka[136].setName("yd1");
        tlacitka[123].setIcon(zlutaKruh);
        tlacitka[123].setEnabled(true);
        tlacitka[123].setName("yd2");
        tlacitka[110].setIcon(zlutaKruh);
        tlacitka[110].setEnabled(true);
        tlacitka[110].setName("yd3");
        tlacitka[97].setIcon(zlutaKruh);
        tlacitka[97].setEnabled(true);
        tlacitka[97].setName("yd4");

        hernicesta[30].setIcon(zlutaKruh);
        hernicesta[30].setEnabled(true);
        hernicesta[30].setName("20");
    }
    //------------------------------------------------------------------------------

    private void vybarvyZeleny() {
        tlacitka[140].setIcon(zelenaKruh);
        tlacitka[140].setEnabled(true);
        tlacitka[140].setName("zs1");
        tlacitka[141].setIcon(zelenaKruh);
        tlacitka[141].setEnabled(true);
        tlacitka[141].setName("zs2");
        tlacitka[153].setIcon(zelenaKruh);
        tlacitka[153].setEnabled(true);
        tlacitka[153].setName("zs3");
        tlacitka[154].setIcon(zelenaKruh);
        tlacitka[154].setEnabled(true);
        tlacitka[154].setName("zs4");
        tlacitka[88].setIcon(zelenaKruh);
        tlacitka[88].setEnabled(true);
        tlacitka[88].setName("zd1");
        tlacitka[87].setIcon(zelenaKruh);
        tlacitka[87].setEnabled(true);
        tlacitka[87].setName("zd2");
        tlacitka[86].setIcon(zelenaKruh);
        tlacitka[86].setEnabled(true);
        tlacitka[86].setName("zd3");
        tlacitka[85].setIcon(zelenaKruh);
        tlacitka[85].setEnabled(true);
        tlacitka[85].setName("zd4");
        hernicesta[20].setIcon(zelenaKruh);
        hernicesta[20].setEnabled(true);
        hernicesta[20].setName("30");
    }

    private void nadefinujIkony() {
        this.cernaKruh = new ImageIcon("../images/cerna_kruh.png");
        this.cervenaKruh = new ImageIcon("../images/cervena_kruh.png");
        this.zlutaKruh = new ImageIcon("../images/zluta_kruh.png");
        this.zelenaKruh = new ImageIcon("../images/zelena_kruh.png");
        this.modraKruh = new ImageIcon("../images/modra_kruh.png");
        this.cervenaFigurka = new ImageIcon("../images/cervena_figurka.png");
        this.modraFigurka = new ImageIcon("../images/modra_figurka.png");
        this.zelenaFigurka = new ImageIcon("../images/zelena_figurka.png");
        this.zlutaFigurka = new ImageIcon("../images/zluta_figurka.png");
    }

    public void setPocetHracu(int pocet) {
        this.pocetHracu = pocet;
    }

    public int getPocetHracu() {
        return this.pocetHracu;
    }

    private void vytvorHrace() {
        for (int i = 0; i < 5; i++) {
            this.hraci[i] = null;
        }
        for (int i = 1; i <= pocetHracu; i++) {
            this.hraci[i] = new Hrac((i));
            System.out.println("hrač č." + (i) + " byl vytvořen!");
        }
        System.out.println("");
        System.out.println("");
        this.vykresliHrace();
    }

    private void vykresliHrace() {
        for (int i = 1; i <= this.pocetHracu; i++) {
            System.out.println("Chci vykreslit hrace c:" + i);
            for (int j = 1; j < 5; j++) {
                Figurka figurka = (Figurka) this.hraci[i].getFigurku(j);
                tlacitka[figurka.getStartIndex()].setIcon(figurka.getIcon());
            }
        }
    }

    public void novaHra() {
        this.odehrano = false;
        this.vykresliHerniCestu();
        this.vytvorHrace();
        this.nastavCheaty();
        this.kostka.pocetHracu = this.pocetHracu;
        this.naRade = 1;
        if (!kostka.aktivni) {
            System.out.println(kostka.aktivni + " kostka");
            this.kostka.nastavFunkciKostka(); //zapneme kostku
        }
        try {
            this.vlakno.interrupt(); //zruseni stare hry
        } catch (NullPointerException e) {
            System.err.print("");
        }
        System.out.println("---------------------------------------------");
        this.vlakno = new Thread() {
            @Override
            public void run() {
                try {
                    hraj();
                } catch (InterruptedException ex) {
                    System.err.println("vyjimka");
                }
            }
        };
        this.vlakno.start();
    }

    public synchronized void hraj() throws InterruptedException {
        while (true) {
            if (this.odehrano = true) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    System.out.print("");
                }
            }
        }
    }

    public synchronized void krok(String jmeno) {
        boolean status = false;
        this.odehrano = true;
        //System.out.println("Hraje " + this.kostka.getNaRade());
        if (pocetHracu > 0) {
            status = true;
        }
        //System.out.println(this.kostka.aktivni);
        if (status == true && pocetHracu > 0 && this.kostka.aktivni) {
            //System.out.println("KROK");
            this.naRade = this.kostka.getNaRade();
            System.out.println("Na rade je: " + this.naRade);
            int index = this.hraci[this.naRade].maFigurkuNaIndexu(jmeno); //index figurky ve tride hraci
            //System.out.println(index + " INDEX");
            if (index != 0) {
                if (this.jeVeStartPozici(jmeno) && kostka.hozeno == 6) {
                    //System.out.println("Nasazuji figuru");
                    this.nasadFigurku(jmeno, index);
                    this.kostka.aktivni = false;
                } else if (this.jeVDomecku(jmeno)) {
                    //System.out.println("Domecek");
                    this.posunDomecek(jmeno, index);
                    this.kostka.aktivni = false;
                } else if (this.jeVHernimPoli(jmeno)) {
                    //System.out.println("Posun figurku");
                    this.posunFigurku(jmeno, index);
                    this.kostka.aktivni = false;
                } else {
                    this.kostka.aktivni = false;
                }
                this.kostka.prictiHod();
            }
            notifyAll();
        }

    }

    public void nasadFigurku(String jmeno, int index) {
        int sIndex = this.hraci[this.naRade].getStartIndex(); //start index hrace
        Figurka figurka = (Figurka) this.hraci[this.naRade].figurky.get(index);
        int[] jeObsazene = this.jeObsazene(this.hernicesta[sIndex].getName()); //je obsazeny index hernicesta[] kam nasazuji figurku
        int indexVPoli = this.getIndexTlacitka(jmeno); //index v atributu tlacitka
        //kdyz vyhazuji jinou figurku
        //System.out.println(jeObsazene[0] + " " + jeObsazene[1] + " OBSAZENE");
        if (jeObsazene[0] > 0) {
            Figurka utocnik = (Figurka) this.hraci[jeObsazene[0]].figurky.get(jeObsazene[1]);
            utocnik.setFigurku(utocnik.getStartIndex(), 0, this.tlacitka[utocnik.getStartIndex()].getName()); //nastavuji model utocnika
            this.setObrazekTlacitka(utocnik.getStartIndex(), utocnik.getIcon()); //nastavuju ikonu tlacitka ve startu utocnika
        }
        //nastaveni figurky hrace na rade
        figurka.setFigurku(sIndex, 0, this.hernicesta[sIndex].getName());
        this.setObrazekTlacitka(indexVPoli, figurka.getPicon()); //nastav predchozi tlacitko
        this.setObrazekHernicesta(this.hraci[this.naRade].getStartIndex(), figurka.getIcon());
    }

    public boolean jeVeStartPozici(String jmeno) {
        if (jmeno.indexOf("s") != -1) {
            return true;
        }
        return false;
    }

    public int getIndexTlacitka(String jmeno) {
        for (int i = 0; i < this.tlacitka.length; i++) {
            if (jmeno.equals(this.tlacitka[i].getName())) {
                return i;
            }
        }
        return -1;
    }

    public void setObrazekTlacitka(int index, Icon ikona) {
        this.tlacitka[index].setIcon(ikona);
    }

    public void setObrazekHernicesta(int index, Icon ikona) {
        this.hernicesta[index].setIcon(ikona);
    }

    /**
     *
     * @param jmeno
     * @return int[] -1,-1 kdyz neni obsazene, jinak cislo hrace a cislo figurky
     */
    public int[] jeObsazene(String jmeno) {
        int ret[] = {-1, -1};
        int cislo;
        for (int i = 1; i < this.pocetHracu + 1; i++) {
            cislo = this.hraci[i].maFigurkuNaIndexu(jmeno);
            if (cislo > 0) {
                ret[0] = i;
                ret[1] = cislo;
                break;
            }
        }
        return ret;
    }

    public boolean jeVHernimPoli(String jmeno) {
        for (int i = 0; i < this.hernicesta.length; i++) {
            if (jmeno.equals(this.hernicesta[i].getName())) {
                return true;
            }
        }
        return false;
    }

    public void posunFigurku(String jmeno, int index) {
        Figurka figurka = (Figurka) this.hraci[this.naRade].figurky.get(index); //figurka se kterou hybu
        int sIndex = figurka.getAktualniIndex(); // index figurky kde stoji
        int dIndex = sIndex + this.kostka.hozeno; //index kam chci jit
        int indexVPoli = this.getIndexTlacitka(jmeno); //index v atributu tlacitka
        int soucet = figurka.usla + this.kostka.hozeno;
        //System.out.println("Soucet: " + soucet);
        int[] jeObsazene;
        if (soucet < 44 && soucet >= 40) {//muzu zalezt do domecku
            int cisloDomecku = this.vratIndex(soucet - 39);
            System.out.println("Cislo domku" + cisloDomecku);
            jeObsazene = this.jeObsazene(this.tlacitka[cisloDomecku].getName());
            if (jeObsazene[0] > 0) {
//                Figurka utocnik = (Figurka) this.hraci[jeObsazene[0]].figurky.get(jeObsazene[1]);
//                utocnik.setFigurku(utocnik.getStartIndex(), 0, this.tlacitka[utocnik.getStartIndex()].getName()); //nastavuji figurku utocnika na zacatek
//                this.setObrazekTlacitka(utocnik.getStartIndex(), utocnik.getIcon()); //nastavuju ikonu tlacitka ve startu utocnika na zacatek
                System.out.println("obsazeny domecek" + jeObsazene[0] + " " + jeObsazene[1] + " " + this.tlacitka[cisloDomecku].getName());
            } else {
                figurka.setFigurku(cisloDomecku, soucet, this.tlacitka[cisloDomecku].getName()); //nastavuji figurku na pozici
                this.setObrazekHernicesta(sIndex, cernaKruh); //predchozi tlacitko
                this.setObrazekTlacitka(cisloDomecku, figurka.getIcon()); //nastav figurku v domecku
            }

        } else {
            if (dIndex > 39) {
                dIndex = dIndex - 40;
            }
            jeObsazene = this.jeObsazene(this.hernicesta[dIndex].getName()); //je obsazeny index hernicesta[] kam nasazuji figurku
            //kdyz vyhazuji jinou figurku
            //System.out.println(jeObsazene[0] + " " + jeObsazene[1] + " OBSAZENE");
            if (jeObsazene[0] > 0) {
                Figurka utocnik = (Figurka) this.hraci[jeObsazene[0]].figurky.get(jeObsazene[1]);
                utocnik.setFigurku(utocnik.getStartIndex(), 0, this.tlacitka[utocnik.getStartIndex()].getName()); //nastavuji figurku utocnika na zacatek
                this.setObrazekTlacitka(utocnik.getStartIndex(), utocnik.getIcon()); //nastavuju ikonu tlacitka ve startu utocnika na zacatek
            }
            figurka.setFigurku(dIndex, soucet, this.hernicesta[dIndex].getName()); //nastavuji figurku na pozici
            this.setObrazekHernicesta(dIndex, figurka.getIcon());
            int jeNaStartu = this.jeNaStartuHracu(sIndex);
            if (jeNaStartu != -1) {
                switch (jeNaStartu) {
                    case 1:
                        this.setObrazekHernicesta(sIndex, this.cervenaKruh);
                        break;
                    case 2:
                        this.setObrazekHernicesta(sIndex, this.modraKruh);
                        break;
                    case 3:
                        this.setObrazekHernicesta(sIndex, this.zelenaKruh);
                        break;
                    case 4:
                        this.setObrazekHernicesta(sIndex, this.zlutaKruh);
                        break;
                    default:
                        this.setObrazekHernicesta(sIndex, this.cervenaKruh);
                        break;
                }
            } else {
                this.setObrazekHernicesta(sIndex, this.cernaKruh);
            }
        }
        //nastaveni figurky hrace na rade

    }

    public int vratIndex(int poradi) {
        String s = Const.getBarvaPrefix(this.hraci[this.naRade].cisloHrace);
        //System.out.println(s + "d" + poradi);
        for (int i = 0; i < this.tlacitka.length; i++) {
            if (this.tlacitka[i].getName().equals(s + "d" + poradi)) {
                return i;
            }
        }
        return -1;
    }

    public int jeNaStartuHracu(int index) {
        switch (index) {
            case 0:
                return 1;
            case 10:
                return 2;
            case 20:
                return 3;
            case 30:
                return 4;
            default:
                return -1;
        }
    }

    public boolean jeVDomecku(String jmeno) {
        if (jmeno.indexOf("d") != -1) {
            return true;
        }
        return false;
    }

    public void posunDomecek(String jmeno, int index) {
        Figurka figurka = (Figurka) this.hraci[this.naRade].figurky.get(index); //figurka se kterou hybu
        int sIndex = figurka.getAktualniIndex(); // index figurky kde stoji v tlacitka[]
        int dIndex = sIndex + this.kostka.hozeno; //index kam chci jit
        int soucet = figurka.usla + this.kostka.hozeno;
        int[] jeObsazene;
        if (soucet < 44) {//posun v domecku
            int cisloDomecku = this.vratIndex(soucet - 39);
            //System.out.println(cisloDomecku);
            jeObsazene = this.jeObsazene(this.tlacitka[cisloDomecku].getName());
            if (jeObsazene[0] > 0) {
//                Figurka utocnik = (Figurka) this.hraci[jeObsazene[0]].figurky.get(jeObsazene[1]);
//                utocnik.setFigurku(utocnik.getStartIndex(), 0, this.tlacitka[utocnik.getStartIndex()].getName()); //nastavuji figurku utocnika na zacatek
//                this.setObrazekTlacitka(utocnik.getStartIndex(), utocnik.getIcon()); //nastavuju ikonu tlacitka ve startu utocnika na zacatek
                //System.out.println("obsazeny domecek" + jeObsazene[0] + " " + jeObsazene[1] + " " + this.tlacitka[cisloDomecku].getName());
            } else {
                figurka.setFigurku(cisloDomecku, soucet, this.tlacitka[cisloDomecku].getName()); //nastavuji figurku na pozici
                this.setObrazekTlacitka(sIndex, figurka.getPicon()); //predchozi tlacitko
                this.setObrazekTlacitka(cisloDomecku, figurka.getIcon()); //nastav figurku v domecku
            }

        } else {
           // System.out.println(" nejde dal");
        }
        //nastaveni figurky hrace na rade

    }

    public void nastavCheaty() {
        tlacitka[0].setEnabled(true);
        tlacitka[0].setText("1");
        tlacitka[0].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kostka.ritKonstanta = 1;
            }
        });
        tlacitka[1].setEnabled(true);
        tlacitka[1].setText("2");
        tlacitka[1].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kostka.ritKonstanta = 2;
            }
        });
        tlacitka[2].setEnabled(true);
        tlacitka[2].setText("3");
        tlacitka[2].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kostka.ritKonstanta = 3;
            }
        });
        tlacitka[3].setEnabled(true);
        tlacitka[3].setText("4");
        tlacitka[3].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kostka.ritKonstanta = 4;
            }
        });
        tlacitka[4].setEnabled(true);
        tlacitka[4].setText("5");
        tlacitka[4].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kostka.ritKonstanta = 5;
            }
        });
        tlacitka[5].setEnabled(true);
        tlacitka[5].setText("6");
        tlacitka[5].addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kostka.ritKonstanta = 6;
            }
        });
    }
}
