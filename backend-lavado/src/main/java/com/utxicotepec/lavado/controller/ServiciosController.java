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

import com.utxicotepec.lavado.model.Servicios;
import com.utxicotepec.lavado.repository.repositoryServicios;

@RestController
@RequestMapping("/api")
public class ServiciosController {
	@Autowired
	
	repositoryServicios repServicios;
	@GetMapping("/servicios")
	
	public ResponseEntity<List<Servicios>> getAllServicios (@RequestParam(required = false) String nombre) {
		try {
			List<Servicios> servicio=new ArrayList<Servicios>();
			if(nombre==null)
				repServicios.findAll().forEach(servicio::add);
			else
				repServicios.findByNombre(nombre).forEach(servicio::add);
			if(servicio.isEmpty()) {
				return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(servicio, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	
	/*peticion get por id*/
	@GetMapping("/servicios/{idservicios}")
	public ResponseEntity<Servicios> getServiciosById(@PathVariable("idservicios") long idservicio){
		Optional<Servicios> servicioData = repServicios.findById(idservicio);
		if (servicioData.isPresent()) {
			return new ResponseEntity<>(servicioData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*peticion post*/
	@PostMapping("/servicios")
	public ResponseEntity<Servicios> createServicio(@RequestBody Servicios servicio){
		try {
			Servicios _servicio = repServicios
					.save(new Servicios(
							servicio.getIdservicio(),
							servicio.getNombre(),
							servicio.getCosto(),
							servicio.getFecha_registro(),
							servicio.getStatus()
							));
			return new ResponseEntity<>( _servicio, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/servicios/{idservicio}")
	public ResponseEntity<HttpStatus> deleteServicio(@PathVariable("idservicio") long idservicio){
		try {
			repServicios.deleteById(idservicio);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/servicios/{idservicio}")
	public ResponseEntity<Servicios> updateServicio(@PathVariable("idservicio") long idservicio, @RequestBody Servicios servicio){
	Optional<Servicios> servicioData = repServicios.findById(idservicio);
	if (servicioData.isPresent()) {
		Servicios _servicio = servicioData.get();
		_servicio.setNombre(servicio.getNombre());
		_servicio.setCosto(servicio.getCosto());
		_servicio.setFecha_registro(servicio.getFecha_registro());
		_servicio.setStatus(servicio.getStatus());
		return new ResponseEntity<>(repServicios.save(_servicio), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
