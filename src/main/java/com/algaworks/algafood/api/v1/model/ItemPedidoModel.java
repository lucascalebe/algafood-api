package com.algaworks.algafood.api.v1.model;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "itens")
@Getter
@Setter
public class ItemPedidoModel extends RepresentationModel<ItemPedidoModel> {

	@ApiModelProperty(example = "1")
	private Long produtoId;
	
	@ApiModelProperty(example = "Carne ao barbecue")
	private String produtoNome;
	
	@ApiModelProperty(example = "2")
	private Integer quantidade;
	
	@ApiModelProperty(example = "55.50")
	private BigDecimal precoUnitario;
	
	@ApiModelProperty(example = "111.00")
	private BigDecimal precoTotal;
	
	@ApiModelProperty(example = "Sem acompanhamentos")
	private String observacao;
}
