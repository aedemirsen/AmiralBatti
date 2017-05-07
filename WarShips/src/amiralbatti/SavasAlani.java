/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amiralbatti;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author aedemirsen
 */
public class SavasAlani {

    int x;
    int y;
    Birim birimler[][];
    JButton [][] butonlar;

    public SavasAlani(int x, int y,JButton[][] butonlar) {
        this.x = x;
        this.y = y;
        this.butonlar = butonlar;
        birimler = new Birim[x][y];
        for (int i = 0; i < birimler.length; i++) {
            for (int j = 0; j < birimler[i].length; j++) {
                birimler[i][j] = new Birim(butonlar[i][j]);
            }
        }
    }
    
    public void birimDoldur(JButton b, String gemiTuru,int [] koordinat){
        birimler[koordinat[0]][koordinat[1]].setB(b);
        birimler[koordinat[0]][koordinat[1]].setGemiTuru(gemiTuru);          
    }

    public boolean birimVur(Birim b) {
        if (b.birimDoluMu()) {
            MethodInvoker.invokeVoidMethod(b.getGemiTuru(), "hasar");
            b.getB().setIcon(new ImageIcon("icons/13.png"));
            b.getB().setEnabled(false);
            return true;
        }
        //b.getB().setIcon(new ImageIcon("icons/13.png"));
        b.getB().setEnabled(false);
        return false;
    }

}

class MethodInvoker {

    private static final String packageName = "amiralbatti";

    static void invokeVoidMethod(String className, String methodName) {
        try {
            Class c = Class.forName(packageName.concat(className));
            Object o = c.newInstance();
            Method m = c.getMethod(methodName);
            m.invoke(o);

        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | NoSuchMethodException |
                SecurityException | IllegalArgumentException |
                InvocationTargetException ex) {
            Logger.getLogger(SavasAlani.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
