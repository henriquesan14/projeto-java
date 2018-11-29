/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author computador
 */
public class Consulta {
    
    private Long id;
    
    private LocalDate dtConsulta;
    
    private String turno;
    
    private Paciente paciente;
    
    private Medico medico;

    public Consulta() {
    }

    public Consulta(Long id, LocalDate dtConsulta, String turno, Paciente paciente, Medico medico) {
        this.id = id;
        this.dtConsulta = dtConsulta;
        this.turno = turno;
        this.paciente = paciente;
        this.medico = medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(LocalDate dtConsulta) {
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
    
    
    
    
    
    
    
}
