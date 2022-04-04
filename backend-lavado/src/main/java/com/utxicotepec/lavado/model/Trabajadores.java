package com.utxicotepec.lavado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trabajador")
public class Trabajadores {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long idtrabajador;
	
	@Column(name="nombre")
	public String nombre;
	
	@Column(name="aparterno")
	public String aparterno;
	
	@Column(name="amaterno")
	public String amaterno;
	
	@Column(name="direccion")
	public String direccion;
	
	@Column(name="telefono")
	public String telefono;
	
	@Column(name="correo")
	public String correo;
	
	@Column(name="contrasena")
	public String contrasena;
	
	@Column(name="tipo")
	public String tipo;
	
	@Column(name="fecha_registro")
	public String fecha_registro;
	
	@Column(name="status")
	public Boolean status;

	public Long getIdtrabajador() {
		return idtrabajador;
	}

	public void setIdtrabajador(Long idtrabajador) {
		this.idtrabajador = idtrabajador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAparterno() {
		return aparterno;
	}

	public void setAparterno(String aparterno) {
		this.aparterno = aparterno;
	}

	public String getAmaterno() {
		return amaterno;
	}

	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Trabajadores(Long idtrabajador, String nombre, String aparterno, String amaterno, String direccion,
			String telefono, String correo, String contrasena, String tipo, String fecha_registro, Boolean status) {
		this.idtrabajador = idtrabajador;
		this.nombre = nombre;
		this.aparterno = aparterno;
		this.amaterno = amaterno;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasena = contrasena;
		this.tipo = tipo;
		this.fecha_registro = fecha_registro;
		this.status = status;
	}

	public Trabajadores() {
	}

	
}
