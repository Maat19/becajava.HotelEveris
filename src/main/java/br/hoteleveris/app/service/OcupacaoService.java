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

		if (request.getData() == null || request.getData() == "") {
			response.message = "Data não foi inserida.";
			return response;
		}

		if (request.getDiarias() <= 0) {
			response.message = "Quantidade de diárias não inseridas";
			return response;
		}

		if (request.getClienteId() <= 0) {
			response.message = "Cliente não inserido";
			return response;
		}

		if (request.getQuartoId() <= 0) {
			response.message = "Quarto não inserido";
			return response;
		}

		Quarto quart = new Quarto();
		quart.setId(request.getQuartoId());
		

		Cliente clie = new Cliente();
		clie.setId(request.getClienteId());
		


		ocupacao.setData(request.getData());
		ocupacao.setDiarias(request.getDiarias());
		ocupacao.setQuarto(quart);
		ocupacao.setCliente(clie);
		

		_repository.save(ocupacao);
		
		response.statusCode = 201;
		response.message = "Ocupação Inserida com sucesso.";
		return response;
	}

	public ListOcupacaoResponse listar() {

		List<Ocupacao> lista = _repository.findAll();

		ListOcupacaoResponse response = new ListOcupacaoResponse();

//		if(lista == null) {
//			response.statusCode = 400;
//			response.message = "Lista vazia";
//			return response;
//		}
		
		response.setOcupacoes(lista);
		response.statusCode = 200;
		response.message = "Lista obtida com sucesso.";
		return response;

	}
}
