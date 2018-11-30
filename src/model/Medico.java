/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author computador
 */
public class Medico {
    
    private Long id;
    
    private String nome;
    
    private String especialidade;
    
    private String crm;
    
    private String cpf;
    
    private String telefone;
    
    private List<Consulta> consultas;

    public Medico() {
    }

    public Medico(Long id, String nome, String especialidade, String crm, String cpf, String telefone, List<Consulta> consultas) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
        this.cpf = cpf;
        this.telefone = telefone;
        this.consultas = consultas;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico{" + "id=" + id + ", nome=" + nome + ", especialidade=" + especialidade + ", crm=" + crm + ", cpf=" + cpf + ", telefone=" + telefone + ", consultas=" + consultas + '}';
    }
    
    
    
    
    
    
    
}
