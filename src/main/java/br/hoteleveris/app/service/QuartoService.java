package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.model.QuartoComodidade;
import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.QuartoComodidadeRepository;
import br.hoteleveris.app.repository.QuartoRepository;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoQuartoPatchRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ClienteResponse;
import br.hoteleveris.app.response.ListQuartoResponse;
import br.hoteleveris.app.response.QuartoResponse;

@Service
public class QuartoService {

	final QuartoRepository _repository;
	final QuartoComodidadeRepository _repositoryQC;

	public QuartoService(QuartoRepository repository, QuartoComodidadeRepository repositoryQC) {
		_repository = repository;
		_repositoryQC = repositoryQC;
	}

	public BaseResponse criar(QuartoRequest request) {

		Quarto quarto = new Quarto();
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getAndar() <= 0) {
			response.message = "Andar não inserido.";
			return response;
		}

		if (request.getSituacao() == null || request.getSituacao() == "") {
			response.message = "Situação não inserida.";
			return response;
		}

		if (request.getNquarto() <= 0) {
			response.message = "Número do quarto não inserida.";
			return response;
		}

		quarto.setAndar(request.getAndar());
		quarto.setNquarto(request.getNquarto());
		quarto.setSituacao(request.getSituacao());

		TipoQuarto obj = new TipoQuarto();
		obj.setId(request.getIdTipoQuarto());
		quarto.setTipoQuarto(obj);
		_repository.save(quarto);

		Optional<Quarto> pegarNumeroQuarto = _repository.findBynquarto(request.getNquarto());
		Long quartoId = pegarNumeroQuarto.get().getId();

		for (ComodidadeRequest com : request.getComodidades()) {

			Quarto quart = new Quarto();
			quart.setId(quartoId);

			Comodidade c = new Comodidade();
			c.setId(com.getId());

			QuartoComodidade quartoComodidade = new QuartoComodidade();
			quartoComodidade.setComodidade(c);
			quartoComodidade.setQuarto(quart);
			
			
			_repositoryQC.save(quartoComodidade);
		}

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

		response.statusCode = 200;
		response.message = "Cliente obtido com suceso";
		return response;

	}

	public ListQuartoResponse listar(Long id) {

		ListQuartoResponse response = new ListQuartoResponse();
		List<Quarto> lista = _repository.findEcontrarQuartos(id);

		response.setQuartos(lista);
		response.statusCode = 200;
		response.message = "Quarto obtido com sucesso.";

		return response;
	}

	// Atualização de Situação do quarto por path

	public BaseResponse atualizarSituacao(Long id, SituacaoQuartoPatchRequest request) {

		BaseResponse response = new BaseResponse();

		Optional<Quarto> quarto = _repository.findById(id);

		if (request.getSituacao() == "" || request.getSituacao() == null) {
			response.statusCode = 400;
			response.message = "Situação não preenchida";
			return response;
		}

		if (quarto.isEmpty() || id <= 0) {
			response.statusCode = 400;
			response.message = "Id do quarto não preenchido";
			return response;
		}

		quarto.get().setSituacao(request.getSituacao());

		_repository.save(quarto.get());

		response.statusCode = 200;
		response.message = "Atualização feita com sucesso";

		return response;

	}
}
