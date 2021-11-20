package com.algaworks.algafood.api.v1.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "usuarios")
@Getter
@Setter
public class UsuarioModel extends RepresentationModel<UsuarioModel>{

	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "João")
	private String nome;
	
	@ApiModelProperty(example = "joaosilva@gmail.com")
	private String email;
}
