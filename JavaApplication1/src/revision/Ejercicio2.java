/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revision;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author aelias
 */
public class Ejercicio2 extends JPanel {
     JButton btn1 = new JButton("btn1");
        JButton btn2 = new JButton("btn2");
        JTextField texto = new JTextField(20);
    
    public static void main(String[] args) {
       JFrame ventana = new JFrame("ejemplo 1 java swing");
       ventana.addWindowListener(new WindowAdapter() {
           
           public void windowClosing(WindowEvent we){
               System.exit(0);
               
           }
    });
       
       ventana.getContentPane().add(new Ejercicio2(),BorderLayout.CENTER);
       ventana.setSize(300, 100);
       ventana.setVisible(true);
               
    }
    
    public Ejercicio2(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(".actionPerformed()");
             String nombre = ((JButton)e.getSource()).getText();
             texto.setText(nombre);
            }
        };
       btn1.addActionListener(al);
       btn1.setToolTipText("Soy el boton 1");
        add(btn1);
       btn2.addActionListener(al);
       btn2.setToolTipText("Soy e boton 2");
       add(btn2);
       texto.setToolTipText("soy el campo de texto");
        add(texto);
        
       
        
    }
}
