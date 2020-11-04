package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.UsuarioModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Restaurantes")
public interface RestauranteUsuarioControllerOpenApi {

	@ApiOperation("Lista os usuários resposáveis associados a restaurante")
	List<UsuarioModel> listar(@ApiParam(value = "Id do restaurante",example = "1",required = true) Long restauranteId);
	
	@ApiOperation("Desassociação de restaurante com usuário responsável")
	@ApiResponses({
		@ApiResponse(code = 204,message = "Restaurante desassociado"),
		@ApiResponse(code = 404,message = "Restaurante ou usuário não encontrado", response = Problem.class)
	})
	void removerResponsavel(@ApiParam(value = "Id do restaurante",example = "1",required = true)Long restauranteId,
			@ApiParam(value = "Id do responsável",example = "1",required = true)Long responsavelId);
	
	@ApiOperation("Associação de restaurante com usuário responsável")
	@ApiResponses({
		@ApiResponse(code = 204,message = "Restaurante associado"),
		@ApiResponse(code = 404,message = "Restaurante ou usuário não encontrado", response = Problem.class)
	})
	void adicionarResponsavel(@ApiParam(value = "Id do restaurante",example = "1",required = true)Long restauranteId,
			@ApiParam(value = "Id do responsável",example = "1",required = true)Long responsavelId);
}
