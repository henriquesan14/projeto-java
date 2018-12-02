/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author computador
 */
public class UsuarioDaoImpl implements UsuarioDao {

    @Override
    public Usuario logar(String login, String senha) {
        Usuario u = new Usuario();
        String sql = "select * from usuario where login=? and senha=?";
        PreparedStatement ps;
        try(Connection conn = new ConnectionFactory().getConnection()){
            ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                u.setId(rs.getLong("id_usuario"));
                u.setNome(rs.getString("nome_usuario"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setAtivo(rs.getInt("ativo"));
                u.setRole(rs.getString("role"));
                return u;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("erro");
        }
        return null;
    }

    @Override
    public int salvar(Usuario u) {
        int ok=0;
	String sql = "insert into usuario(nome_usuario,login,senha,ativo,role) values (?,?,?,?,?);";
        PreparedStatement ps;
        try(Connection conn=new ConnectionFactory().getConnection()){
            ps = conn.prepareStatement(sql);
            ps.setString(1,u.getNome());
            ps.setString(2,u.getLogin());
            ps.setString(3,u.getSenha());
            ps.setInt(4,u.getAtivo());
            ps.setString(5,u.getRole());
            ok=ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error ao inserir usuario no banco");
            System.out.println(e.getMessage());
        }	
        return ok;
    }

    @Override
    public int editar(Usuario u) {
         int ok=0;
            String sql = "update usuario set nome_usuario = ?, login = ?,senha=?,role=? where id_usuario = ?";
            try(Connection conn = new ConnectionFactory().getConnection()){
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, u.getNome());
		ps.setString(2, u.getLogin());
                ps.setString(3,u.getSenha());
                ps.setString(4,u.getRole());
		ps.setLong(5, u.getId());
		ok=ps.executeUpdate();
            }catch(SQLException e) {
		System.out.println("Error ao atualizar um usuario do banco");
		System.out.println(e.getMessage());
            }
                
            return ok;
    }
    

    @Override
    public int desativar(Long id) {
        int ok=0;
		String sql = "update usuario set ativo='0' where id_usuario=?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			ok=ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Error ao desativar usuario do banco");
			System.out.println(e.getMessage());
		}
                
            return ok;
    }

    @Override
    public int ativar(Long id) {
        int ok=0;
		String sql = "update usuario set ativo='1' where id_usuario=?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			ok=ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Error ao ativar usuario do banco");
			System.out.println(e.getMessage());
		}
                
            return ok;
    }

    @Override
    public List<Usuario> buscar() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
	    String sql = "select * from usuario";
	    PreparedStatement ps;
	    try(Connection conn = new ConnectionFactory().getConnection()){
	        ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	            Usuario u = new Usuario();
	            u.setId(rs.getLong("id_usuario"));
                    u.setNome(rs.getString("nome_usuario"));
                    u.setLogin(rs.getString("login"));
                    u.setSenha(rs.getString("senha"));
                    u.setAtivo(rs.getInt("ativo"));
                    u.setRole(rs.getString("role"));
                    usuarios.add(u);
	        }
	     }catch (SQLException e) {
	        System.out.println(e.getMessage());
	        System.out.println("Error ao listar usuarios do banco!");
	    }
	    return usuarios;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Usuario u = new Usuario();
        String sql = "select * from usuario where id_usuario=?";
        PreparedStatement ps;
        try(Connection conn = new ConnectionFactory().getConnection()){
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                u.setId(rs.getLong("id_usuario"));
                u.setNome(rs.getString("nome_usuario"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setAtivo(rs.getInt("ativo"));
                u.setRole(rs.getString("role"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("erro");
        }
        return u;
    }

    @Override
    public List<Usuario> buscarPorNome(String nome) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
	    String sql = "select * from usuario where nome_usuario like ?";
	    PreparedStatement ps;
	    try(Connection conn = new ConnectionFactory().getConnection()){
	        ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+nome+"%");
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	            Usuario u = new Usuario();
	            u.setId(rs.getLong("id_usuario"));
                    u.setNome(rs.getString("nome_usuario"));
                    u.setLogin(rs.getString("login"));
                    u.setSenha(rs.getString("senha"));
                    u.setAtivo(rs.getInt("ativo"));
                    u.setRole(rs.getString("role"));
                    usuarios.add(u);
	        }
	     }catch (SQLException e) {
	        System.out.println(e.getMessage());
	        System.out.println("Error ao listar usuarios do banco!");
	    }
	    return usuarios;
    }
    
    public boolean verificaLogin(String login) {
        Usuario u = new Usuario();
        String sql = "select * from usuario where login=?";
        PreparedStatement ps;
        try(Connection conn = new ConnectionFactory().getConnection()){
            ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("erro");
        }
        return false;
    }
    
}
