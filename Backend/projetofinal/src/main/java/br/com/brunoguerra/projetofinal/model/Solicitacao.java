package br.com.brunoguerra.projetofinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_solicitacao")
public class Solicitacao {
	
	@Column(name="numero")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int numero; 
	
	@Column(name="dataSolicitacao")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date dataSolicitacao;
	
	@Column(name="justificativa", length=200) 
	private String justificativa;
	
	@Column(name="comando", length=200)
	private String comandoRoteador;

	@JsonIgnoreProperties("listaUsuarios")
	@ManyToOne
	private Departamento origem;
	
	@JsonIgnoreProperties("listaUsuarios")
	@ManyToOne
	private Departamento destino;
	
	@JsonIgnoreProperties("solicitacoes")
	@ManyToOne
	private Usuario solicitante;
	 
	public String getComandoRoteador() {
		return comandoRoteador;
	}
	public void setComandoRoteador(String comandoRoteador) {
		this.comandoRoteador = comandoRoteador;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	public Departamento getOrigem() {
		return origem;
	}
	public void setOrigem(Departamento origem) {
		this.origem = origem;
	}
	public Departamento getDestino() {
		return destino;
	}
	public void setDestino(Departamento destino) {
		this.destino = destino;
	}
	public Usuario getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}
	
	

}
