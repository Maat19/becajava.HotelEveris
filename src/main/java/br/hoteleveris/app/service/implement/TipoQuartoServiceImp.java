package br.hoteleveris.app.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.TipoQuartoRepository;
import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListTipoQuartoResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;
import br.hoteleveris.app.service.TipoQuartoService;

@Service
public class TipoQuartoServiceImp implements TipoQuartoService{
	
	@Autowired
	private TipoQuartoRepository repository;
	
	
	
	public BaseResponse inserir (TipoQuartoRequest request) {
		
		TipoQuarto tipo = new TipoQuarto();
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;
		
	
		if(request.getDescricao() == null || request.getDescricao() == "") {
			response.message = "Descricao não inserida.";
			return response;
		}
		
		if(request.getValor() <= 0 ) {
			response.message = "Valor não inserido.";
			return response;
		}
		
		tipo.setDescricao(request.getDescricao());
		tipo.setValor(request.getValor());
		
		repository.save(tipo);
		response.statusCode = 201;
		response.message = "Tipo do Quarto inserido com sucesso.";
		return response;
	}
	
	public TipoQuartoResponse oter(Long id) {
		
		Optional<TipoQuarto> tipo = repository.findById(id);
		TipoQuartoResponse response = new TipoQuartoResponse();
		
		if(tipo.isEmpty()) {
			response.statusCode = 400;
			response.message = "Tipo do quarto não encontrado";
			return response;
		}
		
		response.setDescricao(tipo.get().getDescricao());
		response.setValor(tipo.get().getValor());
		
		response.statusCode = 200;
		response.message ="Cliente obtido com sucesso.";
		return response;
	}
	
	public ListTipoQuartoResponse listar() {
		
		List<TipoQuarto> lista = repository.findAll();
		
		ListTipoQuartoResponse response =new ListTipoQuartoResponse();
		
		response.setTipos(lista);
		response.statusCode = 200;
		response.message = "Lista obtida com sucesso.";
		return response;
		
		
		
	}
	
	
}
