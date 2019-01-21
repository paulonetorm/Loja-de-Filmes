package filmesSpring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import filmesSpring.daos.ClienteDAO;
import filmesSpring.models.Clientes;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@RequestMapping("/form")
	public String form() {
		System.out.println("Chamou o form de clientes");
		return "clientes/form";
	}

	@PostMapping
	public String adicionar(Clientes cliente) {
		System.out.println(cliente);
		ClienteDAO cDAO = new ClienteDAO();
		cDAO.inserir(cliente);

		return "redirect:clientes";
	}
	
	@GetMapping
	public ModelAndView listar() {
		ClienteDAO cDAO = new ClienteDAO();
		List<Clientes> lista = cDAO.getLista();
		ModelAndView model = new ModelAndView("clientes/lista");
		model.addObject("clientes", lista);
		return model;
	}

	@RequestMapping("/remover")
	public String remover(Clientes cliente) {
		System.out.println("Chamou método de remover");
		ClienteDAO cDAO = new ClienteDAO();
		cDAO.remover(cliente);

		return "redirect:../clientes";
	}
	
}