package com.algaworks.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class FotoProduto {

	@EqualsAndHashCode.Include
	@Id
	@Column(name = "produto_id", nullable = false)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	//mapeada através do id da entidade fotoProduto
	@MapsId
	private Produto produto;
	
	@Column(nullable = false)
	private String nomeArquivo;
	
	private String descricao;
	
	@Column(nullable = false)
	private String ContentType;
	
	@Column(nullable = false)
	private Long tamanho;
}