package com.algaworks.algafood.domain.exception;

public class FotoProdutoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public FotoProdutoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public FotoProdutoNaoEncontradaException(Long restauranteId, Long produtoId) {
		this(String.format("Não foi encontrado uma foto para o produto %d no restaurante %d."
				,produtoId, restauranteId));
	}
}
