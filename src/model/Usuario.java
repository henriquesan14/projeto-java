/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author computador
 */
public class Usuario {
    
    private Long id;
    
    private String nome;
    
    private String login;
    
    private String senha;
    
    private int ativo=1;
    
    private String role;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String login, String senha, int ativo, String role) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
        this.role = role;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
}
