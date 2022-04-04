package com.utxicotepec.lavado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utxicotepec.lavado.model.Ventas;



public interface repositoryVentas extends JpaRepository <Ventas, Long >{

	List<Ventas> findByFecha (String fecha);
}
