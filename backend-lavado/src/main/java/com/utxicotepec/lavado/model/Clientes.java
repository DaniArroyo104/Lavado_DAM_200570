package com.utxicotepec.lavado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")

public class Clientes {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long idcliente;
	
	@Column(name="nombre")
	public String nombre;
	
	@Column(name="apaterno")
	public String apaterno;
	
	@Column(name="amaterno")
	public String amaterno;
	
	@Column(name="direccion")
	public String direccion;
	
	@Column(name="telefono")
	public String telefono;
	
	@Column(name="correo")
	public String correo;
	
	@Column(name="fecha_registro")
	public String fecha_registro;
	
	@Column(name="status")
	public Boolean status;

	public Long getIdcliente() {
		return idcliente;
	}

	/*public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApaterno() {
		return apaterno;
	}

	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
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

	public Clientes(String nombre, String apaterno, String amaterno, String direccion, String telefono,
			String correo, String fecha_registro, Boolean status) {
		this.nombre = nombre;
		this.apaterno = apaterno;
		this.amaterno = amaterno;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.fecha_registro = fecha_registro;
		this.status = status;
	}

	public Clientes() {
	}
	
	
}
