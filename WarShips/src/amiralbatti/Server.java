/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amiralbatti;

import static amiralbatti.JBattlefield.jLabel15;
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
    //private Client2 bagliClient;
    InetAddress IPAddress; //client
    String receivedMessage;
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
                        receivedMessage = new String(dp.getData()).trim();
                        process();
                        System.out.println(receivedMessage);
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t.start();
    }

    public String getReceivedMessage() {
        return this.receivedMessage;
    }

    public void stop() {
        t.interrupt();
        socket.close();
    }

    public void process() throws IOException {
        if (receivedMessage.startsWith("#")) {
            String s = receivedMessage.substring(receivedMessage.indexOf("#") + 1);
            JBattlefield.jTextField2.setText(s);
            sendMessage("#".concat(Carrier.player.name));
        } else if (receivedMessage.equals("B")) {
            JBattlefield.jLabel15.setIcon(new ImageIcon(""));
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

    public void sendMessage(String s) throws IOException {
        byte data[] = s.getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, IPAddress, 1299);
        socket.send(dp);
    }

    public static void main(String[] args) {
        
    }

}
