package com.infocarte.app.models.service;

import java.util.List;

import com.infocarte.app.models.entity.Usuario;

public interface UsuarioServiceInterface {

	public List<Usuario> findAll();

	public Usuario findById(Long id);

	public Usuario save(Usuario usuario);

	public void delete(Long id);

}
