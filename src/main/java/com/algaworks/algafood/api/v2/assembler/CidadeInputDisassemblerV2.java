package com.algaworks.algafood.api.v2.assembler;

import com.algaworks.algafood.api.v2.model.input.CidadeInputV2;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeInputDisassemblerV2 {

	@Autowired
	private ModelMapper modelMapper;
	
	public Cidade ToDomain(CidadeInputV2 cidadeInput) {
		return modelMapper.map(cidadeInput, Cidade.class);
	}
	
	public void toDomainObject(CidadeInputV2 cidadeInput, Cidade cidade) {
		 /* evitar: 
		 *  org.hibernate.HibernateException: identifier of an instance of com.algaworks.algafood.domain.model.Estado 
		 *  was altered from 2 to 3
		 */
		cidade.setEstado(new Estado());
		
		modelMapper.map(cidadeInput, cidade);
	}
}
