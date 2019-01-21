package filmesSpring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import filmesSpring.daos.FilmeDAO;

import filmesSpring.models.Filmes;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

	@RequestMapping("/form")
	public String form() {
		System.out.println("Chamou o form de filmes");
		return "filmes/form";
	}

	@PostMapping
	public String adicionar(Filmes filme) {
		System.out.println(filme);
		FilmeDAO fDAO = new FilmeDAO();
		fDAO.inserir(filme);

		return "redirect:filmes";
	}

	@GetMapping
	public ModelAndView listar() {
		FilmeDAO fDAO = new FilmeDAO();
		List<Filmes> lista = fDAO.getLista();
		ModelAndView model = new ModelAndView("filmes/lista");
		model.addObject("filmes", lista);
		return model;
	}
	@GetMapping("/listaRA")
	public ModelAndView listaRA() {
		FilmeDAO fDAO = new FilmeDAO();
		List<Filmes> lista = fDAO.getLista();
		ModelAndView model = new ModelAndView("filmes/listaRA");
		model.addObject("filmes", lista);
		return model;
	}
	
	@RequestMapping("/remover")
	public String remover(Filmes filme) {
		System.out.println("Chamou método de remover");
		FilmeDAO fDAO = new FilmeDAO();
		fDAO.remover(filme);

		return "redirect:../filmes";
	}
	
}