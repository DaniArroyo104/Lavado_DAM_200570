package com.utxicotepec.lavado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Ventas {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long idventa;
	
	@Column(name="fecha")
	public String fecha;
	
	@Column(name="idtrabajador")
	public String idtrabajador;
	
	@Column(name="idcajero")
	public String idcajero;
	
	@Column(name="idservicio")
	public String idservicio;
	
	@Column(name="idvehiculo")
	public String idvehiculo;
	
	@Column(name="status")
	public Boolean status;

	public Long getIdventa() {
		return idventa;
	}

	/*public void setIdventa(Long idventa) {
		this.idventa = idventa;
	}*/

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getIdtrabajador() {
		return idtrabajador;
	}

	public void setIdtrabajador(String idtrabajador) {
		this.idtrabajador = idtrabajador;
	}
	
	public String getIdcajero() {
		return idtrabajador;
	}

	public void setIdcajero(String idcajero) {
		this.idcajero = idcajero;
	}


	public String getIdservicio() {
		return idservicio;
	}

	public void setIdservicio(String idservicio) {
		this.idservicio = idservicio;
	}

	public String getIdvehiculo() {
		return idvehiculo;
	}

	public void setIdvehiculo(String idvehiculo) {
		this.idvehiculo = idvehiculo;
	}
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Ventas(String fecha, String idtrabajador, String idcajero, String idservicio,
			String idvehiculo, Boolean status) {
		this.fecha = fecha;
		this.idtrabajador = idtrabajador;
		this.idcajero = idcajero;
		this.idservicio = idservicio;
		this.idvehiculo = idvehiculo;
		this.status = status;
	}

	public Ventas() {
	}
	
	
}
