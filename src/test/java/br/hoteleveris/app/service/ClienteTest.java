package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;


@SpringBootTest
public class ClienteTest {

	
	@Autowired
	private ClienteService service;
	
	
	@Test
	public void criarCliente() {
		
	ClienteRequest request = new ClienteRequest();

	request.setNome("Mateus");
	request.setCpf("1234567890");
	request.setHash("0987654321");
	
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(201,response.getStatusCode());
	
	}
	
	
	@Test
	public void clienteNomeVazio() {
		
	ClienteRequest request = new ClienteRequest();

	request.setNome("");
	request.setCpf("1234567890");
	request.setHash("0987654321");
	
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}
	
	@Test
	public void clienteNomeNull() {
		
	ClienteRequest request = new ClienteRequest();

	request.setNome(null);
	request.setCpf("1234567890");
	request.setHash("0987654321");
	
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}
			
	@Test
	public void clienteCpfVazio() {
		
	ClienteRequest request = new ClienteRequest();

	request.setNome("Mateus");
	request.setCpf("");
	request.setHash("0987654321");
	
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}		
	
	@Test
	public void clienteCpfNull() {
		
	ClienteRequest request = new ClienteRequest();

	request.setNome("Mateus");
	request.setCpf(null);
	request.setHash("0987654321");
	
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}		
			
	@Test
	public void clienteHashVazio() {
		
	ClienteRequest request = new ClienteRequest();

	request.setNome("Mateus");
	request.setCpf("1234567890");
	request.setHash("");
	
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}	
	
	@Test
	public void clienteHashNull() {
		
	ClienteRequest request = new ClienteRequest();

	request.setNome("Mateus");
	request.setCpf("1234567890");
	request.setHash(null);
	
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}	
	
	@Test
	public void obterCliente() {
		
	BaseResponse response = service.obter(1L);
	Assertions.assertEquals(200,response.getStatusCode());
	
	}
	
	@Test
	public void obterClientePorId0() {
		
	BaseResponse response = service.obter(0L);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}
	@Test
	public void obterClienteSemId() {
		
	BaseResponse response = service.obter(10000000000L);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}
			
}
