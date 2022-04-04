package com.utxicotepec.lavado.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.utxicotepec.lavado.model.Trabajadores;


public interface repositoryTrabajadores extends JpaRepository <Trabajadores, Long > {

	List<Trabajadores> findByNombre (String nombre);
}
