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
import javax.swing.JOptionPane;

/**
 *
 * @author aedemirsen
 */


public class Server1 implements Runnable {

    private final int port = 1453;
    private String ip;
    private boolean aktif;
    private String gelenMesaj;
    private String rakipAdi;
    InetAddress IPAddress;//client ip
    int clientPort;

    private Kullanici k;
    private SavasAlani s;

    DatagramSocket serverSocket;

    public Server1(Kullanici k,SavasAlani s) {
        aktif = true;
        this.k = k;
        this.s = s;
        try {
            ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
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
                gelenMesaj = gelenMesaj.trim();
                gelenMesajiYazdir();
                if (gelenMesaj.startsWith("BAGLANDI")) {                   
                    this.rakipAdi = gelenMesaj.substring(gelenMesaj.indexOf("#")+1);
                    AnaSayfa.jTextField4.setText(this.rakipAdi);
//                    AnaSayfa.jButton45.setText("OYUN BAŞLADI!");
                    IPAddress = receivePacket.getAddress();
                    clientPort = receivePacket.getPort();
                    sendData = this.getKullanici().getKullaniciAdi().getBytes();
                    DatagramPacket sendPacket
                            = new DatagramPacket(sendData, sendData.length, IPAddress, clientPort);
                    serverSocket.send(sendPacket);
                }
                else if (gelenMesaj.equals("BASLADI")) {
                    AnaSayfa.jLabel15.setIcon(new ImageIcon("icons/6.png"));
                }
                else if (gelenMesaj.startsWith("ATIS")) {
                    int x = Integer.parseInt(gelenMesaj.substring(5, gelenMesaj.indexOf(",")));
                    int y = Integer.parseInt(gelenMesaj.substring(gelenMesaj.indexOf(",")+1));
                    if(s.birimVur(s.birimler[x][y])){
                        JOptionPane.showMessageDialog(null, "İSABET!!!");
                    }else{
                        mesajGonder("*");
                    }
                    AnaSayfa.alan1.setVisible(false);
                    AnaSayfa.alan2.setVisible(true);
                }

            }
        } catch (SocketException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mesajGonder(String s) throws IOException{
        byte [] mesaj = s.getBytes();
        DatagramPacket sendPacket
                    = new DatagramPacket(mesaj, mesaj.length, IPAddress, clientPort);
        serverSocket.send(sendPacket);    
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
