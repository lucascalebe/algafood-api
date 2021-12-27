package com.algaworks.algafood.api.v1.controller;

import com.algaworks.algafood.core.security.AlgaSecurity;
import com.algaworks.algafood.core.security.CheckSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.v1.AlgaLinks;
import com.algaworks.algafood.api.v1.assembler.UsuarioModelAssembler;
import com.algaworks.algafood.api.v1.model.UsuarioModel;
import com.algaworks.algafood.api.v1.openapi.controller.RestauranteUsuarioControllerOpenApi;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping(value = "/v1/restaurantes/{restauranteId}/responsaveis", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestauranteUsuarioResponsavelController implements RestauranteUsuarioControllerOpenApi {

	@Autowired
	private UsuarioModelAssembler usuarioModelAssembler;
	
	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
	@Autowired
	private AlgaLinks algaLinks;

	@Autowired
	private AlgaSecurity algaSecurity;

	@CheckSecurity.Restaurantes.PodeGerenciarCadastro
	@Override
	@GetMapping
	public CollectionModel<UsuarioModel> listar(@PathVariable Long restauranteId) {
		Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);

		CollectionModel<UsuarioModel> usuariosModel = usuarioModelAssembler
				.toCollectionModel(restaurante.getResponsaveis())
				.removeLinks();

		usuariosModel.add(algaLinks.linkToRestauranteResponsaveis(restauranteId));

		if (algaSecurity.podeGerenciarCadastroRestaurantes()) {
			usuariosModel.add(algaLinks.linkToRestauranteResponsavelAssociacao(restauranteId, "associar"));

			usuariosModel.getContent().stream().forEach(usuarioModel -> {
				usuarioModel.add(algaLinks.linkToRestauranteResponsavelDesassociacao(
						restauranteId, usuarioModel.getId(), "desassociar"));
			});
		}

		return usuariosModel;
	}

	@CheckSecurity.Restaurantes.PodeGerenciarCadastro
	@DeleteMapping("/{responsavelId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> removerResponsavel(@PathVariable Long restauranteId, @PathVariable Long responsavelId) {
		cadastroRestaurante.removerResponsavel(responsavelId, restauranteId);
		
		return ResponseEntity.noContent().build();
	}

	@CheckSecurity.Restaurantes.PodeGerenciarCadastro
	@PutMapping("/{responsavelId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> adicionarResponsavel(@PathVariable Long restauranteId, @PathVariable Long responsavelId) {
		cadastroRestaurante.adicionarResponsavel(responsavelId, restauranteId);
		
		return ResponseEntity.noContent().build();
	}
}
