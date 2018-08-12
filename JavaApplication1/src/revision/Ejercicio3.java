/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revision;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author aelias
 */
public class Ejercicio3 extends JPanel {
    
    public Ejercicio3(){
        setLayout(new GridLayout(2,2));
        JLabel tag1 = new JLabel();
        tag1.setText("tag 1");
        add(tag1);
        JLabel tag2 = new JLabel();
        tag2.setText("tag 2");
        tag2.setFont(new Font("Dialog", Font.PLAIN, 12));
        add(tag2);
        Icon img = new ImageIcon("/home/aelias/Escritorio/descarga.jpeg");
        JLabel tag3 = new JLabel("tag3", img, SwingConstants.RIGHT);
        add(tag3);
        JLabel tag4 = new JLabel("tag 4", SwingConstants.RIGHT);
        add(tag4);
    }
    
    
    
    public static void main(String[] args) {
        JFrame ventana = new JFrame("ejercicio3");
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we){
               System.exit(0);
               
           }
          
        });
        
        ventana.getContentPane().add(new Ejercicio3(),BorderLayout.CENTER);
        ventana.setSize(300, 150);
        ventana.setVisible(true);
    }
    
}
