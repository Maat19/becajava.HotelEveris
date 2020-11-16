package br.hoteleveris.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hoteleveris.app.service.FaturaService;

@RestController
@RequestMapping("/faturas")
public class FaturaController extends BaseController {

	private final FaturaService _service;
	
	public FaturaController(FaturaService service) {
		_service =service;
	}

	
	@PostMapping
	public ResponseEntity inserir() {
		try {
			_service.inserir();
			return ResponseEntity.status(200).body("Fatura feita com suscesso");
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
	}
	
}
