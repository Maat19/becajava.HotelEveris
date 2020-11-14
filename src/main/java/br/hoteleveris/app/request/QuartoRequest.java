package br.hoteleveris.app.request;

import java.util.List;
import java.util.Set;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.model.TipoQuarto;

public class QuartoRequest {

	private Long Id;
	private int andar;
	private int nquarto;
	private String situacao;
	private Long idTipoQuarto;
	
	private List<ComodidadeRequest> comodidades;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
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

	public Long getIdTipoQuarto() {
		return idTipoQuarto;
	}

	public void setIdTipoQuarto(Long idTipoQuarto) {
		this.idTipoQuarto = idTipoQuarto;
	}

	public List<ComodidadeRequest> getComodidades() {
		return comodidades;
	}

	public void setComodidades(List<ComodidadeRequest> comodidades) {
		this.comodidades = comodidades;
	}
	

}