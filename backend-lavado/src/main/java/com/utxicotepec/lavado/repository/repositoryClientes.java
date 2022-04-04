package com.utxicotepec.lavado.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.utxicotepec.lavado.model.Clientes;

public interface repositoryClientes extends JpaRepository <Clientes, Long> {
	
	List<Clientes> findByNombre (String nombre);

}
