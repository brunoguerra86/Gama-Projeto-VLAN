package br.com.brunoguerra.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunoguerra.projetofinal.dao.DepartamentoDAO;
import br.com.brunoguerra.projetofinal.model.Departamento;

@RestController
@CrossOrigin("*")
public class DepartamentoController {

	@Autowired 
	private DepartamentoDAO dao;
	
	@GetMapping("/departamentos")
	public ArrayList<Departamento> listarTodos(){
		return (ArrayList<Departamento>)dao.findAll();
	}
	
	@GetMapping("/departamentos/{id}")
	public ResponseEntity<Departamento> buscarPorId(@PathVariable int id){
		Departamento depto = dao.findById(id).orElse(null);
		if( depto != null) {
			return ResponseEntity.ok(depto);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
