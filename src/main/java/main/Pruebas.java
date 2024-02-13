/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import forms.JFrameMenu;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;
import persistencia.CuentaDAO;

/**
 *
 * @author Amos Heli Olguin Quiroz
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        
//        ConexionBD conexion = new ConexionBD();
//        ClienteDAO clienteDAO = new ClienteDAO(conexion);
//        CuentaDAO cuentaDAO = new CuentaDAO(conexion);
        JFrameMenu menu = new JFrameMenu();
        menu.setVisible(true);
        
    }
    
}
