/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;

/**
 *
 * @author BAC
 */
public class Users {
    protected String username;
    protected String password;
    protected String tipo;

  
    
    
    public Users (){}

    public Users(String username, String password, String tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User {\nUsername: ").append(this.username);
        sb.append(", {\nPassword: ").append(this.password);
        sb.append("\n}");
        return sb.toString();
    }
    
    
    
    
}
