package com.algaworks.algafood.domain.exception;

public class GrupoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public GrupoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public GrupoNaoEncontradoException(Long grupoId) {
		this(String.format("O grupo de código %d não foi encontrado", grupoId));
	}
}
