package com.example.demo.pojos;

import java.util.Objects;

public class Usuario {
	
	//variables
	private String nombre;
	private int puntaje;
	
	//Constructores
	public Usuario() {
		nombre = "";
		puntaje = 0;
	}
	
	public Usuario(String nombre, int puntaje) {
		this.nombre = nombre;
		this.puntaje = puntaje;
	}
	//getter & setter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	//Equals & HashCode
	@Override
	public int hashCode() {
		return Objects.hash(nombre, puntaje);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre) && puntaje == other.puntaje;
	}
	//toString
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", puntaje=" + puntaje + "]";
	}

	
	
	

}
