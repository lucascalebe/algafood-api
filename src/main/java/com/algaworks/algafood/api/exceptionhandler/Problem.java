package com.algaworks.algafood.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@ApiModel("Problema")
@JsonInclude(Include.NON_NULL)
@Getter 
@Builder
public class Problem {

	@ApiModelProperty(example = "400")
	private Integer status;
	
	@ApiModelProperty(example = "http://algafood.com.br/dados-invalidos")
	private String type;
	
	@ApiModelProperty(example = "Dados Inválidos")
	private String title;
	
	@ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
	private String detail;
	
	@ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
	private String userMessage;
	
	@ApiModelProperty(example = "2020-12-01T18:09:02.70844Z")
	private OffsetDateTime timestamp;
	
	@ApiModelProperty("Objetos ou campos que geraram o erro")
	private List<Object> objects;
	
	
	@ApiModel("ObjetoProblema")
	@Getter
	@Builder
	public static class Object {
		
		@ApiModelProperty(example = "preco")
		private String name;
		
		@ApiModelProperty(example = "o preço é obrigatório")
		private String userMessage;
	}
	
}
