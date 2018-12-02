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
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.Usuario;

/**
 *
 * @author computador
 */
public class ConsultaDaoImpl implements ConsultaDao {
    
    @Override
    public int salvar(Consulta c) {
        int ok=0;
	String sql = "insert into consulta(data_consulta,turno,id_paciente_fk,id_medico_fk,id_usuario_fk) values (?,?,?,?,?);";
        PreparedStatement ps;
        try(Connection conn=new ConnectionFactory().getConnection()){
            ps = conn.prepareStatement(sql);
            ps.setObject(1,c.getDtConsulta());
            ps.setString(2,c.getTurno());
            ps.setLong(3,c.getPaciente().getId());
            ps.setLong(4, c.getMedico().getId());
            ps.setLong(5,c.getUsuario().getId());
            ok=ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error ao inserir consulta no banco");
            System.out.println(e.getMessage());
        }	
        return ok;
    }

    @Override
    public int editar(Consulta c) {
         int ok=0;
            String sql = "update consulta set data_consulta = ?, turno = ?,id_paciente_fk=?,id_medico_fk=? where id_consulta = ?";
            try(Connection conn = new ConnectionFactory().getConnection()){
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, c.getDtConsulta());
		ps.setString(2, c.getTurno());
                ps.setLong(3,c.getPaciente().getId());
                ps.setLong(4, c.getMedico().getId());
                ps.setLong(5, c.getId());
		ok=ps.executeUpdate();
            }catch(SQLException e) {
		System.out.println("Error ao atualizar uma consulta do banco");
		System.out.println(e.getMessage());
            }
                
            return ok;
    }

    @Override
    public int excluir(Long id) {
        int ok=0;
		String sql = "delete from consulta where id_consulta = ?";
		try(Connection conn = new ConnectionFactory().getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, id);
			ok=ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Error ao deletar um consulta do banco");
			System.out.println(e.getMessage());
		}
                
            return ok;
    }

    @Override
    public List<Consulta> buscar() {
        ArrayList<Consulta> consultas = new ArrayList<>();
	    String sql = "SELECT * FROM consulta inner join medico on consulta.id_medico_fk=medico.id_medico inner join paciente on consulta.id_paciente_fk=paciente.id_paciente inner join usuario on consulta.id_usuario_fk=usuario.id_usuario;";
	    PreparedStatement ps;
	    try(Connection conn = new ConnectionFactory().getConnection()){
	        ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
                    
                    Usuario u=new Usuario();
                    u.setId(rs.getLong("id_usuario"));
                    u.setNome(rs.getString("nome_usuario"));
                    u.setRole(rs.getString("role"));
                    
                    Paciente p=new Paciente();
                    p.setId(rs.getLong("id_paciente"));
                    p.setNome(rs.getString("nome_paciente"));
                    p.setRg(rs.getString("rg"));
                    p.setCpf(rs.getString("cpf_paciente"));
                    p.setDtNascimento(rs.getDate("data_nascimento"));
                    p.setTelefone(rs.getString("telefone_paciente"));
                    
                    Medico m = new Medico();
                    m.setId(rs.getLong("id_medico"));
                    m.setNome(rs.getString("nome_medico"));
                    m.setEspecialidade(rs.getString("especialidade"));
                    m.setCpf(rs.getString("cpf_medico"));
                    m.setCrm(rs.getString("crm"));
                    m.setTelefone(rs.getString("telefone_medico"));
                    
	            Consulta c = new Consulta();
                    c.setId(rs.getLong("id_consulta"));
	            c.setDtConsulta(rs.getDate("data_consulta"));
                    c.setTurno(rs.getString("turno"));
                    c.setPaciente(p);
                    c.setMedico(m);
                    c.setUsuario(u);
                    consultas.add(c);
	        }
	     }catch (SQLException e) {
	        System.out.println(e.getMessage());
	        System.out.println("Error ao listar consultas do banco!");
	    }
	    return consultas;
    }

    @Override
    public Consulta buscarPorId(Long id) {
        Consulta c=new Consulta();
	    String sql = "SELECT * FROM consulta inner join medico on consulta.id_medico_fk=medico.id_medico inner join paciente on consulta.id_paciente_fk=paciente.id_paciente where id_consulta=?";
	    PreparedStatement ps;
	    try(Connection conn = new ConnectionFactory().getConnection()){
	        ps = conn.prepareStatement(sql);
                ps.setLong(1, id);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
                    Paciente p=new Paciente();
                    p.setId(rs.getLong("id_paciente"));
                    p.setNome(rs.getString("nome_paciente"));
                    p.setRg(rs.getString("rg"));
                    p.setCpf(rs.getString("cpf_paciente"));
                    p.setDtNascimento(rs.getDate("data_nascimento"));
                    p.setTelefone(rs.getString("telefone_paciente"));
                    
                    Medico m = new Medico();
                    m.setId(rs.getLong("id_medico"));
                    m.setNome(rs.getString("nome_medico"));
                    m.setEspecialidade(rs.getString("especialidade"));
                    m.setCpf(rs.getString("cpf_medico"));
                    m.setCrm(rs.getString("crm"));
                    m.setTelefone(rs.getString("telefone_medico"));
                    
                    c.setId(rs.getLong("id_consulta"));
	            c.setDtConsulta(rs.getDate("data_consulta"));
                    c.setTurno(rs.getString("turno"));
                    c.setPaciente(p);
                    c.setMedico(m);
	        }
	     }catch (SQLException e) {
	        System.out.println(e.getMessage());
	        System.out.println("Error ao listar consultas do banco!");
	    }
	    return c; //To change body of generated methods, choose Tools | Templates.
    }
    
    public int verifica(){
        String sql="SELECT COUNT(*) FROM pedidos WHERE dataPedido= '2018-10-26 12:47:50';";
        PreparedStatement ps;
	    try(Connection conn = new ConnectionFactory().getConnection()){
	        ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    return rs.getInt("count(*)");
                }
	     }catch (SQLException e) {
	        System.out.println(e.getMessage());
	        System.out.println("Error ao listar pedidos do banco!");
	    }
	    return 0;
    }
    
}
