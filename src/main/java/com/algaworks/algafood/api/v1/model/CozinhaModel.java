package com.algaworks.algafood.api.v1.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Relation(collectionRelation = "cozinhas")
public class CozinhaModel extends RepresentationModel<CozinhaModel>{

	@ApiModelProperty(example = "1")
//	@JsonView(RestauranteView.Resumo.class)
	private Long id;
	
	@ApiModelProperty(example = "Brasileira")
//	@JsonView(RestauranteView.Resumo.class)
	private String nome;
}
