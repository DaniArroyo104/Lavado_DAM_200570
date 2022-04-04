package com.utxicotepec.lavado.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.utxicotepec.lavado.model.Vehiculos;

public interface repositoryVehiculos extends JpaRepository <Vehiculos, Long > {

	List<Vehiculos> findByMatricula (String matricula);
}
