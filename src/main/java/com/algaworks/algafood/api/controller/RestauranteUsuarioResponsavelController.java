package com.algaworks.algafood.api.controller;

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

import com.algaworks.algafood.api.AlgaLinks;
import com.algaworks.algafood.api.assembler.UsuarioModelAssembler;
import com.algaworks.algafood.api.model.UsuarioModel;
import com.algaworks.algafood.api.openapi.controller.RestauranteUsuarioControllerOpenApi;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping(value = "/restaurantes/{restauranteId}/responsaveis", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestauranteUsuarioResponsavelController implements RestauranteUsuarioControllerOpenApi {

	@Autowired
	private UsuarioModelAssembler usuarioModelAssembler;
	
	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
	@Autowired
	private AlgaLinks algaLinks;
	
	@GetMapping
	public CollectionModel<UsuarioModel> listar(@PathVariable Long restauranteId) {
		Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);
		
		
		CollectionModel<UsuarioModel> usuariosModel = usuarioModelAssembler.toCollectionModel(
				restaurante.getResponsaveis())
				.removeLinks()
				.add(algaLinks.linkToResponsavelRestauranteAdicionar(restauranteId, "associar"));
		
		usuariosModel.getContent().forEach(usuarioModel -> {
			usuarioModel.add(algaLinks.linkToResponsavelRestauranteRemover(restauranteId, usuarioModel.getId(), "desassociar"));
		});
		
		return usuariosModel;
	}
	
	@DeleteMapping("/{responsavelId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> removerResponsavel(@PathVariable Long restauranteId, @PathVariable Long responsavelId) {
		cadastroRestaurante.removerResponsavel(responsavelId, restauranteId);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{responsavelId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> adicionarResponsavel(@PathVariable Long restauranteId, @PathVariable Long responsavelId) {
		cadastroRestaurante.adicionarResponsavel(responsavelId, restauranteId);
		
		return ResponseEntity.noContent().build();
	}
}
