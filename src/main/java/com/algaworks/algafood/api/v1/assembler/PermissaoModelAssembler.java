package com.algaworks.algafood.api.v1.assembler;

import com.algaworks.algafood.api.v1.AlgaLinks;
import com.algaworks.algafood.api.v1.controller.PermissaoController;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.v1.model.PermissaoModel;
import com.algaworks.algafood.domain.model.Permissao;

@Component
public class PermissaoModelAssembler extends RepresentationModelAssemblerSupport<Permissao,PermissaoModel> {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AlgaLinks algaLinks;

	public PermissaoModelAssembler() {
		super(PermissaoController.class, PermissaoModel.class);
	}

	@Override
	public PermissaoModel toModel(Permissao permissao) {
		PermissaoModel permissaoModel = modelMapper.map(permissao, PermissaoModel.class);
		return permissaoModel;
	}

	@Override
	public CollectionModel<PermissaoModel> toCollectionModel(Iterable<? extends Permissao> entities) {
		return super.toCollectionModel(entities)
				.add(algaLinks.linkToPermissoes());
	}
}
