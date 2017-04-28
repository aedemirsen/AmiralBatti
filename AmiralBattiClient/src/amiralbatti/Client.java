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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aedemirsen
 */
public class Client {
    
    final private String baglandiBilgisi = "BAGLANDI";
    private Kullanici k;
    private String rakipAdi;
    private byte[] baglandi;
    private byte[] kullanici;
    String ip;
    DatagramSocket clientSocket;
    InetAddress IPAddress;
    
    public Client(Kullanici k){
        this.k = k;
        try {
            ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public Kullanici getKullanici() {
        return this.k;
    }
    
    void baglan(String serverIP,int serverPort){
        try {
            clientSocket = new DatagramSocket();
            IPAddress = InetAddress.getByName(serverIP);
            baglandi = baglandiBilgisi.getBytes();
            System.out.println(baglandi.length);
            kullanici = this.getKullanici().getKullaniciAdi().getBytes();
            byte[] receiveData = new byte[8];
            DatagramPacket sendPacket = 
                    new DatagramPacket(baglandi, baglandi.length, IPAddress, serverPort);
            clientSocket.send(sendPacket);
            DatagramPacket sendPacket2 = 
                    new DatagramPacket(kullanici, kullanici.length, IPAddress, serverPort);
            clientSocket.send(sendPacket2);
//            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//            clientSocket.receive(receivePacket);
//            rakipAdi = Arrays.toString(receiveData);
//            System.out.println(rakipAdi);
            clientSocket.close();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    
    public static void main(String args[]) {
        
        Client c = new Client(new Kullanici("aed"));
        c.baglan("localhost",1453);
//        

        /*Scanner sc = new Scanner(System.in);
        System.out.print("IP : ");
        String ip = sc.nextLine();
        System.out.print("Port : ");
        int port = sc.nextInt();

        try {
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName(ip);
            System.out.print("Mesajınız: ");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String line = bf.readLine();
            sendData = line.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            clientSocket.send(sendPacket);
            System.out.println("Mesaj Gönderildi...");
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            clientSocket.close();

        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
}
