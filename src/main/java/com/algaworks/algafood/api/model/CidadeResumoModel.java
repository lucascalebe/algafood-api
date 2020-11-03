package com.algaworks.algafood.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeResumoModel {

	@ApiModelProperty(example = "1")
	private Long id;
	@ApiModelProperty(example = "Brasília")
	private String nome;
	
	@ApiModelProperty(example = "Distrito Federal")
	private String estado;
}
