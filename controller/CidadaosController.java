package br.com.cadastro.gustavo.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.gustavo.demo.repository.CidadaosRepository;
import br.com.cadastro.gustavo.demo.exception.ResourceNotFoundException;
import br.com.cadastro.gustavo.demo.model.Cidadaos;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CidadaosController {
	@Autowired
	private CidadaosRepository cidadaosRepository;

	@GetMapping("/cidadao")
	public List<Cidadaos> getAllCidadaos() {
		return cidadaosRepository.findAll();
	}

	@GetMapping("/cidadao/{id}")
	public ResponseEntity<Cidadaos> getCidadaosById(@PathVariable(value = "id") Long cidadaosId)
			throws ResourceNotFoundException {
        Cidadaos cidadaos = cidadaosRepository.findById(cidadaosId)
				.orElseThrow(() -> new ResourceNotFoundException("Cidadaos id nao existente!!! " + cidadaosId));
		return ResponseEntity.ok().body(cidadaos);
	}

	@PostMapping("/cidadao")
	public Cidadaos createCidadaos(@Valid @RequestBody Cidadaos cidadaos) {
		return cidadaosRepository.save(cidadaos);
	}

	@PutMapping("/cidadao/{id}")
	public ResponseEntity<Cidadaos> updateCidadaos(@PathVariable(value = "id") Long cidadaosId,
			@Valid @RequestBody Cidadaos cidadaosDetails) throws ResourceNotFoundException {
		Cidadaos cidadaos = cidadaosRepository.findById(cidadaosId)
				.orElseThrow(() -> new ResourceNotFoundException("Cidadaos id nao existente!!! " + cidadaosId));

		cidadaos.setCpf(cidadaosDetails.getCpf());
		cidadaos.setNome(cidadaosDetails.getNome());
		cidadaos.setEndereco(cidadaosDetails.getEndereco());
        cidadaos.setSexo(cidadaosDetails.getSexo());

		final Cidadaos updateCidadaos = cidadaosRepository.save(cidadaos);
		return ResponseEntity.ok(updateCidadaos);
	}

	@DeleteMapping("/cidadao/{id}")
	public Map<String, Boolean> deleteCidadaos(@PathVariable(value = "id") Long cidadaosId)
			throws ResourceNotFoundException {
		Cidadaos cidadaos = cidadaosRepository.findById(cidadaosId)
				.orElseThrow(() -> new ResourceNotFoundException("Cidadaos id nao existente!!! " + cidadaosId));

        cidadaosRepository.delete(cidadaos);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
