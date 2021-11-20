package com.algaworks.algafood.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.v1.model.input.FormaPagamentoInput;
import com.algaworks.algafood.domain.model.FormaPagamento;

@Component
public class FormaPagamentoInputDissasembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public FormaPagamento toDomain(FormaPagamentoInput formaPagamentoInput) {
		return modelMapper.map(formaPagamentoInput, FormaPagamento.class);
	}
	
	public void ToDomainObject(FormaPagamentoInput formaPagamentoInput, FormaPagamento formaPagamento) {
		modelMapper.map(formaPagamentoInput, formaPagamento);
	}
}
