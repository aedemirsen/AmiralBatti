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
    
    private int boyut;
    private int hasar;
    
    public Gemi(int boyut){
        this.boyut = boyut;
        this.hasar = 0;
    }
    
    public Gemi(){
        
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

class UcakGemisi extends Gemi{
    
    public UcakGemisi() {
        super(3);
    }    
}

class DenizAlti extends Gemi{
    
    public DenizAlti() {
        super(2);
    }    
}

class Fırkateyn extends Gemi{
    
    public Fırkateyn() {
        super(1);
    }    
}