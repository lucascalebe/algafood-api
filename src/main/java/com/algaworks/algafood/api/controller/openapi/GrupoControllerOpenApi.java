package com.algaworks.algafood.api.controller.openapi;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.GrupoModel;
import com.algaworks.algafood.api.model.input.GrupoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Grupos")
public interface GrupoControllerOpenApi {

	@ApiOperation("Lista os gupos")
	public List<GrupoModel> listar();
	
	@ApiOperation("Busca um grupo por ID")
	@ApiResponses({
		@ApiResponse(code = 400, message = "ID do grupo é inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class)
	})
	public GrupoModel buscar(@ApiParam(value = "Id de uma grupo", example = "1") Long grupoId);
	
	@ApiOperation("Cadastra um grupo")
	public GrupoModel adicionar(@ApiParam(value = "corpo", example = "Representação de um novo grupo") GrupoInput grupoInput);

	@ApiOperation("Atualiza um grupo por ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Grupo Atualizado"),
		@ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class)
	})
	public GrupoModel atualizar(@ApiParam(value = "Id de um grupo", example = "1") Long grupoId,
			@ApiParam(value = "corpo", example = "Representação de um grupo com novos dados") GrupoInput grupoInput);
	
	@ApiOperation("Exclui um grupo por ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Grupo excluído"),
		@ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class)
	})
	public void remover(@ApiParam(value = "Id de um grupo", example = "1") Long grupoId);
}
