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
    private Thread t;
    
    Client(int port){
        try {
            this.ip = Inet4Address.getLocalHost();
            this.port = port;
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
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
                        String gelenMesaj = new String(dp.getData());
                       // bagliClient = new Client(dp.getAddress(),dp.getPort());
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public int getPort(){
        return this.port;
    }
    
    public static void main(String[] args) {
         
        try {
            Client c = new Client(1299);
            c.create(1453, "localhost");
            c.mesajGonder("aed");
        } catch (UnknownHostException | SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
