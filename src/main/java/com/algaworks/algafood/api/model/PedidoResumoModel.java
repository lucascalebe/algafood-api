package com.algaworks.algafood.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.algaworks.algafood.domain.model.StatusPedido;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Relation(collectionRelation = "pedidos")
@Getter
@Setter
public class PedidoResumoModel extends RepresentationModel<PedidoResumoModel>{

	@ApiModelProperty(example = "f9981ca4-5a5e-4da3-af04-933861df3e55")
	private String codigo;
	
	@ApiModelProperty(example = "210.00")
	private BigDecimal subtotal;
	
	@ApiModelProperty(example = "10.00")
	private BigDecimal taxaFrete;
	
	@ApiModelProperty(example = "220.00")
	private BigDecimal valorTotal;
	
	@ApiModelProperty(example = "CRIADO")
	private StatusPedido status;
	
	@ApiModelProperty(example = "2020-12-01T20:34:04Z")
	private OffsetDateTime dataCriacao;
	
	private RestauranteResumoModel restaurante;
	
	private UsuarioModel cliente;
	
	@ApiModelProperty(example = "Carlos")
	private  String nomeCliente;
}
