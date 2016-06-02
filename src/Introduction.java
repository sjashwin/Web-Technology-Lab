/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JApplet;
import javax.swing.JButton ;
import java.awt.Container ;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JComboBox ;
import javax.swing.JLabel ;
import javax.swing.JPanel;
import javax.swing.JTextField ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener;
import java.awt.Checkbox ;
import javax.swing.JList ;


/**
 *
 * @author Ashwin
 */
public class Introduction extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    JButton button ;
    Container  container ;
    JPanel panel ;
    JComboBox select  ;
    Checkbox checker ;
    JLabel label, values ;
    JTextField textField ;
    JList gender ;
    public void populate(){
        button = new JButton("Click") ;
        checker = new Checkbox("Agree to terms and conditions") ;
        container = new Container() ;
        panel = new JPanel() ;
        label = new JLabel("Name:") ;
        values = new JLabel("none") ;
        textField = new JTextField() ;
        textField.setColumns(10);
        String[] list = {"male", "female"} ; 
        gender = new JList<>(list) ;
        
        String months[] = {"Jan", "Feb", "Mar","Apr", 
                            "May", "Jun", "Jul", "Aug", 
                            "Sep", "Oct", "Nov", "Dec"} ;
        select = new JComboBox<>(months) ;
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                StringBuilder answer = new StringBuilder() ;
                answer.append("Month : ").append(select.getSelectedItem()).append("\n");
                answer.append("Month : ").append(select.getSelectedItem()).append("\n") ;
                answer.append("Name : ").append(textField.getText()).append("\n") ;
                answer.append("T & C :").append(checker.getState()).append("\n") ;
                answer.append("Gender : ").append(gender.getSelectedValue()) ;
                System.out.println(answer.toString()) ;
            }
            }) ;
    }
    
    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
        populate() ;
        setLayout(new FlowLayout()) ;
        panel.setLayout(new GridLayout(4,2));
        
        panel.add(label) ;
        panel.add(textField) ;
        panel.add(select) ;
        panel.add(checker) ;
        panel.add(gender) ;
        panel.add(button) ;

        setContentPane(panel);
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){
    }
    // TODO overwrite start(), stop() and destroy() methods
}
