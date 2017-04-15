/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amiralbatti;

/**
 *
 * @author aedemirsen
 */
public class Gemi {
    
    private final int boyut;
    private int hasar;
    
    public Gemi(int boyut){
        this.boyut = boyut;
        this.hasar = 0;
    }
    
    boolean batıkMı(){
        return this.hasar == this.boyut;
    }
    
    void vuruldu(){
        hasar++;                
    }
    
    public int getHasar(){
        return hasar;
    }
    
    public int getBoyut(){
        return boyut;
    }
    
}
