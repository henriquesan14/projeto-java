/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Medico;

/**
 *
 * @author computador
 */
public interface MedicoDao {
    int salvar(Medico m);
    int editar(Medico m);
    int excluir(Long id);
    List<Medico> buscar();
    Medico buscarPorId(Long id);
    List<Medico> buscarPorNome(String nome);
    int qtdConsultas(Long idMedico);
}
