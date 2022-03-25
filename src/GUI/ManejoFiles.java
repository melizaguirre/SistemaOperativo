/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author BAC
 */
public class ManejoFiles extends javax.swing.JInternalFrame {

    String nombre;
    String tipo;
    
    String seleccion;
    File f;
    String nombrefile;
    String elegido;
    
    public ManejoFiles() {
        initComponents();
        System.out.println("Tipo: "+ tipo);
    }
    
    private String manejoDir(String direccion){
        String completo = "";
        for(int i = 0; i<direccion.length(); i++){
            char letra = direccion.charAt(i);
            if(letra == '[' || letra == ']'){
                
            }else if(letra == ','){
                completo += '/';
            }else if (letra == ' '){
                
            }else {
                completo += letra;
            }
        }
        return completo;
    }
     DefaultMutableTreeNode nodoArbol;
     DefaultTreeModel modelo;
    public void Actualizacion (){
        if (tipo.equals("Administrador")){
             File dir = new File ("Raiz");
            nodoArbol = new DefaultMutableTreeNode(dir);
            modelo = new DefaultTreeModel(nodoArbol);
            
            jTree1.setModel(modelo);
            nombreFile.setText("");
        }else {
            File dir = new File("Raiz/"+nombre);
            nodoArbol = new DefaultMutableTreeNode(dir);
            modelo = new DefaultTreeModel(nodoArbol);
            jTree1.setModel(modelo);
            nombreFile.setText("");
        }
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        btnSet = new javax.swing.JButton();
        bthAgregarArchivo = new javax.swing.JButton();
        btnAgregarCarpeta = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCopiar = new javax.swing.JButton();
        btnPegar = new javax.swing.JButton();
        btnActualizat = new javax.swing.JButton();
        nombreFile = new javax.swing.JTextField();

        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        btnSet.setText("Set");
        btnSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetActionPerformed(evt);
            }
        });

        bthAgregarArchivo.setText("Agregar Archivo");
        bthAgregarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthAgregarArchivoActionPerformed(evt);
            }
        });

        btnAgregarCarpeta.setText("Agregar Carpeta");
        btnAgregarCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarpetaActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCopiar.setText("Copiar");
        btnCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiarActionPerformed(evt);
            }
        });

        btnPegar.setText("Pegar");
        btnPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPegarActionPerformed(evt);
            }
        });

        btnActualizat.setText("Actualizar Archivos");
        btnActualizat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnPegar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnActualizat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(124, 124, 124))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCopiar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgregarCarpeta)
                                    .addComponent(bthAgregarArchivo))
                                .addGap(135, 135, 135))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(nombreFile, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(nombreFile, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSet)
                .addGap(78, 78, 78)
                .addComponent(bthAgregarArchivo)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarCarpeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnCopiar)
                .addGap(27, 27, 27)
                .addComponent(btnPegar)
                .addGap(18, 18, 18)
                .addComponent(btnActualizat)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizatActionPerformed

        Actualizacion();
    }//GEN-LAST:event_btnActualizatActionPerformed

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        // TODO add your handling code here:
        seleccion = jTree1.getSelectionPath().toString();
        seleccion = manejoDir(seleccion);
        nombreFile.setText(seleccion);
    }//GEN-LAST:event_jTree1MouseClicked

    private void btnSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetActionPerformed
        // TODO add your handling code here:
        f = new File(seleccion);
        elegido = jTree1.getSelectionPath().getLastPathComponent().toString();
        nombre= nombreFile.getText();
        
        JOptionPane.showMessageDialog(this, "Archivo fijado");
    }//GEN-LAST:event_btnSetActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        borrar();
        nombreFile.setText("");
        Actualizacion();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void bthAgregarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthAgregarArchivoActionPerformed
        // TODO add your handling code here:
        String extension = JOptionPane.showInternalInputDialog(this, "Escriba el nombre d ela extension del archivo");
        f = new File(seleccion +"/" + nombrefile +"."+extension);
        try{
            if(f.createNewFile()){
                JOptionPane.showMessageDialog(this,"Su archivo fue creado correctamente");
                nombreFile.setText("");
                Actualizacion();
            }
        }catch (IOException ex){
            Logger.getLogger(ManejoFiles.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println("Error: "+ ex);
        }
    }//GEN-LAST:event_bthAgregarArchivoActionPerformed

    private void btnAgregarCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarpetaActionPerformed
        // TODO add your handling code here:
        f = new File(seleccion + "/" + nombrefile);
        if(f.mkdirs()){
           JOptionPane.showMessageDialog(this, "Su carpeta fue creada correctamente");
           nombreFile.setText("");
           Actualizacion();
        } else {
            JOptionPane.showMessageDialog(this, "Su carpeta no pudo ser creada");
        }
    }//GEN-LAST:event_btnAgregarCarpetaActionPerformed

    private void btnCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarActionPerformed
        // TODO add your handling code here:
        elegido = manejoDir(jTree1.getSelectionPath().getLastPathComponent().toString());
        seleccion = manejoDir(jTree1.getSelectionPath().toString());
        f = new File(seleccion);
        JOptionPane.showMessageDialog(this, "Copiado");
    }//GEN-LAST:event_btnCopiarActionPerformed

    private void btnPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPegarActionPerformed
        // TODO add your handling code here:
        if (f.isDirectory()){
            seleccion = manejoDir(jTree1.getSelectionPath().toString());
            File n = new File (seleccion +"/" + elegido);
            try{
                Files.copy(f.toPath(), n.toPath());
                
                for (File hijo: n.listFiles()){
                    File j = new File(hijo.getAbsolutePath());
                    j.createNewFile();
                    Files.copy(n.toPath(), j.toPath());
                }
                JOptionPane.showMessageDialog(this, "Archivo pegado");
                Actualizacion();
            } catch (IOException ex){
                JOptionPane.showMessageDialog(this, "Su carpeta no se ha podido copiar");
            }
            f.mkdirs();
        }else if(f.isFile()){
            seleccion = manejoDir(jTree1.getSelectionPath().toString());
            File n = new File(seleccion +"/"+elegido);
            try{
                Files.copy(f.toPath(), n.toPath());
                Actualizacion();
                JOptionPane.showMessageDialog(this, "Archivo pegado");
                
            }catch (IOException ex){
                Logger.getLogger(ManejoFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnPegarActionPerformed

    private boolean buscarFile(File files){
        if(files.isDirectory()){
            for(File hijo: files.listFiles()){
                buscarFile(hijo);
            }
        }
        return files.delete();
    }
    public void borrar(){
        if (buscarFile(f)){
            JOptionPane.showMessageDialog(this, "Su archivo se ha eliminado exitosamente");
        }else {
            JOptionPane.showMessageDialog(this, "Este archivo no se ha encontrado");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bthAgregarArchivo;
    private javax.swing.JButton btnActualizat;
    private javax.swing.JButton btnAgregarCarpeta;
    private javax.swing.JButton btnCopiar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnPegar;
    private javax.swing.JButton btnSet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JTextField nombreFile;
    // End of variables declaration//GEN-END:variables
}
