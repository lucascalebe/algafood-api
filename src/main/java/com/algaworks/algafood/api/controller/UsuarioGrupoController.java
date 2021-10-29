package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.assembler.GrupoModelAssembler;
import com.algaworks.algafood.api.model.GrupoModel;
import com.algaworks.algafood.api.openapi.controller.UsuarioGrupoControllerOpenApi;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.service.CadastroUsuarioService;

@RestController
@RequestMapping(path = "/usuarios/{usuarioId}/grupos",produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioGrupoController implements UsuarioGrupoControllerOpenApi {

	@Autowired
	private GrupoModelAssembler grupoModelAssembler;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuario;
	
	@GetMapping
	public CollectionModel<GrupoModel> listar(@PathVariable Long usuarioId) {
		Usuario usuario = cadastroUsuario.buscarOuFalhar(usuarioId);
		return grupoModelAssembler.toCollectionModel(usuario.getGrupos()).removeLinks();
	}
	
	@DeleteMapping("/{grupoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerGrupo(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
		cadastroUsuario.removerGrupo(grupoId, usuarioId);
	} 
	
	@PutMapping("/{grupoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void adicionarGrupo(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
		cadastroUsuario.adicionarGrupo(grupoId, usuarioId);
	} 
}
