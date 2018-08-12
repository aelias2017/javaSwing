/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revision;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

/**
 *
 * @author aelias
 */
public class Ejercicio4 extends JPanel {
    
    public Ejercicio4(){
        add(new JButton("JButton"));
        add(new JToggleButton("JTOgle button"));
        add(new JCheckBox("checkbox"));
        add(new JRadioButton("Jradio button"));
        
    }
    
    public static void main(String[] args) {
        JFrame ventana = new JFrame("ejercicio4");
        ventana.getContentPane().add(new Ejercicio4(),BorderLayout.CENTER);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we){
               System.exit(0);
               
           }
          
        });
        ventana.setSize(300,200);
        ventana.setVisible(true);
            
    }
}
