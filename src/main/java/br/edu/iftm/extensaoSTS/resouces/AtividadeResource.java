package br.edu.iftm.extensaoSTS.resouces;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.extensaoSTS.domain.Atividade;
import br.edu.iftm.extensaoSTS.repositories.AtividadeRepository;
import br.edu.iftm.extensaoSTS.services.AtividadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/atividade")
@Api(value="Api Rest Atividade")
@CrossOrigin(origins="*")
public class AtividadeResource {

	@Autowired
	private AtividadeService service;

	@Autowired
	AtividadeRepository atividadeRepository;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ApiOperation(value="Retorna uma única atividade pelo id")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Atividade atividade = service.buscar(id);
		return ResponseEntity.ok().body(atividade);
	}

	@GetMapping("/atividades")
	@ApiOperation(value="Retorna uma Lista")
	public List<Atividade> listaAtividades() {
		return atividadeRepository.findAll();
	}

	@PostMapping("/atividade")
	@ApiOperation(value="Salva uma Atividade")
	public Atividade salvarAtividade(@RequestBody Atividade atividade) {
		return atividadeRepository.save(atividade);
	}

	@DeleteMapping("/atividade")
	@ApiOperation(value="Deleta uma Atividade")
	public void deletarAtividade(@RequestBody Atividade atividade) {
		atividadeRepository.delete(atividade);
	}

	@PutMapping("/atividade")
	@ApiOperation(value="Atualiza uma Atividade")
	public Atividade atualizarAtividade(@RequestBody Atividade atividade) {
		return atividadeRepository.save(atividade);
	}
}
