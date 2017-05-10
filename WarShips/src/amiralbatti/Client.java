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
import javax.swing.ImageIcon;

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
    String receivedMessage;
    private Thread t;

    Client(int port) {
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
                System.out.println("client created...");
                while (true) {
                    try {
                        byte data[] = new byte[1024];
                        DatagramPacket dp = new DatagramPacket(data, data.length);
                        socket.receive(dp);
                        receivedMessage = new String(dp.getData()).trim();
                        process();
                        System.out.println(receivedMessage);
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t.start();
    }

    public void sendMessage(String s) throws IOException {
        byte data[] = s.getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, serverIP, serverPort);
        socket.send(dp);
    }

    public InetAddress getIP() {
        return this.ip;
    }

    public String getReceivedMessage() {
        return this.receivedMessage;
    }

    public void process() throws IOException, InterruptedException {
        if (receivedMessage.startsWith("#")) {
            Thread.sleep(1000);
            String s = receivedMessage.substring(receivedMessage.indexOf("#") + 1);
            JBattlefield.jTextField2.setText(s);
        } else if (receivedMessage.startsWith("&")) {
            int x = Integer.parseInt(receivedMessage.
                    substring(1, receivedMessage.indexOf("-")));
            int y = Integer.parseInt(receivedMessage.
                    substring(receivedMessage.indexOf("-") + 1));
            if (Carrier.battlefield.units[x][y].isOccupied()) {
                System.out.println("Hit!");
                JBattlefield.buttonsLeft[x][y].setIcon(new ImageIcon("icons/13.png"));
                sendMessage("H" + x + "-" + y);
            } else {
                sendMessage("M" + x + "-" + y);
                JBattlefield.setState(x, y, false, "L");
                System.out.println("Miss!");
            }
            JBattlefield.jLabel15.setIcon(new ImageIcon("icons/7.png"));
            JBattlefield.jLabel16.setIcon(new ImageIcon(""));
            Carrier.player.isTurn = true;
        } else if (receivedMessage.startsWith("H")) {
            int x = Integer.parseInt(receivedMessage.
                    substring(1, receivedMessage.indexOf("-")));
            int y = Integer.parseInt(receivedMessage.
                    substring(receivedMessage.indexOf("-") + 1));
            JBattlefield.buttonsRight[x][y].setIcon(new ImageIcon("icons/13.png"));
            int i = Carrier.battlefield.units[x][y].getN();
            Carrier.player.ships[i].isSunk = true;
            //JBattlefield.labels[i].setIcon(new ImageIcon("icons/14.png"));
            if (Carrier.battlefield.areShipsSunk()) {
                JBattlefield.isEnd = true;
                JBattlefield.jLabel2.setText("YOU WON!");
                sendMessage("L");
            }
        } else if (receivedMessage.startsWith("M")) {
            int x = Integer.parseInt(receivedMessage.
                    substring(1, receivedMessage.indexOf("-")));
            int y = Integer.parseInt(receivedMessage.
                    substring(receivedMessage.indexOf("-") + 1));
            JBattlefield.setState(x, y, false, "R");
        }
        else if (receivedMessage.equals("L")) {
            JBattlefield.jLabel2.setText("YOU LOSE!");
            JBattlefield.isEnd = true;
        }
    }

    public int getPort() {
        return this.port;
    }

    public static void main(String[] args) {
        
    }
}
