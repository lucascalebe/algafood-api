package com.algaworks.algafood.api.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "cidades")
@Getter
@Setter
public class CidadeResumoModel extends RepresentationModel<CidadeResumoModel>{

	@ApiModelProperty(example = "1")
	private Long id;
	@ApiModelProperty(example = "Brasília")
	private String nome;
	
	@ApiModelProperty(example = "Distrito Federal")
	private String estado;
}
