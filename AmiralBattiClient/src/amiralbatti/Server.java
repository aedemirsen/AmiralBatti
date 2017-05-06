/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amiralbatti;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aedemirsen
 */
public class Server {

    private Thread t;
    private DatagramSocket socket;
    private final int port;
    private Client bagliClient;

    public Server(int port) {
        this.port = port;
    }

    public void create() throws SocketException {
        socket = new DatagramSocket(port);
        t = new Thread() {
            @Override
            public void run() {
                System.out.println("server çalışıyor");
                while (true) {
                    try {
                        byte data[] = new byte[1024];
                        DatagramPacket dp = new DatagramPacket(data, data.length);
                        socket.receive(dp);
                        String gelenMesaj = new String(dp.getData());
                        System.out.println(gelenMesaj);
                        bagliClient = new Client(dp.getPort());
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
    }
    
    public void start(){
        t.start();
    }
    
    public void stop(){
        t.interrupt();
        socket.close();
    }
    
    public void mesajGonder(String s){
        byte data[] = s.getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length,bagliClient.getIP(),bagliClient.getPort());
    }
    
    public static void main(String[] args) {
        Server s = new Server(1453);
        try {
            s.create();
            s.start();
           // s.mesajGonder("ead");
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
