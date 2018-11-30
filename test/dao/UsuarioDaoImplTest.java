/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author computador
 */
public class UsuarioDaoImplTest {
    
    public UsuarioDaoImplTest() {
    }

    UsuarioDao dao = new UsuarioDaoImpl();
    
    @Test
    public void logar() {
        //Usuario u=dao.logar("admin", "admin");
        //System.out.println(u);
    }
    
    @Test
    public void salvar(){
        Usuario u=new Usuario();
        u.setNome("henrique");
        u.setLogin("admin");
        u.setSenha("admin");
        u.setRole("admin");
        dao.salvar(u);
    }
    
    @Test
    public void editar(){
        Usuario u=new Usuario(1l,"carlos","carlos","123","user");
        dao.editar(u);
                
    }
    
    @Test
    public void desativar(){
        dao.desativar(2l);
    }
    
    @Test
    public void ativar(){
        dao.ativar(1l);
    }
    
    @Test
    public void buscar(){
        List<Usuario> usuarios=dao.buscar();
        for(Usuario u : usuarios){
            System.out.println(u);
        }
    }
    
    @Test
    public void buscarPorNome(){
        List<Usuario> usuarios=dao.buscarPorNome("car");
        for(Usuario u : usuarios){
            System.out.println(u);
        }
    }
    
    @Test
    public void buscarPorId(){
        Usuario u=dao.buscarPorId(1l);
        System.out.println(u);
    }
    
}
