/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.*;
import javax.swing.DefaultListModel;
import java.util.ArrayList; 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager; 


public class PlayerMemo extends javax.swing.JFrame{
    
    Playlist pl=new Playlist();
    
    ArrayList updateList= new ArrayList();
    
    javazoom.jl.player.Player player;
    File simpan;
    

    /**
     * Creates new form PlayerMemo
     */
    
    public PlayerMemo() {    
        initComponents();
    }
 
    

    void updateList(){
    
        updateList=pl.getListSong();
        DefaultListModel model=new DefaultListModel();
        
        for(int i=0;i<updateList.size();i++)
            {
                int j=1+1;
                model.add(i,j + " | " + ((File) updateList.get(i)).getName());
                
                
            }
        jPlaylist.setModel(model);
           
    }
    
    // panel de control
    
    void add(){
    
        pl.add(this);
        updateList();
    }
    
    void remove(){
    
        try {
              int memoherdez=jPlaylist.getLeadSelectionIndex();
              pl.ls.remove(memoherdez);
              updateList();
            
        } catch (Exception e) {
        }
        
    }
 
     void up(){
    
         try {
                int s1=jPlaylist.getLeadSelectionIndex();
                simpan=(File)pl.ls.get(s1);
                pl.ls.remove(s1);
                pl.ls.add(s1-1,simpan);
                updateList();
                jPlaylist.setSelectedIndex(s1-1);
             
         } catch (Exception e) {
         }
        
    }
     
      void down(){
          
          try {
                int s1=jPlaylist.getLeadSelectionIndex();
                simpan=(File)pl.ls.get(s1);
                pl.ls.remove(s1);
                pl.ls.add(s1+1,simpan);
                updateList();
                jPlaylist.setSelectedIndex(s1+1);
             
         } catch (Exception e) {
         }
        
    }
      
      void open(){
    
        pl.openPls(this);
        updateList();
    }
      
      void save(){
    
       pl.saveAsPlaylist(this);
       updateList();
    }
      
      File play1;
      static int a=0;
      
      void putar(){
      
          if(a==0)
             {
                 try {
                        int p1=jPlaylist.getSelectedIndex();
                        play1=(File)this.updateList.get(p1);
                        FileInputStream fis=new FileInputStream(play1);
                        BufferedInputStream bis=new BufferedInputStream(fis);
                        player=new javazoom.jl.player.Player(bis);
                        a=1;
                     
                 } catch (Exception e) {
                     System.out.println("Problema al tocar musica");
                     System.out.println(e);
                 }
                 
                 new Thread()
                     {
                         @Override
                         public void run(){
                         
                             try {
                                   player.play();
                                 
                             } catch (Exception e) {
                                 
                             }
                         }
                  
                     }.start();
                 
             }
          else
              {
                 player.close();
                 a=0;
                 putar();
                  
              }
          
      }
      
      File sa;
      void next(){
      
      if(a==0)
             {
                 try {
                        int s1=jPlaylist.getSelectedIndex()+1;
                        sa=(File)this.pl.ls.get(s1);
                        FileInputStream fis=new FileInputStream(sa);
                        BufferedInputStream bis=new BufferedInputStream(fis);
                        player=new javazoom.jl.player.Player(bis);
                        a=1;
                        jPlaylist.setSelectedIndex(s1);
                     
                 } catch (Exception e) {
                     System.out.println("Problema al tocar musica");
                     System.out.println(e);
                 }
                 
                 new Thread()
                     {
                         @Override
                         public void run(){
                         
                             try {
                                   player.play();
                                 
                             } catch (Exception e) {
                                 
                             }
                         }
                  
                     }.start();
                 
             }
          else
              {
                 player.close();
                 a=0;
                 next();
                  
              }    
          
      }
      
      void previous(){
      
             if(a==0)
             {
                 try {
                        int s1=jPlaylist.getSelectedIndex()-1;
                        sa=(File)this.pl.ls.get(s1);
                        FileInputStream fis=new FileInputStream(sa);
                        BufferedInputStream bis=new BufferedInputStream(fis);
                        player=new javazoom.jl.player.Player(bis);
                        a=1;
                        jPlaylist.setSelectedIndex(s1);
                     
                 } catch (Exception e) {
                     System.out.println("Problema al tocar musica");
                     System.out.println(e);
                 }
                 
                 new Thread()
                     {
                         @Override
                         public void run(){
                         
                             try {
                                   player.play();
                                 
                             } catch (Exception e) {
                                 
                             }
                         }
                  
                     }.start();
                 
             }
          else
              {
                 player.close();
                 a=0;
                 previous();
                  
              } 
          
      }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnadd = new javax.swing.JButton();
        btnremove = new javax.swing.JButton();
        btndown = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btnup = new javax.swing.JButton();
        btnopen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPlaylist = new javax.swing.JList<>();
        btnprevius = new javax.swing.JButton();
        btnplay = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btnstop = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnadd.setBackground(new java.awt.Color(102, 102, 102));
        btnadd.setForeground(new java.awt.Color(255, 0, 102));
        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_add_126583.png"))); // NOI18N
        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        getContentPane().add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 102, -1));

        btnremove.setBackground(new java.awt.Color(102, 102, 102));
        btnremove.setForeground(new java.awt.Color(255, 0, 102));
        btnremove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_remove-rounded_383082.png"))); // NOI18N
        btnremove.setText("REMOVE");
        btnremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoveActionPerformed(evt);
            }
        });
        getContentPane().add(btnremove, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        btndown.setBackground(new java.awt.Color(102, 102, 102));
        btndown.setForeground(new java.awt.Color(255, 0, 102));
        btndown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_145_111066.png"))); // NOI18N
        btndown.setText("DOWN");
        btndown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndownActionPerformed(evt);
            }
        });
        getContentPane().add(btndown, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        btnsave.setBackground(new java.awt.Color(102, 102, 102));
        btnsave.setForeground(new java.awt.Color(255, 0, 102));
        btnsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_save_326688.png"))); // NOI18N
        btnsave.setText("SAVE");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 81, -1));

        btnup.setBackground(new java.awt.Color(102, 102, 102));
        btnup.setForeground(new java.awt.Color(255, 0, 102));
        btnup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_arrow-up-thick_216098.png"))); // NOI18N
        btnup.setText("UP");
        btnup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupActionPerformed(evt);
            }
        });
        getContentPane().add(btnup, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 86, -1));

        btnopen.setBackground(new java.awt.Color(102, 102, 102));
        btnopen.setForeground(new java.awt.Color(255, 0, 102));
        btnopen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_folder-open_1608888.png"))); // NOI18N
        btnopen.setText("OPEN");
        btnopen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnopenActionPerformed(evt);
            }
        });
        getContentPane().add(btnopen, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jPlaylist.setBackground(new java.awt.Color(51, 51, 51));
        jPlaylist.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPlaylist.setForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(jPlaylist);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 370, 215));

        btnprevius.setForeground(new java.awt.Color(204, 204, 204));
        btnprevius.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        btnprevius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpreviusActionPerformed(evt);
            }
        });
        getContentPane().add(btnprevius, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 64, 45));

        btnplay.setBackground(new java.awt.Color(51, 51, 51));
        btnplay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/play.png"))); // NOI18N
        btnplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnplayActionPerformed(evt);
            }
        });
        getContentPane().add(btnplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 69, 58));

        btnnext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/next.png"))); // NOI18N
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });
        getContentPane().add(btnnext, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 66, 45));

        btnstop.setBackground(new java.awt.Color(102, 102, 102));
        btnstop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_media-stop_216325.png"))); // NOI18N
        btnstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstopActionPerformed(evt);
            }
        });
        getContentPane().add(btnstop, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 53, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 102));
        jLabel1.setText("Mi Musica");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 22, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnplayActionPerformed
        putar();
    }//GEN-LAST:event_btnplayActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
       add();
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoveActionPerformed
        remove();
    }//GEN-LAST:event_btnremoveActionPerformed

    private void btnpreviusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpreviusActionPerformed
        previous();
    }//GEN-LAST:event_btnpreviusActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        next();
    }//GEN-LAST:event_btnnextActionPerformed

    private void btnopenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnopenActionPerformed
        open();
    }//GEN-LAST:event_btnopenActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        save();
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstopActionPerformed
        player.close();
        
    }//GEN-LAST:event_btnstopActionPerformed

    private void btndownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndownActionPerformed
        down();
    }//GEN-LAST:event_btndownActionPerformed

    private void btnupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupActionPerformed
        up();
    }//GEN-LAST:event_btnupActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PlayerMemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerMemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerMemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerMemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayerMemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndown;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnopen;
    private javax.swing.JButton btnplay;
    private javax.swing.JButton btnprevius;
    private javax.swing.JButton btnremove;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnstop;
    private javax.swing.JButton btnup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jPlaylist;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private DefaultListModel DefaultListModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
