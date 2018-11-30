/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import javax.swing.JFrame;
import javax.swing.JTextField;
import model.Usuario;

/**
 *
 * @author computador
 */
public class LoginController {
 
    private JFrame janela;
    private UsuarioDao dao;

    public LoginController() {
        this.dao=new UsuarioDaoImpl();
    }
    
    public Usuario login(JTextField login,JTextField senha){
        return dao.logar(login.getText(), senha.getText());
    } 
    
}
