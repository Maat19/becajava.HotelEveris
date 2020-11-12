package br.hoteleveris.app.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.repository.ComodidadeRepository;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ComodidadeResponse;

@Service
public class ComodidadeService {

	final ComodidadeRepository _repository;

	public ComodidadeService(ComodidadeRepository repository) {
		_repository = repository;
	}

	public BaseResponse inserir(ComodidadeRequest request) {

		Comodidade comodidade = new Comodidade();
		BaseResponse response = new BaseResponse();

		if (request.getNome() == null || request.getNome() == "") {
			response.statusCode = 400;
			response.message = "Nome da comodidade não foi inserida.";
			return response;
		}

		comodidade.setNome(request.getNome());

		_repository.save(comodidade);
		response.statusCode = 200;
		response.message = "Comodidade inserida com sucesso.";
		return response;
	}

	public ComodidadeResponse obter(Long id) {

		Optional<Comodidade> comodidade = _repository.findById(id);

		ComodidadeResponse response = new ComodidadeResponse();

		if (comodidade.isEmpty()) {
			response.statusCode = 400;
			response.message = "Comodidade não encontrada.";
			return response;
		}

		response.setNome(comodidade.get().getNome());
		response.statusCode = 200;
		response.message = "Comodidade encontrada";
		return response;
	}

}
