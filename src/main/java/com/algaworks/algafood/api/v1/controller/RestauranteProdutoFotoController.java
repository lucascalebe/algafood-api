package com.algaworks.algafood.api.v1.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import com.algaworks.algafood.core.security.CheckSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.algafood.api.v1.assembler.FotoProdutoModelAssembler;
import com.algaworks.algafood.api.v1.model.FotoProdutoModel;
import com.algaworks.algafood.api.v1.model.input.FotoProdutoInput;
import com.algaworks.algafood.api.v1.openapi.controller.RestauranteProdutoFotoControllerOpenApi;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.FotoProduto;
import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.service.CadastroProdutoService;
import com.algaworks.algafood.domain.service.CatalogoFotoProdutoService;
import com.algaworks.algafood.domain.service.FotoStorageService;
import com.algaworks.algafood.domain.service.FotoStorageService.FotoRecuperada;

@RestController
@RequestMapping(path = "/v1/restaurantes/{restauranteId}/produtos/{produtoId}/foto",produces = MediaType.APPLICATION_JSON_VALUE)
public class RestauranteProdutoFotoController implements RestauranteProdutoFotoControllerOpenApi {

	@Autowired
	private CadastroProdutoService cadastroProduto;

	@Autowired
	private CatalogoFotoProdutoService catalogoFotoProduto;

	@Autowired
	private FotoProdutoModelAssembler fotoProdutoModelAssembler;

	@Autowired
	private FotoStorageService fotoStorage;

	@CheckSecurity.Restaurantes.PodeGerenciarFuncionamento
	@PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public FotoProdutoModel atualizarFoto(@PathVariable Long restauranteId, @PathVariable Long produtoId,
			@Valid FotoProdutoInput fotoProdutoInput,
			@RequestPart(required = true) MultipartFile arquivo) throws IOException {
		Produto produto = cadastroProduto.buscarOuFalhar(restauranteId, produtoId);

//		MultipartFile arquivo = fotoProdutoInput.getArquivo();

		FotoProduto foto = new FotoProduto();
		foto.setProduto(produto);
		foto.setDescricao(fotoProdutoInput.getDescricao());
		foto.setContentType(arquivo.getContentType());
		foto.setTamanho(arquivo.getSize());
		foto.setNomeArquivo(arquivo.getOriginalFilename());

		FotoProduto fotoSalva = catalogoFotoProduto.salvar(foto, arquivo.getInputStream());

		return fotoProdutoModelAssembler.toModel(fotoSalva);
	}

	@CheckSecurity.Restaurantes.PodeConsultar
	@GetMapping()
	public FotoProdutoModel buscar(@PathVariable Long restauranteId
			, @PathVariable Long produtoId) {
		
		FotoProduto foto = catalogoFotoProduto.buscarOuFalhar(restauranteId, produtoId);
		return fotoProdutoModelAssembler.toModel(foto);
	}


	@GetMapping(produces = MediaType.ALL_VALUE)
	public ResponseEntity<?> servirFoto(@PathVariable Long restauranteId
			, @PathVariable Long produtoId,@RequestHeader(name ="accept") String acceptHeader) throws HttpMediaTypeNotAcceptableException {
		
		try {
			
			FotoProduto foto = catalogoFotoProduto.buscarOuFalhar(restauranteId, produtoId);
			
			MediaType mediaTypeFoto = MediaType.parseMediaType(foto.getContentType());
			List<MediaType> mediaTypesAceitas = MediaType.parseMediaTypes(acceptHeader);
			
			verificarCompatibilidadeMediaType(mediaTypeFoto, mediaTypesAceitas);
			
			FotoRecuperada FotoRecuperada = fotoStorage.recuperar(foto.getNomeArquivo());
			
			if (FotoRecuperada.temUrl()) {
				return ResponseEntity.status(HttpStatus.FOUND)
						.header(HttpHeaders.LOCATION, FotoRecuperada.getUrl())
						.build();
			}
			else {				
				return ResponseEntity.ok()
						.contentType(mediaTypeFoto)
						.body(new InputStreamResource(FotoRecuperada.getInputStream()));
			}
		}
		catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@CheckSecurity.Restaurantes.PodeGerenciarFuncionamento
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long restauranteId, @PathVariable Long produtoId) {
		catalogoFotoProduto.remover(restauranteId, produtoId);
	}

	private void verificarCompatibilidadeMediaType(MediaType mediaTypeFoto, 
			List<MediaType> mediaTypesAceitas) throws HttpMediaTypeNotAcceptableException {
		
		boolean compativel = mediaTypesAceitas.stream()
				.anyMatch(mediaTypesAceita -> mediaTypesAceita.isCompatibleWith(mediaTypeFoto));
		
		if (!compativel) {
			throw new HttpMediaTypeNotAcceptableException(mediaTypesAceitas);
		}
	}
}
