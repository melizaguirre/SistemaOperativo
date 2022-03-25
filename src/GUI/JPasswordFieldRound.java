/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPasswordField;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author BAC
 */
public class JPasswordFieldRound extends JPasswordField{
    
    public JPasswordFieldRound() {
         setOpaque(true);
        setBorder(border);
        setSize(d);
        setPreferredSize(d);
        setHorizontalAlignment(CENTER);
        setFont(new Font("Century Gothic", 0, 12));
        setEchoChar('*');
        addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                txtFocusGained(e);
            }
            
             public void focusLost(FocusEvent e){
            txtFocusLost(e);          
            setEchoChar('*');
        }
    });
    }
    private void txtFocusGained(FocusEvent evt){
        setBorder(new BorderLineRound(Color.lightGray,true));   
    }
    private void txtFocusLost(FocusEvent evt){
        setBorder(border);
    }
    private final Dimension d = new Dimension(250, 25);
    private final BorderLineRound border = new BorderLineRound((Color.lightGray.darker()), true);
    
}
