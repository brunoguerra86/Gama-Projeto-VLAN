package br.com.brunoguerra.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.brunoguerra.projetofinal.model.Departamento;

public interface DepartamentoDAO extends CrudRepository<Departamento, Integer> {

}
