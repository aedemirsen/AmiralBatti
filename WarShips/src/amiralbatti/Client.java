/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amiralbatti;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aedemirsen
 */
public class Client {
    
    private DatagramSocket socket;
    private InetAddress serverIP;
    private InetAddress ip;
    private int port;
    private int serverPort;
    String gelenMesaj;
    private Thread t;
    
    Client(int port){
        try {
            this.ip = Inet4Address.getLocalHost();
            this.port = port;
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void create(int serverPort, String serverIP) throws SocketException, UnknownHostException {
        socket = new DatagramSocket(this.port);        
        this.serverIP = InetAddress.getByName(serverIP);
        this.serverPort = serverPort;
        t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        byte data[] = new byte[1024];
                        DatagramPacket dp = new DatagramPacket(data, data.length);
                        socket.receive(dp);
                        gelenMesaj = new String(dp.getData()).trim();
                        
                        System.out.println(gelenMesaj);
                    } catch (IOException ex) {
                        Logger.getLogger(Server2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t.start();
    }
    
    public void mesajGonder(String s) throws IOException{
        byte data[] = s.getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length,serverIP,serverPort);
        socket.send(dp);
    }
    
    public InetAddress getIP(){
        return this.ip;
    }
    
    public String getGelenMesaj(){
        return this.gelenMesaj;
    }
    
    public int getPort(){
        return this.port;
    }
    
    public static void main(String[] args) {
         
//        try {
//            Client2 c = new Client2(1299);
//            c.create(1453, "localhost");
//            c.mesajGonder("aed");
//        } catch (UnknownHostException | SocketException ex) {
//            Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
}
