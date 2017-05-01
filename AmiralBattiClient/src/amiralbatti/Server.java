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
import javax.swing.ImageIcon;

/**
 *
 * @author aedemirsen
 */


public class Server implements Runnable {

    private final int port = 1453;
    private String ip;
    private boolean aktif;
    private String gelenMesaj;
    private String rakipAdi;

    private Kullanici k;

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
                byte[] receiveData = new byte[20];
                byte[] sendData;
                DatagramPacket receivePacket;
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                gelenMesaj = new String(receivePacket.getData());
                gelenMesajiYazdir();
                if (gelenMesaj.trim().startsWith("BAGLANDI")) {                   
                    this.rakipAdi = gelenMesaj.substring(gelenMesaj.indexOf("#")+1).trim();
                    AnaSayfa.jTextField4.setText(this.rakipAdi);
                    AnaSayfa.jButton45.setText("OYUN BAŞLADI!");
                    InetAddress IPAddress = receivePacket.getAddress();
                    sendData = this.getKullanici().getKullaniciAdi().getBytes();
                    DatagramPacket sendPacket
                            = new DatagramPacket(sendData, sendData.length, IPAddress, 1299);
                    serverSocket.send(sendPacket);
                }
                else if (gelenMesaj.trim().equals("BASLADI")) {
                    AnaSayfa.jLabel15.setIcon(new ImageIcon("icons/6.png"));
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

    public String getRakipAdi() {
        return this.rakipAdi;
    }

    void gelenMesajiYazdir() {
        System.out.println(gelenMesaj.trim());
    }

    public static void main(String args[]) {

    }
}
