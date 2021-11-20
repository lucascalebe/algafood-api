package com.algaworks.algafood.api.v1.model.input;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoIdInput {

	@NotNull
	@ApiModelProperty(example = "1", required = true)
	private Long id;
}
