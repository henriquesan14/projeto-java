/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Paciente;

/**
 *
 * @author computador
 */
public class PacienteDaoImpl implements PacienteDao {

    @Override
    public int salvar(Paciente p) {
        int ok=0;
	String sql = "insert into paciente(nome_paciente,rg,cpf_paciente,data_nascimento,telefone_paciente) values (?,?,?,?,?);";
        PreparedStatement ps;
        try(Connection conn=new ConnectionFactory().getConnection()){
            ps = conn.prepareStatement(sql);
            ps.setString(1,p.getNome());
            ps.setString(2,p.getRg());
            ps.setString(3,p.getCpf());
            ps.setObject(4,p.getDtNascimento());
            ps.setString(5,p.getTelefone());
            ok=ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error ao inserir paciente no banco");
            System.out.println(e.getMessage());
        }	
        return ok;
    }

    @Override
    public int editar(Paciente p) {
        int ok=0;
            String sql = "update paciente set nome_paciente = ?, rg = ?,cpf_paciente=?,data_nascimento=?,telefone_paciente=? where id_paciente = ?";
            try(Connection conn = new ConnectionFactory().getConnection()){
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, p.getNome());
		ps.setString(2, p.getRg());
                ps.setString(3,p.getCpf());
                ps.setObject(4, p.getDtNascimento());
                ps.setString(5,p.getTelefone());
		ps.setLong(6, p.getId());
		ok=ps.executeUpdate();
            }catch(SQLException e) {
		System.out.println("Error ao atualizar um paciente do banco");
		System.out.println(e.getMessage());
            }
                
            return ok;
    }

    @Override
    public int excluir(Long id) {
        int ok=0;
		String sql = "delete from paciente where id_paciente = ?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			ok=ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Error ao deletar um paciente do banco");
			System.out.println(e.getMessage());
		}
                
            return ok;
    }

    @Override
    public List<Paciente> buscar() {
        ArrayList<Paciente> pacientes = new ArrayList<>();
	    String sql = "select * from paciente";
	    PreparedStatement ps;
	    try(Connection conn = new ConnectionFactory().getConnection()){
	        ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	            Paciente p = new Paciente();
	            p.setId(rs.getLong("id_paciente"));
                    p.setNome(rs.getString("nome_paciente"));
                    p.setRg(rs.getString("rg"));
                    p.setCpf(rs.getString("cpf_paciente"));
                    p.setDtNascimento(rs.getDate("data_nascimento"));
                    p.setTelefone(rs.getString("telefone_paciente"));
                    pacientes.add(p);
	        }
	     }catch (SQLException e) {
	        System.out.println(e.getMessage());
	        System.out.println("Error ao listar categorias do banco!");
	    }
	    return pacientes;
    }

    @Override
    public Paciente buscarPorId(Long id) {
        Paciente p = new Paciente();
        String sql = "select * from paciente where id_paciente=?";
        PreparedStatement ps;
        try(Connection conn = new ConnectionFactory().getConnection()){
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getLong("id_paciente"));
                p.setNome(rs.getString("nome_paciente"));
                p.setRg(rs.getString("rg"));
                p.setCpf(rs.getString("cpf_paciente"));
                p.setDtNascimento(rs.getDate("data_nascimento"));
                p.setTelefone(rs.getString("telefone_paciente"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("erro");
        }
        return p;
    }

    @Override
    public List<Paciente> buscarPorNome(String nome) {
        ArrayList<Paciente> pacientes = new ArrayList<>();
	    String sql = "select * from paciente where nome_paciente like ?";
	    PreparedStatement ps;
	    try(Connection conn = new ConnectionFactory().getConnection()){
	        ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+nome+"%");
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	            Paciente p = new Paciente();
	            p.setId(rs.getLong("id_paciente"));
                    p.setNome(rs.getString("nome_paciente"));
                    p.setRg(rs.getString("rg"));
                    p.setCpf(rs.getString("cpf_paciente"));
                    p.setDtNascimento(rs.getDate("data_nascimento"));
                    p.setTelefone(rs.getString("telefone_paciente"));
                    pacientes.add(p);
	        }
	     }catch (SQLException e) {
	        System.out.println(e.getMessage());
	        System.out.println("Error ao listar categorias do banco!");
	    }
	    return pacientes;
    }
    
   
    
}
