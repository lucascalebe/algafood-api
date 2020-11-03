package com.algaworks.algafood.domain.filter;

import java.time.OffsetDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoFilter {

	@ApiModelProperty(example = "1",value = "ID do cliente para o filtro da pesquisa")
	private Long clienteId;
	
	@ApiModelProperty(example = "1",value = "ID do restaurante para o filtro da pesquisa")
	private Long restauranteId;
	
	@ApiModelProperty(example = "2019-11-01T10:00:00Z"
			,value = "Data/Hora de criação inicial para o filtro da pesquisa")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private OffsetDateTime dataCriacaoInicio;
	
	@ApiModelProperty(example = "2019-11-01T12:30:00Z"
			,value = "Data/Hora de criação inicial para o filtro da pesquisa")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private OffsetDateTime dataCriacaoFim;
	
}
