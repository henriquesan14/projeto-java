/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextField;
import model.Usuario;

/**
 *
 * @author computador
 */
public class UsuarioController {
 
    private UsuarioDao dao;

    public UsuarioController() {
        this.dao=new UsuarioDaoImpl();
    }
    
    public Usuario login(String login,String senha){
        return dao.logar(login, senha);
    }
    
    public int salvar(String nome,String login,String senha,String role){
        if(dao.verificaLogin(login)==false){
            Usuario u=new Usuario(nome,login,senha,role);
            return dao.salvar(u);
        }
        return 0; 
    }
    
    public int editar(Long id,String nome,String login,String senha,String role){
        Usuario u=new Usuario(id,nome,login,senha,role);
        return dao.editar(u);
    }
    
    public List<Usuario> listar() {
        return dao.buscar();
    }
    
    public List<Usuario> listarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }
    
    public int ativar(Long id) {
        return dao.ativar(id);
    }
    
    public int desativar(Long id) {
        return dao.desativar(id);
    }
    
}
