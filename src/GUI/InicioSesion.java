/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author BAC
 */
public class InicioSesion extends javax.swing.JFrame {
    User u = new User();
    public File file = null;
    
    public InicioSesion() {             
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jButtonEnviar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 161, -1, -1));

        jLabel2.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 342, -1, -1));

        jLabel3.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 398, -1, -1));

        txtUser.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background"), 1, true));
        txtUser.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 337, 134, 29));

        txtPass.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.background"), 1, true));
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(366, 393, 134, 29));

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEnviarMouseClicked(evt);
            }
        });
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 458, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/fomdodesenfocado.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        String nombre = txtUser.getText();
        String contra = txtPass.getText();
        try{
            if (u.findUser(nombre, contra)){
                String tipo = u.encontrartipo(nombre, contra);
                System.out.println("UsuarioIngresado tipo:"+tipo);
                Escritorio escritorio = new Escritorio();
                escritorio.setVisible(true);
                escritorio.nombreIngresado = nombre;
                escritorio.tipoIngresado = tipo;
                txtUser.setText("");
                txtPass.setText("");
            }else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
                txtUser.setText("");
                txtPass.setText("");
            }
            
        } catch (IOException ex){
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jButtonEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEnviarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEnviarMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioAplicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

   
}

