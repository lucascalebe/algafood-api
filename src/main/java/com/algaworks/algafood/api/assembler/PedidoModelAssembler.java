package com.algaworks.algafood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.TemplateVariable;
import org.springframework.hateoas.TemplateVariable.VariableType;
import org.springframework.hateoas.TemplateVariables;
import org.springframework.hateoas.UriTemplate;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.controller.CidadeController;
import com.algaworks.algafood.api.controller.FormaPagamentoController;
import com.algaworks.algafood.api.controller.PedidoController;
import com.algaworks.algafood.api.controller.RestauranteController;
import com.algaworks.algafood.api.controller.RestauranteProdutoController;
import com.algaworks.algafood.api.controller.UsuarioController;
import com.algaworks.algafood.api.model.PedidoModel;
import com.algaworks.algafood.domain.model.Pedido;

@Component
public class PedidoModelAssembler extends RepresentationModelAssemblerSupport<Pedido, PedidoModel>{

	
	public PedidoModelAssembler() {
		super(PedidoController.class, PedidoModel.class);
	}

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PedidoModel toModel(Pedido pedido) {
		PedidoModel pedidoModel = createModelWithId(pedido.getCodigo(), pedido);
	
		modelMapper.map(pedido, pedidoModel);
		
		TemplateVariables pageVariables = new TemplateVariables(
				new TemplateVariable("page", VariableType.REQUEST_PARAM),
				new TemplateVariable("size", VariableType.REQUEST_PARAM),				
				new TemplateVariable("sort", VariableType.REQUEST_PARAM)				
				);
		
		TemplateVariables filtroVariables = new TemplateVariables(
				new TemplateVariable("clientId", VariableType.REQUEST_PARAM),
				new TemplateVariable("restauranteId", VariableType.REQUEST_PARAM),				
				new TemplateVariable("dataCriacaoInicio", VariableType.REQUEST_PARAM),
				new TemplateVariable("dataCriacaoFim", VariableType.REQUEST_PARAM)
				);
		
		String pedidosUrl = WebMvcLinkBuilder.linkTo(PedidoController.class).toUri().toString();
		
		pedidoModel.add(new Link(UriTemplate.of(pedidosUrl, pageVariables.concat(filtroVariables)),"pedidos"));
		
		pedidoModel.add(WebMvcLinkBuilder.linkTo(PedidoController.class).withRel("pedidos"));
		
		pedidoModel.getRestaurante().add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
				.methodOn(RestauranteController.class).buscar(pedidoModel.getRestaurante().getId())).withSelfRel());
		
		pedidoModel.getCliente().add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
				UsuarioController.class).buscar(pedidoModel.getCliente().getId())).withSelfRel());
		
		pedidoModel.getFormaPagamento().add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
				FormaPagamentoController.class).buscar(pedidoModel.getFormaPagamento().getId(),null)).withSelfRel());
		
		pedidoModel.getEnderecoEntrega().getCidade().add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
				CidadeController.class).buscar(pedidoModel.getEnderecoEntrega().getCidade().getId())).withSelfRel());
		
		pedidoModel.getItens().forEach(item -> {
	            item.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RestauranteProdutoController.class)
	                    .buscar(pedidoModel.getRestaurante().getId(), item.getProdutoId()))
	                    .withRel("produto"));
	        });
		 
		return pedidoModel;
	}
	
	
}
