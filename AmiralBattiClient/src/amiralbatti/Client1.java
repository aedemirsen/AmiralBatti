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
public class Client1{

    final private String baglandiBilgisi = "BAGLANDI";
    private Kullanici k;
    private SavasAlani s;
    private String rakipAdi;
    DatagramPacket receivePacket;
    private byte[] mesaj;
    String ip;
    DatagramSocket clientSocket;
    InetAddress IPAddress;
    String gelenMesaj;

    public Client1(Kullanici k,SavasAlani s) {
        this.k = k;
        this.s = s;
        try {
            ip = Inet4Address.getLocalHost().getHostAddress();            
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Kullanici getKullanici() {
        return this.k;
    }

    public void baglan(String serverIP, int serverPort) {
        try {    
            IPAddress = InetAddress.getByName(serverIP);
            String ilkMesaj = baglandiBilgisi.concat("#").
                    concat(this.getKullanici().getKullaniciAdi());
            mesaj = ilkMesaj.getBytes();
            byte[] receiveData = new byte[20];
            DatagramPacket sendPacket
                    = new DatagramPacket(mesaj, mesaj.length, IPAddress, serverPort);
            clientSocket = new DatagramSocket(1299);
            clientSocket.send(sendPacket);     
//            if (!clientSocket.isConnected()) 
//                return false;            
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);            
            rakipAdi = new String(receivePacket.getData());
            AnaSayfa.jTextField4.setText(rakipAdi.trim());
           // System.out.println(rakipAdi.trim());
            //clientSocket.close();
        } catch (SocketException ex) {
            Logger.getLogger(Client1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client1.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return true;
//        return true;
    }
    
    public void mesajGonder(String s,int serverPort) throws IOException{
        mesaj = s.getBytes();
        DatagramPacket sendPacket
                    = new DatagramPacket(mesaj, mesaj.length, IPAddress, serverPort);
        clientSocket.send(sendPacket);    
    }
    
    public void dinle(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] receiveData = new byte[20];
                    receivePacket = new DatagramPacket(receiveData, receiveData.length);            
                    clientSocket.receive(receivePacket);
                    gelenMesaj = new String(receivePacket.getData());
                    if (gelenMesaj.startsWith("ATIS")) {
                        System.out.println("OLEYYYY");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Client1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public static void main(String args[]) {

       
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
            Logger.getLogger(Client1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client1.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    

}
