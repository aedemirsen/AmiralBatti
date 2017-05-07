/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amiralbatti;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author aedemirsen
 */
public class Server {

    private Thread t;
    private DatagramSocket socket;
    private final int port;
    private Client2 bagliClient;
    InetAddress IPAddress; //client
    String gelenMesaj;
    boolean b = true;

    public Server(int port) {
        this.port = port;
    }

    public void create() throws SocketException {
        socket = new DatagramSocket(port);
        t = new Thread() {
            @Override
            public void run() {
                System.out.println("server is running...");
                while (true) {
                    try {
                        byte data[] = new byte[1024];
                        DatagramPacket dp = new DatagramPacket(data, data.length);
                        socket.receive(dp);
                        IPAddress = dp.getAddress();
                        gelenMesaj = new String(dp.getData()).trim();
                       
                        System.out.println(gelenMesaj);
                      //  bagliClient = new Client2(dp.getPort());
                    } catch (IOException ex) {
                        Logger.getLogger(Server2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t.start();
    }

    public String getGelenMesaj() {
        return this.gelenMesaj;
    }

    public void stop() {
        t.interrupt();
        socket.close();
    }

    public void mesajGonder(String s) throws IOException {
        byte data[] = s.getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, IPAddress, 1299);
        socket.send(dp);
    }

    public static void main(String[] args) {
//        Server2 s = new Server2(1453);
//        try {
//            s.create();
//            s.start();
//            // s.mesajGonder("ead");
//        } catch (SocketException ex) {
//            Logger.getLogger(Server2.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
