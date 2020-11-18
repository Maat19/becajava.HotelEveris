package br.hoteleveris.app.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.request.TransferenciaRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.service.FaturaService;

@Service
public class FaturaServiceImp implements FaturaService{

	@Autowired
	private OcupacaoRepository repository;

	private String hashContaHotel = "gmHMNkCI8P";

	
	public BaseResponse inserir() {
		
		BaseResponse response = new BaseResponse();
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8081/operacoes/transferencia";

		List<Ocupacao> lista = repository.findBysituacao("N");

			
		for (Ocupacao ocupacao : lista) {

			double valor = ocupacao.getQuarto().getTipoQuarto().getValor() * ocupacao.getDiarias();

			TransferenciaRequest request = new TransferenciaRequest();

			request.setHashDestino(hashContaHotel);
			request.setHashOrigem(ocupacao.getCliente().getHash());
			request.setValor(valor);

			restTemplate.postForObject(uri, request, BaseResponse.class);

			ocupacao.setSituacao("P");
			repository.save(ocupacao);
		}
		
		
		response.statusCode =201;
		
		response.message = "Fatura realizada";
		return response;
	}

}
