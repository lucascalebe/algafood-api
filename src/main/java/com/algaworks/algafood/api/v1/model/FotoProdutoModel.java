package com.algaworks.algafood.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation("fotos")
@Getter
@Setter
public class FotoProdutoModel extends RepresentationModel<FotoProdutoModel> {
	
	@ApiModelProperty(example = "2f4b2abb-01f2-4b81-887b-7d1b75d94a4c_cover.jpg")
	private String nomeArquivo;
	
	@ApiModelProperty(example = "Prime rib ao ponto")
	private String descricao;
	
	@ApiModelProperty(example = "image/jpeg")
	private String ContentType;
	
	@ApiModelProperty(example = "104711")
	private Long tamanho;
}
