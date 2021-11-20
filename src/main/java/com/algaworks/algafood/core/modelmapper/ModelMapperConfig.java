package com.algaworks.algafood.core.modelmapper;

import com.algaworks.algafood.api.v2.model.input.CidadeInputV2;
import com.algaworks.algafood.domain.model.Cidade;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.api.v1.model.EnderecoModel;
import com.algaworks.algafood.api.v1.model.input.ItemPedidoInput;
import com.algaworks.algafood.domain.model.Endereco;
import com.algaworks.algafood.domain.model.ItemPedido;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();


		//diz pro modelMapper ignorar o ItemPedido::setId
		modelMapper.createTypeMap(ItemPedidoInput.class,ItemPedido.class)
			.addMappings(mapper -> mapper.skip(ItemPedido::setId));

		modelMapper.createTypeMap(CidadeInputV2.class, Cidade.class)
				.addMappings(mapper -> mapper.skip(Cidade::setId));

		var enderecoToEnderecoModelTypeMap = modelMapper.createTypeMap(Endereco.class, EnderecoModel.class);
	
		enderecoToEnderecoModelTypeMap.<String>addMapping(
				enderecoSrc -> enderecoSrc.getCidade().getEstado().getNome(),
				(enderecoModelDest,value) -> enderecoModelDest.getCidade().setEstado(value));
		
		return modelMapper;
	}
}
