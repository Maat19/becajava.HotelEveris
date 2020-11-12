package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.QuartoRepository;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ClienteResponse;
import br.hoteleveris.app.response.QuartoResponse;



@Service
public class QuartoService {
	
	final QuartoRepository _repository;
	
	
public QuartoService( QuartoRepository repository) {
	_repository = repository;
}
	
	public BaseResponse criar (QuartoRequest request) {
		
		Quarto quarto = new Quarto();
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;
		
		
		if(request.getAndar() == null || request.getAndar() == "") {
			response.message = "Andar não inserido.";
			return response;
		}
		
		if(request.getSituacao() == null || request.getSituacao() == "") {
			response.message = "Situação não inserida.";
			return response;
		}
		
		if(request.getNquarto() <= 0) {
			response.message = "Número do quarto não inserida.";
			return response;
		}
		
		if(request.getTipoQuarto().getId() <= 0 || request.getTipoQuarto().getId() == null) {
			response.message = "Tipo do quarto não inserida.";
			return response;
		}
		
		if(request.getComodidade().isEmpty()) {
			response.message = "Tipo de comodidade não inserida.";
			return response;
		}
		
		
		
		quarto.setAndar(request.getAndar());
		quarto.setNquarto(request.getNquarto());
		quarto.setSituacao(request.getSituacao());
		quarto.setTipoQuarto(request.getTipoQuarto());
		quarto.setComodidade(request.getComodidade());
		
		_repository.save(quarto);
		response.statusCode = 200;
		response.message = "Quarto inserido com sucesso";
		return response;
	}


	
	public QuartoResponse obter(Long id) {

		Optional<Quarto> quarto = _repository.findById(id);

		QuartoResponse response = new QuartoResponse();

		if (quarto.isEmpty()) {
			response.statusCode = 400;
			response.message = "Cliente não encontrado.";
			return response;
		}

		
		
		response.setAndar(quarto.get().getAndar());
		response.setNquarto(quarto.get().getNquarto());
		response.setSituacao(quarto.get().getSituacao());
		response.setTipoQuarto(quarto.get().getTipoQuarto());
		response.setComodidade(quarto.get().getComodidade());
		

		response.statusCode = 200;
		response.message = "Cliente obtido com suceso";
		return response;

	}
		
	}


