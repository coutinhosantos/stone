package com.coutinho.prova.stonepagamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coutinho.prova.stonepagamentos.model.Cliente;
import com.coutinho.prova.stonepagamentos.model.Produto;
import com.coutinho.prova.stonepagamentos.repository.ClienteRepository;
import com.coutinho.prova.stonepagamentos.repository.ProdutoRepository;

@Controller
public class IndexController {

	@Autowired
	private ProdutoRepository repositoryProduto;
	
	@Autowired
	private ClienteRepository repositoryCliente;
	
	@RequestMapping("/")
	public String index(Model model) {		
		return "index";
	}
	
	@RequestMapping("/administracao")
	public String inicioAdministracao() {
		return "/administracao/index";
	}
	
	@RequestMapping("/venda")
	public String inicioVenda(Model model) {
		Iterable<Produto> produtos = repositoryProduto.findAll();
		model.addAttribute("produtos", produtos);
		
		Cliente cliente = repositoryCliente.findOne(1);
		model.addAttribute("cliente", cliente);
		return "/venda/index";
	}
}
