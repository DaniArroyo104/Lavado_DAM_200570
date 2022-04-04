package com.utxicotepec.lavado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="servicio")
public class Servicios {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long idservicio;
	
	@Column(name="nombre")
	public String nombre;
	
	@Column(name="costo")
	public Double costo;
	
	@Column(name="fecha_registro")
	public String fecha_registro;
	
	@Column(name="status")
	public Boolean status;

	public Long getIdservicio() {
		return idservicio;
	}

	/*public void setIdservicio(Long idservicio) {
		this.idservicio = idservicio;
	}*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
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

	public Servicios(Long idservicio, String nombre, Double costo, String fecha_registro, Boolean status) {
		this.idservicio = idservicio;
		this.nombre = nombre;
		this.costo = costo;
		this.fecha_registro = fecha_registro;
		this.status = status;
	}

	public Servicios() {
	}
	
	
	
}
