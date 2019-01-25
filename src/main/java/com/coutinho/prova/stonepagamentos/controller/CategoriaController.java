package com.coutinho.prova.stonepagamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.coutinho.prova.stonepagamentos.model.Categoria;
import com.coutinho.prova.stonepagamentos.repository.CategoriaRepository;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;

	@RequestMapping("/cadastrar")
	public String index() {
		return "categoria/index";
	}
	
	@RequestMapping("/categorias")
	public String listar(Model model) {
		Iterable<Categoria> categorias = repository.findAll();
		model.addAttribute("categorias", categorias);
		return "categoria/categorias";
	}
	
	@RequestMapping(value= "/cadastrar", method = RequestMethod.POST)
	public String cadastrar(@RequestParam("descricao") String descricao){
		Categoria c = new Categoria();
		c.setDescricao(descricao);
		repository.save(c);		
		return "categoria/index";
	}
}
