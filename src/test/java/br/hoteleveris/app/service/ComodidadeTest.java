package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class ComodidadeTest {

	@Autowired
	private ComodidadeService service;

	@Test
	public void criarComodidade() {

		ComodidadeRequest request = new ComodidadeRequest();
		request.setNome("TV LCD");

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(201, response.getStatusCode());
	}
	
	@Test
	public void criarComodidadeNull() {

		ComodidadeRequest request = new ComodidadeRequest();
		request.setNome(null);

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void criarComodidadeVazio() {

		ComodidadeRequest request = new ComodidadeRequest();
		request.setNome("");

		BaseResponse response = service.inserir(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void obterComodidade() {
		
	BaseResponse response = service.obter(1L);
	Assertions.assertEquals(200,response.getStatusCode());
	
	}
	
	@Test
	public void obterComodidadePorId0() {
		
	BaseResponse response = service.obter(0L);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}
	@Test
	public void obterComodidadeSemId() {
		
	BaseResponse response = service.obter(10000000000L);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}
}
