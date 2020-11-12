package br.hoteleveris.app.request;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Quarto;

public class OcupacaoRequest {

	private String data;
	private int diarias;
	private String situacao = "N";
	private Cliente cliente;
	private Quarto quarto;
	
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getDiarias() {
		return diarias;
	}
	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	
	
	
	
}
