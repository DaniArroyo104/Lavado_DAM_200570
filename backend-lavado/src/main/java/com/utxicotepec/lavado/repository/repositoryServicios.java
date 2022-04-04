package com.utxicotepec.lavado.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.utxicotepec.lavado.model.Servicios;

public interface repositoryServicios extends JpaRepository <Servicios, Long >{

	List<Servicios> findByNombre (String nombre);

}
