package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedModel;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.CozinhaModel;
import com.algaworks.algafood.api.v1.model.input.CozinhaInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Cozinhas")
public interface CozinhaControllerOpenApi {

	@ApiOperation("Lista as cozinhas com paginação")
	PagedModel<CozinhaModel> listar(@PageableDefault(size = 10) Pageable pageable);

	@ApiOperation("Busca uma cozinha por Id")
	@ApiResponses({
		@ApiResponse(code = 400, message = "Id de cozinha inválido", response = Problem.class),
		@ApiResponse(code = 404, message = "Cozinha não encontrada", response = Problem.class)
	})
	CozinhaModel buscar(@ApiParam(value = "Id de uma cozinha",example = "1",required = true) Long cozinhaId);

	
	@ApiOperation("Cadastra uma cozinha")
	CozinhaModel adicionar(@ApiParam(value = "corpo", example = "representação de uma nova cozinha",required = true)
			CozinhaInput cozinhaInput);

	
	@ApiOperation("Atualiza uma cozinha por Id")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Cozinha atualizada"),
		@ApiResponse(code = 404,message = "Cozinha não encontrada", response = Problem.class)
	})
	CozinhaModel atualizar(@ApiParam(value = "Id de uma cozinha",example = "1",required = true) Long cozinhaId,
			@ApiParam(value = "corpo", example = "representação de uma cozinha com novos dados",required = true) CozinhaInput cozinhaInput);
	
	@ApiOperation("Exclui uma cozinha por Id")
	@ApiResponses({		
		@ApiResponse(code = 204, message = "Cozinha excluída"),
		@ApiResponse(code = 404, message = "Cozinha não encontrada", response = Problem.class)
	})
	void remover(@ApiParam(value = "Id de uma cozinha",example = "1") Long cozinhaId);
}
