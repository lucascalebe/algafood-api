package com.algaworks.algafood.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.v1.AlgaLinks;
import com.algaworks.algafood.api.v1.controller.PedidoController;
import com.algaworks.algafood.api.v1.model.PedidoResumoModel;
import com.algaworks.algafood.domain.model.Pedido;

@Component
public class PedidoResumoModelAssembler extends RepresentationModelAssemblerSupport<Pedido, PedidoResumoModel>{

	public PedidoResumoModelAssembler() {
		super(PedidoController.class, PedidoResumoModel.class);
	}

	@Autowired
	private ModelMapper modelMapper;
	
	
	@Autowired
	private AlgaLinks algalinks;
	
	@Override
	public PedidoResumoModel toModel(Pedido pedido) {
		PedidoResumoModel pedidoResumoModel = createModelWithId(pedido.getCodigo(),pedido);
		
		modelMapper.map(pedido, pedidoResumoModel);

		pedidoResumoModel.add(algalinks.linkToPedidos("pedidos"));
		
		pedidoResumoModel.getRestaurante().add(algalinks.linkToRestaurante(pedido.getId()));
		
		pedidoResumoModel.getCliente().add(algalinks.linkToUsuario(pedido.getCliente().getId()));
		
		return pedidoResumoModel;
	}
}
