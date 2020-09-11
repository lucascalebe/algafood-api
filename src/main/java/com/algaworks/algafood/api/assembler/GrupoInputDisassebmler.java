package com.algaworks.algafood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.model.input.GrupoInput;
import com.algaworks.algafood.domain.model.Grupo;

@Component
public class GrupoInputDisassebmler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Grupo toDomain(GrupoInput grupoInput) {
		return modelMapper.map(grupoInput, Grupo.class);
	}
	
	public void toDomainObject(GrupoInput grupoInput, Grupo grupo) {
		modelMapper.map(grupoInput, grupo);
	}
}
