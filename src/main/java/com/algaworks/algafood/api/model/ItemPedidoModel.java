package com.algaworks.algafood.api.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoModel {

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
