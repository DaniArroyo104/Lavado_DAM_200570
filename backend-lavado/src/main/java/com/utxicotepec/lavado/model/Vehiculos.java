package com.utxicotepec.lavado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehiculo")
public class Vehiculos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long idvehiculo;
	
	@Column(name="matricula")
	public String matricula;
	
	@Column(name="tipo")
	public String tipo;
	
	@Column(name="marca")
	public String marca;
	
	@Column(name="modelo")
	public String modelo;
	
	@Column(name="color")
	public String color;
	
	@Column(name="fecha_registro")
	public String fecha_registro;
	
	@Column(name="status")
	public Boolean status;
	
	@Column(name="idcliente")
	public String idcliente;

	public Long getIdvehiculo() {
		return idvehiculo;
	}

	/*public void setIdvehiculo(Long idvehiculo) {
		this.idvehiculo = idvehiculo;
	}*/

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public String getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}

	public Vehiculos( String matricula, String tipo, String marca, String modelo, String color,
			String fecha_registro, Boolean status, String idcliente) {
		
		this.matricula = matricula;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.fecha_registro = fecha_registro;
		this.status = status;
		this.idcliente = idcliente;
	}

	public Vehiculos() {
	}
	
	
}
