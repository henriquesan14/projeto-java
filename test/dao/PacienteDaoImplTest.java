/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Paciente;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author computador
 */
public class PacienteDaoImplTest {
    
    public PacienteDaoImplTest() {
    }
    
    PacienteDao dao=new PacienteDaoImpl();

    @Test
    public void inserir() {
        Date date=new Date();
        Paciente p=new Paciente();
        p.setId(1l);
        p.setNome("jose");
        p.setRg("1111");
        p.setCpf("111");
        p.setDtNascimento(date);
        p.setTelefone("22222");
        dao.salvar(p);
    }
    
    @Test
    public void listar() {
        List<Paciente> pacientes=dao.buscar();
        for(Paciente p : pacientes){
            System.out.println(p);
        }
    }
    
    @Test
    public void editar() {
        Date date=new Date();
        Paciente p=new Paciente();
        p.setId(2l);
        p.setNome("carlos");
        p.setRg("22222222222");
        p.setCpf("222222");
        p.setDtNascimento(date);
        p.setTelefone("33333");
        dao.editar(p);
    }
    
    @Test
    public void excluir() {
        dao.excluir(3l);
    }
    
    @Test
    public void buscarPorId() {
        Paciente p = dao.buscarPorId(5l);
        System.out.println(p);
    }
    
    @Test
    public void buscarPorNom() {
        List<Paciente> pacientes = dao.buscarPorNome("jo");
        for(Paciente p: pacientes){
            System.out.println(p);
        }
        
    }
    
    @Test
    public void qtdConsultas(){
        System.out.println(dao.qtdConsultas(32l));
    }
}
