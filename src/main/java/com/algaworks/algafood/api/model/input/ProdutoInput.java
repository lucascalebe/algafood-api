package com.algaworks.algafood.api.model.input;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoInput {

	@ApiModelProperty(example = "Frango assado",required = true)
	@NotBlank
	private String nome;
	
	@ApiModelProperty(example = "Frango ao bafo em 180ºC",required = true)
	@NotBlank
	private String descricao;
	
	@ApiModelProperty(example = "89.90",required = true)
	@PositiveOrZero
	@NotNull
	private BigDecimal preco;
	
	@ApiModelProperty(example = "true",required = true)
	@NotNull
	private Boolean ativo;
}
