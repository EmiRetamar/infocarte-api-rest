package com.infocarte.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.infocarte.app.models.entity.Usuario;

public interface UsuarioDaoInterface extends CrudRepository<Usuario, Long> { }
