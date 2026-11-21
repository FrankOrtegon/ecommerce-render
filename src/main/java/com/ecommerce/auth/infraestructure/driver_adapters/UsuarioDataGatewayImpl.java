package com.ecommerce.auth.infraestructure.driver_adapters;

import com.ecommerce.auth.domain.model.Usuario;
import com.ecommerce.auth.domain.model.gateway.UsuarioGateway;
import com.ecommerce.auth.infraestructure.mapper.UsuarioMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDataGatewayImpl implements UsuarioGateway {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioDataJpaRepository usuarioDataJpaRepository;

    public UsuarioDataGatewayImpl(UsuarioMapper usuarioMapper, UsuarioDataJpaRepository usuarioDataJpaRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioDataJpaRepository = usuarioDataJpaRepository;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        UsuarioData usuarioMapeadoEntidad = usuarioMapper.toUsuarioData(usuario);
        UsuarioData usuarioEntidadGuardadoAlmacenado = usuarioDataJpaRepository.save(usuarioMapeadoEntidad);
        Usuario usuarioGuardado = usuarioMapper.toUsuario(usuarioEntidadGuardadoAlmacenado);
        return usuarioGuardado;

    }

    @Override
    public Usuario buscarPorId(String idUsuario) {
        return null;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void eliminarPorId(String idUsuario) {

    }

}
