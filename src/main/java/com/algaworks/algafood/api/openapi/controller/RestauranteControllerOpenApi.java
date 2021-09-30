package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.RestauranteApenasNomeModel;
import com.algaworks.algafood.api.model.RestauranteBasicoModel;
import com.algaworks.algafood.api.model.RestauranteModel;
import com.algaworks.algafood.api.model.input.RestauranteInput;
import com.algaworks.algafood.api.openapi.model.RestauranteBasicoModelOpenApi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Restaurantes")
public interface RestauranteControllerOpenApi {

	@ApiOperation(value = "Lista restaurantes",response = RestauranteBasicoModelOpenApi.class)
	@ApiImplicitParams({
		@ApiImplicitParam(value = "Nome da projeção de pedidos",
				name = "projecao", paramType = "string", type = "query", allowableValues = "apenas-nome")
	})
	CollectionModel<RestauranteBasicoModel> listar();

	@ApiOperation(value = "Lista restaurantes",hidden = true)
	CollectionModel<RestauranteApenasNomeModel> listarApenasNomes();
	
	@ApiOperation("Busca um restaurante por Id")
	@ApiResponses({
		@ApiResponse(code = 400,message = "Id do restaurante inválido",response = Problem.class),
		@ApiResponse(code = 404,message = "Restaurante não encontrado",response = Problem.class)
	})
	RestauranteModel buscar(@ApiParam(value = "Id de um restaurante", example = "1",required = true) Long restauranteId);

	RestauranteModel adicionar(@ApiParam(value = "corpo",example = "representação de um novo restaurante",required = true)
			RestauranteInput restauranteInput);

	@ApiOperation("Atualiza um restaurante por Id")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Restaurante atualizado"),
		@ApiResponse(code = 404,message = "Restaurante não encontrado",response = Problem.class)
	})
	RestauranteModel atualizar(@ApiParam(value = "Id de um restaurante",example = "1",required = true)Long restauranteId,
			@ApiParam(value = "corpo",example = "representação de um novo restaurante",required = true)RestauranteInput restauranteInput);
	
	@ApiOperation("Ativar um restaurante por Id")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Restaurante não encontrado",response = Problem.class),
		@ApiResponse(code = 204,message = "Restaurante ativado")
	})
	ResponseEntity<Void> ativar(@ApiParam(value = "Id de um restaurante",example = "1",required = true)Long restauranteId);
	
	@ApiOperation("Inativar um restaurante por Id")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Restaurante não encontrado",response = Problem.class),
		@ApiResponse(code = 204,message = "Restaurante inativado")
	})
	ResponseEntity<Void> inativar(@ApiParam(value = "Id de um restaurante",example = "1",required = true)Long restauranteId);
	
	@ApiOperation("Ativar restaurantes por Ids")
	@ApiResponses({		
		@ApiResponse(code = 204,message = "Restaurante ativado")
	})
	void ativarMultiplos(@ApiParam(value = "Ids dos restaurantes",required = true)List<Long> restauranteIds);
	
	@ApiOperation("Desativar restaurantes por Ids")
	@ApiResponses({		
		@ApiResponse(code = 204,message = "Restaurante desativado")
	})
	void desativarMultiplos(@ApiParam(value = "Ids dos restaurantes",required = true)List<Long> restauranteIds);
	
	
	@ApiOperation("Abre um restaurante por Id")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Restaurante não encontrado",response = Problem.class),
		@ApiResponse(code = 204,message = "Restaurante aberto")
	})
	ResponseEntity<Void> abertura(@ApiParam(value = "Id de um restaurante",example = "1",required = true)Long restauranteId);
	
	
	@ApiOperation("Fecha um restaurante por Id")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Restaurante não encontrado",response = Problem.class),
		@ApiResponse(code = 204,message = "Restaurante fechado")
	})
	ResponseEntity<Void> fechamento(@ApiParam(value = "Id de um restaurante",example = "1",required = true)Long restauranteId);
}
