package com.ecommerce.auth.domain.usecase;

import com.ecommerce.auth.domain.model.Usuario;
import com.ecommerce.auth.domain.model.gateway.UsuarioGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioUseCaseTest {

    @Mock
    private UsuarioGateway usuarioGateway;

    @InjectMocks
    private UsuarioUseCase usuarioUseCase;


    @Test
    void guardarUsuarioCorrectamente(){

        //Arrange
        Usuario usuario = mock(Usuario.class);
        Usuario usuarioGuardado = mock(Usuario.class);

        lenient().when(usuario.getEmail()).thenReturn("usuario@gmail.com");
        lenient().when(usuario.getPass()).thenReturn("12345");
        lenient().when(usuario.getEdad()).thenReturn(20);

        when(usuarioGateway.guardarUsuario(usuario))
                .thenReturn(usuarioGuardado);

        //Act
        Usuario usuarioResultado = usuarioUseCase.guardarUsuario(usuario);

        //Assert
        assertNotNull(usuarioResultado);
        assertSame(usuarioGuardado,usuarioResultado);

    }

    @Test
    void noGuardarUsuarioConDatosNulos(){

        //Arrange
        Usuario usuario = mock(Usuario.class);

        //Act
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> usuarioUseCase.guardarUsuario(usuario));

        //Assert
        assertEquals("Ojo con eso manito!! - algun dato nulo", exception.getMessage());

    }

    @Test
    void noGuardarUsuarioMenorEdad(){

        //Arrange
        Usuario usuario = mock(Usuario.class);

        lenient().when(usuario.getEmail()).thenReturn("usuario@gmail.com");
        lenient().when(usuario.getPass()).thenReturn("12345");
        lenient().when(usuario.getEdad()).thenReturn(15);

        //Act
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> usuarioUseCase.guardarUsuario(usuario));

        //Assert
        assertEquals("Usuario menor de edad", exception.getMessage());


    }

}