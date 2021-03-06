package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hoteleveris.app.request.OcupacaoRequest;


import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListOcupacaoResponse;
import br.hoteleveris.app.service.OcupacaoService;


@RestController
@RequestMapping("/ocupacoes")
public class OcupacaoController extends BaseController {

	@Autowired
	private  OcupacaoService service;
	

	
	
	@PostMapping
	public ResponseEntity<BaseResponse> criar (@RequestBody OcupacaoRequest request){
		try {
			BaseResponse response = service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);			
		}
	}
	
	@GetMapping
    public ResponseEntity<BaseResponse> listar() {
        try {
            ListOcupacaoResponse clientes = service.listar();
            return ResponseEntity.status(clientes.statusCode).body(clientes);
        } catch (Exception e) {
            return ResponseEntity.status(error.statusCode).body(error);
        }
    }
}
