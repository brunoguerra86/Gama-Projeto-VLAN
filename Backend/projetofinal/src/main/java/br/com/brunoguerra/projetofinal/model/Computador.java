package br.com.brunoguerra.projetofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_computador")
public class Computador {
	
	@Column(name="numserie")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numSerie;
	
	@Column(name="descricao", length=200)
	private String descricao;
	
	@Column(name="conector", length=5)
	private String conectorRede;

	public int getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getConectorRede() {
		return conectorRede;
	}

	public void setConectorRede(String conectorRede) {
		this.conectorRede = conectorRede;
	}
	
	

}
