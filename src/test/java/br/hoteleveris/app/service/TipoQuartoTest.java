package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListTipoQuartoResponse;

@SpringBootTest
public class TipoQuartoTest {

	@Autowired
	private TipoQuartoService service;

	@Test
	public void inserirTipoQuarto() {

		TipoQuartoRequest request = new TipoQuartoRequest();

		request.setDescricao("Particular");
		request.setValor(100.00);

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(201, response.getStatusCode());

	}
	
	
	@Test
	public void inserirTipoQuartoDescricaoNull() {
		
		TipoQuartoRequest request = new TipoQuartoRequest();
		
		request.setDescricao(null);
		request.setValor(1.00);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());

	}
	
	@Test
	public void inserirTipoQuartoDescricaoVazio() {
		
		TipoQuartoRequest request = new TipoQuartoRequest();
		
		request.setDescricao("");
		request.setValor(1.00);
		
		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());

	}
	
	
	@Test
	public void inserirTipoQuartoValor0() {

		TipoQuartoRequest request = new TipoQuartoRequest();

		request.setDescricao("Particular");
		request.setValor(0.00);

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());

	}
	
	@Test
	public void inserirTipoQuartoValorNegativo() {

		TipoQuartoRequest request = new TipoQuartoRequest();

		request.setDescricao("Particular");
		request.setValor(-1.00);

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());

	}

	@Test
	public void listarCliente() {
		
	ListTipoQuartoResponse response = service.listar();
	Assertions.assertEquals(200,response.getStatusCode());
	
	}
	
	
	@Test
	public void obterTipoQuarto() {
		
	BaseResponse response = service.oter(1L);
	Assertions.assertEquals(200,response.getStatusCode());
	
	}
	
	@Test
	public void obterClientePorId0() {
		
	BaseResponse response = service.oter(0L);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}
	@Test
	public void obterClienteSemId() {
		
	BaseResponse response = service.oter(10000000000L);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}
	
	
	
	
	
}
