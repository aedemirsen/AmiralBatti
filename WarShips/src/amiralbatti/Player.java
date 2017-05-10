/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amiralbatti;

import java.net.InetAddress;

/**
 *
 * @author aedemirsen
 */
public class Player {
    
    String name;
    InetAddress IPAddress;
    Ship ships[];
    boolean isServer;
    boolean isTurn;
    
    public Player(String name,int shipQuantity){
        this.name = name;
        this.ships = new Ship[shipQuantity];
    }
    
    public Ship setShip(int i, Ship s){
        ships[i] = s;
        return ships[i];
    }
    
}
