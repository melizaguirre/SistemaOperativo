/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

/**
 * 
 * @author BAC
 */
public class User implements Serializable{
   RandomAccessFile user;
   static File archivos = null;
   
   public User(){
   try{
    user = new RandomAccessFile("BDUsuarios/RegistrosUsers.usr", "rw");
    
   }catch (IOException e){
            System.out.println("Error " + e);
   } 
   
   }
   
   public long getFinal()throws IOException{
       if (user.length()!= 0){
           user.seek(0);
           while(user.getFilePointer()< user.length()){
               user.readUTF();
               user.readUTF();
               user.readUTF();
           }
       }
       return user.getFilePointer();
   }
   
   public static void setArchivos(String direccion){
       archivos = new File(direccion);
   }
   
   public static boolean crearFolder(){
       return archivos.mkdir();
   }
   public boolean write(String usuario, String contrasena, String tipo)throws IOException{
       try{
           user.seek(getFinal());
           user.writeUTF(usuario);
           user.writeUTF(contrasena);
           user.writeUTF(tipo);
           
           setArchivos("Raiz");
           archivos.mkdir();
           setArchivos("Raiz/"+ usuario);
           
           if (crearFolder()){
               setArchivos("Raiz/"+ usuario + "/Imagenes");
               archivos.mkdir(); 
               
               setArchivos("Raiz/"+ usuario + "/Documentos");
               archivos.mkdir();
               
               setArchivos("Raiz/"+ usuario + "/Musica");
               archivos.mkdir();
               return true;
           }
       } catch (IOException e){
           return false;
       }
       return false;
   }
   public boolean findUser( String usuario, String contrasena)throws IOException{
       user.seek(0);
       String users; 
       String password;
       String tipo;
       
       while (user.getFilePointer() < user.length()){
           long pos = user.getFilePointer();
           users = user.readUTF();
           password = user.readUTF();
           tipo = user.readUTF();
           
           if(users.equals(usuario) && password.equals(contrasena)){
               user.seek(pos);
               return true;
           }
       }
       return false;
   }
   public String encontrartipo(String usuario, String contra)throws IOException{
       user.seek(0);
       String users; 
       String password;
       String tipo;
       while(user.getFilePointer()< user.length()){
           users=user.readUTF();
           password = user.readUTF();
           tipo = user.readUTF();
           
           if(users.equals(usuario) && password.equals(contra)){
               return tipo;
           }
       }
       return null;
   }
}
    

