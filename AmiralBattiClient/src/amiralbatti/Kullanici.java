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
    
    public Kullanici(String s){
        this.kullaniciAdi = s;
        this.portNumber = Kod.encode(s);
    }
    
    public void setKullaniciAdi(String s){
        this.kullaniciAdi = s;
        this.portNumber = Kod.encode(s);
    }
    
    public String getKullaniciAdi(){
        return kullaniciAdi;
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