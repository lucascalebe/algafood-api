package com.algaworks.algafood.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.v1.AlgaLinks;
import com.algaworks.algafood.api.v1.controller.PedidoController;
import com.algaworks.algafood.api.v1.model.PedidoModel;
import com.algaworks.algafood.domain.model.Pedido;

@Component
public class PedidoModelAssembler extends RepresentationModelAssemblerSupport<Pedido, PedidoModel>{

	@Autowired
	private AlgaLinks algaLinks;
	
	
	public PedidoModelAssembler() {
		super(PedidoController.class, PedidoModel.class);
	}

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PedidoModel toModel(Pedido pedido) {
		PedidoModel pedidoModel = createModelWithId(pedido.getCodigo(), pedido);
	
		modelMapper.map(pedido, pedidoModel);
		
		pedidoModel.add(algaLinks.linkToPedidos("pedidos"));
		
		if (pedido.podeSerConfirmado()) {			
			pedidoModel.add(algaLinks.linkToConfirmacaoPedido(pedidoModel.getCodigo(), "confirmar"));
		}
		
		if (pedido.podeSerCancelado()) {			
			pedidoModel.add(algaLinks.linkToCancelamentoPedido(pedidoModel.getCodigo(), "cancelar"));
		}
		
		if (pedido.podeSerEntregue()) {			
			pedidoModel.add(algaLinks.linkToEntregaPedido(pedidoModel.getCodigo(), "entregar"));
		}
		
		
		pedidoModel.add(WebMvcLinkBuilder.linkTo(PedidoController.class).withRel("pedidos"));
		
		pedidoModel.getRestaurante().add(algaLinks.linkToRestaurante(pedidoModel.getRestaurante().getId()));
		
		pedidoModel.getCliente().add(algaLinks.linkToUsuario(pedidoModel.getCliente().getId()));
		
		pedidoModel.getFormaPagamento().add(algaLinks.linkToFormaPagamento(pedidoModel.getFormaPagamento().getId()));
		
		pedidoModel.getEnderecoEntrega().getCidade().add(algaLinks.linkToCidade(pedidoModel.getEnderecoEntrega().getCidade().getId()));
		
		pedidoModel.getItens().forEach(item -> {
	            item.add(algaLinks.linkToItem(pedidoModel.getRestaurante().getId(), item.getProdutoId(), "produto"));
	        });
		 
		return pedidoModel;
	}
	
	
}
