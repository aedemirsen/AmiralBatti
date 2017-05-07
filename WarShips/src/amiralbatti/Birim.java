/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amiralbatti;

import javax.swing.JButton;

/**
 *
 * @author aedemirsen
 */
public class Birim {
    
    private String gemiTuru;
    private JButton button;
    private final int [] koordinat; 
    
    public Birim(String tur,JButton button){
        this.button = button;
        this.gemiTuru = tur;
        koordinat = new int[2];
    }
    
    public Birim(JButton button){
        this.button = button;
        koordinat = new int[2];
    }
    
    public Birim(){
        this.button = null;
        this.gemiTuru = null;
        koordinat = new int[2];
    }
    
    public boolean birimDoluMu(){
        return (button != null && gemiTuru != null) ;
    }

    public String getGemiTuru() {
        return gemiTuru;
    }

    public void setGemiTuru(String gemiTuru) {
        this.gemiTuru = gemiTuru;
    }

    public JButton getB() {
        return button;
    }

    public void setB(JButton b) {
        this.button = b;
    }
    
    
}
