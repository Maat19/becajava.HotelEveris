package br.hoteleveris.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoQuartoPatchRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListQuartoResponse;

@SpringBootTest
public class QuartoTest {

	@Autowired
	private QuartoService service;

	
	public int pegarNumeroAleatorio(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
          .findFirst()
          .getAsInt();
    }
	
	
	@Test
	public void criarQuarto() {

		QuartoRequest request = new QuartoRequest();
		
		request.setAndar(1);
		request.setIdTipoQuarto(1L);
		int nQuarto = this.pegarNumeroAleatorio(1,1000);
		request.setNquarto(nQuarto);
		request.setSituacao("A");
		
		List<ComodidadeRequest> com = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(1L);
		com.add(comodidade);
		request.setComodidades(com);

		BaseResponse response = service.criar(request);
		Assertions.assertEquals(201, response.getStatusCode());
	}

	@Test
	public void criarQuartoAndar0() {

		QuartoRequest request = new QuartoRequest();
		
		request.setAndar(0);
		request.setIdTipoQuarto(1L);
		int nQuarto = this.pegarNumeroAleatorio(1,1000);
		request.setNquarto(nQuarto);
		request.setSituacao("A");
		
		List<ComodidadeRequest> com = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(1L);
		com.add(comodidade);
		request.setComodidades(com);

		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void criarQuartoAndarNegativo() {

		QuartoRequest request = new QuartoRequest();
		
		request.setAndar(-1);
		request.setIdTipoQuarto(1L);
		int nQuarto = this.pegarNumeroAleatorio(1,1000);
		request.setNquarto(nQuarto);
		request.setSituacao("A");
		
		List<ComodidadeRequest> com = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(1L);
		com.add(comodidade);
		request.setComodidades(com);

		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void criarQuartoSituacaoNull() {

		QuartoRequest request = new QuartoRequest();
		
		request.setAndar(1);
		request.setIdTipoQuarto(1L);
		int nQuarto = this.pegarNumeroAleatorio(1,1000);
		request.setNquarto(nQuarto);
		request.setSituacao(null);
		
		List<ComodidadeRequest> teste = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(1L);
		teste.add(comodidade);
		request.setComodidades(teste);

		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void criarQuartoSituacaoVazio() {

		QuartoRequest request = new QuartoRequest();
		
		request.setAndar(1);
		request.setIdTipoQuarto(1L);
		int nQuarto = this.pegarNumeroAleatorio(1,1000);
		request.setNquarto(nQuarto);
		request.setSituacao("");
		
		List<ComodidadeRequest> com = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(1L);
		com.add(comodidade);
		request.setComodidades(com);

		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void criarQuartoNQuarto0() {

		QuartoRequest request = new QuartoRequest();
		
		request.setAndar(1);
		request.setIdTipoQuarto(1L);
		request.setNquarto(0);
		request.setSituacao("A");
		
		List<ComodidadeRequest> com = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(1L);
		com.add(comodidade);
		request.setComodidades(com);

		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void criarQuartoNQuartoNegativo() {

		QuartoRequest request = new QuartoRequest();
		
		request.setAndar(1);
		request.setIdTipoQuarto(1L);
		request.setNquarto(-1);
		request.setSituacao("A");
		
		List<ComodidadeRequest> com = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(1L);
		com.add(comodidade);
		request.setComodidades(com);

		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void criarQuartoIdTipoQuarto0() {

		QuartoRequest request = new QuartoRequest();
		
		request.setAndar(1);
		request.setIdTipoQuarto(0L);
		int nQuarto = this.pegarNumeroAleatorio(1,1000);
		request.setNquarto(nQuarto);
		request.setSituacao("A");
		
		List<ComodidadeRequest> com = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(1L);
		com.add(comodidade);
		request.setComodidades(com);

		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void criarQuartoIdTipoQuartoNegativo() {

		QuartoRequest request = new QuartoRequest();
		
		request.setAndar(1);
		request.setIdTipoQuarto(-1L);
		int nQuarto = this.pegarNumeroAleatorio(1,1000);
		request.setNquarto(nQuarto);
		request.setSituacao("A");
		
		List<ComodidadeRequest> com = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(-1L);
		com.add(comodidade);
		request.setComodidades(com);

		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}

	
	@Test
	public void criarQuartoIdTipoQuartoCom0() {

		QuartoRequest request = new QuartoRequest();
		
		request.setAndar(1);
		request.setIdTipoQuarto(-1L);
		int nQuarto = this.pegarNumeroAleatorio(1,1000);
		request.setNquarto(nQuarto);
		request.setSituacao("A");
		
		List<ComodidadeRequest> com = new ArrayList<ComodidadeRequest>();
		ComodidadeRequest comodidade = new ComodidadeRequest();
		comodidade.setId(0L);
		com.add(comodidade);
		request.setComodidades(com);

		BaseResponse response = service.criar(request);
		Assertions.assertEquals(400, response.getStatusCode());
	}
	
	@Test
	public void obterQuarto() {
		
	BaseResponse response = service.obter(1L);
	Assertions.assertEquals(200,response.getStatusCode());
	
	}
	
	@Test
	public void obterQuartoPorId0() {
		
	BaseResponse response = service.obter(0L);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}
	@Test
	public void obterQuartoSemId() {
		
	BaseResponse response = service.obter(10000000000L);
	Assertions.assertEquals(400,response.getStatusCode());
	
	}
	
	@Test
	public void listarQuarto() {
		
		ListQuartoResponse response = service.listar(1L);
		Assertions.assertEquals(200,response.getStatusCode());
	}
	
	
	@Test
	public void atualizarSituacao() {
		
		SituacaoQuartoPatchRequest request = new SituacaoQuartoPatchRequest();
		request.setSituacao("A");
		Long id= 1L;
		
		BaseResponse response = service.atualizarSituacao(id, request);
		Assertions.assertEquals(200,response.getStatusCode());
	}
	
	@Test
	public void atualizarSituacaoNull() {
		
		SituacaoQuartoPatchRequest request = new SituacaoQuartoPatchRequest();
		request.setSituacao(null);
		Long id= 1L;
		
		BaseResponse response = service.atualizarSituacao(id, request);
		Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void atualizarSituacaoVazio() {
		
		SituacaoQuartoPatchRequest request = new SituacaoQuartoPatchRequest();
		request.setSituacao("");
		Long id= 1L;
		
		BaseResponse response = service.atualizarSituacao(id, request);
		Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void atualizarSituacaoId0() {
		
		SituacaoQuartoPatchRequest request = new SituacaoQuartoPatchRequest();
		request.setSituacao("A");
		Long id= 0L;
		
		BaseResponse response = service.atualizarSituacao(id, request);
		Assertions.assertEquals(400,response.getStatusCode());
	}
	
	@Test
	public void atualizarSituacaoIdNegativo() {
		
		SituacaoQuartoPatchRequest request = new SituacaoQuartoPatchRequest();
		request.setSituacao("A");
		Long id= -1L;
		
		BaseResponse response = service.atualizarSituacao(id, request);
		Assertions.assertEquals(400,response.getStatusCode());
	}
	
	
	
}
