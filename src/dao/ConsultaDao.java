/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import model.Consulta;

/**
 *
 * @author computador
 */
public interface ConsultaDao {
    int salvar(Consulta c);
    int editar(Consulta c);
    int excluir(Long id);
    List<Consulta> buscar();
    List<Consulta> buscarPorPaciente(String nome);
    int verifica(Date data,String turno,Long id);
    List<Consulta> consultasHoje();
}
