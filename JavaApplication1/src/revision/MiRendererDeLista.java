/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revision;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.border.BevelBorder;

/**
 *
 * @author aelias
 */
public class MiRendererDeLista extends JTextArea implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        setBorder(new BevelBorder(BevelBorder.RAISED));
        setText(value.toString());
        if(isSelected){
            setBackground(Color.red);
            setForeground(Color.white);
        }else{
            setBackground(Color.lightGray);
            setForeground(Color.black);
        }
        
        return (this); 
    }
    
    
    
}

