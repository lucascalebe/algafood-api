package com.algaworks.algafood.api.v2.controller;

import com.algaworks.algafood.api.v2.assembler.CozinhaInputDisassemblerV2;
import com.algaworks.algafood.api.v2.assembler.CozinhaModelAssemblerV2;
import com.algaworks.algafood.api.v2.model.CozinhaModelV2;
import com.algaworks.algafood.api.v2.model.input.CozinhaInputV2;
import com.algaworks.algafood.api.v2.openapi.controller.CozinhaControllerV2OpenApi;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v2/cozinhas",produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaControllerV2 implements CozinhaControllerV2OpenApi {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	@Autowired
	private CozinhaModelAssemblerV2 cozinhaModelAssembler;
	
	@Autowired
	private CozinhaInputDisassemblerV2 cozinhaInputDisassembler;
	
	@Autowired
	private PagedResourcesAssembler<Cozinha> pagedResourceAssembler;
	
	@GetMapping
	public PagedModel<CozinhaModelV2> listar(@PageableDefault(size = 10) Pageable pageable) {
		Page<Cozinha> cozinhasPage = cozinhaRepository.findAll(pageable);

		PagedModel<CozinhaModelV2> cozinhasPagedModel = pagedResourceAssembler.
				toModel(cozinhasPage,cozinhaModelAssembler);

		return cozinhasPagedModel;
	}

	@GetMapping("/{cozinhaId}")
	public CozinhaModelV2 buscar(@PathVariable Long cozinhaId) {
		return cozinhaModelAssembler.toModel(cadastroCozinha.buscarOuFalhar(cozinhaId));
	}	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CozinhaModelV2 adicionar(@RequestBody @Valid CozinhaInputV2 cozinhaInput) {
		Cozinha cozinha = cozinhaInputDisassembler.toDomain(cozinhaInput);
		return cozinhaModelAssembler.toModel(cadastroCozinha.salvar(cozinha));
	}

	@PutMapping("/{cozinhaId}")
	public CozinhaModelV2 atualizar(@PathVariable Long cozinhaId, @RequestBody @Valid CozinhaInputV2 cozinhaInput) {
		Cozinha cozinhaAtual = cadastroCozinha.buscarOuFalhar(cozinhaId);

		cozinhaInputDisassembler.toDomainObject(cozinhaInput, cozinhaAtual);

		return cozinhaModelAssembler.toModel(cadastroCozinha.salvar(cozinhaAtual));
	}
	
	@DeleteMapping("/{cozinhaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cozinhaId) {	
		cadastroCozinha.excluir(cozinhaId);
	}		
}
