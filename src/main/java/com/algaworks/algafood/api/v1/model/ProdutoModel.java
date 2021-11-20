package com.algaworks.algafood.api.v1.model;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "produtos")
@Getter
@Setter
public class ProdutoModel extends RepresentationModel<ProdutoModel> {

	@ApiModelProperty(value = "Id do produto",example = "1")
	private Long id;
	
	@ApiModelProperty(value = "Nome do produto",example = "Frango Assado")
	private String nome;
	
	@ApiModelProperty(value = "Descrição do produto",example = "Frango com molho branco assado ao bafo")
	private String descricao;
	
	@ApiModelProperty(value = "Preço do produto",example = "89.90")
	private BigDecimal preco;
	
	@ApiModelProperty(value = "Status do produto",example = "true")
	private Boolean ativo; 
}
