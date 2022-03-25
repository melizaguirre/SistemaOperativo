/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.io.File;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class CMD extends javax.swing.JFrame {
    String nombre; 
    String tipo;
    String comando;
    String nombreFile = "";
    String carpetaAnterior = "";
    File f;
    
    Calendar fecha = Calendar.getInstance();
  
    public CMD() {
        getContentPane().setBackground(Color.DARK_GRAY);
        initComponents();
        fecha.add(Calendar.MONTH, 1);
    }
    
    public void agregarcomando(String comando){
        FieldComando.setText("");
        AreaComandos.append(comando +"\n");
    }
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
            java.util.logging.Logger.getLogger(CMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CMD().setVisible(true);
            }
        });
    }
    
    public void comand (String instruccion){
        int i =0;
        char letra = instruccion.charAt(i);
        //mkdir
        if(letra == 'M' && instruccion.charAt(i+1) =='k' && instruccion.charAt(i+2) == 'd'
                && instruccion.charAt(i+3) == 'i' && instruccion.charAt(i+4) == 'r'){
            comando = "Mkdir";
            nombreFile = "";
            for(int j = i+5; j<instruccion.length(); j++){
                if(instruccion.charAt(j)=='<'|| instruccion.charAt(j) == '>'){
                    
                }else{
                    nombreFile +=instruccion.charAt(j);
                }
            }
            
            CrearCarpeta(nombreFile);
            //Rm
        }else if (letra == 'R' && instruccion.charAt(i+1)=='m'){
            comando = "Rm";
            nombreFile = "";
            for (int j = 1+2; j<instruccion.length(); j++){
                if (instruccion.charAt(j)== '<' || instruccion.charAt(j)== '>'){
                    
                }else{
                    nombreFile += instruccion.charAt(j);
                }
            }
            System.out.println(nombreFile);
            borrarCarpeta(nombreFile);
            
            //cd
        }else if(letra == 'C' && instruccion.charAt(i+1) =='d'&& instruccion.charAt(i+2) == '<'){
            comando = "Cd";
            carpetaAnterior = nombreFile;
            nombreFile = "";
            for (int j = i+2; j<instruccion.length(); j++){
                if (instruccion.charAt(j) == '<' || instruccion.charAt(j)== '>'){
                
            } else {
                    nombreFile +=instruccion.charAt(j);
                }
            }
            System.out.println(nombreFile);
            setCarpeta(nombreFile);
           //Cd.. 
        }else if (letra == 'C' && instruccion.charAt(i+1) == 'd' && instruccion.charAt(i+2)== '.'
                && instruccion.charAt(i+3) == '.'){
            comando = "Cd..";
            volverAnterior();
            
            //dir
        }else if (letra == 'D' && instruccion.charAt(i+1) == 'i' && instruccion.charAt(i+2)== 'r'){
            comando = "Dir";
            Direccion();
            
            //DATE
        }else if (letra == 'D' && instruccion.charAt(i+1) == 'a' && instruccion.charAt(i+2)== 't'
                && instruccion.charAt(i+3) == 'e'){
            comando = "Date";
            Fecha();
            
            //time
        }else if (letra == 'T' && instruccion.charAt(i+1) == 'i' && instruccion.charAt(i+2)== 'm'
                && instruccion.charAt(i+3) == 'e'){
            comando = "Time";
            Time();
    } else {
            agregarcomando("Este comando no tiene ninguna funcion disponible");
        }
    }
    
    
    
    private boolean buscarFile(File files){
        if (files.isDirectory()){
            for (File hijo: files.listFiles()){
                buscarFile(hijo);
            }
        }
        return files.delete();
    }
    
    private boolean buscarFile2(File files){
        if (files.isDirectory() && files.exists()){
            return true;
        }
        return false;
    }
    
    public void CrearCarpeta(String carpetanueva){
        try{
            f = new File("Raiz/" + nombre + "/" +carpetanueva);
            if (f.mkdirs()){
                agregarcomando("CarpetaCreado\n");
                System.out.println("Carpeta creada");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void borrarCarpeta(String carpetaborrar){
        try{
            f = new File("Raiz/" + nombre+ "/" + carpetaborrar);
            if (buscarFile(f)){
                agregarcomando("Su archivo se ha eliminado");
            }else {
                agregarcomando ("Este archivo no se ha encontrado");  
            }
               
            }catch (Exception e){
                System.out.println(e); 
        }
    }
    
    public void setCarpeta (String carpeta){
        try {
            File n = new File ("Raiz/" + nombre + "/" + carpeta);
            if (buscarFile2(n)){
                f = new File("Raiz/" + nombre + "/"+ carpeta);
                agregarcomando("se ha cambiado la carpeta actual");
                agregarcomando(f.getName());
            }else {
                agregarcomando("Esta carpeta no existe");
            }
        } catch (Exception e){
                    System.out.println(e);
                    }
    }
    public void volverAnterior (){
        try{
            nombreFile = carpetaAnterior;
            f = new File ("Raiz/" + nombre + "/"+nombreFile);
            agregarcomando("Se ha cambiado su carpeta a la seleccionada anteriormente");
            
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void Direccion(){
        File [] dir =f.listFiles();
        agregarcomando("Lista de Archivos");
        
        for (int i = 0; i < dir.length; i++){
            System.out.println(dir[i].getName());
            agregarcomando(dir[i].getName());
        }
    }
    
    public void Fecha(){
        agregarcomando(fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.YEAR));
    }
    public void Time(){
        agregarcomando(fecha.getTime().toString());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEjecutar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaComandos = new javax.swing.JTextArea();
        FieldComando = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("Query");

        AreaComandos.setBackground(new java.awt.Color(51, 51, 51));
        AreaComandos.setColumns(20);
        AreaComandos.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        AreaComandos.setForeground(new java.awt.Color(0, 102, 0));
        AreaComandos.setRows(5);
        AreaComandos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AreaComandosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(AreaComandos);

        FieldComando.setBackground(new java.awt.Color(51, 51, 51));
        FieldComando.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        FieldComando.setForeground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FieldComando)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEjecutar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(FieldComando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEjecutar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        // TODO add your handling code here:
        String comando = FieldComando.getText();
        if (!comando.isEmpty()){
            agregarcomando(comando);
            comand(comando);
        }else {
            JOptionPane.showMessageDialog(this, "Coloque un comando en el area");
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void AreaComandosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AreaComandosKeyPressed
        // TODO add your handling code here:
        String comando = FieldComando.getText();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            agregarcomando(comando);
        }else {
            JOptionPane.showMessageDialog(this, "Coloque un comando en el area");
        }
    }//GEN-LAST:event_AreaComandosKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea AreaComandos;
    public javax.swing.JTextField FieldComando;
    public javax.swing.JButton btnEjecutar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
