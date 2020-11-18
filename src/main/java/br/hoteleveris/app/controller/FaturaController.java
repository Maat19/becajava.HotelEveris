package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hoteleveris.app.service.FaturaService;
import br.hoteleveris.app.service.implement.FaturaServiceImp;

@RestController
@RequestMapping("/faturas")
public class FaturaController extends BaseController {

	@Autowired
	private  FaturaService service;
	

	
	@PostMapping
	public ResponseEntity inserir() {
		try {
			service.inserir();
			return ResponseEntity.status(200).body("Fatura feita com suscesso");
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
	}
	
}
