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
import model.Medico;

/**
 *
 * @author computador
 */
public class MedicoDaoImpl implements MedicoDao{
    
    @Override
    public int salvar(Medico m) {
        int ok=0;
	String sql = "insert into medico(nome_medico,especialidade,crm,cpf_medico,telefone_medico) values (?,?,?,?,?);";
        PreparedStatement ps;
        try(Connection conn=new ConnectionFactory().getConnection()){
            ps = conn.prepareStatement(sql);
            ps.setString(1,m.getNome());
            ps.setString(2,m.getEspecialidade());
            ps.setString(3,m.getCrm());
            ps.setString(4,m.getCpf());
            ps.setString(5,m.getTelefone());
            ok=ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error ao inserir medico no banco");
            System.out.println(e.getMessage());
        }	
        return ok;
    }

    @Override
    public int editar(Medico m) {
        int ok=0;
            String sql = "update medico set nome_medico = ?, especialidade = ?,crm=?,cpf_medico=?,telefone_medico=? where id_medico = ?";
            try(Connection conn = new ConnectionFactory().getConnection()){
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, m.getNome());
		ps.setString(2, m.getEspecialidade());
                ps.setString(3,m.getCrm());
                ps.setObject(4, m.getCpf());
                ps.setString(5,m.getTelefone());
		ps.setLong(6, m.getId());
		ok=ps.executeUpdate();
            }catch(SQLException e) {
		System.out.println("Error ao atualizar um medico do banco");
		System.out.println(e.getMessage());
            }
                
            return ok;
    }

    @Override
    public int excluir(Long id) {
        int ok=0;
		String sql = "delete from medico where id_medico = ?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			ok=ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Error ao deletar um medico do banco");
			System.out.println(e.getMessage());
		}
                
            return ok;
    }

    @Override
    public List<Medico> buscar() {
        ArrayList<Medico> medicos = new ArrayList<>();
	    String sql = "select * from medico";
	    PreparedStatement ps;
	    try(Connection conn = new ConnectionFactory().getConnection()){
	        ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	            Medico m = new Medico();
	            m.setId(rs.getLong("id_medico"));
                    m.setNome(rs.getString("nome_medico"));
                    m.setEspecialidade(rs.getString("especialidade"));
                    m.setCrm(rs.getString("crm"));
                    m.setCpf(rs.getString("cpf_medico"));
                    m.setTelefone(rs.getString("telefone_medico"));
                    medicos.add(m);
	        }
	     }catch (SQLException e) {
	        System.out.println(e.getMessage());
	        System.out.println("Error ao listar medicos do banco!");
	    }
	    return medicos;
    }

    @Override
    public Medico buscarPorId(Long id) {
        Medico m = new Medico();
        String sql = "select * from medico where id_medico=?";
        PreparedStatement ps;
        try(Connection conn = new ConnectionFactory().getConnection()){
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                m.setId(rs.getLong("id_medico"));
                m.setNome(rs.getString("nome_medico"));
                m.setEspecialidade(rs.getString("especialidade"));
                m.setCrm(rs.getString("crm"));
                m.setCpf(rs.getString("cpf_medico"));
                m.setTelefone(rs.getString("telefone_medico"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("erro");
        }
        return m;
    }

    @Override
    public List<Medico> buscarPorNome(String nome) {
        ArrayList<Medico> medicos = new ArrayList<>();
	    String sql = "select * from medico where nome_medico like ?";
	    PreparedStatement ps;
	    try(Connection conn = new ConnectionFactory().getConnection()){
	        ps = conn.prepareStatement(sql);
                ps.setString(1,"%"+nome+"%");
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	            Medico m = new Medico();
	            m.setId(rs.getLong("id_medico"));
                    m.setNome(rs.getString("nome_medico"));
                    m.setEspecialidade(rs.getString("especialidade"));
                    m.setCrm(rs.getString("crm"));
                    m.setCpf(rs.getString("cpf_medico"));
                    m.setTelefone(rs.getString("telefone_medico"));
                    medicos.add(m);
	        }
	     }catch (SQLException e) {
	        System.out.println(e.getMessage());
	        System.out.println("Error ao listar medicos do banco!");
	    }
	    return medicos;
    }
    
}
