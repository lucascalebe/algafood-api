package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query("from Produto where restaurante.id = :restauranteId and id = :produtoId")
    Optional<Produto> findById(Long restauranteId, Long produtoId);
	
	List<Produto> findAllByRestaurante(Restaurante restaurante);
	
}
