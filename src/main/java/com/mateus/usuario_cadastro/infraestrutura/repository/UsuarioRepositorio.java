package com.mateus.usuario_cadastro.infraestrutura.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mateus.usuario_cadastro.infraestrutura.entidade.Usuario;


public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
	
}
