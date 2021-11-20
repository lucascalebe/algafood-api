package com.algaworks.algafood.api.v1.openapi.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.v1.model.FotoProdutoModel;
import com.algaworks.algafood.api.v1.model.input.FotoProdutoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags ="Produtos")
public interface RestauranteProdutoFotoControllerOpenApi {

	@ApiOperation("Atualiza a foto do produto de um restaurante")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Foto Atualizada"),
		@ApiResponse(code = 404,message = "Restaurante ou produto inexistente",response = Problem.class)
	})
	FotoProdutoModel atualizarFoto(
			@ApiParam(value = "Id do restaurante",example = "1",required = true)Long restauranteId,
			@ApiParam(value = "Id do produto",example = "1",required = true)Long produtoId,
			@ApiParam(value = "corpo",example = "foto do produto e descrição opcional"
				,required = true)FotoProdutoInput fotoProdutoInput,
			@ApiParam(value = "Arquivo da foto do produto (máximo 500KB, apenas JPG e PNG)",
					required = true) MultipartFile arquivo) throws IOException;

	@ApiOperation(value = "Busca a foto de um produto de um restaurante",
			produces = "application/json, image/jpeg, image/png")
	@ApiResponses({
		@ApiResponse(code = 404,message = "Restaurante ou produto inexistente",response = Problem.class),
		@ApiResponse(code = 400,message = "Id do restaurante ou produto inválido",response = Problem.class)
	})
	FotoProdutoModel buscar(@ApiParam(value = "Id do restaurante",example = "1",required = true)Long restauranteId,
			@ApiParam(value = "Id do produto",example = "1",required = true)Long produtoId);

	@ApiOperation("Exclui a foto do produto de um restaurante")
	@ApiResponses({
		@ApiResponse(code = 204,message = "Foto Excluída"),
		@ApiResponse(code = 404,message = "Restaurante ou produto inexistente",response = Problem.class)
	})
	void remover(@ApiParam(value = "Id do restaurante",example = "1",required = true)Long restauranteId,
			@ApiParam(value = "Id do produto",example = "1",required = true)Long produtoId);
	
	
	@ApiOperation(value = "Busca a foto de produto de um restaurante",hidden = true)
	ResponseEntity<?> servirFoto(Long restauranteId
			,Long produtoId,String acceptHeader) throws HttpMediaTypeNotAcceptableException;
	

}
