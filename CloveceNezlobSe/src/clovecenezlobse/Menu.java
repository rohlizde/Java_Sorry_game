/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clovecenezlobse;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Menu {
    private GUI deska;
    private int pocet_hracu;
    
    public Menu(GUI hra){
        this.deska = hra;
    }
    
    public JMenuBar createMenu(){
        JMenuBar menu = new JMenuBar();
        JMenu mfile = new JMenu("File");
        JMenuItem nova_hra = new JMenuItem("Nová hra");
        mfile.add(nova_hra);
        JMenuItem ulozit_hru = new JMenuItem("Uložit hru");
        mfile.add(ulozit_hru);        
        JMenuItem nacist_hru = new JMenuItem("Načíst hru");
        mfile.add(nacist_hru); 
        JMenuItem konec = new JMenuItem("Konec");
        mfile.add(konec);
        menu.add(mfile);
        
        JMenu mnapoveda = new JMenu("Nápověda");
        JMenuItem pravidla = new JMenuItem("Pravidla");
        mnapoveda.add(pravidla);
        menu.add(mnapoveda);
        
        pravidla.addActionListener(  
            new java.awt.event.ActionListener(){  
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {  
                    JOptionPane.showMessageDialog(null,
                              "Všechny figurky jsou před začátkem hry umístěny ve startovním domečku,\n"
                            + "který je barevně vyznačen stejnou barvou, jakou jsou označeny 4 figurky hráče.\n"
                            + "\n"
                            + "Cílem hry je dovést své figurky jedné barvy ze startovního pole do cílového\n"
                            + "domečku. To lze pouze tak, že figurka musí projít postupně všemi poli na obvodu\n"
                            + "hracího plánu. Každý hráč posune při svém tahu figurku o tolik bodů, kolik padlo\n"
                            + "při jeho hodu kostkou. Skončí-li s figurkou na políčku obsazeném cizí figurkou,\n"
                            + "je tato odstraněna ze hry a vrácena zpět do startovního domečku. Na políčko\n"
                            + "obsazené figurkou stejné barvy vstoupit nelze.\n"
                            + "K nasazení figurky na startovní pole je potřeba hodit šestku.\n"
                            + "Nemá-li hráč nasazenou žádnou figurku, hází kostkou do té doby, dokud\n"
                            + "nepadne šestka, maximálně však třikrát. Pokud ani po třetím hodu nepadne šestka,\n"
                            + "pokračuje ve hře další hráč. Na začátku hry se první figurka umisťuje na startovní\n"
                            + "pole okamžitě."
                            + "\n"
                            + "Vyhrává ten hráč, který první oběhne hrací plán všemi svými figurkami a umístí je\n"
                            + "do cílového domečku. Ostatní hráči poté obvykle pokračují ve hře a hrají tak o další\n"
                            + "pořadí."
                            + "\n"
                            + "Hra Člověče, nezlob se! je určena hráčům od tří do věku který usoudíte.", "Pravidla hry", JOptionPane.INFORMATION_MESSAGE);
                };  
        }); 
        
        nova_hra.addActionListener(
            new java.awt.event.ActionListener(){  
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int s=-1;
                while(s<0){
                Object[] options = {"2 hráči","3 hráči","4 hráči"};
                s=JOptionPane.showOptionDialog(null,"Vyberte jednu z možností:","Zvolte počet hráců",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE, null,options, options[2]);
                }
                    s = s+2;
                    deska.setPocetHracu(s);
                    deska.novaHra();
                };  
        });
        
        konec.addActionListener(  
        new java.awt.event.ActionListener(){  
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {  
                System.exit(0);
            };  
        }); 
        
        
        return menu;
    }
    
}
