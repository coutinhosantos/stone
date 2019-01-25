package com.coutinho.prova.stonepagamentos.repository;

import org.springframework.data.repository.CrudRepository;

import com.coutinho.prova.stonepagamentos.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
