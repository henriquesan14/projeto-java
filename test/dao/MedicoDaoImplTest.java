/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Medico;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author computador
 */
public class MedicoDaoImplTest {
    
    public MedicoDaoImplTest() {
        
    }
    
    MedicoDao dao= new MedicoDaoImpl();

    @Test
    public void inserir() {
     
        Medico m=new Medico();
        m.setId(1l);
        m.setNome("jose");
        m.setEspecialidade("cardio");
        m.setCrm("1111");
        m.setCpf("111");
        m.setTelefone("22222");
        dao.salvar(m);
    }
    
    @Test
    public void listar() {
        List<Medico> medicos=dao.buscar();
        for(Medico m : medicos){
            System.out.println(m);
        }
    }
    
    @Test
    public void editar() {
        Medico m=new Medico();
        m.setId(2l);
        m.setNome("carlos");
        m.setEspecialidade("nutri");
        m.setCrm("22222222222");
        m.setCpf("222222");
        m.setTelefone("33333");
        dao.editar(m);
    }
    
    @Test
    public void excluir() {
        dao.excluir(5l);
    }
    
    @Test
    public void buscarPorId() {
        Medico m = dao.buscarPorId(3l);
        System.out.println(m);
    }
    
    @Test
    public void buscarPorNome() {
        List<Medico> medicos = dao.buscarPorNome("jo");
        for(Medico m: medicos){
            System.out.println(m);
        }
        
    }
    
    @Test
    public void qtdConsultas(){
        System.out.println(dao.qtdConsultas(8l));
    }
    
}
