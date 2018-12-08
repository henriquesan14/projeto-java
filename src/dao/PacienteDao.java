/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Paciente;

/**
 *
 * @author computador
 */
public interface PacienteDao {
    int salvar(Paciente p);
    int editar(Paciente p);
    int excluir(Long id);
    List<Paciente> buscar();
    Paciente buscarPorId(Long id);
    List<Paciente> buscarPorNome(String nome);
    int qtdConsultas(Long idPaciente);
}
