package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.exceptionhandler.Problem;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Pedidos")
public interface FluxoPedidoControllerOpenApi {

	@ApiOperation("Confirmar pedido")
	@ApiResponses({
		@ApiResponse(code = 204,message = "Pedido Confirmado"),
		@ApiResponse(code = 404, message = "Pedido não encontrado", response = Problem.class)
	})
	ResponseEntity<Void> confirmar(@ApiParam(value = "Código de um pedido",
			example = "f9981ca4-5a5e-4da3-af04-933861df3e55",required = true)String codigoPedido);
	
	@ApiOperation("Cancelar Pedido")
	@ApiResponses({		
		@ApiResponse(code = 204,message = "Pedido Cancelado"),
		@ApiResponse(code = 404, message = "Pedido não encontrado", response = Problem.class)
	})
	ResponseEntity<Void> cancelar(@ApiParam(value = "Código de um pedido",
			example = "f9981ca4-5a5e-4da3-af04-933861df3e55",required = true)String codigoPedido);
	
	@ApiOperation("Entregar Pedido")
	@ApiResponses({		
		@ApiResponse(code = 204,message = "Pedido Entregue"),
		@ApiResponse(code = 404, message = "Pedido não encontrado", response = Problem.class)
	})
	ResponseEntity<Void> entregar(@ApiParam(value = "Código de um pedido",
			example = "f9981ca4-5a5e-4da3-af04-933861df3e55",required = true)String codigoPedido);
}
