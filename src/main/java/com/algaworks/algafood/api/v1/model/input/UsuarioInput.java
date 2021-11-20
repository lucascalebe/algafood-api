package com.algaworks.algafood.api.v1.model.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {

	@ApiModelProperty(example = "João",required = true)
	@NotBlank
	private String nome;
	
	@ApiModelProperty(example = "joao@gmail.com",required = true)
	@Email
	@NotBlank
	private String email;
}
