/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Color;
import java.awt.GridLayout ;
import javax.swing.JButton ;
import java.awt.Container ;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel ;
import javax.swing.BoxLayout ;
import javax.swing.JTextField ;
/**
 *
 * @author Ashwin
 */
public class ColorPallette extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    BoxLayout root ;
    GridLayout paletteLayout, selectorLayout ;
    JButton button ;
    Container paletteContainer ;
    JPanel palettePanel, selectorPanel, foreground, background ;
    JTextField text ;
    
    void populate(){
        paletteLayout = new GridLayout(3,3) ;
        selectorPanel = palettePanel = new JPanel( ) ;
        palettePanel.setLayout(paletteLayout);
        text = new JTextField("This is a foreground") ;
        for (int i=1 ;i<10; i++){
            button = new JButton() ;
            button.setBackground(new Color(new Random().nextInt(255),
                    new Random().nextInt(255),
                    new Random().nextInt(255))) ;
            button.setPreferredSize(new Dimension(30,30));
            button.setBorder(BorderFactory.createBevelBorder(1));
            button.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent event){
                    button = (JButton)event.getSource() ;
                    Color setting = button.getBackground() ;
                    background.setBackground(setting) ;
                    text.setForeground(setting) ;
                }
            });
            palettePanel.add(button);
        }
        palettePanel.setVisible(true);
        
    }
    @Override
    public void init() {
        populate() ;
        background  = new JPanel() ;
        background.setPreferredSize(new Dimension(200, 200));
        background.add(text) ;
        background.setVisible(true) ;
        
        add(palettePanel) ;
        add(background) ;
        this.setVisible(true);
    }
}
