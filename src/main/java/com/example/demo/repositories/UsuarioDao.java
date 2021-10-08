package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.example.demo.pojos.Usuario;

public interface UsuarioDao {

	int count();
	int save(Usuario usuario);
	int update(Usuario usuario);
	int deleteById(String nombre);
	List<Usuario> findAll();
	//Optional<Usuario> findById(String nombre);
}
