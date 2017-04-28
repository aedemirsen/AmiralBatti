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
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable {

    private final int port = 1453;
    private String ip;
    private boolean aktif;
    private String gelenMesaj;

    private Kullanici k;

    // static Server s = new Server();    
    DatagramSocket serverSocket;

    public Server(Kullanici k) {
        aktif = true;
        this.k = k;
        try {
            ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getPort() {
        return this.port;
    }

    public String getIp() {
        return this.ip;
    }

    public Kullanici getKullanici() {
        return this.k;
    }

    @Override
    public void run() {
        try {
            serverSocket = new DatagramSocket(port);
            while (aktif) {
                byte[] receiveData = new byte[8];
                byte[] sendData;
                DatagramPacket receivePacket;
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                gelenMesaj = new String(receivePacket.getData());
                InetAddress IPAddress = receivePacket.getAddress();
                sendData = gelenMesaj.getBytes();
                gelenMesajiYazdir();
                if (gelenMesaj.equals("BAGLANDI")) {
                    DatagramPacket sendPacket
                            = new DatagramPacket(sendData, sendData.length, IPAddress, getPort());
                    serverSocket.send(sendPacket);
                }

            }
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stop() {
        aktif = false;
    }

    void gelenMesajiYazdir() {
        System.out.println(gelenMesaj);
    }

    public static void main(String args[]) throws UnknownHostException {

    }
}
