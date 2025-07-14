package com.mateus.usuario_cadastro.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mateus.usuario_cadastro.infraestrutura.entidade.Usuario;
import com.mateus.usuario_cadastro.negocio.UsuarioServico;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioServico usuarioServico;
    
    
    public UsuarioController(UsuarioServico usuarioServico) {
		this.usuarioServico = usuarioServico;
	}

	@PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        usuarioServico.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioServico.buscarUsuarioPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email){
        usuarioServico.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam Integer id,
                                                      @RequestBody Usuario usuario){
        usuarioServico.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }
}
