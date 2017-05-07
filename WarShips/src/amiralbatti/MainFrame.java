/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amiralbatti;

import java.awt.Color;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author aedemirsen
 */
public class MainFrame extends javax.swing.JFrame {

    
    private final int shipQuantity = 5;
    private final int height = 5,width = 8;
    private final int SERVER_PORT = 1453;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        initIcons();
        
        base2.setVisible(false);
        base3.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        mainFrameBase = new javax.swing.JLayeredPane();
        base1 = new javax.swing.JLayeredPane();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton41 = new javax.swing.JButton();
        base2 = new javax.swing.JLayeredPane();
        jLabel10 = new javax.swing.JLabel();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        base3 = new javax.swing.JLayeredPane();
        jLabel11 = new javax.swing.JLabel();
        jButton47 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton48 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AMİRAL BATTI");

        jLabel9.setText("Kullanıcı Adı:");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton41.setText("DEVAM");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        base1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        base1.setLayer(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        base1.setLayer(jButton41, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout base1Layout = new javax.swing.GroupLayout(base1);
        base1.setLayout(base1Layout);
        base1Layout.setHorizontalGroup(
            base1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(base1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(base1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(base1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        base1Layout.setVerticalGroup(
            base1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(base1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(base1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton41)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton42.setText("Yeni Oyun");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton43.setText("Oyuna Katıl");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        base2.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        base2.setLayer(jButton42, javax.swing.JLayeredPane.DEFAULT_LAYER);
        base2.setLayer(jButton43, javax.swing.JLayeredPane.DEFAULT_LAYER);
        base2.setLayer(jButton44, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout base2Layout = new javax.swing.GroupLayout(base2);
        base2.setLayout(base2Layout);
        base2Layout.setHorizontalGroup(
            base2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(base2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addGroup(base2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton43, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(jButton42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        base2Layout.setVerticalGroup(
            base2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(base2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(base2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton43, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jLabel12.setText("Port :");

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel19.setText("Kullanıcı Adı:");

        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jLabel20.setText("IP:");

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        base3.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        base3.setLayer(jButton47, javax.swing.JLayeredPane.DEFAULT_LAYER);
        base3.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        base3.setLayer(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        base3.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        base3.setLayer(jButton48, javax.swing.JLayeredPane.DEFAULT_LAYER);
        base3.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        base3.setLayer(jTextField5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout base3Layout = new javax.swing.GroupLayout(base3);
        base3.setLayout(base3Layout);
        base3Layout.setHorizontalGroup(
            base3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(base3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(base3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(base3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField5)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        base3Layout.setVerticalGroup(
            base3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(base3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(base3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(base3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(base3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(base3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jButton48, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                    .addGroup(base3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        mainFrameBase.setLayer(base1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainFrameBase.setLayer(base2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainFrameBase.setLayer(base3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainFrameBaseLayout = new javax.swing.GroupLayout(mainFrameBase);
        mainFrameBase.setLayout(mainFrameBaseLayout);
        mainFrameBaseLayout.setHorizontalGroup(
            mainFrameBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base2)
            .addGroup(mainFrameBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(base3))
            .addGroup(mainFrameBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(base1))
        );
        mainFrameBaseLayout.setVerticalGroup(
            mainFrameBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(mainFrameBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(base3))
            .addGroup(mainFrameBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(base1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainFrameBase, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainFrameBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
        if (!jTextField1.getText().equals("")) {
            Carrier.player = new Player(jTextField1.getText(), shipQuantity);            
            jLabel10.setText(jTextField1.getText());
            jLabel11.setText(jTextField1.getText());
            base1.setVisible(false);
            base2.setVisible(true);
        } else {
            jTextField1.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
        Carrier.player.isServer = true;
        Carrier.battlefield = new Battlefield(height, width);
        Carrier.server = new Server(SERVER_PORT);
        try {
            Carrier.server.create();
        } catch (SocketException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Carrier.mainFrame = this;
        JBattlefield jBattlefield = new JBattlefield();
        jBattlefield.setVisible(true);
        this.dispose();
       
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
        Carrier.player.isServer = false;
        base2.setVisible(false);
        base3.setVisible(true);
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
        base2.setVisible(false);
        base1.setVisible(true);
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
        base3.setVisible(false);
        base2.setVisible(true);
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        // TODO add your handling code here:
        //        try {
        
    }//GEN-LAST:event_jButton48ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    
    private void initIcons() {
//        jLabel1.setIcon(new ImageIcon("icons/1.png"));
//        jLabel2.setIcon(new ImageIcon("icons/2.png"));
//        jLabel3.setIcon(new ImageIcon("icons/3.png"));
        jLabel8.setIcon(new ImageIcon("icons/4.jpg"));
        jButton44.setIcon(new ImageIcon("icons/5.png"));
        jButton47.setIcon(new ImageIcon("icons/5.png"));
        jButton48.setIcon(new ImageIcon("icons/9.jpg"));
//        jLabel13.setIcon(new ImageIcon("icons/8.png"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane base1;
    private javax.swing.JLayeredPane base2;
    private javax.swing.JLayeredPane base3;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLayeredPane mainFrameBase;
    // End of variables declaration//GEN-END:variables
}