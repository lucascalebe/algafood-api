package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.EstadoModel;
import com.algaworks.algafood.api.v1.model.input.EstadoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Estados")
public interface EstadoControllerOpenApi {

	@ApiOperation("Lista os estados")
	CollectionModel<EstadoModel> listar();

	@ApiOperation("Busca um estado por Id")
	@ApiResponses({
		@ApiResponse(code = 400,message = "Id de estado inválido",response = Problem.class),
		@ApiResponse(code = 404,message = "Estado não encontrado",response = Problem.class)
	})
	EstadoModel buscar(@ApiParam(value = "Id de um estado",example = "1",required = true) Long estadoId);
	
	@ApiOperation("Adiciona um novo estado")
	EstadoModel adicionar(@ApiParam(value = "corpo",example = "representação de um novo estado",required = true)
		EstadoInput estadoInput);
	
	@ApiOperation("Atualiza um estado por Id")
	@ApiResponses({	
		@ApiResponse(code = 404,message = "estado não encontrado", response = Problem.class)
	})
	EstadoModel atualizar(@ApiParam(value = "Id de um estado",example = "1", required = true)Long estadoId,
			@ApiParam(value = "corpo",example = "representação nova do estado", required = true)EstadoInput estadoInput);
	
	@ApiOperation("Exclui um estado por Id")
	@ApiResponses({		
		@ApiResponse(code = 404,message = "estado não encontrado", response = Problem.class)
	})
	void remover(@ApiParam(value = "Id de um estado",example = "1", required = true)Long estadoId);
}
