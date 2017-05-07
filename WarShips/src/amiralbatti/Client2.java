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
public class Client2 {
    
    private DatagramSocket socket;
    private InetAddress serverIP;
    private InetAddress ip;
    private int port;
    private int serverPort;
    String gelenMesaj;
    String rakip;
    private Thread t;
    Kullanici k;
    SavasAlani s;
    
    Client2(int port,Kullanici k, SavasAlani s){
        try {
            this.ip = Inet4Address.getLocalHost();
            this.port = port;
            this.k = k;
            this.s = s;
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
                        if (gelenMesaj.startsWith("RAKIP")) {
                            rakip = gelenMesaj.substring(gelenMesaj.indexOf("#")+1).trim();
                        }
                        else if (gelenMesaj.startsWith("ATIS")) {
                            int x = Integer.parseInt(gelenMesaj.substring(5, gelenMesaj.indexOf(",")));
                            int y = Integer.parseInt(gelenMesaj.substring(gelenMesaj.indexOf(",") + 1));
                            if (s.birimVur(s.birimler[x][y])) {
                                JOptionPane.showMessageDialog(null, "İSABET!!!");
                            } else {
                                mesajGonder("*");
                            }
                            AnaSayfa.alan1.setVisible(false);
                            AnaSayfa.alan2.setVisible(true);
                        }
                        System.out.println(gelenMesaj);
                       // bagliClient = new Client2(dp.getAddress(),dp.getPort());
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
    
    public String getRakip(){
        return this.rakip;
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
