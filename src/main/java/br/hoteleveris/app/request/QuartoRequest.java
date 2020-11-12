package br.hoteleveris.app.request;

import java.util.Set;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.model.TipoQuarto;

public class QuartoRequest {

	private String andar;
	private int nquarto;
	private String situacao;
	private TipoQuarto tipoQuarto;
	
	Set<Comodidade>comodidade;
	
	
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