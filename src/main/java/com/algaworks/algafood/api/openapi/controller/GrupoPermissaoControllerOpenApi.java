package com.algaworks.algafood.api.openapi.controller;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.PermissaoModel;
import io.swagger.annotations.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

@Api(tags = "Grupos")
public interface GrupoPermissaoControllerOpenApi {
	
	@ApiOperation("Lista as permissões associadas a um grupo")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Grupo não encontrado",response = Problem.class),
		@ApiResponse(code = 400,message = "Id do grupo inválido",response = Problem.class)
	})
	CollectionModel<PermissaoModel> listar(@ApiParam(value = "ID do grupo",example = "1",required = true)Long grupoId);
	
	@ApiOperation("Desassociação de permissão com grupo")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Grupo não encontrado",response = Problem.class),
		@ApiResponse(code = 204,message = "Permissão desassociada do grupo")
	})
	ResponseEntity<Void> removerPermissao(
			@ApiParam(value = "ID do grupo",example = "1",required = true)Long grupoId,
			@ApiParam(value = "ID da permissão",example = "1",required = true)Long permissaoId);	

	@ApiOperation("Associação de permissão com grupo")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Grupo não encontrado",response = Problem.class),
		@ApiResponse(code = 204,message = "Permissão associada ao grupo")
	})
	ResponseEntity<Void> adicionarPermissao(
			@ApiParam(value = "ID do grupo",example = "1",required = true)Long grupoId,
			@ApiParam(value = "ID da permissão",example = "1",required = true)Long permissaoId);
}
