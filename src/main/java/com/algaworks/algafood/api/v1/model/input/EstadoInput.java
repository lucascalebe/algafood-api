package com.algaworks.algafood.api.v1.model.input;

import lombok.Setter;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@Setter
public class EstadoInput {

	@ApiModelProperty(example = "Minas Gerais",required = true)
	@NotBlank
	private String nome;
}
