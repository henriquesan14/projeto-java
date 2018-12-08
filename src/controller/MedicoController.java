/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MedicoDao;
import dao.MedicoDaoImpl;
import java.util.List;
import model.Medico;

/**
 *
 * @author computador
 */
public class MedicoController {
    
    private MedicoDao dao;

    public MedicoController() {
        this.dao = new MedicoDaoImpl();
    }
    
    public int salvar(String nome,String especialidade,String crm,String cpf,String telefone){
        Medico m=new Medico(nome,especialidade,crm,cpf,telefone);
        return dao.salvar(m);
    }
    
    public int editar(Long id,String nome,String especialidade,String crm,String cpf,String telefone){
        Medico m=new Medico(id,nome,especialidade,crm,cpf,telefone);
        return dao.editar(m);
    }
    
    public List<Medico> listar() {
        return dao.buscar();
    }
    
    public List<Medico> listarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }
    
    public int apagar(Long id) {
        if(dao.qtdConsultas(id) ==0){
            return dao.excluir(id);
        }
        return 0;
    }
    
    public Medico listarPorId(Long id){
        return dao.buscarPorId(id);
    }
    
    
    
}
