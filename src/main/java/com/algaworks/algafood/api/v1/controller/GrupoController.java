package com.algaworks.algafood.api.v1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.api.v1.assembler.GrupoInputDisassebmler;
import com.algaworks.algafood.api.v1.assembler.GrupoModelAssembler;
import com.algaworks.algafood.api.v1.model.GrupoModel;
import com.algaworks.algafood.api.v1.model.input.GrupoInput;
import com.algaworks.algafood.api.v1.openapi.controller.GrupoControllerOpenApi;
import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.domain.repository.GrupoRepository;
import com.algaworks.algafood.domain.service.CadastroGrupoService;

@RestController
@RequestMapping(path = "/grupos", produces = MediaType.APPLICATION_JSON_VALUE)
public class GrupoController implements GrupoControllerOpenApi {

	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private CadastroGrupoService cadastroGrupo;
	
	@Autowired
	private GrupoModelAssembler grupoModelAssembler;
	
	@Autowired
	private GrupoInputDisassebmler grupoInputDisassebmler;
	
	@GetMapping
	public CollectionModel<GrupoModel> listar() {
		return grupoModelAssembler.toCollectionModel(grupoRepository.findAll());
	}
	
	@GetMapping("/{grupoId}")
	public GrupoModel buscar(@PathVariable Long grupoId) {
		return grupoModelAssembler.toModel(cadastroGrupo.buscarOuFalhar(grupoId));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GrupoModel adicionar(@RequestBody @Valid GrupoInput grupoInput) {
		Grupo grupo = grupoInputDisassebmler.toDomain(grupoInput);
		return grupoModelAssembler.toModel(cadastroGrupo.salvar(grupo));
	}
	
	@PutMapping("/{grupoId}")
	public GrupoModel atualizar(@PathVariable Long grupoId,
			@RequestBody @Valid GrupoInput grupoInput) {
		
		Grupo grupo = cadastroGrupo.buscarOuFalhar(grupoId);
	
		grupoInputDisassebmler.toDomainObject(grupoInput, grupo);
		
		return grupoModelAssembler.toModel(cadastroGrupo.salvar(grupo));
	}
	
	@DeleteMapping("/{grupoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long grupoId) {
		cadastroGrupo.remover(grupoId);
	}
}
