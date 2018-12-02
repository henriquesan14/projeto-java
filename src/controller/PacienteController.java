/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PacienteDao;
import dao.PacienteDaoImpl;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Paciente;

/**
 *
 * @author computador
 */
public class PacienteController {
    
    private PacienteDao dao;
    
    public PacienteController() {
        this.dao=new PacienteDaoImpl();
    }
    
    private Date formatarData(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new Date( formatter.parse(data).getTime() );
    }
    
    public int salvar(String nome,String rg,String cpf,String dtNascimento,String telefone) throws ParseException{
        Paciente u=new Paciente(nome,rg,cpf,telefone);
        u.setDtNascimento(formatarData(dtNascimento));
        return dao.salvar(u);
    }
    
    public int editar(Long id,String nome,String rg,String cpf,String dtNascimento,String telefone) throws ParseException{
        Paciente u=new Paciente(id,nome,rg,cpf,telefone);
        u.setDtNascimento(formatarData(dtNascimento));
        return dao.editar(u);
    }
    
    public int apagar(Long id){
        return dao.excluir(id);
    }
    
    public List<Paciente> listar() {
        return dao.buscar();
    }
    
    public List<Paciente> listarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }
    
    public Paciente listarPorId(Long id){
        return dao.buscarPorId(id);
    }
    
    
    
}
