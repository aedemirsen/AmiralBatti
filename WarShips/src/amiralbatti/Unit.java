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
public class Unit {
    
    private Ship ship;
    private JButton b; 
    private int n;
     
    public boolean isOccupied(){
        return (b != null && ship != null);
    }
    
    public void setN(int n){
        this.n = n;
    }
    
    public int getN(){
        return n;
    }
    
    
    public void setShip(Ship s){
        this.ship = s;
    }
    
    public Ship getShip(){
        return ship;
    }
    
    public void setButton(JButton b){
        this.b = b;
    }
           
    
}
