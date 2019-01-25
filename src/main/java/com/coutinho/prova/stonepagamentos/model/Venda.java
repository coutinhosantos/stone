package com.coutinho.prova.stonepagamentos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer qtdItens;

	@OneToOne
	private Produto produtos;

	@OneToOne
	private Cliente cliente;

	@OneToOne
	private Endereco endereco;

	public Venda() {
		// TODO Auto-generated constructor stub
	}

	public Venda(Integer id, Integer qtdItens, Produto produtos, Cliente cliente, Endereco endereco) {
		super();
		this.id = id;
		this.qtdItens = qtdItens;
		this.produtos = produtos;
		this.cliente = cliente;
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", qtdItens=" + qtdItens + ", produtos=" + produtos + ", cliente=" + cliente
				+ ", endereco=" + endereco + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(Integer qtdItens) {
		this.qtdItens = qtdItens;
	}

	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
