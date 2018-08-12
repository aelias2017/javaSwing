/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revision;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

/**
 *
 * @author aelias
 */
public class BotonesGrupos extends JPanel{
    static String []ids={ "Mortadelo","Filemon","Carpanta", 
    "Rompetechos","Pepe Gotera","Otilio"};
    
    public BotonesGrupos(){
        add(creaPanelBotones(JButton.class, ids));
        add(creaPanelBotones(JToggleButton.class, ids));
        add(creaPanelBotones(JCheckBox.class, ids));
        add(creaPanelBotones(JRadioButton.class, ids));
    }
    static JPanel creaPanelBotones(Class bClass, String []ids){
        ButtonGroup grup = new ButtonGroup();
        JPanel panel = new JPanel();
        String titulo = bClass.getName();
        titulo = titulo.substring(titulo.lastIndexOf(".")+1);
        panel.setBorder(new TitledBorder(titulo));
        for (String id : ids) {
            AbstractButton butonAbs = new JButton("fallo");
            try {
                Constructor ctor = bClass.getConstructor(new Class[]{
                String.class
            });
            // Se crea un nuevo objeto del tipo del botón
	butonAbs = ( AbstractButton )ctor.newInstance( new Object[]{
	  id
	  });
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            grup.add(butonAbs);
            panel.add(butonAbs);
        }
        
        return panel;
    }
    
    
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Grupo de botones");
        ventana.getContentPane().add(new BotonesGrupos(),BorderLayout.CENTER);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we){
               System.exit(0);
           }
          
        });
        ventana.setSize(600,300);
        ventana.setVisible(true);
    }
    
}
