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
public class Kullanici {
    
    private String kullaniciAdi;
    private final Gemi gemiler[];
    
    public Kullanici(String s){
        this.kullaniciAdi = s;
        gemiler = new Gemi[3];
        gemiler[0] = new UcakGemisi();
        gemiler[1] = new Denizalti();
        gemiler[2] = new Firkateyn();
    }    
    
    public void setKullaniciAdi(String s){
        this.kullaniciAdi = s;
    }
    
    public String getKullaniciAdi(){
        return kullaniciAdi;
    }
    
    public void secim(){
        
    }
    
    
    
    
}

