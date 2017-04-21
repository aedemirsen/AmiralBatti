/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amiralbatti;

import static amiralbatti.UcakGemisi.boyut;

/**
 *
 * @author aedemirsen
 */
public interface Gemi {
    
    boolean batıkMı();
    
    void hasar();
    
    public int getHasar();    
    
}

class UcakGemisi implements Gemi{
    
    static String isim = "UcakGemisi";   
    static int boyut = 3;
    private int hasar;

    public UcakGemisi(){
        hasar = 0;
    }
    
    @Override
    public boolean batıkMı() {
        return this.hasar == boyut;
    }

    @Override
    public void hasar() {
       hasar++;
    }

    @Override
    public int getHasar() {
        return this.hasar;
    }
}

class Denizalti implements Gemi{
    
    static String isim = "Denizalti";   
    static int boyut = 2;
    private int hasar;
    
    public Denizalti(){
        hasar = 0;
    }

    @Override
    public boolean batıkMı() {
        return this.hasar == boyut;
    }

    @Override
    public void hasar() {
        hasar++;
    }

    @Override
    public int getHasar() {
        return this.hasar;
    }   
    
}

class Firkateyn implements Gemi{

    static String isim = "Firkateyn";   
    static int boyut = 1;
    private int hasar;
    
    public Firkateyn(){
        hasar = 0;
    }

    @Override
    public boolean batıkMı() {
        return this.hasar == boyut;
    }

    @Override
    public void hasar() {
        hasar++;
    }

    @Override
    public int getHasar() {
        return this.hasar;
    }   
      
}