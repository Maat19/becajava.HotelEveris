package br.hoteleveris.app.service;

import org.springframework.stereotype.Service;

import br.hoteleveris.app.repository.QuartoComodidadeRepository;

@Service
public class QuartoComodidadeService {

	final QuartoComodidadeRepository _repository;
	
	public QuartoComodidadeService ( QuartoComodidadeRepository repository) {
		_repository = repository;
	}
	
	 
	
	
	
}
