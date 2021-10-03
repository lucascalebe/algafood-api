package com.algaworks.algafood.api.openapi.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.ServletWebRequest;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.FormaPagamentoModel;
import com.algaworks.algafood.api.model.input.FormaPagamentoInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Formas de Pagamento")
public interface FormaPagamentoControllerOpenApi {
	
	@ApiOperation("Lista as formas de pagamento")
	ResponseEntity<CollectionModel<FormaPagamentoModel>> listar(ServletWebRequest request);
	
	@ApiOperation("Busca uma forma de pagamento por Id")
	@ApiResponses({
		@ApiResponse(code = 400,message = "Id de forma de pagamento inválido", response = Problem.class),
		@ApiResponse(code = 404,message = "Forma de pagamento não encontrada", response = Problem.class)
	})
	ResponseEntity<FormaPagamentoModel> buscar(@ApiParam(value = "Id da forma de pagamento",
			example = "1",required = true)Long formaPagamentoId,
				ServletWebRequest request);
	
	@ApiOperation("Cadastra uma nova forma de pagamento")
	FormaPagamentoModel adicionar(@ApiParam(value = "corpo",example = "Representação deuma nova forma de pagamento",required = true)
				FormaPagamentoInput formaPagamentoInput);
	
	@ApiOperation("Atualiza uma forma de pagamento por Id")
	@ApiResponses({
		@ApiResponse(code = 200,message = "Forma de pagamento atualizada"),
		@ApiResponse(code = 404,message = "Forma de pagamento não encontrada", response = Problem.class)
	})
	FormaPagamentoModel atualizar(@ApiParam(value = "Id de uma forma de Pagamento",example = "1",required = true)Long formaPagamentoId,
			@ApiParam(value = "corpo",example = "nova representação da forma de pagamento",required = true)FormaPagamentoInput formaPagamentoInput);
	
	@ApiOperation("Exclui uma forma de pagamento por Id")
	@ApiResponses({
		@ApiResponse(code = 204,message = "Forma de pagamento excluída"),
		@ApiResponse(code = 404,message = "Forma de pagamento não encontrada", response = Problem.class)
	})
	void remover(@ApiParam(value = "Id de uma forma de Pagamento",example = "1")Long formaPagamentoId);
}
