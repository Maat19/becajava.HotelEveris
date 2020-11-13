package br.hoteleveris.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListOcupacaoResponse;



@Service
public class OcupacaoService {

	final OcupacaoRepository _repository;
	
	public OcupacaoService(OcupacaoRepository repository) {
	
		_repository = repository;
	}

	public BaseResponse criar(OcupacaoRequest request) {
		
		Ocupacao ocupacao = new Ocupacao();
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;
		
		if(request.getData() == null || request.getData() == "") {
			response.message = "Data não foi inserida.";
			return response;
		}
		
		if(request.getDiarias() <= 0 ) {
			response.message = "Quantidade de diárias não inseridas";
			return response;
		}
		
		if(request.getClienteId() <= 0) {
			response.message = "Cliente não inserido";
			return response;
		}
		
		if(request.getQuartoId() <= 0) {
			response.message = "Quarto não inserido";
			return response;
		}
		
		ocupacao.setData(request.getData());
		ocupacao.setDiarias(request.getDiarias());
	
		Quarto obj = new Quarto();
		obj.setId(request.getQuartoId());
		ocupacao.setQuarto(obj);
		
		
		Cliente obj1 = new Cliente();
		obj1.setId(request.getClienteId());
		ocupacao.setCliente(obj1);
		
		
		_repository.save(ocupacao);
		response.statusCode = 200;
		response.message = "Ocupação Inserida com sucesso.";
		return response;
	}
	
	
	
		public ListOcupacaoResponse listar() {
		
		List<Ocupacao> lista = _repository.findAll();
		
		ListOcupacaoResponse response =new ListOcupacaoResponse();
		
		response.setOcupacoes(lista);
		response.statusCode = 200;
		response.message = "Lista obtida com sucesso.";
		return response;
	
}
}
