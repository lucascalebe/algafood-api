package com.algaworks.algafood.api.model.input;

import lombok.Setter;

import javax.validation.constraints.NotBlank;

import lombok.Getter;

@Getter
@Setter
public class EstadoInput {

	@NotBlank
	private String nome;
}
