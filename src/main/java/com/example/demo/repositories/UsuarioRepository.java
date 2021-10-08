package com.example.demo.repositories;

import java.util.List;
import java.util.Vector;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.pojos.Usuario;

@Repository
public class UsuarioRepository implements UsuarioDao {

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		
		Integer cantidad = template.queryForObject("select count(*) as 'cantidad'  from usuario", Integer.class);
		return cantidad;
	}

	@Override
	public int save(Usuario usuario) {
		// TODO Auto-generated method stub
		return template.update("insert into usuario(nombre, puntaje) values (?,?)", usuario.getNombre(), usuario.getPuntaje());
	}

	@Override
	public int update(Usuario usuario) {
		// TODO Auto-generated method stub
		return template.update("update usuario set nombre = ?, puntaje= ? where nombre = ?", usuario.getNombre(), usuario.getPuntaje(), usuario.getNombre());
	}

	@Override
	public int deleteById(String nombre) {
		// TODO Auto-generated method stub
		return template.update("delete from usuario where nombre = ?", nombre);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return template.query("select * from usuario order by puntaje desc limit 15", (rs, rowNum) -> new Usuario(rs.getString("nombre"), rs.getInt("puntaje")));
	}

	/*
	 * @Override public Optional<Usuario> findById(String nombre) { // TODO
	 * Auto-generated method stub return null; }
	 */

}
