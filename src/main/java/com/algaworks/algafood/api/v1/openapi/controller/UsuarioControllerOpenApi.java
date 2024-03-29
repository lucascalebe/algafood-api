package com.algaworks.algafood.api.v1.openapi.controller;

import org.springframework.hateoas.CollectionModel;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.UsuarioModel;
import com.algaworks.algafood.api.v1.model.input.SenhaInput;
import com.algaworks.algafood.api.v1.model.input.UsuarioComSenhaInput;
import com.algaworks.algafood.api.v1.model.input.UsuarioInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Usuários")
public interface UsuarioControllerOpenApi {

	@ApiOperation("Lista os usuários")
	CollectionModel<UsuarioModel> listar();

	@ApiOperation("Busca um usuário por Id")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Usuário não encontrado",response = Problem.class),
		@ApiResponse(code = 400,message = "Id do usuário inválido",response = Problem.class)
	})
	UsuarioModel buscar(@ApiParam(value = "Id do usuário",example = "1",required = true)Long usuarioId);
	
	@ApiOperation("Cadastra um usuário")
	UsuarioModel adicionar(@ApiParam(value = "corpo",example = "representação de um novo usuário",required = true)
		UsuarioComSenhaInput usuarioInput);
	
	@ApiOperation("Atualiza um usuário por Id")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Usuário não encontrado",response = Problem.class)
	})
	UsuarioModel atualizar(
			@ApiParam(value = "Id do usuário",example = "1",required = true)Long usuarioId,
			@ApiParam(value = "corpo",
				example = "Representação de um usuário com novos dados",required = true) UsuarioInput usuarioInput);
	
	@ApiOperation("Atualiza a senha de um usuário")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Usuário não encontrado",response = Problem.class)
	})
	void alterarSenha(
			@ApiParam(value = "Id do usuário",example = "1",required = true)Long usuarioId,
			@ApiParam(value = "corpo",example = "representação de uma nova senha",required = true)SenhaInput senhaInput);
}
