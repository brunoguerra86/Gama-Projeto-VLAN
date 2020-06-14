package br.com.brunoguerra.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.brunoguerra.projetofinal.model.Solicitacao;

public interface SolicitacaoDAO extends CrudRepository<Solicitacao, Integer> {

}
