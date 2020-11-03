package com.algaworks.algafood.api.openapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.algafood.api.exceptionhandler.Problem;
import com.algaworks.algafood.api.model.PedidoModel;
import com.algaworks.algafood.api.model.PedidoResumoModel;
import com.algaworks.algafood.api.model.input.PedidoInput;
import com.algaworks.algafood.domain.filter.PedidoFilter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

@Api(tags = "Pedidos")
public interface PedidoControllerOpenApi {

	@ApiOperation("Pesquisa pedidos com consulta dinâmica")
	@ApiImplicitParams({
		@ApiImplicitParam(value = "Nomes das popriedades para filtrar na resposta, separados por vírgula",
				name = "campos", paramType = "query", type = "string")
	})
	public Page<PedidoResumoModel> pesquisar(PedidoFilter filtro, Pageable pageable);
	
	@ApiOperation("Busca um pedido por Id")
	@ApiImplicitParams({
		@ApiImplicitParam(value = "Nomes das popriedades para filtrar na resposta, separados por vírgula",
				name = "campos", paramType = "query", type = "string")
	})
	@ApiResponse(code = 404,message = "Pedido não encontrado", response = Problem.class)
	public PedidoModel buscar(@ApiParam(value = "Código de um pedido",
			example = "f9981ca4-5a5e-4da3-af04-933861df3e55")String codigoPedido);
	
	@ApiOperation("Cadastra um pedido")
	@ApiResponse(code = 201, message = "Pedido Registrado")
	public PedidoModel adicionar(PedidoInput pedidoInput);
}