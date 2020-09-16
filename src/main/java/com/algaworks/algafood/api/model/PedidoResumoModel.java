package com.algaworks.algafood.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.algafood.domain.model.StatusPedido;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoResumoModel {

	private String codigo;
	private BigDecimal subtotal;
	private BigDecimal taxaFrete;
	private BigDecimal valorTotal;
	private StatusPedido status;
	private OffsetDateTime dataCriacao;
	private RestauranteResumoModel restaurante;
//	private UsuarioModel cliente;
	private  String nomeCliente;
}
