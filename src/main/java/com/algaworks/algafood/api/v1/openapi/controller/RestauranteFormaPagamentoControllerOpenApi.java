package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.FormaPagamentoModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Restaurantes")
public interface RestauranteFormaPagamentoControllerOpenApi {

	@ApiOperation("Lista as formas de pagamento do restaurante")
	@ApiResponses({
		@ApiResponse(code = 400,message = "Id do restaurante inválido", response = Problem.class),
		@ApiResponse(code = 404,message = "Restaurante não encontrado", response = Problem.class)
	})
	CollectionModel<FormaPagamentoModel> listar(@ApiParam(value = "Id do restaurante",example = "1", required = true)Long restauranteId);
	
	@ApiOperation("Desassociação de restaurante com forma de pagamento")
	@ApiResponses({
		@ApiResponse(code = 400,message = "Id inválido", response = Problem.class),
		@ApiResponse(code = 204,message = "Forma de pagamento desassociada do restaurante"),
		@ApiResponse(code = 404,message = "Restaurante ou Forma de pagamento não encontrada", response = Problem.class)
	})
	ResponseEntity<Void> desassociar(@ApiParam(value = "Id do restaurante",example = "1", required = true)Long restauranteId,
			@ApiParam(value = "Id da forma de pagamento",example = "1", required = true)Long formaPagamentoId);
	
	@ApiOperation("Associação de restaurante com forma de pagamento")
	@ApiResponses({
		@ApiResponse(code = 400,message = "Id inválido", response = Problem.class),
		@ApiResponse(code = 204,message = "Forma de Pagamento associada com o restaurante"),
		@ApiResponse(code = 404,message = "Restaurante ou Forma de pagamento não encontrada", response = Problem.class)
	})
	ResponseEntity<Void> associar(@ApiParam(value = "Id do restaurante",example = "1", required = true)Long restauranteId,
			@ApiParam(value = "Id da forma de pagamento",example = "1", required = true)Long formaPagamentoId);
}
