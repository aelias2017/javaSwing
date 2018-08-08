/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author alejandroelias
 */
public class EventosDeVEntana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       JFrame frame = new JFrame("mi frame ejemplo");
       // configuración de componente
       frame.setLocation(100, 100);
       frame.setVisible(true);
       frame.addWindowListener(new WindowListener() {
           @Override
           public void windowOpened(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
           }

           @Override
           public void windowClosing(WindowEvent e) {
               System.exit(0);
                //To change body of generated methods, choose Tools | Templates.
           }

           @Override
           public void windowClosed(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
           }

           @Override
           public void windowIconified(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
           }

           @Override
           public void windowDeiconified(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
           }

           @Override
           public void windowActivated(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
           }

           @Override
           public void windowDeactivated(WindowEvent e) {
                //To change body of generated methods, choose Tools | Templates.
           }
       });
    }
    
}
