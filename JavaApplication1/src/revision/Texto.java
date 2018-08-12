/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revision;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author aelias
 */
public class Texto extends JPanel implements ActionListener{
     private Style estiloRojo,estiloVerde,estiloAzul;
     private JTextPane texto;
     
     public Texto(){
         setLayout(new BorderLayout());
         add( creaMenu(),BorderLayout.NORTH );
    JTextPane texto = creaEditor();
    add( texto,BorderLayout.CENTER ); 
         
     }
     
     private JMenuBar creaMenu() {
    JMenuBar menu = new JMenuBar();
    JMenu estilo = new JMenu( "Estilo" );
    menu.add( estilo );
    
    JMenuItem mi = new JMenuItem( "Rojo" );
    estilo.add( mi );
    mi.addActionListener( this );
    
    mi = new JMenuItem( "Verde" );
    estilo.add( mi );
    mi.addActionListener( this );
    
    mi = new JMenuItem( "Azul" );
    estilo.add( mi );
    mi.addActionListener( this );
    
    return( menu );
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        Style estilo = null;
    String color = (String)e.getActionCommand();
    
    if( color.equals( "Rojo" ) ) {
      estilo = estiloRojo;
    } else if( color.equals( "Azul" ) ) {
      estilo = estiloAzul;
    } else if( color.equals( "Verde" ) ) {
      estilo = estiloVerde;
    }
    texto.setCharacterAttributes( estilo,false );
        
    }
    
    private JTextPane creaEditor() {
    StyleContext sc = creaEstilos();
    DefaultStyledDocument doc = new DefaultStyledDocument( sc );
    
    return( texto = new JTextPane( doc ) );
  }
  
  private StyleContext creaEstilos() {
    StyleContext sc = new StyleContext();
    
    estiloRojo = sc.addStyle( null,null );
    StyleConstants.setForeground( estiloRojo,Color.red );
    
    estiloVerde = sc.addStyle( null,null );
    StyleConstants.setForeground( estiloVerde,Color.green );
    StyleConstants.setFontSize( estiloVerde,24 );
    
    estiloAzul = sc.addStyle( null,null );
    StyleConstants.setForeground( estiloAzul,Color.blue );
    
    return( sc );
  }
  
  public static void main( String argv[] ) {
    JFrame ventana = new JFrame( "Tutorial de Java, Swing" );
    
    ventana.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent evt ){
	System.exit( 0 );
      }
    } );
    ventana.getContentPane().add( new Texto(),BorderLayout.CENTER );
    ventana.setSize( 300,180 );
    
    ventana.setVisible( true );
  }
    
}
