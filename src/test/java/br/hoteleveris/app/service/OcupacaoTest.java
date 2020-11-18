package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListOcupacaoResponse;
import br.hoteleveris.app.service.implement.OcupacaoServiceImp;



@SpringBootTest
public class OcupacaoTest {

	@Autowired
	private OcupacaoService service;
	
	
	@Test
	public void criarOcupacao() {
		
	OcupacaoRequest request = new OcupacaoRequest();
	
	request.setDiarias(1);
	request.setData("13/11/2020");
	request.setQuartoId(1L);
	request.setClienteId(1L);
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(201,response.getStatusCode());
	}
	
	@Test
	public void criarOcupacaoDataNull() {
		
	OcupacaoRequest request = new OcupacaoRequest();
	
	request.setDiarias(1);
	request.setData(null);
	request.setQuartoId(1L);
	request.setClienteId(1L);
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void criarOcupacaoDataVazio() {
		
	OcupacaoRequest request = new OcupacaoRequest();
	
	request.setDiarias(1);
	request.setData("");
	request.setQuartoId(1L);
	request.setClienteId(1L);
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void criarOcupacaoDiariasIgual0() {
		
	OcupacaoRequest request = new OcupacaoRequest();
	
	request.setDiarias(0);
	request.setData("13/11/2020");
	request.setQuartoId(1L);
	request.setClienteId(1L);
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void criarOcupacaoDiariasNegativo() {
		
	OcupacaoRequest request = new OcupacaoRequest();
	
	request.setDiarias(-1);
	request.setData("13/11/2020");
	request.setQuartoId(1L);
	request.setClienteId(1L);
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void criarOcupacaoCleinteIdNegativo() {
		
	OcupacaoRequest request = new OcupacaoRequest();
	
	request.setDiarias(1);
	request.setData("13/11/2020");
	request.setQuartoId(1L);
	request.setClienteId(-1L);
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void criarOcupacaoCleinteIdIgual0() {
		
	OcupacaoRequest request = new OcupacaoRequest();
	
	request.setDiarias(1);
	request.setData("13/11/2020");
	request.setQuartoId(1L);
	request.setClienteId(0L);
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	
	
	
	@Test
	public void criarOcupacaoQuartoIdIgual0() {
		
	OcupacaoRequest request = new OcupacaoRequest();
	
	request.setDiarias(1);
	request.setData("13/11/2020");
	request.setQuartoId(0L);
	request.setClienteId(1L);
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void criarOcupacaoQuartoIdNegativo() {
		
	OcupacaoRequest request = new OcupacaoRequest();
	
	request.setDiarias(1);
	request.setData("13/11/2020");
	request.setQuartoId(-1L);
	request.setClienteId(1L);
	BaseResponse response = service.criar(request);
	Assertions.assertEquals(400,response.getStatusCode());
	}
	
	
	@Test
	public void listarCliente() {
		
	ListOcupacaoResponse response = service.listar();
	Assertions.assertEquals(200,response.getStatusCode());
	
	}
	
//	@Test
//	public void listarClienteNaoExiste() {
//		
//	ListOcupacaoResponse response = service.listar();
//	Assertions.assertEquals(200,response.getStatusCode());
//	
//	}
	
	
	
}
