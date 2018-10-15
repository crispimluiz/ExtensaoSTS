package br.edu.iftm.extensaoSTS.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.extensaoSTS.domain.Atividade;
import br.edu.iftm.extensaoSTS.repositories.AtividadeRepository;
import br.edu.iftm.extensaoSTS.services.AtividadeService;

@RestController
@RequestMapping(value = "/atividade")
public class AtividadeResource {

	@Autowired
	private AtividadeService service;

	@Autowired
	AtividadeRepository atividadeRepository;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Atividade atividade = service.buscar(id);
		return ResponseEntity.ok().body(atividade);
	}

	@GetMapping("/atividades")
	public List<Atividade> listaAtividades() {
		return atividadeRepository.findAll();
	}

	@PostMapping("/atividade")
	public Atividade salvarAtividade(@RequestBody Atividade atividade) {
		return atividadeRepository.save(atividade);
	}

	@DeleteMapping("/atividade")
	public void deletarAtividade(@RequestBody Atividade atividade) {
		atividadeRepository.delete(atividade);
	}

	@PutMapping("/atividade")
	public Atividade atualizarAtividade(@RequestBody Atividade atividade) {
		return atividadeRepository.save(atividade);
	}
}
