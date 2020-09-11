package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.algafood.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
