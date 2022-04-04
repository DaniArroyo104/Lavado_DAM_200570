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

import com.utxicotepec.lavado.model.Trabajadores;
import com.utxicotepec.lavado.repository.repositoryTrabajadores;

@RestController
@RequestMapping("/api")
public class TrabajadoresController {
	@Autowired
	
	repositoryTrabajadores repTrabajadores;
	@GetMapping("/trabajadores")
	
	public ResponseEntity<List<Trabajadores>> getAllTrabajadores (@RequestParam(required = false) String nombre) {
		try {
			List<Trabajadores> trabajador=new ArrayList<Trabajadores>();
			if(nombre==null)
				repTrabajadores.findAll().forEach(trabajador::add);
			else
				repTrabajadores.findByNombre(nombre).forEach(trabajador::add);
			if(trabajador.isEmpty()) {
				return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(trabajador, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	
	/*peticion get por id*/
	@GetMapping("/trabajadores/{idtrabajador}")
	public ResponseEntity<Trabajadores> getTrabajadorById(@PathVariable("idtrabajador") long idtrabajador){
		Optional<Trabajadores> trabajadorData = repTrabajadores.findById(idtrabajador);
		if (trabajadorData.isPresent()) {
			return new ResponseEntity<>(trabajadorData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*peticion post*/
	@PostMapping("/trabajadores")
	public ResponseEntity<Trabajadores> createTrabajador(@RequestBody Trabajadores trabajador){
		try {
			Trabajadores _trabajador = repTrabajadores
					.save(new Trabajadores(
							trabajador.getIdtrabajador(),
							trabajador.getNombre(),
							trabajador.getAparterno(),
							trabajador.getAmaterno(),
							trabajador.getDireccion(),
							trabajador.getTelefono(),
							trabajador.getCorreo(),
							trabajador.getContrasena(),
							trabajador.getTipo(),
							trabajador.getFecha_registro(),
							trabajador.getStatus()
							));
			return new ResponseEntity<>( _trabajador, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/trabajadores/{idtrabajador}")
	public ResponseEntity<HttpStatus> deleteTrabajador(@PathVariable("idtrabajador") long idtrabajador){
		try {
			repTrabajadores.deleteById(idtrabajador);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/trabajadores/{idtrabajador}")
	public ResponseEntity<Trabajadores> updateCliente(@PathVariable("idtrabajador") long idtrabajador, @RequestBody Trabajadores trabajador){
	Optional<Trabajadores> trabajadorData = repTrabajadores.findById(idtrabajador);
	if (trabajadorData.isPresent()) {
		Trabajadores _trabajador = trabajadorData.get();
		_trabajador.setNombre(trabajador.getNombre());
		_trabajador.setAmaterno(trabajador.getAmaterno());
		_trabajador.setAparterno(trabajador.getAparterno());
		_trabajador.setDireccion(trabajador.getDireccion());
		_trabajador.setTelefono(trabajador.getTelefono());
		_trabajador.setCorreo(trabajador.getCorreo());
		_trabajador.setContrasena(trabajador.getContrasena());
		_trabajador.setTipo(trabajador.getTipo());
		_trabajador.setFecha_registro(trabajador.getFecha_registro());
		_trabajador.setStatus(trabajador.getStatus());
		
		return new ResponseEntity<>(repTrabajadores.save(_trabajador), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
