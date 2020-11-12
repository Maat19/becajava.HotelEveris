package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Ocupacao;

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
		
		if(request.getQuarto().getId() == null ||request.getQuarto().getId() <=0) {
			response.message = "Id do quarto não preenchido.";
			return response;
		}
		
		if(request.getCliente().getId() == null || request.getCliente().getId() <=0) {
			response.message = "Id do cliente não preenchido.";
			return response;
		}
		
		if(request.getSituacao() == null || request.getSituacao() == "" || request.getSituacao() != "N") {
			response.message = "Situação não preenchido.";
			return response;
		}
		
		ocupacao.setData(request.getData());
		ocupacao.setDiarias(request.getDiarias());
		ocupacao.setSituacao(request.getSituacao());
		ocupacao.setQuarto(request.getQuarto());
		ocupacao.setCliente(request.getCliente());
		
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
