package com.coutinho.prova.stonepagamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coutinho.prova.stonepagamentos.model.Venda;
import com.coutinho.prova.stonepagamentos.repository.VendaRepository;

@Controller
@RequestMapping("/administracao")
public class AdministracaoController {

	@Autowired
	private VendaRepository repositoryVenda;
	
	@RequestMapping("/vendas")
	public String vendas(Model model) {
		Iterable<Venda> vendas = repositoryVenda.findAll();
		model.addAttribute("vendas", vendas);
		return "/administracao/vendas";
	}
}
