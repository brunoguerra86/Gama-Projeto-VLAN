package br.com.brunoguerra.projetofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunoguerra.projetofinal.dao.DepartamentoDAO;
import br.com.brunoguerra.projetofinal.dao.SolicitacaoDAO;
import br.com.brunoguerra.projetofinal.dao.UsuarioDAO;
import br.com.brunoguerra.projetofinal.model.Departamento;
import br.com.brunoguerra.projetofinal.model.Solicitacao;
import br.com.brunoguerra.projetofinal.model.Usuario;

@RestController
@CrossOrigin("*")
public class SolicitacaoController {

	@Autowired
	private SolicitacaoDAO sdao;
	
	@Autowired
	private DepartamentoDAO ddao;
	
	@Autowired
	private UsuarioDAO udao;
	
	@PostMapping("/solicitacoes/nova")
	public ResponseEntity<Solicitacao> adicionarNova(@RequestBody Solicitacao nova) {
		try {
			// aqui se faz a mágica
			Usuario      user = udao.findById(nova.getSolicitante().getId()).get();
			Departamento novo = ddao.findById(nova.getDestino().getId()).get();
			
			String comando = "switchport vlan " + user.getDepartamento().getVlan() + ";" +
							 "interface range " + user.getComputador().getConectorRede() + "  " +
							 novo.getVlan()+ "; exit";
			
			nova.setComandoRoteador(comando);
			
			user.setDepartamento(novo);
			
			udao.save(user);
			sdao.save(nova);
			return ResponseEntity.ok(nova); 
		}
		catch(Exception e) {
			//e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/solicitacoes/{numero}")
	public ResponseEntity<Solicitacao> getDetalhes(@PathVariable int numero){
		Solicitacao sol = sdao.findById(numero).orElse(null);
		
		if(sol != null) {
			return ResponseEntity.ok(sol);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
