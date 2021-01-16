package com.algaworks.algafood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.AlgaLinks;
import com.algaworks.algafood.api.controller.EstadoController;
import com.algaworks.algafood.api.model.EstadoModel;
import com.algaworks.algafood.domain.model.Estado;

@Component
public class EstadoModelAssembler extends RepresentationModelAssemblerSupport<Estado, EstadoModel>{

	public EstadoModelAssembler() {
		super(EstadoController.class, EstadoModel.class);
	}

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AlgaLinks algaLinks;
	
	public EstadoModel toModel(Estado estado) {
		EstadoModel estadoModel = modelMapper.map(estado, EstadoModel.class);
	
		estadoModel.add(algaLinks.LinkToEstados("estados"));
		
		estadoModel.add(algaLinks.linkToEstado(estadoModel.getId()));
		
		return estadoModel;
	}
	
	
	 @Override
	    public CollectionModel<EstadoModel> toCollectionModel(Iterable<? extends Estado> entities) {
	        return super.toCollectionModel(entities)
	            .add(WebMvcLinkBuilder.linkTo(EstadoController.class).withSelfRel());
	    } 
}
