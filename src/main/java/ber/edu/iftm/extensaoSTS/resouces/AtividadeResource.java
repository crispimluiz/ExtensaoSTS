package ber.edu.iftm.extensaoSTS.resouces;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/atividade")
public class AtividadeResource {
	@RequestMapping(method=RequestMethod.GET)
	public String listar() {
		return "Rest ok";
	}
}
