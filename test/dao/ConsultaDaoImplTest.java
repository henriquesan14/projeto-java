/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public void listarPorPaciente() {
        List<Consulta> consultas =dao.buscarPorPaciente("jubileu");
        for(Consulta c: consultas){
            System.out.println(c);
        }
    }
    
    @Test
    public void verifica(){
        Date date=new Date();
        System.out.println(dao.verifica(date, "Manhã", 7l));
        //System.out.println(dao.verifica(c));
    }
    
    
}
