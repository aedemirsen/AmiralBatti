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
    private int portNumber;
    private Gemi gemiler[];
    
    public Kullanici(String s){
        this.kullaniciAdi = s;
        this.portNumber = Kod.encode(s);
        Gemi gemi[] = new Gemi[3];
        gemiler[0] = new UcakGemisi();
        gemiler[1] = new DenizAlti();
        gemiler[2] = new Fırkateyn();
    }    
    
    public void setKullaniciAdi(String s){
        this.kullaniciAdi = s;
        this.portNumber = Kod.encode(s);
    }
    
    public String getKullaniciAdi(){
        return kullaniciAdi;
    }
    
    public void secim(){
        
    }
    
    
    
    
}

class Kod{
    
    static public int encode(String s){
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            a += s.charAt(i);
        }
        return a;
    }
        
}
