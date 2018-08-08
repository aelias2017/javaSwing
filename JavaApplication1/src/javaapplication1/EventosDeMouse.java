/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author alejandroelias
 */
public class EventosDeMouse {
    
    public static void main(String[] args) {
        JButton boton = new JButton("Click me");
        boton.setVisible(true);
        boton.setSize(50, 50);
        boton.setLocation(100, 100);
        JFrame frame = new JFrame("Eventos de Mouse");
        frame.setVisible(true);
        frame.setLocation(200, 200);
        frame.setSize(300, 300);
        frame.add(boton);
        boton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(".mouseClicked()");
                
            }
            
        });
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
           public void windowClosing(WindowEvent e) {
               System.exit(0);
           }
        });
    }
    
}
