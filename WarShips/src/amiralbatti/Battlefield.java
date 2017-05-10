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

public class Battlefield {
    
    private final int height,width;
    final Unit units[][];
    
    public Battlefield(int height,int width){
        this.height = height;
        this.width = width;
        units = new Unit[height][width];
        for (int i = 0; i < units.length; i++) {
            for (int j = 0; j < units[i].length; j++) {
                units[i][j] = new Unit();
            }
        }
    }
    
    public void fillUnit(int i, int j,int n,JButton b,Ship s){
        units[i][j].setButton(b);
        units[i][j].setShip(s);
        units[i][j].setN(n);
    }
    
    public boolean areShipsSunk(){
        boolean b = true;
        for (int i = 0; i < Carrier.player.ships.length; i++) {
            if (!Carrier.player.ships[i].isSunk) 
                return false;
        }
        return b;
    }
    
    
}
