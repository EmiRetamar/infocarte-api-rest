package com.infocarte.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.infocarte.app.models.service.UsuarioServiceInterface;
import com.infocarte.app.models.entity.Usuario;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioServiceInterface usuarioService;

	@GetMapping("/usuarios")
	public List<Usuario> index() {
		return usuarioService.findAll();
	}

	@GetMapping("/usuarios/{id}")
	public Usuario show(@PathVariable Long id) {
		return this.usuarioService.findById(id);
	}

	@PostMapping("/usuarios/crear")
	// Devuelve un codigo de estado 201 en la respuesta http
	@ResponseStatus(HttpStatus.CREATED)
	/* Con la notacion @RequestBody se obtiene el json que se encuentra en el cuerpo de la solicitud http,
	se lo convierte en un objeto java y lo inyecta en el parametro "usuario" */
	public Usuario create(@RequestBody Usuario usuario) {
		return this.usuarioService.save(usuario);
	}

	@PutMapping("/usuarios/editar/{id}")
	// Devuelve un codigo de estado 201 en la respuesta http
	@ResponseStatus(HttpStatus.CREATED)
	/* Con la notacion @RequestBody se obtiene el json que se encuentra en el cuerpo de la solicitud http,
	se lo convierte en un objeto java y lo inyecta en el parametro "usuario" */
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioActual = this.usuarioService.findById(id);
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setApellido(usuario.getApellido());
		usuarioActual.setEmail(usuario.getEmail());
		return this.usuarioService.save(usuarioActual);
	}

	@DeleteMapping("/usuarios/{id}")
	// Devuelve un codigo de estado 204 en la respuesta http
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		this.usuarioService.delete(id);
	}

}
