package br.hoteleveris.app.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoQuartoPatchRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListQuartoResponse;
import br.hoteleveris.app.service.QuartoService;

@RestController
@RequestMapping("/quartos")
public class QuartoController extends BaseController {

	private final QuartoService _service;

	public QuartoController(QuartoService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody QuartoRequest request) {
		try {
			BaseResponse response = _service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);

		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);

		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		try {
			BaseResponse response = _service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
	}

	@GetMapping(path = "/tipo/{id}")
	public ResponseEntity<BaseResponse> listar(@PathVariable Long id) {
		try {
			ListQuartoResponse quartos = _service.listar(id);
			return ResponseEntity.status(quartos.statusCode).body(quartos);
		} catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<BaseResponse> atualizarSituacao(@Validated @PathVariable("id") Long id, @RequestBody SituacaoQuartoPatchRequest request ){
		
		try {
			BaseResponse quarto = _service.atualizarSituacao(id, request);
			return ResponseEntity.status(quarto.statusCode).body(quarto);
		}catch (Exception e) {
			return ResponseEntity.status(error.statusCode).body(error);
		}
				
	}

}
