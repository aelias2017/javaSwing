/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revision;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author aelias
 */
public class JHolaMundo extends JFrame {
    public static void main(String[] args) {
        new JHolaMundo();
    }
    
    public JHolaMundo(){
        JLabel holaMundo = new JLabel("Hola Mundo!");
        getContentPane().add(holaMundo,"Center");
        setSize(200, 100);
        setVisible(true);
    }
    
}
