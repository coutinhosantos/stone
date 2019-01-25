package com.coutinho.prova.stonepagamentos.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.coutinho.prova.stonepagamentos.model.Categoria;
import com.coutinho.prova.stonepagamentos.model.Cliente;
import com.coutinho.prova.stonepagamentos.model.Endereco;
import com.coutinho.prova.stonepagamentos.model.Produto;
import com.coutinho.prova.stonepagamentos.model.Venda;
import com.coutinho.prova.stonepagamentos.repository.ClienteRepository;
import com.coutinho.prova.stonepagamentos.repository.EnderecoRepository;
import com.coutinho.prova.stonepagamentos.repository.ProdutoRepository;
import com.coutinho.prova.stonepagamentos.repository.VendaRepository;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repositoryProduto;
	
	@Autowired
	private VendaRepository repositoryVenda;
	
	@Autowired
	private ClienteRepository repositoryCliente;
	
	@Autowired
	private EnderecoRepository repositoryEndereco;
	
	@RequestMapping("/cadastrar")
	public String index() {
		return "produto/index";
	}
	
	@RequestMapping("/produtos")
	public String listar(Model model) {
		Iterable<Produto> produtos = repositoryProduto.findAll();
		model.addAttribute("produtos", produtos);
		return "produto/produtos";
	}
	
	@RequestMapping(value= "/cadastrar", method = RequestMethod.POST)
	public String cadastrar(@RequestParam("titulo")    String titulo,
							@RequestParam("foto") 	   String foto,
							@RequestParam("descricao") String descricao,
							@RequestParam("preco") 	   Double preco,
							@RequestParam("categoria") Integer idCategoria) {
		
		
		Categoria c = new Categoria();
		c.setId(idCategoria);
		
		Produto p = new Produto(titulo, foto, descricao, preco, c);
		repositoryProduto.save(p);		
		return "produto/index";
	}
	
	@RequestMapping("/descricao")
	public String descricao(@RequestParam("id") Integer id,Model model) {
		Produto produto = repositoryProduto.findOne(id);
		model.addAttribute("produto", produto);
		Cliente cliente = repositoryCliente.findOne(1);
		model.addAttribute("cliente", cliente);
		return "produto/descricao";
	}
	
	@RequestMapping("/comprar")
	public String comprar(@RequestParam("id") Integer id,Model model) {
		Produto produto = repositoryProduto.findOne(id);
		model.addAttribute("produto", produto);
		
		Iterable<Produto> produtos = repositoryProduto.findAll();
		model.addAttribute("produtos", produtos);
		return "produto/comprar";
	}
	
	@RequestMapping(value = "/agradecimento", method = RequestMethod.POST)
	public String agradecimento(@RequestParam("id") Integer id, 
								@RequestParam("nome") String nome,
								@RequestParam("email") String email,
								@RequestParam("telefone") String telefone,
								@RequestParam("cep") String cep,
								@RequestParam("rua") String rua,
								@RequestParam("numero") String numero,
								@RequestParam("bairro") String bairro,
								@RequestParam("cidade") String cidade,
								@RequestParam("uf") String uf,
								//@RequestParam("pais") String pais,								
								Model model) {
						
		Endereco endereco = new Endereco(null, cep, rua, bairro, cidade, uf, "Brasil");
		
		Cliente cliente = new Cliente(null, nome, email, telefone, endereco);
		
		Produto produto = repositoryProduto.findOne(id);
		
		Venda v = new Venda(null, 1, produto, cliente, endereco);
		
		repositoryEndereco.save(endereco);
		repositoryCliente.save(cliente);
		repositoryVenda.save(v);
		
		model.addAttribute("produto", produto);
		model.addAttribute("nome", nome);
		model.addAttribute("email", email);
		model.addAttribute("telefone", telefone);
		model.addAttribute("pedido", v.getId());
		model.addAttribute("frete", new Random().nextInt((100)+1)).toString();
		model.addAttribute("prazo", new Random().nextInt((20)+1)).toString();
		return "/venda/agradecimento";
	}
	
}
