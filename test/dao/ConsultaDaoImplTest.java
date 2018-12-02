/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author computador
 */
public class ConsultaDaoImplTest {
    
    public ConsultaDaoImplTest() {
    }
    
    ConsultaDao dao = new ConsultaDaoImpl();

    @Test
    public void inserir() {
        Medico medico = new Medico();
        medico.setId(7l);
        Paciente paciente=new Paciente();
        paciente.setId(32l);
        Usuario u=new Usuario();
        u.setId(1l);
        Consulta c=new Consulta();
        c.setDtConsulta(new Date());
        c.setTurno("manha");
        c.setMedico(medico);
        c.setPaciente(paciente);
        c.setUsuario(u);
        dao.salvar(c);
    }
    
    @Test
    public void listar() {
        List<Consulta> consultas=dao.buscar();
        for(Consulta c : consultas){
            System.out.println(c);
        }
    }
    
    @Test
    public void listarPorId() {
        Consulta consulta=dao.buscarPorId(10l);
        System.out.println(consulta);
    }
    
    @Test
    public void verifica(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String data=sdf.format(date);
        System.out.println(dao.verifica(data, "Manhã", 7l));
        //System.out.println(dao.verifica(c));
    }
    
    
}
