package com.mateus.usuario_cadastro.negocio;


import org.springframework.stereotype.Service;

import com.mateus.usuario_cadastro.infraestrutura.entidade.Usuario;
import com.mateus.usuario_cadastro.infraestrutura.repository.UsuarioRepositorio;



@Service
public class UsuarioServico{

    private final UsuarioRepositorio repositorio;

    public UsuarioServico(UsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void salvarUsuario(Usuario usuario){
        repositorio.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return repositorio.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    public void deletarUsuarioPorEmail( String email){
        repositorio.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        Usuario usuarioEntidade = repositorio.findById(id).orElseThrow(() ->
                new RuntimeException("Usuario não encontrado"));
        usuarioEntidade.setEmail(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntidade.getEmail());
        usuarioEntidade.setNome(usuario.getNome() != null ? usuario.getNome() : usuarioEntidade.getNome());

        repositorio.saveAndFlush(usuarioEntidade);
       
    }
} 