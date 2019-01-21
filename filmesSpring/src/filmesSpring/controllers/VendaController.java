package filmesSpring.controllers;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import filmesSpring.daos.ClienteDAO;
import filmesSpring.daos.VendaDAO;
import filmesSpring.daos.FilmeDAO;
import filmesSpring.models.Clientes;
import filmesSpring.models.Vendas;
import filmesSpring.models.Filmes;

@Controller
public class VendaController {
	
	@RequestMapping("/vendas/form")
	public ModelAndView listarCF() {
		ClienteDAO cDAO = new ClienteDAO();
		FilmeDAO fDAO = new FilmeDAO();
		List<Clientes> listaC = cDAO.getLista();
		List<Filmes> listaF = fDAO.getLista();
		ModelAndView model = new ModelAndView("vendas/form");
		model.addObject("clientes", listaC);
		model.addObject("filmes", listaF);
		return model;
	}
	
	@PostMapping("/vendas")
	public String inserir(Vendas venda) {
		System.out.println("Chamou o método de adicionar");
		System.out.println("Cliente ID: " + venda.getCliente().getId());
		System.out.println("Filme ID: " + venda.getFilme().getId());
		VendaDAO vDAO = new VendaDAO();
		vDAO.inserir(venda);
		return "redirect:/vendas";
	}
	
	@GetMapping("/vendas") 
	public ModelAndView listar() {
		VendaDAO vDAO = new VendaDAO();
		List<Vendas> lista = vDAO.getLista();
		ModelAndView model = new ModelAndView("vendas/lista");
		model.addObject("vendas", lista);
		return model;
	}


@RequestMapping("/vendas/selecionar")
public ModelAndView selecionar(Vendas venda) {
	System.out.println("Chamou o método selecionar");
	VendaDAO vDAO = new VendaDAO();
	venda = vDAO.getVendasByID(venda.getId());
	ModelAndView model = new ModelAndView("vendas/form-alterar");
	model.addObject("venda", venda);
	return model;
}

@PostMapping("/vendas/alterar")
public String alterar(Vendas venda) {
	System.out.println("Chamou o método alterar");
	System.out.println(venda);
	VendaDAO vDAO = new VendaDAO();
	vDAO.alterarStatus(venda);
	return "redirect:/vendas";
}
}