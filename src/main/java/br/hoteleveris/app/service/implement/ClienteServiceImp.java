package br.hoteleveris.app.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ClienteResponse;
import br.hoteleveris.app.service.ClienteService;


@Service
public class ClienteServiceImp implements ClienteService{

	@Autowired
	private ClienteRepository repository;

	

	public BaseResponse criar(ClienteRequest request) {

		Cliente cliente = new Cliente();
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getNome() == null || request.getNome() == "") {
			response.message = "Nome não foi inserido.";
			return response;
		}

		if (request.getCpf() == null || request.getCpf() == "") {
			response.message = "CPF não foi inserido.";
			return response;
		}

		if (request.getHash() == null || request.getHash() == "") {
			response.message = "Hash não foi inserido.";
			return response;
		}

		cliente.setNome(request.getNome());
		cliente.setCpf(request.getCpf());
		cliente.setHash(request.getHash());

		repository.save(cliente);
		response.statusCode = 201;
		response.message = "Cliente inserido com sucesso.";
		return response;
	}

	public ClienteResponse obter(Long id) {

		Optional<Cliente> cliente = repository.findById(id);

		ClienteResponse response = new ClienteResponse();

		if (cliente.isEmpty()) {
			response.statusCode = 400;
			response.message = "Cliente não encontrado.";
			return response;
		}

		response.setNome(cliente.get().getNome());
		response.setCpf(cliente.get().getCpf());

		response.statusCode = 200;
		response.message = "Cliente obtido com suceso";
		return response;

	}

	
	
	

}
