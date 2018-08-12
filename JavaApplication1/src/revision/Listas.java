/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revision;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author aelias
 */
public class Listas extends JPanel{
    
    
    public Listas(){
        setLayout(new GridLayout(2, 1));
        JList lista = new JList(BotonesGrupos.ids);
        add(new JScrollPane(lista));
        JComboBox combo = new JComboBox();
        for (int i = 0; i < 10; i++) {
            combo.addItem(Integer.toString(i));
            add(combo);
        } 
    }
    
    
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Litas swing");
        ventana.getContentPane().add(new MiRendererDeLista(),BorderLayout.CENTER);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we){
               System.exit(0);
           }
          
        });
        ventana.setSize(200,200);
        ventana.setVisible(true);
    }
    
}
