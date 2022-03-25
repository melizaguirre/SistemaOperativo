/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;

/**
 *
 * @author BAC
 */
public class test {
    public static void main(String[] args) throws IOException {
        User admin = new User();
        admin.write("Admin", "1234", "Administrador");
    }
}
