package com.algaworks.algafood.api.openapi.controller;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.GrupoModel;
import io.swagger.annotations.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

@Api(tags = "Usuários")
public interface UsuarioGrupoControllerOpenApi {

	@ApiOperation("Lista os grupos associados a um usuário")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Usuário não encontrado",response = Problem.class),
		@ApiResponse(code = 400,message = "Usuário não encontrado",response = Problem.class)
	})
	CollectionModel<GrupoModel> listar(@ApiParam(value = "Id do usuário",example = "1",required = true)Long usuarioId);
	
	@ApiOperation("Desassociação de grupo com usuário")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Usuário ou grupo não encontrado",response = Problem.class)
	})
	ResponseEntity<Void> removerGrupo(
			@ApiParam(value = "Id do usuário",example = "1",required = true)Long usuarioId,
			@ApiParam(value = "Id do grupo",example = "1",required = true)Long grupoId);
	
	@ApiOperation("Associação de grupo com usuário")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Usuário ou grupo não encontrado",response = Problem.class)
	})
	ResponseEntity<Void> adicionarGrupo(
			@ApiParam(value = "Id do usuário",example = "1",required = true)Long usuarioId,
			@ApiParam(value = "Id do grupo",example = "1",required = true)Long grupoId);
}
