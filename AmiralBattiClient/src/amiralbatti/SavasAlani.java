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
import javax.swing.JButton;

/**
 *
 * @author aedemirsen
 */
public class SavasAlani {

    int x;
    int y;
    private static Birim birimler[][];

    public SavasAlani(int x, int y) {
        this.x = x;
        this.y = y;
        birimler = new Birim[x][y];
        for (Birim[] birimler1 : birimler) {
            for (int j = 0; j < birimler1.length; j++) {
                birimler1[j] = new Birim();
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
            return true;
        }
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
