/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author computador
 */
public class Consulta {
    
    private Long id;
    
    private Date dtConsulta;
    
    private String turno;
    
    private Paciente paciente;
    
    private Medico medico;
    
    private Usuario usuario;

    public Consulta() {
    }

    public Consulta(Long id, Date dtConsulta, String turno, Paciente paciente, Medico medico, Usuario usuario) {
        this.id = id;
        this.dtConsulta = dtConsulta;
        this.turno = turno;
        this.paciente = paciente;
        this.medico = medico;
        this.usuario = usuario;
    }

    

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(Date dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Consulta{" + "id=" + id + ", dtConsulta=" + dtConsulta + ", turno=" + turno + ", paciente=" + paciente + ", medico=" + medico + ", usuario=" + usuario + '}';
    }
    
    
    

    
    
    
    
    
    
    
    
    
    
    
}
