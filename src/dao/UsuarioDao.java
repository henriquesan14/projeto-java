/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Usuario;

/**
 *
 * @author computador
 */
public interface UsuarioDao {
    Usuario logar(String nome,String senha);
    int salvar(Usuario u);
    int editar(Usuario u);
    int desativar(Long id);
    int ativar(Long id);
    List<Usuario> buscar();
    Usuario buscarPorId(Long id);
    List<Usuario> buscarPorNome(String nome);
}
