package com.ecommerce.auth.domain.usecase;

import com.ecommerce.auth.domain.model.Usuario;
import com.ecommerce.auth.domain.model.gateway.UsuarioGateway;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
public class UsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public UsuarioUseCase(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public Usuario guardarUsuario(Usuario usuario){
        if(usuario.getEmail() == null && usuario.getPass() == null){
            throw new NullPointerException("Ojo con eso manito!! - algun dato nulo");
        }

        if(usuario.getEdad() < 18){
            throw new RuntimeException("Usuario menor de edad");
        }



        Usuario usuarioGuardado = usuarioGateway.guardarUsuario(usuario);


        return usuarioGuardado;
    }
}
