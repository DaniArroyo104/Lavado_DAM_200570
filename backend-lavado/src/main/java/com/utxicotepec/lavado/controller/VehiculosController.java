package com.utxicotepec.lavado.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utxicotepec.lavado.model.Vehiculos;
import com.utxicotepec.lavado.repository.repositoryVehiculos;

@RestController
@RequestMapping("/api")
public class VehiculosController {
	@Autowired
	
	repositoryVehiculos repVehiculos;
	@GetMapping("/vehiculos")
	
	public ResponseEntity<List<Vehiculos>> getAllVehiculos (@RequestParam(required = false) String matricula) {
		try {
			List<Vehiculos> vehiculo=new ArrayList<Vehiculos>();
			if(matricula==null)
				repVehiculos.findAll().forEach(vehiculo::add);
			else
				repVehiculos.findByMatricula(matricula).forEach(vehiculo::add);
			if(vehiculo.isEmpty()) {
				return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(vehiculo, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	
	/*peticion get por id*/
	@GetMapping("/vehiculos/{idvehiculo}")
	public ResponseEntity<Vehiculos> getVehiculoById(@PathVariable("idvehiculo") long idvehiculo){
		Optional<Vehiculos> vehiculoData = repVehiculos.findById(idvehiculo);
		if (vehiculoData.isPresent()) {
			return new ResponseEntity<>(vehiculoData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*peticion post*/
	@PostMapping("/vehiculos")
	public ResponseEntity<Vehiculos> createVehiculo(@RequestBody Vehiculos vehiculo){
		try {
			Vehiculos _vehiculo = repVehiculos
					.save(new Vehiculos(
							vehiculo.getMatricula(),
							vehiculo.getTipo(),
							vehiculo.getMarca(),
							vehiculo.getModelo(),
							vehiculo.getColor(),
							vehiculo.getFecha_registro(),
							vehiculo.getStatus(),
							vehiculo.getIdcliente()
							));
			return new ResponseEntity<>( _vehiculo, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/vehiculos/{idvehiculo}")
	public ResponseEntity<HttpStatus> deleteVehiculo(@PathVariable("idvehiculo") long idvehiculo){
		try {
			repVehiculos.deleteById(idvehiculo);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/vehiculos/{idvehiculo}")
	public ResponseEntity<Vehiculos> updateVehiculo(@PathVariable("idvehiculo") long idvehiculo, @RequestBody Vehiculos vehiculo){
		Optional<Vehiculos> vehiculoData = repVehiculos.findById(idvehiculo);
	if (vehiculoData.isPresent()) {
		Vehiculos _vehiculo = vehiculoData.get();
		_vehiculo.setColor(vehiculo.getColor());
		_vehiculo.setFecha_registro(vehiculo.getFecha_registro());
		_vehiculo.setIdcliente(vehiculo.getIdcliente());
		_vehiculo.setMarca(vehiculo.getMarca());
		_vehiculo.setMatricula(vehiculo.getMatricula());
		_vehiculo.setModelo(vehiculo.getModelo());
		_vehiculo.setStatus(vehiculo.getStatus());
		_vehiculo.setTipo(vehiculo.getTipo());
		return new ResponseEntity<>(repVehiculos.save(_vehiculo), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
