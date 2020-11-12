package br.hoteleveris.app.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Quarto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String andar;
	private int nquarto;
	private String situacao;
	
	@ManyToOne
	@JoinColumn(name ="tipoQuartoId")
	private TipoQuarto tipoQuarto;
	
	@ManyToMany(mappedBy = "quarto")
	Set<Comodidade>comodidade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAndar() {
		return andar;
	}
	public void setAndar(String andar) {
		this.andar = andar;
	}
	public int getNquarto() {
		return nquarto;
	}
	public void setNquarto(int nquarto) {
		this.nquarto = nquarto;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}
	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
	public Set<Comodidade> getComodidade() {
		return comodidade;
	}
	public void setComodidade(Set<Comodidade> comodidade) {
		this.comodidade = comodidade;
	}

	
	
}
