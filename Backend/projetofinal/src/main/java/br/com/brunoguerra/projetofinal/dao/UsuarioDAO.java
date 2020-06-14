package br.com.brunoguerra.projetofinal.dao;

import br.com.brunoguerra.projetofinal.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
	public Usuario findByEmailAndSenha(String email, String senha);
	public Usuario findByRacfAndSenha(String racf, String senha);
	public Usuario findByEmail(String email);
	public Usuario findByRacf(String racf);
}
