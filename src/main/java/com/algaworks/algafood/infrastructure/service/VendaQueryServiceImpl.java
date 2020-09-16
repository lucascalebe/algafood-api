package com.algaworks.algafood.infrastructure.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.filter.VendaDiariaFilter;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.model.dto.VendaDiaria;
import com.algaworks.algafood.domain.service.VendaQueryService;

@Repository
public class VendaQueryServiceImpl implements VendaQueryService {

	/*
	 * 	select date(p.data_criacao) as data_criacao,
	 *	count(p.id) as total_vendas,
	 *	sum(p.valor_total) as total_faturado
     *
	 *	from pedido p
	 *
	 *	group by date(p.data_criacao)
	 */
	
	@Autowired
	private EntityManager manager;
	
	@Override
	public List<VendaDiaria> consultarVendasDiarias(VendaDiariaFilter filtro) {
		var builder = manager.getCriteriaBuilder();
		
		//builder com tipo de retorno da consulta
		var  query = builder.createQuery(VendaDiaria.class);
		
		//entidade raiz
		var root = query.from(Pedido.class);
		
		//construindo função de data
		var functionDateDataCriacao = builder.function(
				"date", Date.class, root.get("dataCriacao"));
		
		
		var selection = builder.construct(VendaDiaria.class, 
				functionDateDataCriacao,
				builder.count(root.get("id")),
				builder.sum(root.get("valorTotal")));
		
		
		query.select(selection);
		query.groupBy(functionDateDataCriacao);
		
		return manager.createQuery(query).getResultList();
	}

}
