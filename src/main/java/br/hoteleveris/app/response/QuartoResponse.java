package br.hoteleveris.app.response;

import java.util.Set;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.model.TipoQuarto;

public class QuartoResponse extends BaseResponse{

	public Long id;
	public String andar;
	public int nquarto;
	public String situacao;
	public TipoQuarto tipoQuarto;
	
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
