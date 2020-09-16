package com.algaworks.algafood.core.data;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableTranslator {

	
	/*
	 * Se o cliente pesquisar por nomeCliente dará erro pois o Pageable
	 * busca pelo Pedido(Domain) e não pelo resumoModel.
	 * Esse método converte por exemplo de nomeCliente para cliente.nome como está
	 * no Domain. Assim o Pageable consegue fazer sort by nomeCliente. 
	 */
	public static Pageable translate(Pageable pageable, Map<String, String> fieldsMapping) {
		
		var orders = pageable.getSort().stream()
			.filter(order -> fieldsMapping.containsKey(order.getProperty()))
			.map(order -> new Sort.Order(order.getDirection(),
					fieldsMapping.get(order.getProperty())))			
		
			.collect(Collectors.toList());
		
		return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), 
				Sort.by(orders));
	}
}
