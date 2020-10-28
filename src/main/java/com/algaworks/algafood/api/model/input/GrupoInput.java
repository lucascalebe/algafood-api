package com.algaworks.algafood.api.model.input;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrupoInput {

	@NotBlank
	@ApiModelProperty(example = "Gerente",required = true)
	private String nome;
}
