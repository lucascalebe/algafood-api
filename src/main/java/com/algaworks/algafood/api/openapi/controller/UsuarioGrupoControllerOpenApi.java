package com.algaworks.algafood.api.openapi.controller;

import java.util.List;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.GrupoModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Usuários")
public interface UsuarioGrupoControllerOpenApi {

	@ApiOperation("Lista os grupos associados a um usuário")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Usuário não encontrado",response = Problem.class),
		@ApiResponse(code = 400,message = "Usuário não encontrado",response = Problem.class)
	})
	List<GrupoModel> listar(@ApiParam(value = "Id do usuário",example = "1",required = true)Long usuarioId);
	
	@ApiOperation("Desassociação de grupo com usuário")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Usuário ou grupo não encontrado",response = Problem.class)
	})
	void removerGrupo(
			@ApiParam(value = "Id do usuário",example = "1",required = true)Long usuarioId,
			@ApiParam(value = "Id do grupo",example = "1",required = true)Long grupoId);
	
	@ApiOperation("Associação de grupo com usuário")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Usuário ou grupo não encontrado",response = Problem.class)
	})
	void adicionarGrupo(
			@ApiParam(value = "Id do usuário",example = "1",required = true)Long usuarioId,
			@ApiParam(value = "Id do grupo",example = "1",required = true)Long grupoId);
}
