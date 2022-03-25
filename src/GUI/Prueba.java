/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author BAC
 */
public class Prueba {
     RandomAccessFile user;
   static File archivos = null;
   
   public Prueba(){
   try{
    user = new RandomAccessFile("BDUsuarios/RegistrosUsers.usr", "rw");
    
   }catch (IOException e){
            System.out.println("Error " + e);
   } 
   
   }
   
}
/*
VISOR 
String nombre; 
    File[] imagenes;
    int pos =0;
    
    public void obetnerimagenes(String camino){
        File carpeta = new File(camino);
        imagenes = carpeta.listFiles();
    }
    public ImageIcon ResizeImage(File ImagePath){
        String dir = ImagePath.getAbsolutePath();
        ImageIcon myimage = new ImageIcon(dir);
        Image img = myimage.getImage();
        Image newImg = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    public VisordeImagenes() {
        initComponents();
    }

 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        pos = pos +1;
       if (pos > imagenes.length){
           pos = 0;
           jLabel1.setIcon(ResizeImage(imagenes[pos]));
       }else {
           jLabel1.setIcon(ResizeImage(imagenes[pos]));
       }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       pos = pos -1;
       if (pos == -1){
           pos = imagenes.length;
           jLabel1.setIcon(ResizeImage(imagenes[pos]));
       }else {
           jLabel1.setIcon(ResizeImage(imagenes[pos]));
       }
    } 
*/
