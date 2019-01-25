package com.coutinho.prova.stonepagamentos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String titulo;
	private String foto;
	private String descricao;
	private Double preco;

	@OneToOne
	Categoria categoria;

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(Integer id, String titulo, String foto, String descricao, Double preco, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.foto = foto;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	public Produto(Integer id, String titulo, String foto, String descricao, Double preco) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.foto = foto;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public Produto(String titulo, String foto, String descricao, Double preco, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.foto = foto;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}
	
	public Produto(String titulo, String foto, String descricao, Double preco) {
		super();
		this.titulo = titulo;
		this.foto = foto;
		this.descricao = descricao;
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", titulo=" + titulo + ", foto=" + foto + ", descricao=" + descricao + ", preco="
				+ preco + ", categoria=" + categoria + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
