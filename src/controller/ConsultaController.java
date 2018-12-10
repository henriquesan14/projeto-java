/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ConsultaDao;
import dao.ConsultaDaoImpl;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.Usuario;

/**
 *
 * @author computador
 */
public class ConsultaController {
    
    private ConsultaDao dao;

    public ConsultaController() {
        this.dao = new ConsultaDaoImpl();
    }
    
    private Date formatarData(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new Date( formatter.parse(data).getTime() );
    }
    
    public int salvar(String dtConsulta,String turno,Paciente paciente,Medico medico,Usuario usuario) throws ParseException{
        
        int ok=dao.verifica(formatarData(dtConsulta), turno, medico.getId());
        if(ok <=10){
            Consulta c=new Consulta(turno,paciente,medico,usuario);
            c.setDtConsulta(formatarData(dtConsulta));
            return dao.salvar(c);
        }
        return 0;
    }
    
    public int editar(Long id,String dtConsulta,String turno,Paciente paciente,Medico medico,Usuario usuario) throws ParseException{
        Consulta c=new Consulta(id,turno,paciente,medico,usuario);
        c.setDtConsulta(formatarData(dtConsulta));
        return dao.editar(c);
    }
    
    public int apagar(Long id){
        return dao.excluir(id);
    }
    
    public List<Consulta> listar() {
        return dao.buscar();
    }
    
    public List<Consulta> listarPorPaciente(String nome) {
        return dao.buscarPorPaciente(nome);
    }
    
    public List<Consulta> consultasHoje(){
        return dao.consultasHoje();
    }
    
    
}
